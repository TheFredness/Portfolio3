package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        String url = "jdbc:sqlite:listdb.db";
        Model Model = new Model(url);
        Controller control = new Controller(Model);
        Model.createStatement();
        Model.connect();
        View view = new View();
        control.setView(view);
        primaryStage.setTitle("Course Management");
        primaryStage.setScene(new Scene(view.asParent(),600,475));
        primaryStage.show();

    }
    public static void main(String[]args){
        launch(args);
    }
}

    /*public static void main(String[] args) {
        String url = "jdbc:sqlite:listdb.db";
        Model Model = new Model(url);
        try {
            Model.connect();
            Model.createStatement();
            ArrayList<String> Names = Model.SQLQueryTeacherName();
            Model.printTeacher(Names);
            Model.courseQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                Model.close();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}*/
