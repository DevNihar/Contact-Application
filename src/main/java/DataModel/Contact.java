package DataModel;

import javafx.beans.property.SimpleStringProperty;

public class Contact {

    private final SimpleStringProperty firstName = new SimpleStringProperty("");

    private final SimpleStringProperty lastName = new SimpleStringProperty("");

    private final SimpleStringProperty phoneNumber = new SimpleStringProperty("");

    private final SimpleStringProperty note = new SimpleStringProperty("");

    public Contact(String firstName, String lastName, String phoneNumber, String note) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.phoneNumber.set(phoneNumber);
        this.note.set(note);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getNote() {
        return note.get();
    }

    public SimpleStringProperty noteProperty() {
        return note;
    }

    public void setNote(String note) {
        this.note.set(note);
    }

    @Override
    public String toString() {
        return "Contact {\n" +
                "\t\tFirst Name: " + this.firstName + "\n" +
                "\t\tLast Name: " + this.lastName + "\n" +
                "\t\tPhone Number: " + this.phoneNumber + "\n" +
                "\t\tNote: " + this.note + "\n" +
                "}";
    }
}
