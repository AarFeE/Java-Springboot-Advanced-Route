package com.aarfee.persistence.imodels;

import com.aarfee.entities.GradeEntity;
import com.aarfee.persistence.crud.*;

public interface IGradeModel extends
        CreateModel<GradeEntity>,
        DeleteModel<Integer>,
        ReadAllModel<GradeEntity>,
        ReadModel<GradeEntity, Integer>,
        UpdateModel<GradeEntity, Integer> {}
