package com.moskitol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

@Controller
public class FileController {

    //saving the picture not to the server, but to the web resources, you may have to change the implementation.
    @RequestMapping(value = "/admin/uploadFile", method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse response) {

        Iterator<String> itr =  request.getFileNames();
        String fileName=itr.next();
        MultipartFile file = request.getFile(fileName);

        if (!file.isEmpty()) {
            try {
                String pathForUpload = request.getSession().getServletContext().getRealPath("/web/");
                pathForUpload = pathForUpload.substring(0,pathForUpload.indexOf("out")) + "web/resources/css/images/";

                File fileNew = new File(pathForUpload, file.getOriginalFilename());

                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileNew));

                stream.write(bytes);
                stream.close();


                return "You successfully uploaded " + fileName + " into " + fileName + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + fileName + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload because the file was empty.";
        }


    }
    @RequestMapping(value = "/admin/uploadFile", method = RequestMethod.GET)
    public ModelAndView uploadFileGet() {
        return new ModelAndView("admin/uploadFile");
    }
}
