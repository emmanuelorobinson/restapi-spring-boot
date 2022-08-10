package com.backend.restapi.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
    
    public List<Staff> getStaff() {
        return staffRepository.findAll();
    }

    public void addStaff(Staff staff) {
        Optional<Staff> staffOptional = staffRepository.findByEmail(staff.getEmail());

        if (staffOptional.isPresent()) {
            throw new IllegalStateException("Staff already exists");
        }

        staffRepository.save(staff);
    }

    public void deleteStaff(Long id) {
        boolean staffExists = staffRepository.existsById(id);

        if (!staffExists) {
            throw new IllegalStateException("Staff does not exist");
        }

        staffRepository.deleteById(id);

    }

    @Transactional
    public void updateStaff(Long id, Staff staff) {
        Optional<Staff> staffOptional = staffRepository.findById(id);
        if (!staffOptional.isPresent()) {
            throw new IllegalStateException("Staff does not exist");
        }
        Staff staffToUpdate = staffOptional.get();

        // check if any of the fields are null or in use
        if (staff.getName() != null) {
            staffToUpdate.setName(staff.getName());
        }
        if (staff.getEmail() != null) {
            staffToUpdate.setEmail(staff.getEmail());
        }
        if (staff.getDob() != null) {
            staffToUpdate.setDob(staff.getDob());
        }
        staffRepository.save(staffToUpdate);
    }

}
