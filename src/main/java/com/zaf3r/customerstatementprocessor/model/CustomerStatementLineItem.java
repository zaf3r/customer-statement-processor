package com.zaf3r.customerstatementprocessor.model;


import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "record")
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerStatementLineItem {

    @XmlAttribute
    @CsvBindByName(column = "Reference")
    private long transactionReference;


    @XmlElement(name = "accountNumber")
    @CsvBindByName(column = "Account Number")
    private String accountNumber;

    @XmlElement(name = "startBalance")
    @CsvBindByName(column = "Start Balance")
    private double startBalance;

    @XmlElement(name = "mutation")
    @CsvBindByName(column = "Mutation")
    private double mutation;

    @XmlElement(name = "endBalance")
    @CsvBindByName(column = "End Balance")
    private double endBalance;

    @XmlElement(name = "description")
    @CsvBindByName(column = "Description")
    private String description;
}
