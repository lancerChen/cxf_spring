package com.socket.chatclient.main.view;

import com.socket.chatclient.main.ChatManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 11:38 2018/02/08
 * @Modified By:
 * @description：
 */
public class MainWindow extends JFrame {
    private static final long serialVersionUID;

    static {
        serialVersionUID = 1L;
    }

    private JPanel rootPanel;
     JTextArea readyTextArea;
    private JTextField ip;
    private JButton ipButton;
    private JTextField send;
    private JButton sendButton;

    public MainWindow() {
        JFrame frame = new JFrame();
        frame.setContentPane(rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100,100,450,300);
        rootPanel = new JPanel();
        rootPanel.setBorder(new EmptyBorder(5,5,5,5));
       // rootPanel.setLayout(new BorderLayout(0,0));
        setContentPane(rootPanel);


        readyTextArea = new JTextArea();
        readyTextArea.setText("Ready...");

        ip =new JTextField();
        ip.setText("127.0.0.1");
        ip.setColumns(10);

        ipButton = new JButton("链接到服务器");
        ipButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChatManager.getInstance().connect(ip.getText());
            }
        });

        send = new JTextField();
        send.setText("你好");
        send.setColumns(10);

        sendButton = new JButton("发送");
        sendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChatManager.getInstance().send(send.getText());
                setReadyTextArea("我说: "+send.getText());
                send.setText("");
            }
        });

        GroupLayout gl_rootPanel = new GroupLayout(rootPanel);
        gl_rootPanel.setHorizontalGroup(
                gl_rootPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING,gl_rootPanel.createSequentialGroup()
                        .addGroup(gl_rootPanel.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(gl_rootPanel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(readyTextArea,GroupLayout.DEFAULT_SIZE,434,Short.MAX_VALUE))
                            .addGroup(gl_rootPanel.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(ip,GroupLayout.DEFAULT_SIZE,306,Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ipButton))
                            .addGroup(gl_rootPanel.createSequentialGroup()
                                    .addComponent(send,GroupLayout.DEFAULT_SIZE,272,Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sendButton,GroupLayout.PREFERRED_SIZE,162,GroupLayout.PREFERRED_SIZE)))
                         .addContainerGap())
        );
        gl_rootPanel.setVerticalGroup(
                gl_rootPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(gl_rootPanel.createSequentialGroup()
                            .addGroup(gl_rootPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(ip,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE)
                                    .addComponent(ipButton))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(readyTextArea,GroupLayout.DEFAULT_SIZE,196,Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(gl_rootPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(sendButton,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE)
                                    .addComponent(sendButton)))

        );

        rootPanel.setLayout(gl_rootPanel);
    }

    public void setReadyTextArea(String in) {
        readyTextArea.append("\n"+in);
    }
}
