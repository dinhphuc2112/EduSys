/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.*;

/**
 *
 * @author user
 */
public class JDBCHelper {

    static String url = "jdbc:sqlserver://localhost;databaseName=EduSys;user=sa;password=123";

  public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        PreparedStatement stmt;
        Connection cn = DriverManager.getConnection(url);
        if (sql.trim().startsWith("{")) {
            stmt = cn.prepareCall(sql);
          
        } else {
            stmt = cn.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    };
  
  /*
  Thực hiện sql truy vấn (select ) haowjc thủ tục lưu truy vấn dữ liệu 
  @param sql là câu lệnh sql chứa các tham số ,nó có thể là một lời gọi thụ tục lưu
  @param args là danh sách các giá trị được cung cấp cho các tham số  trong câu lệnh sql 
  */
    public static ResultSet query(String sql, Object ...args) throws SQLException {
        PreparedStatement stsm = JDBCHelper.getStmt(sql, args);
        return stsm.executeQuery();
    }

    public static Object value(String sql, Object ...args) {
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object update(String sql, Object ...args) {
        try {
            PreparedStatement stsm = JDBCHelper.getStmt(sql, args);
            try {
                return stsm.executeUpdate();
            } finally {
                stsm.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
