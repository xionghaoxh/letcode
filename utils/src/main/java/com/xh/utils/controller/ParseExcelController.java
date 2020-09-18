package com.xh.utils.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.xh.utils.Service.ParseExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.util.List;

@RestController
public class ParseExcelController {
    @Autowired
    ParseExcelService service;
    @PostMapping("/parseExcel")
    @ResponseBody
    public String  uploadFile(@RequestParam("file") MultipartFile file)throws  Exception{
     if(file.isEmpty()){
         return "文件为空";
     }
        return service.uploadFile(file);
    }
    @PostMapping("/uploadFile")
    @ResponseBody
    public List parseExcel(@RequestParam("file") MultipartFile file)throws  Exception{
        if(file.isEmpty()){
           throw new NullPointerException("文件类型为空");
        }
        return service.parseExcel(file);
    }
}
