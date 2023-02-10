package com.example.todolist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HelloController {

    public Button Add;

    public TextField addToDo;

    public ListView todos;

    public ComboBox chooseDay;


    int mondayTodos;
    int tuesdayTodos;
    int wednesdayTodos;
    int thursdayTodos;
    int fridayTodos;
    int saturdayTodos;
    int sundayTodos;

    ObservableList<ArrayList> week;
    ArrayList monday = new ArrayList();
    ArrayList tuesday = new ArrayList();
    ArrayList wednesday = new ArrayList();
    ArrayList thursday = new ArrayList();
    ArrayList friday = new ArrayList();
    ArrayList saturday = new ArrayList();
    ArrayList sunday = new ArrayList();

    int currentWeekday;

    public void initialize() {
        week = FXCollections.observableArrayList();

        week.add(monday);
        chooseDay.getItems().add("monday");
        week.add(tuesday);
        chooseDay.getItems().add("tuesday");
        week.add(wednesday);
        chooseDay.getItems().add("wednesday");
        week.add(thursday);
        chooseDay.getItems().add("thursday");
        week.add(friday);
        chooseDay.getItems().add("friday");
        week.add(saturday);
        chooseDay.getItems().add("saturday");
        week.add(sunday);
        chooseDay.getItems().add("sunday");

        chooseDay.getSelectionModel().select(currentWeekday);

        todos.setItems(week);
    }

      public void type () {
           String bob = addToDo.getText();
            monday.add(bob);
            week.add(monday);
        }

        public void Weekday() {
       /* currentWeekday = chooseDay.getSelectionModel().getSelectedIndex();
        Object selectedItem = chooseDay.getSelectionModel().getSelectedItem();


            System.out.println("Selection made: [" + currentWeekday + "] " + selectedItem);
            System.out.println("   ChoiceBox.getValue(): " + chooseDay.getValue());
*/
            chooseDay.setOnAction((event) -> {
                int selectedIndex = chooseDay.getSelectionModel().getSelectedIndex();
                Object selectedItem = chooseDay.getSelectionModel().getSelectedItem();

                System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
                System.out.println("   ChoiceBox.getValue(): " + chooseDay.getValue());
            });

        }

    public void deleteKey( final KeyEvent keyEvent )
    {
        final Object selectedItem;
        selectedItem = todos.getSelectionModel().getSelectedItem();
        todos.getSelectionModel();

        if ( selectedItem != null ) {

            if ( keyEvent.getCode().equals( KeyCode.BACK_SPACE ) ) {
                System.out.println("Completed Task:");
                System.out.println(selectedItem);
                todos.getItems().remove(selectedItem);
                //text.clear
            }
        }
    }



}
