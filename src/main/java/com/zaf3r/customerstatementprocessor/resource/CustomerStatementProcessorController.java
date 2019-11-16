package com.zaf3r.customerstatementprocessor.resource;

import com.zaf3r.customerstatementprocessor.model.CustomerStatementLineItem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerStatementProcessorController implements CommandLineRunner {

    public final int TRANSACTION_REFERENCE_COLUMN = 0;
    public final int ACCOUNT_NUMBER_COLUMN = 1;
    public final int DESCRIPTION_COLUMN = 2;
    public final int START_BALANCE_COLUMN = 3;
    public final int MUTATION_COLUMN = 4;
    public final int FINAL_BALANCE_COLUMN = 5;

    public List<CustomerStatementLineItem> readCustomerStatement() {
        String fileLocation = new File("src/main/resources/customerstatements/records.csv").getAbsolutePath();
        List<CustomerStatementLineItem> lineItemList = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(new File(fileLocation)))) {
            reader.readLine();
            String line;
            while((line = reader.readLine()) != null) {
                lineItemList.add(loadCommaSeparatedLineIntoModel(line));
            }
        } catch (IOException e) {
            System.out.println(e.getClass()+ " : " + e.getMessage());
        }
        System.out.println(lineItemList);
        return lineItemList;
    }

    public CustomerStatementLineItem loadCommaSeparatedLineIntoModel(String line) {
        String[] splitLine = line.split(",");
        long transactionRef = Long.parseLong(splitLine[TRANSACTION_REFERENCE_COLUMN]);
        String accountNumber = splitLine[ACCOUNT_NUMBER_COLUMN];
        double startBalance = Double.parseDouble(splitLine[START_BALANCE_COLUMN]);
        double mutation = Double.parseDouble(splitLine[MUTATION_COLUMN]);
        String description = splitLine[DESCRIPTION_COLUMN];
        double finalBalance = Double.parseDouble(splitLine[FINAL_BALANCE_COLUMN]);

        return new CustomerStatementLineItem(transactionRef,accountNumber,startBalance,mutation,finalBalance,description);
    }

    @Override
    public void run(String... args) {
        readCustomerStatement();
    }
}
