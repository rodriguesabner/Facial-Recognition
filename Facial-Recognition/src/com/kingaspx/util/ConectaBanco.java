package com.kingaspx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * Connect to the database (MySQL) Database: facial_recognition
 *
 */
public class ConectaBanco {

    public Statement stm;
    public ResultSet rs;
    public Connection conn;

    private final String driver = "org.mysql.Driver";
    private final String path = "jdbc:mysql://127.0.0.1/facial_recognition";
    private final String user = "root";
    private final String pass = "";

    /**
     * Method responsible for opening the connection to the database.
     * <br><br>
     * <b>Required:</b>
     * <br>
     * Yes. This method must be invoked whenever you perform an operation that
     * involves the database.
     * <br><br>
     * <b>Example:</b>
     * <br>
     * ConectaBanco conecta = new ConectaBanco();
     * <br>
     * conecta.conexao();
     *
     * @exception Error Database not exists, driver not configured correctly,
     * library was not added to the project
     */
    public void conexao() {
        try {
            System.setProperty("jdbc.Driver", driver);
            conn = DriverManager.getConnection(path, user, pass);
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Method responsible for closing the connection to the database.
     * <br><br>
     * <b>Required:</b>
     * <br>
     * No. but it is advisable to close the connection every time you perform a
     * database operation.
     * <br><br>
     * <b>Example:</b>
     * <br>
     * ConectaBanco conecta = new ConectaBanco();
     * <br>
     * conecta.conexao();
     * <br>
     * ...
     * <br>
     * conecta.desconecta();
     *
     * @exception Error Connection not started.
     */
    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Method is used to execute SELECT query. It returns the object of
     * ResultSet.
     *
     * @param SQL ex: "SELECT * FROM table"
     * <br><br>
     * <b>Example:</b>
     * <br>
     * ConectaBanco conecta = new ConectaBanco();
     * <br>
     * conecta.conexao();
     * <br>
     * conecta.executaSQL("SELECT * FROM table");
     * <br>
     * conecta.desconecta();
     *
     * @exception Error Connection not started.
     */
    public void executaSQL(String SQL) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(SQL);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
