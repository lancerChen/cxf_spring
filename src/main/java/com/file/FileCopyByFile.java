package com.file;

import java.io.*;

public class FileCopyByFile {
    public static void main(String[] args){
        try {
            FileReader fr = new FileReader("hello.txt");
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter("text_file.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            String line;
            while ((line=br.readLine())!=null){
                bw.write(line+"\n");
            }
            bw.flush();

            bw.close();
            fw.close();

            br.close();
            fr.close();

            System.out.println("-------\n复制完成！");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
