package cc.sharper.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by liumin3 on 2015/11/17.
 */
public class Test
{
    public static void main(String[] args) throws  Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8",
                "root","root");
        String sql = "select * from user";
        Statement st =  conn.createStatement();

        //删除
        String sql2 = "delete from person where id='222'";
        System. out.println( st.execute( sql2));

        //更新
        String sql3 = "update person set name='柳敏' where id='111' ";
        System. out.println( st.execute( sql3));
        conn.close();

    }
}
