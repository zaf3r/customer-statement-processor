package com.zaf3r.customerstatementprocessor.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;

@RestController
public class FileUploadController {

    private final String UPLOAD_FOLDER = new File("src/main/resources/upload/").getAbsolutePath();

    @PostMapping("/")
    public String fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        return "nothing";

    }
}
