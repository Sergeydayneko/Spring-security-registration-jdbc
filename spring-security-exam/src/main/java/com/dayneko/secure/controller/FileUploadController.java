package com.dayneko.secure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileUploadController {

    @GetMapping(value = "uploadFile")
    public String uploadFile() {
        return null;
    }
}
