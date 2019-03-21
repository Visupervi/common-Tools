package com.HopeRun.ListenerAndFilter.CommonUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Tools {
    static String url = "";
    static String name = "";
    static String pwd = "";
    static String driver = "";

    static {
        try {
            Properties prop = new Properties();
            InputStream is = Tools.class.getClassLoader().getResourceAsStream("config.prop");
            prop.load(is);
            url = prop.getProperty("url");
            name = prop.getProperty("name");
            pwd = prop.getProperty("pwd");
            driver = prop.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Release(Connection conn, ResultSet rs, Statement st) {
        closeConn(conn);
        closeRs(rs);
        closeSt(st);
    }
    public static void Release(Connection conn, Statement st) {
        closeConn(conn);
        closeSt(st);
    }


    String sql = "";

    public static Connection getConn() {
        Connection conn = null;
        try {
            getRegisterDriver();
            conn = DriverManager.getConnection(url, name, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static void getRegisterDriver() throws Exception {
        Class.forName(driver);
    }

    private static void closeSt(Statement st) {
        try {
            if (st != null)
                st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            st = null;
        }
    }

    private static void closeRs(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs = null;
        }
    }

    private static void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

    private  static  void  closePs(PreparedStatement ps){
        try {
            if(ps !=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
