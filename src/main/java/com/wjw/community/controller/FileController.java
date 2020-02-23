package com.wjw.community.controller;

import com.wjw.community.dto.FileDTO;
import com.wjw.community.provider.AliYunProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private AliYunProvider aliYunProvider;

    @ResponseBody
    @RequestMapping("/file/upload")
    public FileDTO upload(@RequestParam("editormd-image-file")MultipartFile file) {
        FileDTO fileDTO = new FileDTO();
        String filename = file.getOriginalFilename();
        try {
            if(file != null){
                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream outputStream = new FileOutputStream(newFile);
                    outputStream.write(file.getBytes());
                    outputStream.close();
                    file.transferTo(newFile);
                    String url = aliYunProvider.upLoad(newFile);
                    fileDTO.setSuccess(1);
                    fileDTO.setUrl(url);
                    fileDTO.setMessage("上传成功");
                }
            }
        } catch (FileNotFoundException e) {
            fileDTO.setSuccess(0);
            fileDTO.setMessage("上传失败");
            e.printStackTrace();
        } catch (IOException e) {
            fileDTO.setSuccess(0);
            fileDTO.setMessage("上传失败");
            e.printStackTrace();
        }
         return fileDTO;
    }
}