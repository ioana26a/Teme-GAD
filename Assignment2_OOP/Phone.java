package Assignment2_OOP;
import java.util.ArrayList;
import java.util.Scanner;

public class Phone {
        ArrayList<Contact>contacts=new ArrayList<>();
        ArrayList<String>historyCalls=new ArrayList<>();
        ArrayList<String>historyMessages=new ArrayList<>();     //mesaje trimise unui nr de telefon care nu exista in agenda
        private Scanner sc=new Scanner(System.in);
        class Contact{
                int index;
                String lastName, firstName, phoneNumber;
                ArrayList<String>messagesSent=new ArrayList<>();
                public Contact(int index,String phoneNumber,String firstName,String lastName){
                        this.index=index;
                        this.lastName=lastName;
                        this.firstName=firstName;
                        this.phoneNumber=phoneNumber;
                }

                public String getFirstName() {
                        return firstName;
                }

                public String getLastName() {
                        return lastName;
                }

                @Override
                public String toString() {
                        return  index + ".First name:" + firstName + "\n  Last name:"+lastName + "\n  Phone number:" + phoneNumber;
                }
        }
        Contact searchContact(String phone){
                for(Contact c : contacts) {
                        if (phone.equals(c.phoneNumber)) {
                                return c;
                        }
                }
                return null;
        }
        void addContact(int index,String phoneNumber ,String firstName, String lastName) {
                Contact contact = new Contact(index,phoneNumber,firstName,lastName);
                contacts.add(contact);
                System.out.println("Successfully added a new contact");
        }
        void listContacts(){
                if(contacts.isEmpty()){
                        System.out.println("There is no contact in your phone.");
                        return;
                }
                System.out.println("Contacts:");
                for(Contact c : contacts){
                        System.out.println(c);
                }
                System.out.println("\n");
        }
        void sendMessage(String phone,String msg) {
                if (msg.length() > 500) {
                        System.out.println("Message too large.Please try again");
                        return;
                }
                Contact c=searchContact(phone);
                if(c!=null){
                        c.messagesSent.add(msg);
                        return;
                }
                historyMessages.add("Message sent to " + phone + "\n\t" + msg );
        }
        void listMessages(String phoneNumber){
                Contact c = searchContact(phoneNumber);
                if(c!=null){
                        System.out.println("Messages sent to " + c.getFirstName() + " " + c.getLastName());
                        for(int i=0;i<c.messagesSent.size();++i){
                                System.out.println("\t" + c.messagesSent.get(i));
                        }
                        return;
                }
                for (String msg:historyMessages) {
                        if(msg.contains(phoneNumber))
                                System.out.println(msg);
                }
        }
        void call(String phoneNumber) {
                Contact c = searchContact(phoneNumber);
                if(c!=null){
                        System.out.println("Called " + c.getFirstName() + " " + c.getLastName());
                        historyCalls.add(c.getFirstName() + "  " + c.getLastName());
                        return;
                }
                System.out.println("Called " + phoneNumber);
                historyCalls.add(phoneNumber);
        }
        void viewHistory(){
                if(historyCalls.isEmpty()){
                        System.out.println("There are no recent calls");
                        return;
                }
                System.out.println("Recents:");
                for(String var : historyCalls)
                        System.out.println("\t" +var);
        }
}









