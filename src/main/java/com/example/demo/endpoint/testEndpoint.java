package com.example.demo.endpoint;

import com.example.demo.core.exception.CtmHttpError;
import com.example.demo.core.redis.CtmRedisTemplate;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class testEndpoint {
    @Autowired
    CtmRedisTemplate ctmRedisTemplate;

    @PostMapping("/left-push")
    public void leftPush(@RequestBody Map<String, String> request) {
        ctmRedisTemplate.opsForList().leftPush(request.get("key"), request.get("value"));
    }

    @PostMapping("/right-push")
    public void rightPush(@RequestBody Map<String, String> request) {
        ctmRedisTemplate.opsForList().rightPush(request.get("key"), request.get("value"));
    }

    @GetMapping("/getAll")
    public List<Object> getAll() {
        return (List<Object>) ctmRedisTemplate.getAllByKey("meo");
    }

    @PostMapping("/import")
    public void importData(@RequestParam("file") MultipartFile file) throws IOException {
        Workbook workbook = new HSSFWorkbook(file.getInputStream());
        //Get first/desired sheet from the workbook
        workbook.getSheetAt(0).getRow(0).getCell(100);
        workbook.close();
        System.out.println("sdas");
    }

    @GetMapping("/export")
    public String exportData() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");

        Object[][] bookData = {
                {"Head First Java", "Kathy Serria", 79},
                {"Effective Java", "Joshua Bloch", 36},
                {"Clean Code", "Robert martin", 42},
                {"Thinking in Java", "Bruce Eckel", 35},
        };

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        try (FileOutputStream outputStream = new FileOutputStream("/home/dung/Documents/JavaBooks.xlsx")) {
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();
            return "/home/dung/Documents/JavaBooks.xlsx";
        }
    }

    @PostMapping("/test")
    public Object test(@RequestBody Map<String, Object> request) {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("meo", "meo");
            return map;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CtmHttpError(
                    new Timestamp(new Date().getTime()),
                    1000,
                    "loi tum lum",
                    "nhap du lieu ga vl",
                    "/api/test"));
        }
    }

    @PostMapping("/abc")
    public String test(@RequestBody String abc) {
        return abc;
    }

}
