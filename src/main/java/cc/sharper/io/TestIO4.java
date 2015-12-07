package cc.sharper.io;

import java.io.*;

/**
 * Created by liumin3 on 2015/11/27.
 *
 * 对象的序列化
 */
public class TestIO4
{
    public static void main(String[] args) throws  Exception
    {
        //ObjectInputStream和ObjectOutputStream
        File file = new File("G:\\test\\io\\test2.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(new SerializableDemo("rollen","20"));
        oos.close();

        File file2 = new File("G:\\test\\io\\test2.txt");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file2));
        Object obj = input.readObject();
        input.close();
        System.out.println(obj);

//        ser(); // 序列化
//        dser(); // 反序列话


    }


    public static void ser() throws Exception
    {
        File file = new File("G:\\test\\io\\test2.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream( file));
        out.writeObject(new Person("liumin", 20));
        out.close();
    }

    public static void dser() throws Exception
    {
        File file = new File("G:\\test\\io\\test2.txt");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        Object obj = input.readObject();
        input.close();
        System.out.println(obj);
    }
}

class SerializableDemo  implements Serializable
{
    public  SerializableDemo()
    {

    }
    public SerializableDemo(String name,String age)
    {
        this.age = age;
        this.name= name;
    }

    public String toString()
    {
        return "name:"+name+":age:"+age;
    }

    private  transient String name;
    private String age;
}


class Person implements Externalizable
{
    public Person()
    {

    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "姓名：" + name + "  年龄：" + age;
    }

    // 复写这个方法，根据需要可以保存的属性或者具体内容，在序列化的时候使用
    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeObject(this.name);
        out.writeInt(age);
    }

    // 复写这个方法，根据需要读取内容 反序列话的时候需要
    @Override
    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException
    {
        this.name = (String) in.readObject();
        this.age = in.readInt();
    }

    private String name;
    private int age;
}
