package com.file;
/**
 *
 * created by lancer on 2018-02-02 11:25
 **/
import java.io.File;

public class FileScaner {
    public static void main(String[] args){
        printFiles(new File("D:\\project\\javadev\\IdeaProjects\\cxf_spring\\src\\main\\java\\com"),1);
    }

    /**
     * @param  dir :文件夹的路径（绝对or相对）
     *
     *
     * */
    public static void printFiles(File dir,int tab){

        if (dir.isDirectory()){
            File[] next = dir.listFiles();//获取文件夹路径数组
            for (int i = 0; i <next.length ; i++) {
                for (int j = 0; j < tab; j++) {
                    System.out.print("|--");
                }
                System.out.println(next[i].getName());
                if (next[i].isDirectory()) {
                    //调用自身实现递归
                    printFiles(next[i],tab+1);
                }

            }
        }
    }
}
