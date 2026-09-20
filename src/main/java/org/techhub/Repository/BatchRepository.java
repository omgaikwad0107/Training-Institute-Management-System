package org.techhub.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.BatchModel;

@Repository
public class BatchRepository {

    @Autowired
    private JdbcTemplate template;

    // Add Batch
    public boolean saveBatch(BatchModel batch) {

        String sql = "INSERT INTO batches "
                   + "(batch_name, course_name, start_date, end_date, status) "
                   + "VALUES (?, ?, ?, ?, ?)";

        int result = template.update(
                sql,
                batch.getBatchName(),
                batch.getCourseName(),
                batch.getStartDate(),
                batch.getEndDate(),
                batch.getStatus()
        );

        return result > 0;
    }

    // Get All Batches
    public List<BatchModel> getAllBatches() {

        String sql = "SELECT id, batch_name, course_name, "
                   + "start_date, end_date, status "
                   + "FROM batches "
                   + "ORDER BY id DESC";

        return template.query(sql, (rs, rowNum) -> {

            BatchModel batch = new BatchModel();

            batch.setId(rs.getInt("id"));
            batch.setBatchName(rs.getString("batch_name"));
            batch.setCourseName(rs.getString("course_name"));

            if (rs.getDate("start_date") != null) {
                batch.setStartDate(
                        rs.getDate("start_date").toLocalDate()
                );
            }

            if (rs.getDate("end_date") != null) {
                batch.setEndDate(
                        rs.getDate("end_date").toLocalDate()
                );
            }

            batch.setStatus(rs.getString("status"));

            return batch;
        });
    }

    // Get Active Batches
    public List<BatchModel> getActiveBatches() {

        String sql = "SELECT id, batch_name, course_name, "
                   + "start_date, end_date, status "
                   + "FROM batches "
                   + "WHERE status = 'ACTIVE' "
                   + "ORDER BY batch_name";

        return template.query(sql, (rs, rowNum) -> {

            BatchModel batch = new BatchModel();

            batch.setId(rs.getInt("id"));
            batch.setBatchName(rs.getString("batch_name"));
            batch.setCourseName(rs.getString("course_name"));

            if (rs.getDate("start_date") != null) {
                batch.setStartDate(
                        rs.getDate("start_date").toLocalDate()
                );
            }

            if (rs.getDate("end_date") != null) {
                batch.setEndDate(
                        rs.getDate("end_date").toLocalDate()
                );
            }

            batch.setStatus(rs.getString("status"));

            return batch;
        });
    }

    // Get Batch By ID
    public BatchModel getBatchById(int id) {

        String sql = "SELECT id, batch_name, course_name, "
                   + "start_date, end_date, status "
                   + "FROM batches "
                   + "WHERE id = ?";

        List<BatchModel> list = template.query(
                sql,
                (rs, rowNum) -> {

                    BatchModel batch = new BatchModel();

                    batch.setId(rs.getInt("id"));
                    batch.setBatchName(rs.getString("batch_name"));
                    batch.setCourseName(rs.getString("course_name"));

                    if (rs.getDate("start_date") != null) {
                        batch.setStartDate(
                                rs.getDate("start_date").toLocalDate()
                        );
                    }

                    if (rs.getDate("end_date") != null) {
                        batch.setEndDate(
                                rs.getDate("end_date").toLocalDate()
                        );
                    }

                    batch.setStatus(rs.getString("status"));

                    return batch;
                },
                id
        );

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    // Update Batch
    public boolean updateBatch(BatchModel batch) {

        String sql = "UPDATE batches SET "
                   + "batch_name = ?, "
                   + "course_name = ?, "
                   + "start_date = ?, "
                   + "end_date = ?, "
                   + "status = ? "
                   + "WHERE id = ?";

        int result = template.update(
                sql,
                batch.getBatchName(),
                batch.getCourseName(),
                batch.getStartDate(),
                batch.getEndDate(),
                batch.getStatus(),
                batch.getId()
        );

        return result > 0;
    }

    // Delete Batch
    public boolean deleteBatch(int id) {

        String sql = "DELETE FROM batches WHERE id = ?";

        int result = template.update(sql, id);

        return result > 0;
    }

    // Get Active Batches By Course
    public List<BatchModel> getActiveBatchesByCourse(String courseName) {

        String sql = "SELECT id, batch_name, course_name, "
                   + "start_date, end_date, status "
                   + "FROM batches "
                   + "WHERE course_name = ? "
                   + "AND status = 'ACTIVE' "
                   + "ORDER BY batch_name";

        return template.query(
                sql,
                (rs, rowNum) -> {

                    BatchModel batch = new BatchModel();

                    batch.setId(rs.getInt("id"));
                    batch.setBatchName(rs.getString("batch_name"));
                    batch.setCourseName(rs.getString("course_name"));

                    if (rs.getDate("start_date") != null) {
                        batch.setStartDate(
                                rs.getDate("start_date").toLocalDate()
                        );
                    }

                    if (rs.getDate("end_date") != null) {
                        batch.setEndDate(
                                rs.getDate("end_date").toLocalDate()
                        );
                    }

                    batch.setStatus(rs.getString("status"));

                    return batch;
                },
                courseName
        );
    }

    // Get Total Batches
    public int getTotalBatches() {

        String sql = "SELECT COUNT(*) FROM batches";

        return template.queryForObject(
                sql,
                Integer.class
        );
    }
}