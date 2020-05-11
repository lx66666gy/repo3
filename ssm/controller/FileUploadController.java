package com.it.ssm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.MulticastChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileUploadController {


    /*@RequestMapping("/fileUpload")
    public Map<String,Object> fileUpload(@RequestParam("file") MultipartFile uploadFile, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();
        String fileName="";
        try {

            String uploadFileName=uploadFile.getOriginalFilename();
            System.out.println("文件原名字--->"+uploadFileName);

            String extendName=uploadFileName.substring(uploadFileName.lastIndexOf('.'));
            System.out.println("文件扩展名--->"+extendName);
            fileName=UUID.randomUUID().toString()+extendName;
            System.out.println("新文件名字--->"+fileName);

            String basePath= request.getSession().getServletContext().getRealPath("/uploads");

            System.out.println(basePath);

            uploadFile.transferTo(new File(basePath,fileName));
            map.put("code",0);
            map2.put("src","/uploads"+fileName);
            map.put("data",map2);
            map.put("msg","");
        } catch (IOException e) {
            e.printStackTrace();
            map.put("code",1);
            map2.put("src","/uploads"+fileName);
            map.put("data",map2);
            map.put("msg","");
        }
        return map;
    }*/

    @RequestMapping(value = "/upload/headImg", method = {RequestMethod.POST})
    @ResponseBody
    public Object headImg(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String fileName="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                /*String originalName = file.getOriginalFilename();
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
               // dateStr = format.format(new Date());
                fileName=UUID.randomUUID().toString();
                String filepath = request.getSession().getServletContext().getRealPath("/uploads1");
               *//* filepath = filepath.replace("\\", "/");*//*
                File files=new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                if(!files.exists()){
                    files.mkdirs();
                }
                file.transferTo(files);*/

                String uploadFileName=file.getOriginalFilename();
                System.out.println("文件原名字--->"+uploadFileName);

                String extendName=uploadFileName.substring(uploadFileName.lastIndexOf('.'));
                System.out.println("文件扩展名--->"+extendName);
                fileName=UUID.randomUUID().toString()+extendName;
                System.out.println("新文件名字--->"+fileName);

                String basePath= request.getSession().getServletContext().getRealPath("/uploads2");

                System.out.println("路径"+basePath);

                file.transferTo(new File(basePath,fileName));
            }
        }catch (Exception e){
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map2=new HashMap<>();
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",map2);
        map2.put("src","/uploads2" + fileName);
        return map;
    }
}
