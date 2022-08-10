package com.backend.restapi.staff;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getStudents() {
        return staffService.getStaff();
    }

    @PostMapping
    public void addStaff(@RequestBody Staff staff) {
        staffService.addStaff(staff);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStaff(@PathVariable("id") Long id) {
        staffService.deleteStaff(id);
    }

    @PutMapping(path = "{id}")
    public void updateStaff(@PathVariable("id") Long id, @RequestBody Staff staff) {
        staffService.updateStaff(id, staff);
    }
}
