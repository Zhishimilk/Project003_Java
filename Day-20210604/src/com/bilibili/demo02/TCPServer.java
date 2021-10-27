package com.bilibili.demo02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServer {

    public static void main(String[] args) throws IOException {

        long l0 = System.currentTimeMillis();
        //--------------------------------------------------

        //创建一个服务器 ServerSocket对象,和系统指定端口号
        ServerSocket sst = new ServerSocket(8888);
        //ServerSocket accept方法获取请求的客服端Socket对象
        Socket skt = sst.accept();
        //使用客服端Socket getInputStream()获取输入流对象
        InputStream ism = skt.getInputStream();
        //创建FileOutputStream 绑定输出目的地
        File file = new File("M:\\new!");
        if(!file.exists()){
            file.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(file+"\\dd.jpg");
        //使用InputStream read()读取客服端发送发文件并写入服务器硬盘
        int len = 0;
        byte[] bytes = new byte[1024];
        while((len = ism.read(bytes)) != -1){
            fos.write(bytes, 0, len);
        }
        //使用客服端Socket getOutputStream()获取输出流,向客户端发送结果
        OutputStream osm = skt.getOutputStream();
        osm.write("成功".getBytes(StandardCharsets.UTF_8));
        //结束关闭使用流 释放资源
        fos.close();
        skt.close();
        sst.close();

        //--------------------------------------------------
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l0+"mms");
    }
}
