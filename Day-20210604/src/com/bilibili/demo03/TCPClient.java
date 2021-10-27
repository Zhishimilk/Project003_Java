package com.bilibili.demo03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) throws IOException {

        long l0 = System.currentTimeMillis();
        //--------------------------------------------------

        //客服端对象
        Socket skt = new Socket("127.0.0.1", 8888);
        //创建本地字节输入流 FileInputStream对象
        /*File file = new File("C:\\Users\\zhish\\Desktop\\dd.jpg");*/
        FileInputStream fis = new FileInputStream("C:\\Users\\zhish\\Desktop\\dd.jpg");
        //使用Socket getOutputStream()方法获取客服端输出流对象
        OutputStream osm = skt.getOutputStream();
        //读取本地输入源,并提交服务器
        int len = 0;
        byte[] bytes = new byte[1024];
        while((len = fis.read(bytes)) != -1){
            osm.write(bytes, 0 ,len);
        }
        skt.shutdownOutput();
        //获取服务器返回的消息
        InputStream ism = skt.getInputStream();
        while((len = ism.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, len));
        }
        //结束关闭使用流,释放资源
        fis.close();
        skt.close();

        //--------------------------------------------------
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l0+"mms");
    }
}
