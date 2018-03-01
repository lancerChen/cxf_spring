package com.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args){
        File file = new File("hello.txt");
        if (file.exists()){
            System.out.println(file.isFile());
            System.out.println(file.isDirectory());
            /*file.delete();
            System.out.println("文件已删除！");*/
        }else{
            System.out.println("文件不存在！");
            try {
                file.createNewFile();
                System.out.println("文件已创建！");
            }catch (IOException o){
                System.out.println("文件无法创建！");

            }
        }
        System.out.println(file.getAbsolutePath());
    }
}
