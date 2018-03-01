package com.socket.serversocket;

import java.util.Vector;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 20:00 2018/02/07
 * @Modified By:
 * @description：
 */
public class ChatManager {
    //单例化
    private ChatManager(){}
    private  static final ChatManager cm = new ChatManager();

    public static ChatManager getChatManager() {
        return cm;
    }

    Vector<ChatSocket> vector = new Vector<ChatSocket>();

    public void add(ChatSocket cs){
        vector.add(cs);
    }

    public void publish(ChatSocket cs,String out){
        for (int i = 0; i <vector.size() ; i++) {
            ChatSocket csChatSocket = vector.get(i);
            if (!cs.equals(csChatSocket)){
                csChatSocket.out(out);
            }
        }
    }
}
