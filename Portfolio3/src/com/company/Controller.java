package com.company;

import javafx.application.Platform;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class Controller {
    Model model;
    View view;

    public Controller(Model model) {
        this.model = model;
        try {
            model.connect();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void setView(View view) {
        this.view = view;
        view.button.setOnAction(e-> Platform.exit());
        view.newJoin.setOnAction(e-> model.courseQuery());
        view.join.setOnAction(e-> model.findStudens());
    }

}
