package MainTest;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Chris on 2016/3/30.
 */
public class StaticTest {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/panda?useSSL=true";
        String user = "root";
        String password = "qwerty123456";
        long sum =0;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            Statement statement = (Statement) conn.createStatement();
            String sql = "create table IF NOT EXISTS danmustatic (roomId integer,time text,danmuNum integer)";
            int r = statement.executeUpdate(sql);
            if (r == -1){
                System.out.println("创建数据表失败");
            }
            ResultSet rs = statement.executeQuery("select count(*) from danmuinfo where time >= "+"\""+"2016-03-30 04:49:00"+"\""+"AND time <= "+"\""+"2016-03-30 04:51:00"+"\"");
//            while (rs.next()) {
//                sum += 1;
//            }
            rs.next();
            sum = rs.getInt(1);
            System.out.println(sum);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
