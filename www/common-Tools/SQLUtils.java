package com.HopeRun.ListenerAndFilter.CommonUtils;

import java.sql.*;

public class SQLUtils <T> {
        Connection conn = null;
        PreparedStatement ps = null;

public void  update(String sql,Object...args){

    try {
        conn = Tools.getConn();
        ps = conn.prepareStatement(sql);
        ParameterMetaData metaData = ps.getParameterMetaData();
        for(int i = 0; i < metaData.getParameterCount(); i++){
            ps.setObject(i+1,args[i]);
        }
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        Tools.Release(conn,ps);
    }
}

public T querySelect(String sql, ResultHandler<T> handler, Object ...args){

    try {
        conn = Tools.getConn();
        ps = conn.prepareStatement(sql);
        ParameterMetaData metaData = ps.getParameterMetaData();
        for(int i = 0; i < metaData.getParameterCount(); i++){
            ps.setObject(i+1,args[i]);
        }
        ResultSet rs = ps.executeQuery();
        T t = (T) handler.handle(rs);

        return t;
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        Tools.Release(conn,ps);
    }
    return null;
}
}
