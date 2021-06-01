package com.example.webSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: lyh
 * @Date: 2021/05/24  16:38
 * @Description:
 */
public class Server extends Thread {

    public static void main(String[] args) {
        Server server = new Server(1998);
        server.start();
    }

    ServerSocket server = null;
    Socket socket = null;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println(DateTimeUtils.getDate() + " 等待客户端连接...");
            socket = server.accept();
            // 连接并返回socket后，再启用发送消息线程
            new SendMessThread().start();
            System.out.println(DateTimeUtils.getDate() + "  客户端 （" + socket.getInetAddress().getHostAddress() + "） 连接成功...");
            InputStream in = socket.getInputStream();
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = in.read(buf)) != -1) {
                System.out.println(DateTimeUtils.getDate() + " 客户端:(" + socket.getInetAddress().getHostAddress() + ")说:"
                        + new String(buf, 0, len, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    class SendMessThread extends Thread {
        @Override
        public void run() {
            super.run();
            Scanner scanner = null;
            OutputStream out = null;
            try {
                if (socket != null) {
                    scanner = new Scanner(System.in);
                    out = socket.getOutputStream();
                    String in = "";
                    do {
                        in = scanner.next();
                        out.write(("" + in).getBytes("UTF-8"));
                        out.flush();
                    } while (!in.equals("q"));
                    scanner.close();
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
