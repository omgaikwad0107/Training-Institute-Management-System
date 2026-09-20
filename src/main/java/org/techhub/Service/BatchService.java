package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.techhub.Model.BatchModel;
import org.techhub.Repository.BatchRepository;

@Service
public class BatchService {

    @Autowired
    private BatchRepository batchRepository;

    // Add Batch
    @Transactional
    public boolean saveBatch(BatchModel batch) {

        if (batch == null) {
            return false;
        }

        if (batch.getStatus() == null || batch.getStatus().trim().isEmpty()) {
            batch.setStatus("ACTIVE");
        }

        return batchRepository.saveBatch(batch);
    }

    // Get All Batches
    public List<BatchModel> getAllBatches() {
        return batchRepository.getAllBatches();
    }

    // Get Active Batches
    public List<BatchModel> getActiveBatches() {
        return batchRepository.getActiveBatches();
    }

    // Get Batch By ID
    public BatchModel getBatchById(int id) {

        if (id <= 0) {
            return null;
        }

        return batchRepository.getBatchById(id);
    }

    // Update Batch
    @Transactional
    public boolean updateBatch(BatchModel batch) {

        if (batch == null) {
            return false;
        }

        if (batch.getId() <= 0) {
            return false;
        }

        return batchRepository.updateBatch(batch);
    }

    // Delete Batch
    @Transactional
    public boolean deleteBatch(int id) {

        if (id <= 0) {
            return false;
        }

        return batchRepository.deleteBatch(id);
    }

    // Get Active Batches By Course
    public List<BatchModel> getActiveBatchesByCourse(String courseName) {

        if (courseName == null || courseName.trim().isEmpty()) {
            return List.of();
        }

        return batchRepository.getActiveBatchesByCourse(courseName);
    }

    // Get Total Batches
    public int getTotalBatches() {
        return batchRepository.getTotalBatches();
    }
}