package com.orage.clientservice.service;


import com.orage.clientservice.model.Client;
import com.orage.clientservice.repository.ClientRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ExcelExportService {

    @Autowired
    private ClientRepository clientRepository;

    // Export clients to Excel based on pagination
    public byte[] exportClientsToExcel(int page, int size) throws IOException {
        // Paginated request to fetch clients
        Page<Client> clientsPage = clientRepository.findAll(PageRequest.of(page, size));

        // Create a new workbook and sheet for Excel export
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Clients");

        // Create cell style for headers
        CellStyle headerStyle = createHeaderCellStyle(workbook);

        // Create a cell style for normal data
        CellStyle dataStyle = createDataCellStyle(workbook);

        // Create the header row
        Row headerRow = sheet.createRow(0);

        // Set the headers with bold and color styling
        String[] headers = {
                "Client ID", "Company Name", "Phone", "Email", "GST Treatment", "GSTIN", "PAN", "TIN", "VAT"
        };

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Populate the data rows with client data
        int rowNum = 1;
        for (Client client : clientsPage.getContent()) {
            Row row = sheet.createRow(rowNum++);

            createDataCell(row, 0, client.getId(), dataStyle);
            createDataCell(row, 1, client.getCompanyName(), dataStyle);
            createDataCell(row, 2, client.getPhone(), dataStyle);
            createDataCell(row, 3, client.getEmail(), dataStyle);
            createDataCell(row, 4, client.getGstTreatment(), dataStyle);
            createDataCell(row, 5, client.getGstin(), dataStyle);
            createDataCell(row, 6, client.getPan(), dataStyle);
            createDataCell(row, 7, client.getTin(), dataStyle);
            createDataCell(row, 8, client.getVat(), dataStyle);
        }

        // Adjust column widths to fit the content
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the workbook to a byte array output stream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        workbook.close();

        // Return the byte array of the Excel file
        return byteArrayOutputStream.toByteArray();
    }

    // Method to create a header style with color and bold text
    private CellStyle createHeaderCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();

        // Set background color
        style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Set text to bold
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);

        // Align text to center horizontally and vertically
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        // Set borders
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        return style;
    }

    // Method to create a data cell style for normal data
    private CellStyle createDataCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();

        // Set borders
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        // Align text to left (default)
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        return style;
    }


    private void createDataCell(Row row, int columnIndex, Object value, CellStyle style) {
        Cell cell = row.createCell(columnIndex);
        if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue(value != null ? value.toString() : "");
        }
        cell.setCellStyle(style);
    }
}
