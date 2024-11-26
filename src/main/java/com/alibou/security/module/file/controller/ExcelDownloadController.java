package com.alibou.security.module.file.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibou.security.util.FileUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/excel")
public class ExcelDownloadController {

    // private XSSFWorkbook workbook;
    // private XSSFSheet sheet;

    private static final DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    private static final String currentDateTime = dateFormatter.format(new Date());
    private FileUtil fileUtil;

    public ExcelDownloadController() {
        // workbook = new XSSFWorkbook();
        fileUtil = new FileUtil();
    }

    
    

    @GetMapping("/downloadFixPath")
    public void downloadFixPath(HttpServletResponse response) throws IOException{
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";

        response.setContentType("application/octet-stream");
        response.setHeader(headerKey, headerValue);
        // ExcelDownloadController excelExporter = new ExcelDownloadController();
        // excelExporter.export(response);  
        fileUtil.export(response);
    }

    // public void export(HttpServletResponse response) throws IOException {
    //     writeHeaderLine();
    //     writeDataLines();
    //     File currDir = new File(".");
    //     String path = currDir.getAbsolutePath();
    //     String fileLocation = path.substring(0, path.length() - 1) + "file/temp.xlsx";
    //     FileOutputStream outputStream = new FileOutputStream(fileLocation);
    //     // ServletOutputStream outputStream = response.getOutputStream();
    //     workbook.write(outputStream);
    //     workbook.close();
         
    //     outputStream.close();
    // }

    // private void writeHeaderLine() {
    //     sheet = workbook.createSheet("Users");
    //     Row row = sheet.createRow(0);
    //     CellStyle style = workbook.createCellStyle();
    //     XSSFFont font = workbook.createFont();
    //     font.setBold(true);
    //     font.setFontHeight(16);
    //     style.setFont(font);
         
    //     createCell(row, 0, "User ID", style);      
    //     createCell(row, 1, "E-mail", style);       
    //     createCell(row, 2, "Full Name", style);    
    //     createCell(row, 3, "Roles", style);
    //     createCell(row, 4, "Enabled", style);
    // }

    // private void writeDataLines() {
    //     int rowCount = 1;
    //     CellStyle style = workbook.createCellStyle();
    //     XSSFFont font = workbook.createFont();
    //     font.setFontHeight(14);
    //     style.setFont(font);
                 
    //     Row row = sheet.createRow(rowCount++);
    //     int columnCount = 0;
             
    //     createCell(row, columnCount++, "-", style);
    //     createCell(row, columnCount++, "-", style);
    //     createCell(row, columnCount++, "-", style);
    //     createCell(row, columnCount++, "-", style);
    //     createCell(row, columnCount++, "-", style);
    // }

    // private void createCell(Row row, int columnCount, Object value, CellStyle style) {
    //     sheet.autoSizeColumn(columnCount);
    //     Cell cell = row.createCell(columnCount);
    //     if (value instanceof Integer) {
    //         cell.setCellValue((Integer) value);
    //     } else if (value instanceof Boolean) {
    //         cell.setCellValue((Boolean) value);
    //     }else {
    //         cell.setCellValue((String) value);
    //     }
    //     cell.setCellStyle(style);
    // }
}