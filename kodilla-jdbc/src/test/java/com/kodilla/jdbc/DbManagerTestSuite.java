package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class DbManagerTestSuite {
    @Test
    void testConnect() throws SQLException{
        //given
        //when
        DbManager dbManager = DbManager.getInstance();
        //then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException{
        //given
        DbManager dbManager = DbManager.getInstance();

        //when
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //then
        int counter = 0;
        while(rs.next()){
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException{
        //given
        DbManager dbManager = DbManager.getInstance();

        //when
        String query = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER FROM USERS U " +
                "JOIN POSTS P ON U.ID = P.USER_ID GROUP BY P.USER_ID HAVING COUNT(*) > 1";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet result = statement.executeQuery(query);

        //then
        int counter = 0;
        while (result.next()){
            System.out.println(result.getString("FIRSTNAME") + " "
            + result.getString("LASTNAME"));
            counter ++;
        }
        result.close();
        statement.close();
        assertEquals(3, counter);
    }
}
