package com.example.demoex;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;


public class db {
    // Данные для подключения к локальной базе данных
    Map<String ,String > env = System.getenv();
    private final String HOST = env.getOrDefault("DB_HOST","192.168.13.100") ;
    private final String PORT = env.getOrDefault("DB_PORT","3306") ;
    private final String DB_NAME = env.getOrDefault("DB_NAME","user32") ;
    private final String LOGIN = env.getOrDefault("DB_USER","user32") ; // Если OpenServer, то здесь mysql напишите
    private final String PASS = env.getOrDefault("DB_PASS","43853"); // Если OpenServer, то здесь mysql напишите

    private Connection dbConn = null;

    // Метод для подключения к БД с использованием значений выше
    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }
    public ArrayList<String> Login() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Login FROM Employee";

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> login = new ArrayList<>();
        while(res.next())
            login.add(res.getString("Login"));

        return login;
    }
    public ArrayList<String> Password() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Password FROM Employee";

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> login = new ArrayList<>();
        while(res.next())
            login.add(res.getString("Password"));

        return login;
    }
    public ArrayList<String> Role() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Role FROM Employee";

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> login = new ArrayList<>();
        while(res.next())
            login.add(res.getString("Role"));

        return login;
    }
    public ArrayList<String> FIO() throws SQLException, ClassNotFoundException {
        String sql = "SELECT FIO FROM Employee";

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> login = new ArrayList<>();
        while(res.next())
            login.add(res.getString("FIO"));

        return login;
    }
    public void Update(String loginDB) throws SQLException, ClassNotFoundException {
        String sql1 = "update Employee set LastEnter =current_timestamp() where Login = '"+loginDB+"'";
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql1);
    }

}
