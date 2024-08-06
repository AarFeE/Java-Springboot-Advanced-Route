package com.aarfee.persistence.imodels;

import com.aarfee.entities.SubscriptionEntity;
import com.aarfee.persistence.crud.*;

public interface ISubscriptionModel extends
        CreateModel<SubscriptionEntity>,
        DeleteModel<Integer>,
        ReadAllModel<SubscriptionEntity>,
        ReadModel<SubscriptionEntity, Integer>,
        UpdateModel<SubscriptionEntity, Integer> {

    public SubscriptionEntity checkSubscription(int studentId, int courseId);

    public String readStudentCourseById(int id);

    public String readStudentsCourses();
}
