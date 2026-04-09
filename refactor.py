import os

base_dir = r"c:\Users\ADMIN\OneDrive\Máy tính\hr-management\backend\main\java\com\example\hrm"
domains = ["users", "department", "employee", "tasks"]
layers = ["controller", "service", "repository", "dto", "mapper", "entity"]

import_additions = {
    "users": ["com.example.hrm.users.dto.*", "com.example.hrm.users.entity.*", "com.example.hrm.employee.entity.*"],
    "department": ["com.example.hrm.department.dto.*", "com.example.hrm.department.entity.*", "com.example.hrm.employee.entity.*"],
    "employee": ["com.example.hrm.employee.dto.*", "com.example.hrm.employee.entity.*", "com.example.hrm.department.repository.*", "com.example.hrm.users.repository.*", "com.example.hrm.department.entity.*", "com.example.hrm.users.entity.*", "com.example.hrm.tasks.entity.*"],
    "tasks": ["com.example.hrm.tasks.dto.*", "com.example.hrm.tasks.entity.*", "com.example.hrm.employee.entity.*"]
}

for domain in domains:
    domain_path = os.path.join(base_dir, domain)
    if not os.path.exists(domain_path): continue
    
    for layer in layers:
        os.makedirs(os.path.join(domain_path, layer), exist_ok=True)
        
    for file in os.listdir(domain_path):
        if not file.endswith(".java"): continue
        
        file_path = os.path.join(domain_path, file)
        
        # Determine layer
        if file.endswith("Controller.java"): layer = "controller"
        elif file.endswith("Service.java"): layer = "service"
        elif file.endswith("Repository.java"): layer = "repository"
        elif file.endswith("DTO.java"): layer = "dto"
        elif file.endswith("Mapper.java"): layer = "mapper"
        else: layer = "entity"
        
        new_path = os.path.join(domain_path, layer, file)
        
        with open(file_path, "r", encoding="utf-8") as f:
            content = f.read()
            
        old_pkg = f"package com.example.hrm.{domain};"
        new_pkg = f"package com.example.hrm.{domain}.{layer};"
        content = content.replace(old_pkg, new_pkg)
        
        imports = "\n".join([f"import {imp};" for imp in import_additions[domain]])
        content = content.replace(new_pkg, new_pkg + "\n\n" + imports)
        
        content = content.replace("import com.example.hrm.users.Role;", "import com.example.hrm.users.entity.Role;")
        content = content.replace("import com.example.hrm.users.User;", "import com.example.hrm.users.entity.User;")
        content = content.replace("import com.example.hrm.employee.Employee;", "import com.example.hrm.employee.entity.Employee;")
        content = content.replace("import com.example.hrm.department.Department;", "import com.example.hrm.department.entity.Department;")
        content = content.replace("import com.example.hrm.department.Position;", "import com.example.hrm.department.entity.Position;")
        content = content.replace("import com.example.hrm.tasks.Task;", "import com.example.hrm.tasks.entity.Task;")
        content = content.replace("import com.example.hrm.tasks.TaskStatus;", "import com.example.hrm.tasks.entity.TaskStatus;")
        content = content.replace("import com.example.hrm.employee.AttendanceStatus;", "import com.example.hrm.employee.entity.AttendanceStatus;")
        content = content.replace("import com.example.hrm.employee.LeaveStatus;", "import com.example.hrm.employee.entity.LeaveStatus;")
        content = content.replace("import com.example.hrm.users.UserRepository;", "import com.example.hrm.users.repository.UserRepository;")

        with open(new_path, "w", encoding="utf-8") as f:
            f.write(content)
            
        os.remove(file_path)

print("Refactoring complete.")
