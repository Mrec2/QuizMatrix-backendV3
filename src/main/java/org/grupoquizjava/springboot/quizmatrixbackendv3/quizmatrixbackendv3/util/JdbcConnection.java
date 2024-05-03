//package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.util;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//@Component
//public class JdbcConnection {
//
//    private static String url;
//    private static String username;
//    private static String password;
//
//    private static Connection connection;
//
//    @Value("${spring.datasource.url}")
//    public void setUrl(String url) {
//        JdbcConnection.url = url;
//    }
//
//    @Value("${spring.datasource.username}")
//    public void setUsername(String username) {
//        JdbcConnection.username = username;
//    }
//
//    @Value("${spring.datasource.password}")
//    public void setPassword(String password) {
//        JdbcConnection.password = password;
//    }
//
//    static {
//        try {
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Manejar la excepción de alguna manera adecuada
//        }
//    }
//
//    public static Connection getConnection() {
//        return connection;
//    }
//}
