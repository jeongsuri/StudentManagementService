package attendanceTest;


import org.choongang.attendance.entities.Attendance;
import org.choongang.attendance.mapper.AttendanceMapper;
import org.choongang.global.configs.DBConn;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SelectData {
    @Test
    void test1() {
        AttendanceMapper mapper = DBConn.getSession().getMapper(AttendanceMapper.class);
        List<Attendance> items = mapper.getList();
        items.forEach(System.out::println);
    }
}
