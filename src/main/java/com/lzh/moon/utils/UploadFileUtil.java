package com.lzh.moon.utils;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.lzh.moon.Vo.Photo;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiAnGzh
 * @date 2020/3/20 18:09
 */

@Component
public class UploadFileUtil {


    public List uploadFile(MultipartFile[] files,FastFileStorageClient fast) throws IOException {
        List<Photo> photos = new ArrayList<>();
        //判断files是否有文件
        if (files == null || files.length == 0) {
            //如果是空就直接返回null对象
            return photos;
        }
        //循环把数组里面的所有文件拿出来进行上传
        for (int i = 0; i < files.length; i++) {
            //获得图片一个VO对象
            Photo vo=new Photo();
            //获取当前的图片
            MultipartFile multipartFile = files[i];
            //获取图片的名字
            String fileName = multipartFile.getOriginalFilename();
            //获取图片的后缀名
            String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
            //发送上传请求到fastdfs服务器
            StorePath storePath = fast.uploadFile(multipartFile.getInputStream(),multipartFile.getSize(),suffix,null);
            //把需要的参数设置到Vo临时对象中
            vo.setPhotoGroup(storePath.getGroup());
            System.out.println(storePath.getGroup());
            vo.setPhotoPath(storePath.getFullPath());
            //add到数组中
            photos.add(vo);
            System.out.println(storePath.getFullPath());
        }
        //返回结果
        return photos;
    }
}
