package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;

public class Model {
    Connection conn = null;
    String url;
    Statement stmt = null;
    ResultSet rs = null;

    Model(String url) {
        this.url = url;
    }

    public void connect() throws SQLException {
        conn = getConnection(url);
    }

    public void close() throws SQLException {
        if (conn != null)
            conn.close();
    }

    public void createStatement() throws SQLException {
        this.stmt = conn.createStatement();
    }

    public ArrayList<String> SQLQueryTeacherName() {
        ArrayList<String> Names = new ArrayList<>();
        String sql = "Select name from Teacher;";
        try {
            rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                String name = rs.getString(1);
                Names.add(name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        rs = null;
        return Names;
    }
    public void courseQuery() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write what course you want");
        String course = scanner.nextLine();
        String sql = "select fld1 from students inner join lecture on lecture.name = students.fld1;";
        try {
            rs = stmt.executeQuery(sql);
            if (rs == null || rs.getFetchSize() == 0)
                System.out.println("not available");
            while (rs != null && rs.next()) {
                String name = rs.getString(1);
                Integer student = rs.getInt(2);
                System.out.println("Course " + name + " has " + student + " students assigned");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void findStudens() {
        String sql = "update students set fld2 = 'Johnny' where fld1 = 1;";
        try {
            rs = stmt.executeQuery(sql);
            if (rs == null)
                System.out.println("HEJ MED DIG MIN GODE VEN -oppenheimer");
            while (rs != null && rs.next()) {
                String key = rs.getString(1);
                String name =rs.getString(2);
                System.out.println("Student number:"+ key +" name: "+ name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void printTeacher(ArrayList<String> Names) {
        for (int i = 0; i < Names.size(); i++) {
            System.out.println(Names.get(i));
        }
    }
}