package com.lab.labschooldemo.controller;

import com.lab.labschooldemo.dto.request.SchoolRequest;
import com.lab.labschooldemo.dto.response.SchoolCreateResponse;
import com.lab.labschooldemo.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    public SchoolCreateResponse createSchool(@RequestBody SchoolRequest request){
        return schoolService.createSchool(request);
    }
    @DeleteMapping("{id}")
    public void deleteSchoolByID(@PathVariable long id){
        schoolService.deleteSchoolById(id);
    }

}
