package com.nihar_raut.contactsapplication;

import DataModel.Contact;
import DataModel.ContactsData;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import java.io.IOException;
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
        contactsTable.getSelectionModel().selectFirst();

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
        Contact contact = contactsTable.getSelectionModel().getSelectedItem();
        contactsTable.getSelectionModel().select(contact);
        contactsTable.sort();
    }

    @FXML
    public void handleEditContact(){
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

        Contact contact = contactsTable.getSelectionModel().getSelectedItem();
        NewContactDialog controller = loader.getController();
        controller.editContactFields(contact);

        Optional<ButtonType> result =  dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            controller.editContact(contact);
        }
        contactsTable.refresh();
        contactsTable.getSelectionModel().select(contact);
        contactsTable.sort();
    }
    @FXML
    public void handleDeleteContact(){
        Contact contact = contactsTable.getSelectionModel().getSelectedItem();
        delete(contact);
        contactsTable.getSelectionModel().selectFirst();
    }

    public void delete(Contact contact){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact");
        alert.setHeaderText("Delete Contact " + contact.getFirstName());
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get().equals(ButtonType.OK)){
            ContactsData.getInstance().removeContact(contact);
        }
    }

    public void handleKeyPressed(KeyEvent keyEvent){
        Contact contact = contactsTable.getSelectionModel().getSelectedItem();
        if(contact != null){
            if(keyEvent.getCode().equals(KeyCode.DELETE)){
                delete(contact);
            }
        }
    }
    @FXML
    public void handleExit(){
        Platform.exit();
    }

}