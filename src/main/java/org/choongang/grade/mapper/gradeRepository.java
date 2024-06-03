package org.choongang.grade.mapper;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class gradeRepository implements GradeMapper{
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE"; // 데이터베이스 URL
    private static final String DB_USERNAME = "PROJECT2_1"; // 데이터베이스 사용자
    private static final String DB_PASSWORD = "oracle"; // 데이터베이스 비밀번호

    public gradeRepository() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle 드라이버 로드
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
//        }
        }
        private Connection getConnection() throws SQLException {
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

    }
        @Override
        public grade get(String studentNo) { // 학생 개별 조회
            Grade grade = null;
            String sql = "SELECT * FROM STUDENT WHERE STUDENT_NO = ?";

            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, studentNo);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        grade = Grade.builder()
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

            return grade;
        }

}
