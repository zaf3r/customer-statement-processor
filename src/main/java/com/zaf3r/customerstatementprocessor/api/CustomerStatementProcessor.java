package com.zaf3r.customerstatementprocessor.api;

import com.zaf3r.customerstatementprocessor.model.CustomerStatementLineItem;
import com.zaf3r.customerstatementprocessor.util.DocumentType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CustomerStatementProcessor {

    List<CustomerStatementLineItem> process(MultipartFile file);

    DocumentType getProcessorFileType();
}
