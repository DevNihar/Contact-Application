package com.nihar_raut.contactsapplication;

import DataModel.Contact;
import DataModel.ContactsData;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private TableView<Contact> contactsTable;
    @FXML
    private TableColumn<Contact, String> firstNameColumn;
    @FXML
    private TableColumn<Contact, String> secondNameColumn;
    @FXML
    private TableColumn<Contact, String> phoneNumberColumn;
    @FXML
    private TableColumn<Contact, String> noteColumn;
    private List<Contact> contactList;

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

        contactList = new ArrayList<>(ContactsData.getInstance().getContactsList());
        firstNameColumn.setMinWidth(100);
        firstNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Contact, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Contact, String> contactStringCellDataFeatures) {
                return contactStringCellDataFeatures.getValue().firstNameProperty();
            }
        });
        secondNameColumn.setMinWidth(100);
        secondNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Contact, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Contact, String> contactStringCellDataFeatures) {
                return contactStringCellDataFeatures.getValue().lastNameProperty();
            }
        });
        phoneNumberColumn.setMinWidth(100);
        phoneNumberColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Contact, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Contact, String> contactStringCellDataFeatures) {
                return contactStringCellDataFeatures.getValue().phoneNumberProperty();
            }
        });
        noteColumn.setMinWidth(100);
        noteColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Contact, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Contact, String> contactStringCellDataFeatures) {
                return contactStringCellDataFeatures.getValue().noteProperty();
            }
        });

        
        contactsTable.setItems(ContactsData.getInstance().getContactsList());

    }
}