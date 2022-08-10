package com.backend.restapi.staff;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StaffConfig {

    @Bean
    CommandLineRunner commandLineRunner(StaffRepository repository) {
        return args -> {
            Staff john = new Staff(1L, "John", "john@exmaple.com", LocalDate.of(1980, Month.JANUARY, 1));
            Staff jane = new Staff( "Jane", "jane@exmaple.com", LocalDate.of(1980, Month.JANUARY, 1));

            List<Staff> staff = new ArrayList<>();
            staff.add(john);
            staff.add(jane);

            repository.saveAll(staff);
        };
    }
}