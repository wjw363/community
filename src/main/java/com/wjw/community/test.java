package com.wjw.community;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.ByteArrayInputStream;

public class test {


    /**
     * LTAI4FrVDsCeBopgpmgm7oHu L7zH9PhKx58wxXeplEIRZMm7RewDRA
     * @param args
     */

    public static void main(String[] args) {
// Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4FrVDsCeBopgpmgm7oHu";
        String accessKeySecret = "L7zH9PhKx58wxXeplEIRZMm7RewDRA";
        String bucketName = "wjwcommunity";
// <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = "images/WG.jpg";
// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
// 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
        String content = "Hello OSS";
        ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
// 关闭OSSClient。
        ossClient.shutdown();
    }
}