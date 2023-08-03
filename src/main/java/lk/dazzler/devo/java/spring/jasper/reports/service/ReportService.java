package lk.dazzler.devo.java.spring.jasper.reports.service;

import net.sf.jasperreports.engine.JRException;

import java.io.IOException;

public interface ReportService {
    public byte[] generateReport() throws JRException, IOException;
}
