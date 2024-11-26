package com.alibou.security.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import jakarta.servlet.http.HttpServletResponse;

public class FileUtil {
    
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private Path foundFile;

    private static final DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    private static final String currentDateTime = dateFormatter.format(new Date());

    public FileUtil() {
        workbook = new XSSFWorkbook();
    }
     
    public Resource getFileAsResource(String filename) throws IOException {
        Path dirPath = Paths.get("file");
         
        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(filename)) {
                foundFile = file;
                return;
            }
        });
 
        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }
         
        return null;
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "file/temp.xlsx";
        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        // ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "User ID", style);      
        createCell(row, 1, "E-mail", style);       
        createCell(row, 2, "Full Name", style);    
        createCell(row, 3, "Roles", style);
        createCell(row, 4, "Enabled", style);
    }

    private void writeDataLines() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        Row row = sheet.createRow(rowCount++);
        int columnCount = 0;
             
        createCell(row, columnCount++, "-", style);
        createCell(row, columnCount++, "-", style);
        createCell(row, columnCount++, "-", style);
        createCell(row, columnCount++, "-", style);
        createCell(row, columnCount++, "-", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
}
