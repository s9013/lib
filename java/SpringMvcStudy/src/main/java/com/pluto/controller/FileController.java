package com.pluto.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Jay
 * @time 2015Äê7ÔÂ27ÈÕ
 */
@RestController
@ResponseBody
@RequestMapping(value = "api/file")
public class FileController {

	Log log = LogFactory.getLog(getClass());

	@RequestMapping(value = "upload")
	private void upload(@RequestParam(value = "files") MultipartFile[] files) throws IllegalStateException, IOException {
		log.info("upload");
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			file.transferTo(new File("d:/test.txt"));
		}
	}

}
