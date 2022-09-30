package com.nihar_raut.contactsapplication;

import DataModel.Contact;
import DataModel.ContactsData;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @FXML
    private BorderPane mainBorderPane;

    public void initialize(){

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

    public void handleCreateContact(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add Contact");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("new-contact-dialog.fxml"));
        try {
            dialog.getDialogPane().setContent(loader.load());
        }catch (IOException e){
            System.out.println("Couldn't load new Contact Dialog");
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK){
            NewContactDialog controller = loader.getController();
            controller.processData();
        }
    }
}