/**
 * #=== Created by Dazzler7Soft.Eng.Udg ===#
 * Date : 03-Aug-2023
 * Time : 12:09 PM
 * Project Name : JasperReports-Spring-Boot
 */
package lk.dazzler.devo.java.spring.jasper.reports.controller;

import lk.dazzler.devo.java.spring.jasper.reports.dto.CustomerDTO;
import lk.dazzler.devo.java.spring.jasper.reports.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportServiceImpl service;

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generateReport(@RequestBody CustomerDTO dto) {
        try {
            byte[] reportBytes = service.generateReport(dto);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            // You can set additional headers if needed (e.g., Content-Disposition)

            return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
