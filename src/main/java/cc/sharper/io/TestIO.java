package cc.sharper.io;

import java.io.*;

/**
 * Created by liumin3 on 2015/11/26.
 */
public class TestIO
{
    public static void main(String[] args) throws  Exception
    {
        //先是关于File的使用
//        File file = new File("G:\\test\\io\\test2.txt");
//
//        try{
//            file.createNewFile();
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }


//        System.out.printf(File.separator);
//        System.out.printf(File.pathSeparator);
//        \;

//        File file = new File("G:"+File.separator+"test"+File.separator+"io"+File.separator+"test3.txt");
//
//        try{
//            file.createNewFile();
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }

//        File file = new File("G:"+File.separator+"test"+File.separator+"io"+File.separator+"test3.txt");
//        if (file.exists())
//        {
//            file.delete();
//        }else {
//            System.out.println("文件不存在");
//        }

//        File file = new File("G:"+File.separator+"test"+File.separator+"io"+File.separator+"test");
//        file.mkdir();

        //列出目录下得所有文件，包括隐藏文件
//        String path = "C:"+File.separator;
//        File f = new File(path);
//        String[] li = f.list();
//        for(String str : li){
//            System.out.println(str);
//        }

        //带有文件的路径信息
//        String path = "C:"+File.separator;
//        File f = new File(path);
//        File[] li = f.listFiles();
//        for(File ff : li){
//            System.out.println(ff);
//        }

        //判断一个指定的路径是否为目录
//        File file = new File("G:"+File.separator+"test"+File.separator+"io"+File.separator+"test");
//        if(file.isDirectory())
//        {
//            System.out.println("yes");
//        }else {
//            System.out.println("no");
//        }

//        String fileName = "F:"+File.separator;
//        File f = new File(fileName);
//        print(f);


        //==========================关于file的api结束=======================================

        //==========================关于输出输入开始=======================================

        //RandomAccessFile 写入文件------------------------------->以后深究
//        File file = new File("G:"+File.separator+"test"+File.separator+"io"+File.separator+"test3.txt");
//
//        RandomAccessFile demo = new RandomAccessFile(file,"rw");
//
//        //demo.writeInt(51);
//        String h=new String(("ttttt").getBytes("iso-8859-1"),"UTF-8");
//        demo.write(h.getBytes());
//        demo.close();

        //字节流
//        File file = new File("G:"+File.separator+"test"+File.separator+"io"+File.separator+"test3.txt");
//        OutputStream out  = new FileOutputStream(file);
//        String str = "你好!!!!!！";
//        byte[] bb = str.getBytes();

        //一个一个自己的写
//        for (int i = 0; i < bb.length; i++) {
//            out.write(bb[i]);
//        }
        //out.write(bb);
//        out.close();

        //向文件中追加新内容：
//        File file2 = new File("G:"+File.separator+"test"+File.separator+"io"+File.separator+"test3.txt");
//        OutputStream out2  = new FileOutputStream(file2,true);
//        String str2 = "\r\n你好!!!!!！";
//        byte[] bb2 = str2.getBytes();
//        out2.write(bb2);
//        out2.close();


        //读取文件内容
//        File file3 = new File("G:"+File.separator+"test"+File.separator+"io"+File.separator+"test3.txt");
//        InputStream in = new FileInputStream(file3);
//        byte[] bb = new byte[1024];
//        int ss =  in.read(bb);
//        in.close();
//        //System.out.printf(new String(bb));
//        System.out.printf(new String(bb,0,ss));


        //预先申请了一个指定大小的空间
//        File file3 = new File("G:"+File.separator+"test"+File.separator+"io"+File.separator+"test3.txt");
//        InputStream in = new FileInputStream(file3);
//        byte[] bb = new byte[(int)file3.length()];
//        int ss =  in.read(bb);
//        in.close();
//        System.out.printf(new String(bb));
//        //System.out.printf(new String(bb,0,ss));



        //字符流

        //写入
//        File f = new File("G:"+File.separator+"test"+File.separator+"io"+File.separator+"test3.txt");
//        Writer w = new FileWriter(f,true); //true就只追加
//        w.write("\r\n11111111111111");
//        w.close();



        //读取
//        File f = new File("G:"+File.separator+"test"+File.separator+"io"+File.separator+"test3.txt");
//        char[] ch=new char[100];
//        Reader read=new FileReader(f);
//        int temp=0;
//        int count=0;
//        while((temp=read.read())!=(-1)){
//            ch[count++]=(char)temp;
//        }
//        read.close();
//        System.out.println("内容为"+new String(ch,0,count));


        //文件复制
        File f1 = new File("");
        File f2 = new File("");
        if(!f1.exists()){
            System.out.println("被复制文件不存在");

        }else
        {
            InputStream input = new FileInputStream(f1);
            OutputStream output  = new FileOutputStream(f2);

            if((input!=null) && (output!=null))
            {
                int temp = 0;
                while ((temp=input.read())!=(-1))
                {
                    output.write(temp);
                }
            }
        }


















//        InputStream用于读取基于字节的数据，一次读取一个字节
//        InputStream in = new FileInputStream("G:\\test\\io\\test.txt");

//        int data  = in.read();
//        while(data!= -1)
//        {
//            //System.out.println((char) data);
//            System.out.print(data);
//            data = in.read();
//        }
//        in.close();


//        byte[] bytes = new byte[20];
//        int data  = in.read(bytes);
//        while(data!=-1){
//            System.out.print((char) data);
//            data = in.read(bytes);
//
//        }
//        in.close();





    }


    public static void print(File f)
    {
        if(f!=null)
        {
            if(f.isDirectory())
            {
                File[] li = f.listFiles();
                if(li!= null)//这里不可以少
                {
                    for(File ff : li)
                    {
                        print(ff);
                    }
                }
            }else
            {
                System.out.println(f);
            }
        }
    }

}
