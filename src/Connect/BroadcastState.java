package Connect;

import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Server.HttpRequest;

public class BroadcastState {
    final static String ROOMINFOSERVERURL = "http://www.panda.tv/api_room";

    public static boolean getState(String roomID) throws JSONException {
        String requestData = HttpRequest.sendGet(ROOMINFOSERVERURL, "roomid=" + roomID);
        JSONObject json = new JSONObject(requestData);
        if (json.getJSONObject("data").getJSONObject("roominfo").getString("watermark_switch").equals("1")) {
            System.out.println(roomID + "房间主播在直播");
            return true;
        } else {
            System.out.println(roomID + "房间主播不在直播");
            return false;
        }
    }

    public static void getFansNum(String roomID) throws JSONException {
        String requestData = HttpRequest.sendGet(ROOMINFOSERVERURL, "roomid=" + roomID);
        JSONObject json = new JSONObject(requestData);
        String fansNum = json.getJSONObject("data").getJSONObject("roominfo").getString("fans");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/panda?useSSL=true";
        String user = "root";
        String password = "qwerty123456";
        try {
            Class.forName(driver);
            Connection conn = (Connection) DriverManager.getConnection(url, user, password);
            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            String sql = "insert into fansInfo (roomid, time, fansnum) values(?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(roomID));
            preparedStatement.setString(2, df.format(new Date()));
            preparedStatement.setInt(3, Integer.parseInt(fansNum));
            int re = preparedStatement.executeUpdate();
            if (re > 0) {
                System.out.println("插入关注人数成功");
            }
            // conn.commit();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
    }

    public static void getBambooSum(String roomID) throws JSONException {
        String requestData = HttpRequest.sendGet(ROOMINFOSERVERURL, "roomid=" + roomID);
        JSONObject json = new JSONObject(requestData);
        String BambooSum = json.getJSONObject("data").getJSONObject("hostinfo").getString("bamboos");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/panda?useSSL=true";
        String user = "root";
        String password = "qwerty123456";
        try {
            Class.forName(driver);
            Connection conn = (Connection) DriverManager.getConnection(url, user, password);
            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            String sql = "insert into bambooSumInfo (roomid, time, bamboosum) values(?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(roomID));
            preparedStatement.setString(2, df.format(new Date()));
            preparedStatement.setInt(3, Integer.parseInt(BambooSum));
            int re = preparedStatement.executeUpdate();
            if (re > 0) {
                System.out.println("插入竹子总数成功");
            }
            // conn.commit();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }

    }

    public static void getClassification(String roomID) throws JSONException {
        String requestData = HttpRequest.sendGet(ROOMINFOSERVERURL, "roomid=" + roomID);
        JSONObject json = new JSONObject(requestData);
        String classification = json.getJSONObject("data").getJSONObject("roominfo").getString("classification");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/panda?useSSL=true";
        String user = "root";
        String password = "qwerty123456";
        try {
            Class.forName(driver);
            Connection conn = (Connection) DriverManager.getConnection(url, user, password);
            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            String sql = "insert into classifiInfo (roomid, time, classification) values(?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(roomID));
            preparedStatement.setString(2, df.format(new Date()));
            preparedStatement.setString(3, classification);
            int re = preparedStatement.executeUpdate();
            if (re > 0) {
                System.out.println("插入直播间分类成功");
            }
            // conn.commit();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }

    }
}
