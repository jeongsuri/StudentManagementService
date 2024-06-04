package org.choongang.attendance.services;

import org.choongang.attendance.entities.Attendance;
import org.choongang.attendance.mapper.AttendanceMapper;
import org.choongang.global.Service;
import java.util.List;

public class ListAttendanceService implements Service<List<Attendance>> {

    private AttendanceMapper mapper;

    public ListAttendanceService(AttendanceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Attendance> process() {
        return mapper.getList();
    }
}
