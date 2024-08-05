package com.aarfee.persistance.imodel;

import com.aarfee.entities.EnterpriseEntity;
import com.aarfee.persistance.crud.*;

public interface IEnterpriseModel extends
        CreateModel<EnterpriseEntity>,
        DeleteModel<Integer>,
        ReadAllModel<EnterpriseEntity>,
        ReadModel<Integer, EnterpriseEntity>,
        UpdateModel<Integer, EnterpriseEntity> {}
