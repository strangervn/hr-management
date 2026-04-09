import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Refactor {
    public static void main(String[] args) throws Exception {
        String baseDir = "backend/main/java/com/example/hrm";
        List<String> domains = Arrays.asList("users", "department", "employee", "tasks");
        List<String> layers = Arrays.asList("controller", "service", "repository", "dto", "mapper", "entity");

        for (String domain : domains) {
            File domainDir = new File(baseDir, domain);
            if (!domainDir.exists()) continue;

            for (String layer : layers) {
                new File(domainDir, layer).mkdirs();
            }

            File[] files = domainDir.listFiles();
            if (files == null) continue;

            for (File file : files) {
                if (file.isDirectory() || !file.getName().endsWith(".java")) continue;

                String name = file.getName();
                String layer = "entity";
                if (name.endsWith("Controller.java")) layer = "controller";
                else if (name.endsWith("Service.java")) layer = "service";
                else if (name.endsWith("Repository.java")) layer = "repository";
                else if (name.endsWith("DTO.java")) layer = "dto";
                else if (name.endsWith("Mapper.java")) layer = "mapper";

                File newFile = new File(domainDir, layer + "/" + name);
                
                String content = new String(Files.readAllBytes(file.toPath()));
                
                String oldPkg = "package com.example.hrm." + domain + ";";
                String newPkg = "package com.example.hrm." + domain + "." + layer + ";";
                content = content.replace(oldPkg, newPkg);
                
                String imports = "";
                if (domain.equals("users")) imports = "import com.example.hrm.users.dto.*;\nimport com.example.hrm.users.entity.*;\nimport com.example.hrm.employee.entity.*;\n";
                if (domain.equals("department")) imports = "import com.example.hrm.department.dto.*;\nimport com.example.hrm.department.entity.*;\nimport com.example.hrm.employee.entity.*;\n";
                if (domain.equals("employee")) imports = "import com.example.hrm.employee.dto.*;\nimport com.example.hrm.employee.entity.*;\nimport com.example.hrm.department.repository.*;\nimport com.example.hrm.users.repository.*;\nimport com.example.hrm.department.entity.*;\nimport com.example.hrm.users.entity.*;\nimport com.example.hrm.tasks.entity.*;\n";
                if (domain.equals("tasks")) imports = "import com.example.hrm.tasks.dto.*;\nimport com.example.hrm.tasks.entity.*;\nimport com.example.hrm.employee.entity.*;\n";

                content = content.replace(newPkg, newPkg + "\n\n" + imports);
                
                content = content.replace("import com.example.hrm.users.Role;", "import com.example.hrm.users.entity.Role;");
                content = content.replace("import com.example.hrm.users.User;", "import com.example.hrm.users.entity.User;");
                content = content.replace("import com.example.hrm.employee.Employee;", "import com.example.hrm.employee.entity.Employee;");
                content = content.replace("import com.example.hrm.department.Department;", "import com.example.hrm.department.entity.Department;");
                content = content.replace("import com.example.hrm.department.Position;", "import com.example.hrm.department.entity.Position;");
                content = content.replace("import com.example.hrm.tasks.Task;", "import com.example.hrm.tasks.entity.Task;");
                content = content.replace("import com.example.hrm.tasks.TaskStatus;", "import com.example.hrm.tasks.entity.TaskStatus;");
                content = content.replace("import com.example.hrm.employee.AttendanceStatus;", "import com.example.hrm.employee.entity.AttendanceStatus;");
                content = content.replace("import com.example.hrm.employee.LeaveStatus;", "import com.example.hrm.employee.entity.LeaveStatus;");
                content = content.replace("import com.example.hrm.users.UserRepository;", "import com.example.hrm.users.repository.UserRepository;");

                Files.write(newFile.toPath(), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                file.delete();
            }
        }
        System.out.println("Refactoring complete.");
    }
}
