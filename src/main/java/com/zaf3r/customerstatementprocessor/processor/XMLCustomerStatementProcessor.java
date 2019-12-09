package com.zaf3r.customerstatementprocessor.processor;

import com.zaf3r.customerstatementprocessor.api.CustomerStatementProcessor;
import com.zaf3r.customerstatementprocessor.model.CustomerStatementLineItem;
import com.zaf3r.customerstatementprocessor.util.DocumentType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class XMLCustomerStatementProcessor implements CustomerStatementProcessor {

    @Override
    public List<CustomerStatementLineItem> process(MultipartFile file) {
        return null;
    }

    @Override
    public DocumentType getProcessorFileType() {
        return DocumentType.XML;
    }
}
