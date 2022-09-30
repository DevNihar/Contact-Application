package DataModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class ContactsData {

    private static ContactsData contactsData = new ContactsData();

    private ObservableList<Contact> contactsList;

    private String filename = "Contacts.txt";

    public ContactsData() {
    }

    public static ContactsData getInstance(){
        return contactsData;
    }

    public void addContact(Contact contact){
        if(contact != null){
            contactsList.add(contact);
        }else{
            System.out.println("Contact cannot be Null");
        }
    }

    public ObservableList<Contact> getContactsList() {
        return contactsList;
    }

    public void removeContact(Contact contact){
        if(contact != null){
            contactsList.remove(contact);
        }else{
            System.out.println("Contact cannot be Null");
        }
    }

    public void loadContacts(){
        contactsList = FXCollections.observableArrayList();
        Path filePath = Paths.get(filename);
        String input;
        if(Files.exists(filePath)){
            try(BufferedReader bf = Files.newBufferedReader(filePath)){
                while((input = bf.readLine()) != null){
                    String[] contactPart = input.split("\t");
                    String firstname = contactPart[0];
                    String lastname = contactPart[1];
                    String phoneNumber = contactPart[2];
                    String note = contactPart[3];
                    Contact contact = new Contact(firstname, lastname, phoneNumber, note);
                    contactsList.add(contact);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void saveContacts(){
        if(!contactsList.isEmpty()){
            Path filePath = Paths.get(filename);
            try(BufferedWriter bw = Files.newBufferedWriter(filePath)) {
                Iterator<Contact> iter = contactsList.iterator();
                while (iter.hasNext()){
                    Contact contact = iter.next();
                    bw.write(String.format("%s\t%s\t%s\t%s", contact.getFirstName(),
                                                            contact.getLastName(),
                                                            contact.getPhoneNumber(),
                                                            contact.getNote()));
                    bw.newLine();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
