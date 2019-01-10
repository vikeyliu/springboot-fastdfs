package com.golding.service;

import com.golding.fastdfs.StorageClient1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FastDfsService {
    @Autowired
    private StorageClient1 storageClient1;

    public String uploadFile(MultipartFile file) {
        String path = null;
        try {
            byte[] bytes = file.getBytes();
            storageClient1.upload_file1(bytes, null, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;

    }
}
