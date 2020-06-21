package com.jakey.car.caridentify.utils;


import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

public class FastDFSClient {

    private TrackerClient trackerClient = null;
    private TrackerServer trackerServer = null;
    private StorageServer storageServer = null;
        //注意此处使用的是StorageClient1这个类，和前面的demo不一样，所以文件上传后直接得到file_id字符串而不是字符串数组。
    private StorageClient1 storageClient = null;
    
    //构造方法，传入fastDFS的配置文件，用于加载。同时把前面所有的准备工作完成。
    public FastDFSClient(String conf) throws Exception {
        //我们创建该对象时传入的fastDFS配置文件要带“classpath:”，这里就把它转化成获取当前类的根目录了。
        //加上文件名就是fastDFS配置文件的路径了。
        if (conf.contains("classpath:")) {
            conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
        }
        ClientGlobal.init(conf);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageServer = null;
        storageClient = new StorageClient1(trackerServer, storageServer);
    }
    
    /**
     * 上传文件方法，通过文件的路径字符
     * <p>Title: uploadFile</p>
     * <p>Description: </p>
     * @param fileName 文件全路径
     * @param extName 文件扩展名，不包含（.）
     * @param metas 文件扩展信息
     * @return
     * @throws Exception
     */
    public String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception {
        String result = storageClient.upload_file1(fileName, extName, metas);
        return result;
    }
    
    public String uploadFile(String fileName) throws Exception {
        return uploadFile(fileName, null, null);
    }
    
    public String uploadFile(String fileName, String extName) throws Exception {
        return uploadFile(fileName, extName, null);
    }
    
    /**
     * 上传文件方法2，通过文件的字节数组
     * <p>Title: uploadFile</p>
     * <p>Description: </p>
     * @param fileContent 文件的内容，字节数组
     * @param extName 文件扩展名
     * @param metas 文件扩展信息
     * @return  文件上传成功后的file_id
     * @throws Exception
     */
    public String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception {
        
        String result = storageClient.upload_file1(fileContent, extName, metas);
        return result;
    }
    
    public String uploadFile(byte[] fileContent) throws Exception {
        return uploadFile(fileContent, null, null);
    }
    
    public String uploadFile(byte[] fileContent, String extName) throws Exception {
        return uploadFile(fileContent, extName, null);
    }
}