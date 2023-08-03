/**
 * #=== Created by Dazzler7Soft.Eng.Udg ===#
 * Date : 03-Aug-2023
 * Time : 12:05 PM
 * Project Name : JasperReports-Spring-Boot
 */
package lk.dazzler.devo.java.spring.jasper.reports.service;

import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private ResourceLoader resourceLoader;

    public byte[] generateReport() throws JRException, IOException {
        // Load the JRXML file
        Resource resource = resourceLoader.getResource("classpath:WelcomeReport.jrxml");

        // Compile the report design to JasperReport object
        JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());

        // Add data to the report (if needed)
        Map<String, Object> params = new HashMap<>();
        // Add parameters if needed
        
        // Generate the report using the JasperReport and data
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

        // Export the report to a byte array (PDF, XLS, etc.)
        byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        return reportBytes;
    }
}
