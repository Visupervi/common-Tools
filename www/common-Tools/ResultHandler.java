package com.HopeRun.ListenerAndFilter.CommonUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultHandler<T> {
    T  handle(ResultSet rs);
}
