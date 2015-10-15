/*
 * Copyright (c) 2015..
 */

package com.ms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Jay on 2015/9/24.
 */
@Controller
public class FileController {

    @RequestMapping(value = "uploadFile",method = RequestMethod.POST)
    private void upload(@RequestParam(value="file") MultipartFile file){

        String originalFilename = file.getOriginalFilename();
        String extensionName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        System.out.print(file);

//        user = userService.getUserByIdJpa(id);
    }

}
