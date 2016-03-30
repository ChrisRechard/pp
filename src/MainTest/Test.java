package MainTest;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;

import Connect.ConnectDanMuServer;

public class Test {
	private static ConnectDanMuServer rec = new ConnectDanMuServer();

	public static void main(String[] args) throws InterruptedException {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/panda?useSSL=true";
		String user = "root";
		String password = "qwerty123456";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			Statement statement = (Statement) conn.createStatement();
			String sql1 = "create table IF NOT EXISTS roomInfo (roomId integer,time text,audienceNum integer)";
			String sql2 = "create table IF NOT EXISTS danmuInfo (roomId integer,time text,danmu text)";
			String sql3 = "create table IF NOT EXISTS zhuziInfo (roomId integer,time text,zhuzi integer)";
			String sql4 = "create table IF NOT EXISTS presentInfo (roomId integer,time text,present text,num integer)";
			String sql5 = "create table IF NOT EXISTS fansInfo (roomId integer,time text,fansNum integer)";
			String sql6 = "create table IF NOT EXISTS bambooSumInfo (roomId integer,time text,bamboosum integer)";
			String sql7 = "create table IF NOT EXISTS classifiInfo (roomId integer,time text,classification text)";
			// ResultSet rs = statement.executeQuery(sql);
			int r1 = statement.executeUpdate(sql1);
			int r2 = statement.executeUpdate(sql2);
			int r3 = statement.executeUpdate(sql3);
			int r4 = statement.executeUpdate(sql4);
			int r5 = statement.executeUpdate(sql5);
			int r6 = statement.executeUpdate(sql6);
			int r7 = statement.executeUpdate(sql7);
			if (r1 == -1) {
				System.out.println("创建roomInfo失败");
			}
			if (r2 == -1) {
				System.out.println("创建danmuInfo失败");
			}
			if (r3 == -1) {
				System.out.println("创建zhuziInfo失败");
			}
			if (r4 == -1) {
				System.out.println("创建persentInfo失败");
			}
			if (r5 == -1) {
				System.out.println("创建fansInfo失败");
			}
			if (r6 == -1) {
				System.out.println("创建bambooSumInfo失败");
			}
			if (r7 == -1) {
				System.out.println("创建ClsaaifiInfo失败");
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		}
		String room = "88911";
		Thread danmuThread = new Thread(new Runnable() {

			@Override
			public void run() {
				rec.ConnectToDanMuServer(room);
			}
		});
		danmuThread.start();
		System.out.println("开始等待");
		danmuThread.sleep(10000);
		System.out.println("等待ֹ");
		rec.Close();
		//new ConnectDanMuServer().Close();
		// danmuThread.destroy();
		System.out.println("停止");
	}

}
