package com.bilibili.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServer {

    public static void main(String[] args) throws IOException {

        long l0 = System.currentTimeMillis();
        //--------------------------------------------------

        ServerSocket sst = new ServerSocket(8888);
        Socket skt = sst.accept();
        InputStream ism = skt.getInputStream();

        byte[] bytes = new byte[1024*64];
        int len = ism.read(bytes);
        System.out.println(new String(bytes, 0, len));

        OutputStream osm = skt.getOutputStream();
        osm.write("收到".getBytes(StandardCharsets.UTF_8));

        skt.close();
        sst.close();

        //--------------------------------------------------
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l0+"mms");
    }
}
