package com.socket.chatclient.main;

import com.socket.chatclient.main.view.MainWindow;

import java.awt.*;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 11:37 2018/02/08
 * @Modified By:
 * @description：BUG:界面能运行出来，但是按钮无效，也无法与ChatManager进行绑定
 */
public class StartClient {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow frame = new MainWindow();
                //frame.setVisible(true);
                ChatManager.getInstance().setWindow(frame);
            }
        });
    }
}
