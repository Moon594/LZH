package com.lzh.moon.service.impl;

import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.lzh.moon.Vo.Photo;
import com.lzh.moon.common.DefaultResult;
import com.lzh.moon.common.ResultCode;
import com.lzh.moon.mapper.PhotoMapper;
import com.lzh.moon.service.uploadLibraryService;
import com.lzh.moon.utils.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lzh
 * @date 2020-04-21 16:43
 */
@Service
public class uploadLibraryServiceImpl implements uploadLibraryService {
    @Autowired
    private UploadFileUtil util;
    @Autowired
    private PhotoMapper photoMapper;
    Map map =new HashMap<>();

    @Override
    public DefaultResult upload(MultipartFile[] files, FastFileStorageClient fast,int userId) {
        try {
            List<Photo> list = util.uploadFile(files, fast);
            if (list!= null){
                for (Photo vo : list) {
                    vo.setUserId(userId);
                    photoMapper.insert(vo);
                }
                return new DefaultResult(ResultCode.SUCCESS);
            }
            return new DefaultResult(ResultCode.FAIL);
        } catch (IOException e) {
            return new DefaultResult(ResultCode.FAIL);
        }
    }
}
