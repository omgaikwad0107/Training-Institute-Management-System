package org.techhub.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.Model.ReportModel;
import org.techhub.Repository.ReportRepository;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;


    public ReportModel getReport() {

        return reportRepository.getReport();
    }
}