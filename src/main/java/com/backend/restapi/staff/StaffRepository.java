package com.backend.restapi.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>  {

    // SELECT * FROM staff WHERE email = ?
    @Query("SELECT s FROM Staff s WHERE s.email = ?1")
    Optional<Staff> findByEmail(String email);
}
