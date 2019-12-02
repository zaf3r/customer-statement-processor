package com.zaf3r.customerstatementprocessor.processor;

import com.zaf3r.customerstatementprocessor.api.CustomerStatementProcessor;
import com.zaf3r.customerstatementprocessor.model.CustomerStatementLineItem;
import org.w3c.dom.DocumentType;

import java.util.List;

public class XMLCustomerStatementProcessor implements CustomerStatementProcessor {
    @Override
    public List<CustomerStatementLineItem> process() {
        return null;
    }

    @Override
    public DocumentType getProcessorFileType() {
        return null;
    }
}
