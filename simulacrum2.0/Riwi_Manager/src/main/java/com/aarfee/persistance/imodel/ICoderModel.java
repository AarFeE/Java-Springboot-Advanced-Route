package com.aarfee.persistance.imodel;

import com.aarfee.entities.CoderEntity;
import com.aarfee.persistance.crud.*;

public interface ICoderModel extends
        CreateModel<CoderEntity>,
        DeleteModel<Integer>,
        ReadAllModel<CoderEntity>,
        ReadModel<Integer, CoderEntity>,
        UpdateModel<Integer, CoderEntity> {}
