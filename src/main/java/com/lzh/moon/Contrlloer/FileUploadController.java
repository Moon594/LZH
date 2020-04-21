package com.lzh.moon.Contrlloer;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.lzh.moon.Vo.Users;
import com.lzh.moon.common.DefaultResult;
import com.lzh.moon.common.DefaultResultData;
import com.lzh.moon.service.uploadLibraryService;
import com.lzh.moon.utils.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 文件上传
 *
 * @author LiAnGzh
 * @date 2020/3/17 18:02
 */
@Controller
public class FileUploadController {

    @Autowired
    private FastFileStorageClient fast;
    @Autowired
    private UploadFileUtil util;
    @Autowired
    private uploadLibraryService uploadLibraryService;

    @GetMapping("/upload")
    public String upload(HttpSession session, Model model){
        Users user = (Users) session.getAttribute("user");
        if (user!=null){
            return "upload";
        }
        model.addAttribute("msg","请先登录才可以上传你好看的图片呢!");
        return "login";
    }

    @PostMapping("/upload")
    @ResponseBody
    public DefaultResultData upload(@RequestParam("file") MultipartFile[] files) throws IOException {
        return new DefaultResultData(util.uploadFile(files, fast));
    }

    @PostMapping("/uploadLibrary")
    @ResponseBody
    public DefaultResult uploadLibrary(@RequestParam("file") MultipartFile[] files,HttpSession session) throws IOException {
        Users user =(Users)session.getAttribute("user");
        return uploadLibraryService.upload(files,fast,user.getUserId());
    }
}