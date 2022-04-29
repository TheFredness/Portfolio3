package com.company;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;

public class View {
    private GridPane startView;
    Button button = new Button("Exit");
    Button findTeacher = new Button("Find Teacher");
    Button findCourse = new Button ("Find course");
    Label teacherLabel = new Label("Select teacher");
    Label courselabel = new Label ("Select course");
    Button join = new Button("JOIN");
    Button newJoin = new Button("JOIN 2");
    public View(){
    CreateAndConfig();

    }
    private void CreateAndConfig(){
        startView = new GridPane();
        startView.setMinSize(300,200);
        startView.setPadding(new Insets(10,10,10,10));
        startView.setVgap(5);
        startView.setHgap(1);

        startView.add(findCourse,50,5);
        startView.add(join,60,40);
        startView.add(newJoin,70,40);
        startView.add(teacherLabel,40,10);
        startView.add(courselabel,40,5);
        startView.add(button,61,60);
        startView.add(findTeacher,50,10);
    }
    public Parent asParent(){
        return startView;
    }
}
