package com.aarfee.persistance.imodel;

import com.aarfee.entities.EnterpriseEntity;
import com.aarfee.entities.VacancyEntity;
import com.aarfee.persistance.crud.*;

public interface IVacancyModel extends
        CreateModel<VacancyEntity>,
        DeleteModel<Integer>,
        ReadAllModel<VacancyEntity>,
        ReadModel<Integer, VacancyEntity>,
        UpdateModel<Integer, VacancyEntity> {

    public void changeState(Integer id);

}
