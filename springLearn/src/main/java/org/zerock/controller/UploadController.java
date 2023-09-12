package org.zerock.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {
  
  private String getFolder() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String str = sdf.format(date);
    
    return str.replace("-", File.separator);
  }
  
  @GetMapping("/uploadForm")
  public void uploadForm() {
    log.info("upload form");
  }
  
  @PostMapping("/uploadFormAction")
  public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
    
    String uploadFolder = "C:\\java\\upload";
    
    for(MultipartFile multipartFile : uploadFile) {
      log.info("-----------------------------------");
      log.info("upload file name: "+multipartFile.getOriginalFilename());
      log.info("upload file size: "+multipartFile.getSize());
      
      File savefile = new File(uploadFolder, multipartFile.getOriginalFilename());
      
      try {
        multipartFile.transferTo(savefile);
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
  }
  
  @GetMapping("/uploadAjax")
  public void uploadAjax() {
    log.info("upload ajax");
  }
  
  @PostMapping("/uploadAjaxAction")
  public void uploadAjaxPost(MultipartFile[] uploadFile) {
    log.info("update ajax post...............................");
    
    String uploadFolder = "C:\\java\\upload";
    
    File uploadPath = new File(uploadFolder, getFolder());
    log.info("upload path"+uploadPath);
    
    if(uploadPath.exists() == false) {
      uploadPath.mkdirs();
    }
    
    for (MultipartFile multipartFile : uploadFile) {
      log.info("-----------------------------------");
      log.info("upload file name: "+multipartFile.getOriginalFilename());
      log.info("upload file size: "+multipartFile.getSize());
      
      String uploadFileName = multipartFile.getOriginalFilename();
      
      //IE has file path
      uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
      log.info("only file name: "+uploadFileName);
      
      UUID uuid = UUID.randomUUID();
      
      uploadFileName = uuid.toString()+"_"+uploadFileName;
      
      File saveFile = new File(uploadPath, uploadFileName);
      
      try {
        multipartFile.transferTo(saveFile);
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
  }
}
