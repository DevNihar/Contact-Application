package com.nihar_raut.contactsapplication;

import DataModel.Contact;
import DataModel.ContactsData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller {
    @FXML
    private TableView contactsTable;
    @FXML
    private TableColumn firstNameColumn;
    @FXML
    private TableColumn secondNameColumn;
    @FXML
    private TableColumn phoneNumberColumn;
    @FXML
    private TableColumn noteColumn;

    public void initialize(){
//        Contact contact1 = new Contact("Nihar", "Raut", "8390069093", "Me");
//        Contact contact2 = new Contact("Niharika", "Raut", "5478965135", "Sister");
//        Contact contact3 = new Contact("Damayanti", "Raut", "7546982145", "Mother");
//        Contact contact4 = new Contact("Suresh", "Raut", "6854257954", "Father");
//
//        ContactsData.getInstance().addContact(contact1);
//        ContactsData.getInstance().addContact(contact2);
//        ContactsData.getInstance().addContact(contact3);
//        ContactsData.getInstance().addContact(contact4);
    }
}