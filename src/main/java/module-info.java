module com.nihar_raut.contactsapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.nihar_raut.contactsapplication to javafx.fxml;
    exports com.nihar_raut.contactsapplication;
}