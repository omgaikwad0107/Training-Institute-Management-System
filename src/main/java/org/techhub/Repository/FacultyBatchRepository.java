package org.techhub.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.BatchModel;

@Repository
public class FacultyBatchRepository {

    @Autowired
    private JdbcTemplate template;


    // =====================================================
    // GET FACULTY BATCHES
    // =====================================================

    public List<BatchModel> getBatchesByFacultyUsername(
            String username) {

        String sql =
                "SELECT " +
                "b.id, " +
                "b.batch_name, " +
                "b.course_name, " +
                "b.start_date, " +
                "b.end_date, " +
                "b.status, " +
                "b.faculty_id, " +

                "(SELECT COUNT(DISTINCT e.student_id) " +
                " FROM enrollments e " +
                " INNER JOIN students s " +
                " ON e.student_id = s.id " +
                " WHERE TRIM(e.batch) = TRIM(b.batch_name) " +
                " AND e.status = 'ACTIVE' " +
                " AND s.status = 'ACTIVE'" +
                ") AS student_count " +

                "FROM batches b " +

                "INNER JOIN faculty f " +
                "ON b.faculty_id = f.id " +

                "INNER JOIN users u " +
                "ON f.user_id = u.id " +

                "WHERE u.username = ? " +

                "ORDER BY b.id";


        return template.query(
                sql,
                (rs, rowNum) -> {

                    BatchModel batch =
                            new BatchModel();


                    batch.setId(
                            rs.getInt("id")
                    );


                    batch.setBatchName(
                            rs.getString("batch_name")
                    );


                    batch.setCourseName(
                            rs.getString("course_name")
                    );


                    if (rs.getDate("start_date") != null) {

                        batch.setStartDate(
                                rs.getDate("start_date")
                                        .toLocalDate()
                        );
                    }


                    if (rs.getDate("end_date") != null) {

                        batch.setEndDate(
                                rs.getDate("end_date")
                                        .toLocalDate()
                        );
                    }


                    batch.setStatus(
                            rs.getString("status")
                    );


                    batch.setFacultyId(
                            rs.getInt("faculty_id")
                    );


                    batch.setStudentCount(
                            rs.getInt("student_count")
                    );


                    return batch;

                },
                username
        );
    }


    // =====================================================
    // GET TOTAL BATCHES
    // =====================================================

    public int getTotalBatchesByFacultyUsername(
            String username) {

        String sql =
                "SELECT COUNT(*) " +

                "FROM batches b " +

                "INNER JOIN faculty f " +
                "ON b.faculty_id = f.id " +

                "INNER JOIN users u " +
                "ON f.user_id = u.id " +

                "WHERE u.username = ?";


        Integer count =
                template.queryForObject(
                        sql,
                        Integer.class,
                        username
                );


        return count != null ? count : 0;
    }
}