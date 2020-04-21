package com.lzh.moon.service;

import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.lzh.moon.common.DefaultResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Lzh
 * @date 2020-04-21 16:41
 */
public interface uploadLibraryService {

    DefaultResult upload(MultipartFile[] files, FastFileStorageClient fast,int userId);
}
