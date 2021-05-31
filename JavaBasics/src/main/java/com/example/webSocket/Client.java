package com.example.webSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


/**
 * @Author: lyh
 * @Date: 2021/05/24  17:04
 * @Description:
 */
public class Client extends Thread {
    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 1998);
        client.start();
    }

    Socket socket = null;

    public Client(String host, int port) {
        try {
            socket = new Socket(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        new SendMessThread(socket).start();
        super.run();
        try {
            InputStream is = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = is.read(buf)) != -1) {
                System.out.println(DateTimeUtils.getDate() + " 服务器说:" + new String(buf, 0, len, "UTF-8"));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    class SendMessThread extends Thread{

        Socket socket;
        public SendMessThread(){};
        public SendMessThread(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {
            super.run();
            //写操作
            Scanner scanner=null;
            OutputStream os= null;
            try {
                scanner=new Scanner(System.in);
                os= socket.getOutputStream();
                String in="";
                do {
                    in=scanner.next();
                    os.write((""+in).getBytes());
                    os.flush();
                } while (!in.equals("bye"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            scanner.close();
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
