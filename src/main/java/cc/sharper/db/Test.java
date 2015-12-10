package cc.sharper.db;

import java.sql.*;


/**
 * Created by liumin3 on 2015/11/17.
 */
public class Test
{
    public static void main(String[] args) throws  Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://101.200.145.47:3306/liumin?useUnicode=true&amp;characterEncoding=utf-8",
                "root","liumin110");
        Statement st =  conn.createStatement();
//        String sql = "delete from user where id='999'";
//        Statement st =  conn.createStatement();
//        st.execute(sql);

//        String sql  = "select * from user";
//        ResultSet rs =  st.executeQuery(sql);
//        while(rs.next())
//        {
//            String id  = rs.getString("id");
//            int age = rs.getInt("age");
//            String first = rs.getString("NICKNAME");
//            Timestamp date = rs.getTimestamp("CREATED_TIME");
//
//            //Display values
//            System.out.print("ID: " + id);
//            System.out.print(", Age: " + age);
//            System.out.print(", NICKNAME: " + first);
//            System.out.println(" , CREATED_TIME:"+date);
//        }
//        rs.close();


        String sql = "select * from user where age = ? and nickname=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,"18");
        ps.setString(2,"大壮");
        ResultSet rs = ps.executeQuery();

        while(rs.next())
        {
            String id  = rs.getString("id");
            int age = rs.getInt("age");
            String first = rs.getString("NICKNAME");
            Timestamp date = rs.getTimestamp("CREATED_TIME");

            //Display values
            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", NICKNAME: " + first);
            System.out.println(" , CREATED_TIME:"+date);
        }

//        Boolean isSu = conn.getMetaData().supportsBatchUpdates();
//
//        System.out.println(isSu);
//        st.addBatch("delete from user where id='999' ");
//        st.addBatch("delete from user where id='999' ");
//        st.addBatch("delete from user where id='999' ");
//        st.addBatch("delete from user where id='999' ");
//        st.addBatch("delete from user where id='999' ");
//        st.addBatch("delete from user where id='999' ");
//        int[] count = st.executeBatch();
//
//        System.out.println(count.length);


//        //删除
//        String sql2 = "delete from person where id='222'";
//        System. out.println( st.execute( sql2));
//
//        //更新
//        String sql3 = "update person set name='柳敏' where id='111' ";
//        System. out.println( st.execute( sql3));
        st.close();
        conn.close();

    }
}
