package org.choongang.student.mapper;

import org.choongang.student.controllers.SearchStudent;
import org.choongang.student.entities.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements StudentMapper {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE"; // 데이터베이스 URL
    private static final String DB_USERNAME = "PROJECT2_1"; // 데이터베이스 사용자
    private static final String DB_PASSWORD = "oracle"; // 데이터베이스 비밀번호

    public StudentRepository() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle 드라이버 로드
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    @Override
    public List<Student> getList(SearchStudent search) { // 전체 학생 목록 조회
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM STUDENT";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Student student = Student.builder()
                        .studentNo(rs.getLong("STUDENT_NO")) // 학번
                        .studentNm(rs.getString("STUDENT_NM")) // 이름
                        .mobile(rs.getString("MOBILE")) // 전화번호
                        .classId(rs.getString("CLASS_ID")) // 과정 ID
                        .build();
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public Student get(String studentNo) { // 학생 개별 조회
        Student student = null;
        String sql = "SELECT * FROM STUDENT WHERE STUDENT_NO = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentNo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    student = Student.builder()
                            .studentNo(rs.getLong("STUDENT_NO")) // 학번
                            .studentNm(rs.getString("STUDENT_NM")) // 이름
                            .mobile(rs.getString("MOBILE")) // 전화번호
                            .classId(rs.getString("CLASS_ID")) // 과정 ID
                            .build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public long getTotal(SearchStudent search) { // 학생 총 수 조회
        long total = 0;
        String sql = "SELECT COUNT(*) FROM STUDENT";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }

    @Override
    public int exist(String studentNo) { // 학생 등록 여부 파악
        int count = 0;
        String sql = "SELECT COUNT(*) FROM STUDENT WHERE STUDENT_NO = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentNo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public int register(Student student) { // 학생 등록
        String sql = "INSERT INTO STUDENT (STUDENT_NO, STUDENT_NM, MOBILE, CLASS_ID) VALUES (STUDENT_SEQ.NEXTVAL, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getStudentNm()); // 이름
            pstmt.setString(2, student.getMobile()); // 전화번호
            pstmt.setString(3, student.getClassId()); // 과정 ID

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}

/**
 * StudentRepository 클래스 정의 -> StudentMapper 인터페이스 구현 -> 데이터베이스와 상호작용하여 학생 관련 정보 처리
 * getList : 데이터베이스에서 전체 학생 목록 조회 -> SQL 쿼리 실행하여 결과를 List<Student> 형태로 반환
 * get : 주어진 학번에 해당하는 학생 조회 -> SQL 쿼리 실행하여 결과를 Student 객체로 반환
 * getTotal: 데이터베이스에 등록된 전체 학생 수 조회 -> SQL 쿼리를 실행하여 결과를 long 형태로 반환
 * exist : 주어진 학번이 이미 등록되어 있는지 확인 -> SQL 쿼리를 실행하여 결과를 int 형태로 반환
 * register : 새로운 학생 정보 데이터베이스에 등록 -> SQL 쿼리를 실행하여 등록된 행의 수 반환
 */