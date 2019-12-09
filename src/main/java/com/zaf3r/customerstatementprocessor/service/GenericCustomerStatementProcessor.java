package com.zaf3r.customerstatementprocessor.service;

import com.zaf3r.customerstatementprocessor.api.CustomerStatementProcessor;
import com.zaf3r.customerstatementprocessor.exception.FileTypeNotSupportedException;
import com.zaf3r.customerstatementprocessor.model.CustomerStatementLineItem;
import com.zaf3r.customerstatementprocessor.util.DocumentHelper;
import com.zaf3r.customerstatementprocessor.util.DocumentType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenericCustomerStatementProcessor {

    private final Map<DocumentType, CustomerStatementProcessor> customerStatementProcessorMap;

    public GenericCustomerStatementProcessor(final List<CustomerStatementProcessor> statementProcessors) {
        customerStatementProcessorMap = statementProcessors.stream()
                .collect(Collectors.toMap(CustomerStatementProcessor::getProcessorFileType, processor -> processor));
    }

    private Optional<CustomerStatementProcessor> getTransactionStatementProcessorByFileType(final String requestFileType) {
        DocumentType documentType = DocumentType.findTypeByString(requestFileType.toUpperCase());

        if (documentType == DocumentType.UNKNOWN) {
            throw new FileTypeNotSupportedException("The requested file type not supported", requestFileType);
        }

        return Optional.ofNullable(customerStatementProcessorMap.get(documentType));
    }

    public List<CustomerStatementLineItem> process(final MultipartFile file) {
        return DocumentHelper.getFileExtensionFromFileName(file.getOriginalFilename())
                .map(fileType -> getTransactionStatementProcessorByFileType(fileType))
                .orElseThrow(() ->
                        new FileTypeNotSupportedException("The requested file type not supported", ""))
                .map(fileProcessor -> fileProcessor.process(file))
                .orElseThrow(() ->
                        new RuntimeException("Document processor not available for requested file getType"));

    }





}
