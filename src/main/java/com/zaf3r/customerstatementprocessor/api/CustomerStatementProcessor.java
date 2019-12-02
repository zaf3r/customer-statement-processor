package com.zaf3r.customerstatementprocessor.api;

import com.zaf3r.customerstatementprocessor.model.CustomerStatementLineItem;
import com.zaf3r.customerstatementprocessor.util.DocumentType;

import java.util.List;

public interface CustomerStatementProcessor {

    List<CustomerStatementLineItem> process();

    DocumentType getProcessorFileType();
}
