package com.nihar_raut.contactsapplication;

import DataModel.ContactsData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("Contacts");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        ContactsData.getInstance().loadContacts();
    }

    @Override
    public void stop() throws Exception {
        ContactsData.getInstance().saveContacts();
    }

    public static void main(String[] args) {
        launch();
    }
}