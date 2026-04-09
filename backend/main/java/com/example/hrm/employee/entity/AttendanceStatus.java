package com.example.hrm.employee.entity;

import com.example.hrm.employee.dto.*;
import com.example.hrm.employee.entity.*;
import com.example.hrm.department.repository.*;
import com.example.hrm.users.repository.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.tasks.entity.*;


public enum AttendanceStatus {
    PRESENT,
    ABSENT,
    LATE,
    HALF_DAY,
    ON_LEAVE
}
