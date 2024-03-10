package com.lab.labschooldemo.repository;

import com.lab.labschooldemo.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School,Long> {
   Optional<School> findBySchoolName(String schoolName);
   List<School> findAllBySchoolName(String SchoolName);
}
