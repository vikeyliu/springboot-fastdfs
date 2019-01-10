package com.golding.config;


import com.golding.fastdfs.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FastDfsConfig {

    @Bean
    public StorageClient1 storageClient1() throws IOException, MyException {
        ClientGlobal.initByProperties("fastdfs-client.properties");
        // 创建跟踪器客户端对象
        TrackerClient trackerClient = new TrackerClient();
        // 获取跟踪器连接
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
        // 获取存储器客户端对象
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
        return storageClient1;
    }
}
