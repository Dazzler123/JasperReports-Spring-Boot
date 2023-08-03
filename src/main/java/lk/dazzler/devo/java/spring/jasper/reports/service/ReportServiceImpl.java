/**
 * #=== Created by Dazzler7Soft.Eng.Udg ===#
 * Date : 03-Aug-2023
 * Time : 12:05 PM
 * Project Name : JasperReports-Spring-Boot
 */
package lk.dazzler.devo.java.spring.jasper.reports.service;

import lk.dazzler.devo.java.spring.jasper.reports.dto.CustomerDTO;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ResourceLoader resourceLoader;

    public byte[] generateReport(CustomerDTO dto) throws JRException, IOException {
        // Load the JRXML file
        Resource resource = resourceLoader.getResource("classpath:WelcomeReport.jrxml");

        // Compile the report design to JasperReport object
        JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());

        // Add data to the report (if needed)
        Map<String, Object> params = new HashMap<>();
        // Add parameters if needed
        params.put("id",dto.getId());
        params.put("name",dto.getName());
        params.put("age",dto.getAge());
        params.put("address",dto.getAddress());

        // Generate the report using the JasperReport and data
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

        // Export the report to a byte array (PDF, XLS, etc.)
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
