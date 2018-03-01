package com.socket.chatclient.main;

import com.socket.chatclient.main.view.MainWindow;

import java.io.*;
import java.net.Socket;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 16:27 2018/02/08
 * @Modified By:
 * @description：
 */
public class ChatManager {

    private ChatManager(){}
    private static final ChatManager instance = new ChatManager();

    public static ChatManager getInstance() {
        return instance;
    }

    MainWindow window;
    String IP;
    Socket socket;
    BufferedReader reader;
    PrintWriter writer;

    public void setWindow(MainWindow window) {
        this.window = window;
        window.setReadyTextArea("文本框已经与ChatManager绑定.");
    }

    public void connect(String ip){
        this.IP = ip;
        new Thread(){
            @Override
            public void run() {
                try {
                    socket = new Socket(IP,50506);
                    writer = new PrintWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()));

                    reader = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
                    String line;
                    while ((line=reader.readLine())!=null){
                        window.setReadyTextArea("收到:"+line);
                    }
                    reader.close();
                    writer.close();
                    reader=null;
                    writer=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    public  void send(String out){
        if (writer != null){
            writer.write(out+"\n");
            writer.flush();

        }else{
            window.setReadyTextArea("当前链接已中断");
        }

    }
}
