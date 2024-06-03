package org.choongang.attendance.validators;

import org.choongang.attendance.controllers.RequestInsertAttendance;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;

public class InsertAttendanceValidator implements Validator<RequestInsertAttendance>, RequiredValidator {
    @Override
    public void check(RequestInsertAttendance form) {

    }
}
