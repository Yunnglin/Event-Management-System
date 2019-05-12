package com.cms.mapper;

import com.cms.pojo.Doctor;

public interface DoctorMapper {

    int insert(Doctor doctor);

    Doctor queryById(String id);

    String queryNameById(String id);
}
