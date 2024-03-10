package com.lab.labschooldemo.service;

import com.lab.labschooldemo.converter.SchoolConverter;
import com.lab.labschooldemo.dto.request.SchoolRequest;
import com.lab.labschooldemo.dto.response.SchoolResponse;
import com.lab.labschooldemo.exception.SchoolAlreadyExistsException;
import com.lab.labschooldemo.exception.SchoolNotFoundException;
import com.lab.labschooldemo.model.School;
import com.lab.labschooldemo.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class SchoolService {
  private final SchoolRepository schoolRepository;

  public SchoolResponse createSchool(SchoolRequest request) {
    Optional<School> schoolByName=schoolRepository.findBySchoolName(request.getSchoolName());
    if (schoolByName.isPresent()){
  throw new SchoolAlreadyExistsException("School already exists with name: "+request.getSchoolName());

    }
    return SchoolConverter.convertToSchoolCreateResponse(schoolRepository.save(SchoolConverter.convertToSchool(request)));
  }

  public void deleteSchoolById(long id) {
    schoolRepository.deleteById(id);
  }

  public SchoolResponse getSchoolByID(long id) {
    return SchoolConverter.convertToSchoolCreateResponse(findById(id));
  }
  private School findById(long id){
    return schoolRepository.findById(id).orElseThrow(() -> new SchoolNotFoundException("School not found"));
  }

  public void updateSchool(long id, SchoolRequest request) {
  School oldSchool=findById(id);
  oldSchool.setSchoolName(request.getSchoolName());
  schoolRepository.save(oldSchool);
  }

  public List<School> getSchool(String schoolName) {
    if (schoolName==null){
      return schoolRepository.findAll();
    }else {
      return schoolRepository.findAllBySchoolName(schoolName);
    }
  }
}
