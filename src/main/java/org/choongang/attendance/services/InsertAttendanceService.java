package org.choongang.attendance.services;

import org.choongang.attendance.controllers.RequestInsertAttendance;
//import org.choongang.attendance.validators.InsertAttendanceValidator;
import org.choongang.global.Service;

public class InsertAttendanceService implements Service<RequestInsertAttendance> {
    /*
    private final InsertAttendanceValidator
    */
    @Override
    public void process(RequestInsertAttendance form) {
       // validator.check(form);
    }
}
