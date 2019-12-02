package com.zaf3r.customerstatementprocessor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerStatement {

    @XmlElement(name = "record")
    List<CustomerStatementLineItem> statementLineItems;
}