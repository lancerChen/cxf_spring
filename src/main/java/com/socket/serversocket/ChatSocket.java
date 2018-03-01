package com.socket.serversocket;

import java.io.*;
import java.net.Socket;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 19:43 2018/02/07
 * @Modified By:
 * @description：
 */
public class ChatSocket extends Thread {
    Socket socket;
    public ChatSocket(Socket s){
        this.socket=s;
    }

    public void out(String out){
        try {
            socket.getOutputStream().write(out.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        /*try {
            socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()));
            int count = 0;
            while (true){
                bw.write("loop:"+count);
                sleep(1000);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //int count = 0;
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream(),"UTF-8"));
            String line;
            while ((line=br.readLine())!=null){
                ChatManager.getChatManager().publish(this,line);
            }
            br.close();
            System.out.println("有一个客户端断开了链接!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*while (true){
            count++;
            out("loop:"+count );
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

    }
}
