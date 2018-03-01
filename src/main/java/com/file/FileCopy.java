package com.file;

import java.io.*;

public class FileCopy {

    public static void main(String[] args){
        try {
            File file = new File("hello.txt");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");

            File file1 = new File("text_new.txt");
            FileOutputStream fos = new FileOutputStream(file1);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");

            char[] input = new char[100];
            int k=0;
            while ((k=isr.read(input))!= -1){
                //String inputString = new String(input,0,k);
                osw.write(input,0,k);
            }

            osw.close();
            fos.close();
            isr.close();
            fis.close();

            System.out.println("-------\n复制完成！");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
