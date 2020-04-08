package com.lzh.moon.utils;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.lzh.moon.Vo.Photo;
import com.lzh.moon.common.DefaultResultData;
import com.lzh.moon.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiAnGzh
 * @date 2020/3/20 18:09
 */

@Component
public class UploadFileUtils {


    public List uploadFile(MultipartFile[] files,FastFileStorageClient fast) throws IOException {
        List<Photo> photos = new ArrayList<>();
        if (files == null || files.length == 0) {
            return photos;
        }
        for (int i = 0; i < files.length; i++) {
            Photo vo=new Photo();
            MultipartFile multipartFile = files[i];
            String fileName = multipartFile.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
            StorePath storePath = fast.uploadFile(multipartFile.getInputStream(),multipartFile.getSize(),suffix,null);
            vo.setPhotoGroup(storePath.getGroup());
            System.out.println(storePath.getGroup());
            vo.setPhotoPath(storePath.getFullPath());
            photos.add(vo);
            System.out.println(storePath.getFullPath());
        }
        return photos;
    }
}
