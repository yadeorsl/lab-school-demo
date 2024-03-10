package com.lab.labschooldemo.service;

import com.lab.labschooldemo.converter.SchoolConverter;
import com.lab.labschooldemo.dto.request.SchoolRequest;
import com.lab.labschooldemo.dto.response.SchoolCreateResponse;
import com.lab.labschooldemo.exception.SchoolAlreadyExistsException;
import com.lab.labschooldemo.model.School;
import com.lab.labschooldemo.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class SchoolService {
  private final SchoolRepository schoolRepository;

  public SchoolCreateResponse createSchool(SchoolRequest request) {
    Optional<School> schoolByName=schoolRepository.findBySchoolName(request.getSchoolName());
    if (schoolByName.isPresent()){
  throw new SchoolAlreadyExistsException("School already exists with name: "+request.getSchoolName());

    }
    return SchoolConverter.convertToSchoolCreateResponse(schoolRepository.save(SchoolConverter.convertToSchool(request)));
  }
}
