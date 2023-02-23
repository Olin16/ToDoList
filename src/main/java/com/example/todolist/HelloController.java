package com.example.todolist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.*;
import java.util.ArrayList;

public class HelloController {

    public Button Add;

    public Button save;

    public Button restore;

    public TextField addToDo;

    public ListView todos;

    public ComboBox chooseDay;




    ArrayList<ObservableList> week;
    ObservableList monday = FXCollections.observableArrayList();
    ObservableList tuesday = FXCollections.observableArrayList();
    ObservableList wednesday = FXCollections.observableArrayList();
    ObservableList thursday = FXCollections.observableArrayList();
    ObservableList friday = FXCollections.observableArrayList();
    ObservableList saturday = FXCollections.observableArrayList();
    ObservableList sunday = FXCollections.observableArrayList();

    int currentWeekday;

    public void initialize() {
        week = new ArrayList<ObservableList>();

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

        todos.setItems(week.get(0));
    }

      public void type () {
           String bob = addToDo.getText();

          int selectedIndex = chooseDay.getSelectionModel().getSelectedIndex();

          week.get(selectedIndex).add(bob);


      }

        public void Weekday() {
                int selectedIndex = chooseDay.getSelectionModel().getSelectedIndex();
                Object selectedItem = chooseDay.getSelectionModel().getSelectedItem();
                todos.setItems(week.get(selectedIndex));
                System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
                System.out.println("   ChoiceBox.getValue(): " + chooseDay.getValue());
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

    public void saveData() throws Exception {
        FileOutputStream fileOut =
                new FileOutputStream("RestoredList");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        for (ObservableList<ArrayList> eachDay: week) {
            ArrayList tempArrayList = new ArrayList(eachDay);
            out.writeObject(tempArrayList);
        }
        out.close();
        fileOut.close();
    }

    public void restoreData() throws Exception {
        FileInputStream fileIn = new FileInputStream("RestoredList");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<String> mondayList = (ArrayList<String>) in.readObject();
        ArrayList<String> tuesdayList = (ArrayList<String>) in.readObject();
        ArrayList<String> wednesdayList = (ArrayList<String>) in.readObject();
        ArrayList<String> thursdayList = (ArrayList<String>) in.readObject();
        ArrayList<String> fridayList = (ArrayList<String>) in.readObject();
        ArrayList<String> saturdayList = (ArrayList<String>) in.readObject();
        ArrayList<String> sundayList = (ArrayList<String>) in.readObject();

        week = new ArrayList<ObservableList>();

        //week.remove(currentWeekday);
        monday = FXCollections.observableArrayList(mondayList);
        week.add(monday);
        tuesday = FXCollections.observableArrayList(tuesdayList);
        week.add(tuesday);
        wednesday = FXCollections.observableArrayList(wednesdayList);
        week.add(wednesday);
        thursday = FXCollections.observableArrayList(thursdayList);
        week.add(thursday);
        friday = FXCollections.observableArrayList(fridayList);
        week.add(friday);
        saturday = FXCollections.observableArrayList(saturdayList);
        week.add(saturday);
        sunday = FXCollections.observableArrayList(sundayList);
        week.add(sunday);

        System.out.println(week);

        int selectedIndex = chooseDay.getSelectionModel().getSelectedIndex();
        todos.setItems(week.get(selectedIndex));

        // create new ObservableList containing the 7 arrayLists
        in.close();
        fileIn.close();
    }



}
