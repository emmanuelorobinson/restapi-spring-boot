package com.backend.restapi.staff;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {
    public List<Staff> getStudents() {

        List<Staff> staffList = new ArrayList<Staff>();

        Staff staff = new Staff(1L, "John", "john@example.com", LocalDate.of(1980, Month.JANUARY, 1), 30);

        staffList.add(staff);

        return staffList;
    }
}
