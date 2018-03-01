package com.socket.serversocket;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 19:40 2018/02/07
 * @Modified By:
 * @description：
 */
public class ServerListener extends Thread {
    @Override
    public void run() {
        try {
            //port:1-65535
            ServerSocket serverSocket = new ServerSocket(50505);

            while (true){
                //block
                Socket socket = serverSocket.accept();
                //building connection
                JOptionPane.showMessageDialog(null,"有客户端链接到了本机的50505端口");

                //将socket传递给新的线程
                ChatSocket cs = new ChatSocket(socket);
                cs.start();
                ChatManager.getChatManager().add(cs);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
