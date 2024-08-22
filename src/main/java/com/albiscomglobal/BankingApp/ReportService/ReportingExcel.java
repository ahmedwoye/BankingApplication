package com.albiscomglobal.BankingApp.ReportService;


import com.albiscomglobal.BankingApp.Entity.Account;
import com.albiscomglobal.BankingApp.Repository.AccountRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ReportingExcel {

    @Autowired
    private AccountRepository accountRepository;


    public void generateExcel(HttpServletResponse response) throws IOException {

        List<Account> account = accountRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("AccountHolders");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("AccountHolder");
        row.createCell(2).setCellValue("Balance");

        int dataRowIndex = 1;

        for(Account accounts :  account){
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(accounts.getId());
            dataRow.createCell(1).setCellValue(accounts.getAccountHolderName());
            dataRow.createCell(2).setCellValue(accounts.getBalance());
            dataRowIndex ++;


        }

       ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();
    }
}
