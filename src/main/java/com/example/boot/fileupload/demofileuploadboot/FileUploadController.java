package com.example.boot.fileupload.demofileuploadboot;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

@RestController
@RequestMapping("/spring-mvc-fileupload")
public class FileUploadController {

    @Value(value = "${spring.servlet.multipart.location}")
    private String filePath = ".";

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") final MultipartFile file) {

        saveFile(file);
        return "fileUploadView";
    }

    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
    public String submit(@RequestParam("files") final MultipartFile[] files) {

        Stream.of(files).forEach(file -> saveFile(file));
        return "fileUploadView";
    }

    @RequestMapping(value = "/uploadFileWithAddtionalData", method = RequestMethod.POST)
    public String submit(@RequestParam final MultipartFile file, @RequestParam final String name, @RequestParam final String email) {
        saveFile(file);
        return "fileUploadView";
    }

    @RequestMapping(value = "/uploadFileModelAttribute", method = RequestMethod.POST)
    public String submit(@ModelAttribute final FormDataWithFile formDataWithFile) {

        return "fileUploadView";
    }

    public void saveFile(MultipartFile multipartFile) {
        try {
            if(! new File(filePath).exists())
            {
                new File(filePath).mkdir();
            }

            String orgName = multipartFile.getOriginalFilename();
            String destPath = String.join("/", filePath, orgName);
            File dest = new File(destPath);
            multipartFile.transferTo(dest);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


