package com.biz.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.bbs.model.FileVO;
import com.biz.bbs.service.AjaxFileService;

@Controller
@RequestMapping(value = "/file")
public class FileController {
	
	
	@Autowired
	AjaxFileService aFService;
	
	@ResponseBody
	@RequestMapping(value = "/file_up", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String file_up(@RequestParam("file") MultipartFile file) {
		
//		String originName = file.getOriginalFilename();
		String saveName = aFService.upLoad(file);
		return saveName;
	}
	
	@ResponseBody
	@RequestMapping(value = "/files_up", method=RequestMethod.POST)
	public List<FileVO> files_up(MultipartHttpServletRequest files) {
		
		List<FileVO> fileVOList = aFService.uploads(files);
		
		return fileVOList;
	}
	
}
