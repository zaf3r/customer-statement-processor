package com.zaf3r.customerstatementprocessor.resource;

import com.zaf3r.customerstatementprocessor.model.CustomerStatementLineItem;
import jdk.internal.util.xml.impl.Input;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public final String RECORD_TAG = "record";
    public final String REFERENCE_ELEMENT = "reference";
    public final String ACCOUNT_NUMBER_TAG = "accountNumber";
    public final String DESCRIPTION_TAG = "description";
    public final String START_BALANCE_TAG = "startBalance";
    public final String MUTATION_TAG = "mutation";
    public final String FINAL_BALANCE_TAG = "endBalance";


    public List<CustomerStatementLineItem> readCSVCustomerStatement() {
        String fileLocation = new File("src/main/resources/customerstatements/records.csv").getAbsolutePath();
        List<CustomerStatementLineItem> lineItemList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileLocation)))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                lineItemList.add(loadCommaSeparatedLineIntoModel(line));
            }
        } catch (IOException e) {
            System.out.println(e.getClass() + " : " + e.getMessage());
        }
        System.out.println(lineItemList);
        return lineItemList;
    }

    public List<CustomerStatementLineItem> readXMLCustomerStatement() {
        String fileLocation = new File("src/main/resources/customerstatements/records.xml").getAbsolutePath();
        List<CustomerStatementLineItem> lineItemList = new ArrayList<>();
        Document document;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File(fileLocation));
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName(RECORD_TAG);
            for(int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    lineItemList.add(loadXMLIntoModel((Element) node));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getClass() + " : " + e.getMessage());
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

        return new CustomerStatementLineItem(transactionRef, accountNumber, startBalance, mutation, finalBalance, description);
    }

    public CustomerStatementLineItem loadXMLIntoModel(Element elementNode) {
        long transactionRef = Long.parseLong(elementNode.getAttribute(REFERENCE_ELEMENT));
        String accountNumber = elementNode.getElementsByTagName(ACCOUNT_NUMBER_TAG).item(0).getTextContent();
        double startBalance = Double.parseDouble(elementNode.getElementsByTagName(START_BALANCE_TAG).item(0).getTextContent());
        double mutation = Double.parseDouble(elementNode.getElementsByTagName(MUTATION_TAG).item(0).getTextContent());
        String description = elementNode.getElementsByTagName(DESCRIPTION_TAG).item(0).getTextContent();
        double finalBalance = Double.parseDouble(elementNode.getElementsByTagName(FINAL_BALANCE_TAG).item(0).getTextContent());
        
        return new CustomerStatementLineItem(transactionRef, accountNumber, startBalance, mutation, finalBalance, description);
    }

    @Override
    public void run(String... args) {
//        readCSVCustomerStatement();
//        readXMLCustomerStatement();
    }
}
