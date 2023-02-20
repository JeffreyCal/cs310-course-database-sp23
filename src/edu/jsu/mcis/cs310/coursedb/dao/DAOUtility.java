package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {

    public static final int TERMID_SP23 = 1;

    public static String getResultSetAsJson(ResultSet rs) {

        JsonArray records = new JsonArray();

        try {

            if (rs != null) {

                while (rs.next()) {

                    ResultSetMetaData headers = rs.getMetaData();
                    int columnCount = headers.getColumnCount();
                    JsonObject tempRecord = new JsonObject();

                    for (int x = 0; x < columnCount; x++) {

                        String columnName = headers.getColumnName(x + 1);
                        String value = rs.getString(columnName);
                        tempRecord.put(columnName, value);

                    }
                    records.add(tempRecord);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Jsoner.serialize(records);

    }

}
