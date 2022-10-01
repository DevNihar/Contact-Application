package com.nihar_raut.contactsapplication;

import DataModel.Contact;
import DataModel.ContactsData;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewContactDialog {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField noteField;

    public void processData(){
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String note = noteField.getText();

        Contact contact = new Contact(firstName, lastName, phoneNumber, note);
        ContactsData.getInstance().addContact(contact);
    }

    public void editContactFields(Contact contact){
        firstNameField.setText(contact.getFirstName());
        lastNameField.setText(contact.getLastName());
        phoneNumberField.setText(contact.getPhoneNumber());
        noteField.setText(contact.getNote());
    }
    public void editContact(Contact contact){
        contact.setFirstName(firstNameField.getText());
        contact.setLastName(lastNameField.getText());
        contact.setPhoneNumber(phoneNumberField.getText());
        contact.setNote(noteField.getText());

    }
}
