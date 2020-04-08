package com.lzh.moon.Contrlloer;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.lzh.moon.Vo.Photo;
import com.lzh.moon.Vo.Users;
import com.lzh.moon.common.DefaultResultData;
import com.lzh.moon.common.ResultCode;
import com.lzh.moon.utils.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private UploadFileUtils util;

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
}