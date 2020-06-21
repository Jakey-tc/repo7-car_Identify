package com.jakey.car.caridentify;


import com.jakey.car.caridentify.pojo.Result;
import com.jakey.car.caridentify.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by Jakey on 2020/6/18.
 * desc:
 */
@RestController
@RequestMapping("/car")
public class FileUpload {

    @Value("${FILE_SERVER_URL}")
    private String file_server_url;

    @RequestMapping("/upload")
    public Result FileUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file") MultipartFile files) throws Exception {

        //获取上传的文件名
        String fileName = files.getOriginalFilename();
        //获取上传的文件的后缀，也就是.后面的字符串
        String extName = fileName.substring(fileName.lastIndexOf(".") + 1);


        //使用工具类，创建工具类对象，传入fastDFS配置文件，用于加载
        FastDFSClient client = new FastDFSClient("classpath:/fdfs_client.conf");
        //使用工具类对象直接上传文件。
        String file_id = client.uploadFile(files.getBytes(), extName);
        //将文件存储的Uri和ip地址组合起来形成url，方便传到前端，能够显示已经上传的图片。
        String fileUrl = file_server_url + file_id;
        //将该文件存储的url保存在AddResult对象的message属性中，传给前端。

        //设置一个文件上传后保存在服务器硬盘中的路径,这里表示的是一个项目根路径下的路径
        String path = request.getSession().getServletContext().getRealPath("caridentify");

        //将字符串形式的路径改为文件形式的路径
        File file = new File(path);
        //如果该路径不存在，在硬盘上创建该路径的文件夹
        if (!file.exists()) {
            file.mkdir();
        }

        files.transferTo(new File(path, files.getOriginalFilename()));

        CarController car = new CarController();
        return new Result(true, car.getCar(path + "/" + files.getOriginalFilename()),fileUrl);


    }
}
