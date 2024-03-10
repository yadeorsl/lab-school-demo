package com.lab.labschooldemo.controller;

import com.lab.labschooldemo.dto.request.SchoolRequest;
import com.lab.labschooldemo.dto.response.SchoolResponse;
import com.lab.labschooldemo.exception.SchoolAlreadyExistsException;
import com.lab.labschooldemo.exception.SchoolNotFoundException;
import com.lab.labschooldemo.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    public SchoolResponse createSchool(@RequestBody SchoolRequest request){
        return schoolService.createSchool(request);
    }
    @GetMapping("{id}")
    public SchoolResponse getSchoolByID(@PathVariable long id){
        return schoolService.getSchoolByID(id);
    }
    @PutMapping("{id}")
    public void updateSchool(@PathVariable long id,@RequestBody SchoolRequest request){
        schoolService.updateSchool(id,request);
    }

    @DeleteMapping("{id}")
    public void deleteSchoolByID(@PathVariable long id){
        schoolService.deleteSchoolById(id);
    }
    @ExceptionHandler(SchoolAlreadyExistsException.class)
    public ResponseEntity<String> handleSchoolAlreadyExistsException(SchoolAlreadyExistsException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(SchoolNotFoundException.class)
    public ResponseEntity<String> handleSchoolNotFoundException(SchoolNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
