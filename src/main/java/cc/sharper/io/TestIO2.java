package cc.sharper.io;

import java.io.*;
import java.util.Scanner;

/**
 * Created by liumin3 on 2015/11/27.
 */
public class TestIO2
{
    public static void main(String[] args) throws  Exception
    {
        //管道流  PipedOutputStream   PipedInputStream
//        Send send=new Send();
//        Recive recive=new Recive();
//        try
//        {
//            //管道连接
//            send.getOut().connect(recive.getInput());
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        new Thread(send).start();
//        new Thread(recive).start();

        //使用PrintStream进行输出
//        PrintStream print = new PrintStream(new FileOutputStream(new File("G:\\test\\io\\test2.txt")));
//        print.println(true);
//        print.println("liumin");
//        print.close();


//        PrintStream print = new PrintStream(new FileOutputStream(new File("G:\\test\\io\\test2.txt")));
//        String name="Rollen";
//        int age=20;
//        print.println(true);
//        print.printf("姓名：%s. 年龄：%d.",name,age);
//        print.close();

//        使用OutputStream向屏幕上输出内容
//        OutputStream out=System.out;
//        try
//        {
//            out.write("hello".getBytes());
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        try
//        {
//            out.close();
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }

//        输入输出重定向

// 此刻直接输出到屏幕
//        为System.out.println()重定向输出
//        System.out.println("hello");
//        File file = new File("G:\\test\\io\\test2.txt");
//        try
//        {
//            System.setOut(new PrintStream(new FileOutputStream(file)));
//        }catch(FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        System.out.println("这些内容在文件中才能看到哦！");

//        System.err重定向 这个例子也提示我们可以使用这种方法保存错误信息
//        File file = new File("G:\\test\\io\\test2.txt");
//        System.err.println("这些在控制台输出");
//        try
//        {
//            System.setErr(new PrintStream(new FileOutputStream(file)));
//        }catch(FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        System.err.println("这些在文件中才能看到哦！!!!!");
//        System.in重定向
//        File file = new File("G:\\test\\io\\test2.txt");
//        if(!file.exists())
//        {
//            return;
//        }else
//        {
//            try
//            {
//                System.setIn(new FileInputStream(file));
//            }catch(FileNotFoundException e)
//            {
//                e.printStackTrace();
//            }
//            byte[] bytes = new byte[1024];
//            int len = 0;
//            try
//            {
//                len = System.in.read(bytes);
//            }catch(IOException e)
//            {
//                e.printStackTrace();
//            }
//            System.out.println("读入的内容为：" + new String(bytes, 0, len));
//        }

//        BufferedReader  使用缓冲区从键盘上读入内容
//        BufferedReader只能接受字符流的缓冲区，因为每一个中文需要占据两个字节，所以需要将System.in这个字节输入流变为字符输入流，采用：
//        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

//        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
//        String str = null;
//        System.out.println("请输入内容");
//        try
//        {
//            str = buf.readLine();
//        }catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//        System.out.println("你输入的内容是：" + str);

//        用Scanner类来进行数据输入

        Scanner sca = new Scanner(System.in);
        // 读一个整数
        int temp = sca.nextInt();
        System.out.println(temp);
        //读取浮点数
        float flo=sca.nextFloat();
        System.out.println(flo);









    }
}


class Send implements Runnable{
    private PipedOutputStream out=null;
    public Send() {
        out=new PipedOutputStream();
    }
    public PipedOutputStream getOut(){
        return this.out;
    }
    public void run(){
        String message="tttttttttt";
        try{
            out.write(message.getBytes());
        }catch (Exception e) {
            e.printStackTrace();
        }try{
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}



class Recive implements Runnable{
    private PipedInputStream input=null;
    public Recive(){
        this.input=new PipedInputStream();
    }
    public PipedInputStream getInput(){
        return this.input;
    }
    public void run(){
        byte[] b=new byte[1000];
        int len=0;
        try{
            len=this.input.read(b);
        }catch (Exception e) {
            e.printStackTrace();
        }try{
            input.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("接受的内容为 "+(new String(b,0,len)));
    }
}