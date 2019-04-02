package com.example.undertakes.exception;

import sun.applet.Main;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileThread extends Thread {

    public void run(){

    }

    public static void main(String[] args) {
        FileThread fileThread=new FileThread();
        try {
            FileReader fr = new FileReader("D:\\小志.txt");
            BufferedReader br=new BufferedReader(fr);
            String line="";
            String[] arrs=null;
            fileThread.read(br);
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void read(BufferedReader br){
        String line;
        String[] arrs=null;
        try {
            while ((line=br.readLine())!=null) {
                arrs=line.split(",");
                System.out.println(arrs[0]);
            }
            sleep(1000);
            System.out.println("=======");
            read(br);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) throws IOException {
//        FileWriter fw = new FileWriter("D:\\小志.txt",true);
//        PrintWriter pw = new PrintWriter(fw);
//        pw.println("追加内容");
//        pw.flush();
//    }

//    public static void main(String[] args)  {
//        File file = new File("D:\\小志.txt");
//        RandomAccessFile fout = null;
//        FileChannel fcout = null;
//        try {
//            fout = new RandomAccessFile(file, "rw");
//            long filelength = fout.length();//获取文件的长度
//            fout.seek(filelength);//将文件的读写指针定位到文件的末尾
//            fcout = fout.getChannel();//打开文件通道
//            FileLock flout = null;
//            while (true) {
//                try {
//                    flout = fcout.tryLock();//不断的请求锁，如果请求不到，等一秒再请求
//                    break;
//                } catch (Exception e) {
//                    System.out.print("lock is exist ......");
//                    sleep(1000);
//                }
//            }
//            String str = "hello word!!!!\r\n";//需要写入的内容
//            fout.write(str.getBytes());//将需要写入的内容写入文件
//            flout.release();
//            fcout.close();
//            fout.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally {
//            if (fcout != null) {
//                try {
//                    fcout.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    fcout = null;
//                }
//            }
//            if (fout != null) {
//                try {
//                    fout.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    fout = null;
//                }
//            }
//        }
//    }
}
