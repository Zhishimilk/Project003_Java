package com.bilibili.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClient {

    public static void main(String[] args) throws IOException {

        long l0 = System.currentTimeMillis();
        //--------------------------------------------------

        Socket skt = new Socket("127.0.0.1",8888);
        OutputStream os = skt.getOutputStream();
        os.write("你好".getBytes(StandardCharsets.UTF_8));

        InputStream ism = skt.getInputStream();
        byte[] bytes = new byte[1024*64];
        int len = ism.read(bytes);
        System.out.println(new String(bytes, 0, len));

        skt.close();

        //--------------------------------------------------
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l0+"mms");
    }
}
