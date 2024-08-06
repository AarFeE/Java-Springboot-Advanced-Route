package com.aarfee.persistence.imodels;

import com.aarfee.entities.CourseEntity;
import com.aarfee.persistence.crud.*;

public interface ICourseModel extends
        CreateModel<CourseEntity>,
        DeleteModel<Integer>,
        ReadAllModel<CourseEntity>,
        ReadModel<CourseEntity, Integer>,
        UpdateModel<CourseEntity, Integer> {}
