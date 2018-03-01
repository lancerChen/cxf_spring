package com.file;

import java.io.*;

public class FileCopyBuffer {
    public static void main(String[] args){
        try {
            //read the file data
            File file = new File("hello.txt");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br = new BufferedReader(isr);

            //writer the data in file
            File file1 = new File("text_new_buff.txt");
            FileOutputStream fos = new FileOutputStream(file1);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            //BufferedWriter bw = new BufferedWriter(osw);//使用此类会丢失换行符
            PrintWriter pw = new PrintWriter(osw,true); //此类可以输出换行符

            String input;

            while ((input=br.readLine())!=null){
                //bw.write(input);
                pw.println(input);
            }
            //当PrintWriter中设置了true，则不用手动调用此方法
            //pw.flush();//强制将缓存区中的内容输出到磁盘中。因为如果缓存区没被写满，数据是不会写出的

            //bw.flush();bw.close();
            pw.close();
            osw.close();
            fos.close();
            br.close();
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
