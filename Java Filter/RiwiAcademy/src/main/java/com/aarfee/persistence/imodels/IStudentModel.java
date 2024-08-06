package com.aarfee.persistence.imodels;

import com.aarfee.entities.StudentEntity;
import com.aarfee.persistence.crud.*;

import java.util.List;

public interface IStudentModel extends
        CreateModel<StudentEntity>,
        DeleteModel<Integer>,
        ReadAllModel<StudentEntity>,
        ReadModel<StudentEntity, Integer>,
        UpdateModel<StudentEntity, Integer> {

    public StudentEntity readByEmail(String email);

    public List<StudentEntity> readAllActive();
}
