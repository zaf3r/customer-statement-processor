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
    public final int START_BALANCE_COLUMN = 2;
    public final int MUTATION_COLUMN = 3;
    public final int DESCRIPTION_COLUMN = 4;
    public final int FINAL_BALANCE_COLUMN = 5;

    public List<CustomerStatementLineItem> readCustomerStatement() {
        File file = new File("C:\\Users\\zafer.torun\\projects\\cgi\\rabo-assignment\\customer-statement-processor\\src\\main\\resources\\customerstatements\\records.csv");

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] splitRow = line.split(",");

            }


        } catch (IOException e) {
            System.out.println(e.getClass()+ " : " + e.getMessage());
        }

        return new ArrayList<>();
    }


    @Override
    public void run(String... args) throws Exception {
        readCustomerStatement();
    }
}
