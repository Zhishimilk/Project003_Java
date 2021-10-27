package com.bilibili.demo01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BSTCPServer {

    public static void main(String[] args) throws IOException {

        /*long l0 = System.currentTimeMillis();*/
        //--------------------------------------------------

        //
        ServerSocket sst = new ServerSocket(8080);

        while(true){
            //
            Socket skt = sst.accept();
            //
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        //
                        InputStream ism = skt.getInputStream();
                        //
                        /*int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = ism.read(bytes)) != -1){
                            System.out.println(new String(bytes, 0, len));
                        }*/
                        //
                        BufferedReader brr = new BufferedReader(new InputStreamReader(ism));
                        //
                        String sl = brr.readLine();
                        System.out.println(sl);
                        //
                        String[] sls = sl.split(" ");
                        //
                        String pathHtml = sls[1].substring(1);

                        //
                        FileInputStream fis = new FileInputStream(pathHtml);
                        //
                        OutputStream osm = skt.getOutputStream();
                        //
                        osm.write("HTTP/1.1 200 OK\r\n".getBytes(StandardCharsets.UTF_8));
                        osm.write("Content-Type:text/html\r\n".getBytes(StandardCharsets.UTF_8));
                        osm.write("\r\n".getBytes(StandardCharsets.UTF_8));

                        //
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = fis.read(bytes)) != -1){
                            osm.write(bytes, 0, len);
                        }

                        //
                        fis.close();
                        skt.close();
                    }catch (IOException e){
                        System.out.println(e);
                    }
                }
            }).start();
        }

        //sst.close();

        //--------------------------------------------------
        /*long l1 = System.currentTimeMillis();
        System.out.println(l1-l0+"mms");*/
    }
}
