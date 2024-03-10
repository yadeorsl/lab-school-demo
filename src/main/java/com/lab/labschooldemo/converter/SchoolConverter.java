package com.lab.labschooldemo.converter;

import com.lab.labschooldemo.dto.request.SchoolRequest;
import com.lab.labschooldemo.dto.response.SchoolResponse;
import com.lab.labschooldemo.model.School;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SchoolConverter {
    public static School convertToSchool(SchoolRequest request){
        School school=new School();
        school.setSchoolName(request.getSchoolName());
        return school;
    }
    public static SchoolResponse convertToSchoolCreateResponse(School school){
        SchoolResponse schoolResponse =new SchoolResponse();
        schoolResponse.setCreatedDate(school.getCreatedDate());
        schoolResponse.setSchoolName(school.getSchoolName());
        return schoolResponse;

    }
}
