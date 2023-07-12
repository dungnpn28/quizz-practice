/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.QuestionDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import model.Question;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Acer
 */
@MultipartConfig
public class QuestionImportController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDAO qe = new QuestionDAO();
        Part filePart = req.getPart("xlsxfile");
        System.out.println(filePart);
        FileInputStream fis = (FileInputStream) filePart.getInputStream();
        System.out.println("inputStream: " + fis);
        //creating Workbook instance that refers to .xlsx file  
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
//        FormulaEvaluator fmEval = wb.getCreationHelper().createFormulaEvaluator();
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                Cell subjectIdCell = row.getCell(0);
                Cell lessonIdCell = row.getCell(1);
                Cell contentCell = row.getCell(2);
                Cell optionACell = row.getCell(3);
                Cell optionBCell = row.getCell(4);
                Cell optionCCell = row.getCell(5);
                Cell optionDCell = row.getCell(6);
                Cell answerCell = row.getCell(7);
                Cell answerExplanationCell = row.getCell(8);
                Cell levelCell = row.getCell(9);
                Cell statusCell = row.getCell(10);
                System.out.println(optionBCell.getStringCellValue());
                if (subjectIdCell != null) {
                    // Extract ID and content values
                    int subjectId = (int) subjectIdCell.getNumericCellValue();
                    int lessonId = (int) lessonIdCell.getNumericCellValue();
                    String content = (String) contentCell.getStringCellValue();
                    String optionA = (String) optionACell.getStringCellValue();
                    String optionB = (String) optionBCell.getStringCellValue();
                    String optionC = (String) optionCCell.getStringCellValue();
                    String optionD = (String) optionDCell.getStringCellValue();
                    String answer = (String) answerCell.getStringCellValue();
                    String answerExplanation = (String) answerExplanationCell.getStringCellValue();
                    String level = (String) levelCell.getStringCellValue();
                    boolean status = false;
                    if (statusCell.getNumericCellValue() == 1) {
                        status = true;
                    }
                    Question q = new Question(subjectId, lessonId, content, optionA, optionB, optionC, optionD, answer, answerExplanation, level, status);
                    qe.addQuestion(q);
                }
            }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filePath = "D:\\02.FPTU\\05.Semester5\\02.SWP391\\QuestionImportTemplate.xlsx";
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);

        // if you want to use a relative path to context root:
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);

        // obtains ServletContext
        ServletContext context = getServletContext();

        // gets MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        // modifies response
        resp.setContentType(mimeType);
        resp.setContentLength((int) downloadFile.length());

        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        resp.setHeader(headerKey, headerValue);

        // obtains response's output stream
        OutputStream outStream = resp.getOutputStream();
        
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        inStream.close();
        outStream.close();
    }
    
}
