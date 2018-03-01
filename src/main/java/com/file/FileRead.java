package com.file;
/**
 *
 * created by lancer on 2018-02-02 11:50
 **/
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileRead {

    public static void main(String[] args){
        File file = new File("hello.txt");
        if (file.exists()){
            System.out.println("文件存在！\n---------");

            //创建文件写出流
            try {
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
                BufferedReader br = new BufferedReader(isr);

                String line;
                while ((line = br.readLine())!=null){
                    System.out.println(line);
                }
                br.close();;
                isr.close();
                fis.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //创建文件写入流
            try {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEE HH:mm:ss");
                String dt = sdf.format(date);

                File newfile = new File("newhello.txt");
                FileOutputStream fos = new FileOutputStream(newfile);
                OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
                BufferedWriter bw = new BufferedWriter(osw);

                bw.write("我走过山时，山不说话；\n");
                bw.write("我路过海时，海不说话；\n");
                bw.write("小毛驴滴滴答答，\n");
                bw.write("倚天剑伴我走天涯，\n");
                bw.write("大家都说我因为爱着杨过大侠，\n");
                bw.write("才在峨眉山上出了家，\n");
                bw.write("其实我只是爱上了峨眉山上的云和霞，像极了十六岁那年的烟花。\n");
                bw.write(dt);

                bw.close();
                osw.close();
                fos.close();

                System.out.println("-------\n写入完成！");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件不存在！");
        }
    }
}
