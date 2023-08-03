package lk.dazzler.devo.java.spring.jasper.reports.service;

import lk.dazzler.devo.java.spring.jasper.reports.dto.CustomerDTO;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;

public interface ReportService {
    public byte[] generateReport(CustomerDTO dto) throws JRException, IOException;
}
