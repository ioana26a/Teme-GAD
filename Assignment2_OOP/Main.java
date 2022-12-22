package Assignment2_OOP;

public class Main {
        public static void main(String[] args) {
                Phone phone1=new Iphone12("Green","73856225",8);
                Phone phone2=new SamsungA20e("Blue","22353245",7);

                phone1.addContact(1, "07123", "John", "Smith");
                phone1.addContact(2, "07456", "Marry", "Jane");
                phone1.listContacts();

                phone1.sendMessage("07123", "Hello");
                phone1.sendMessage("07456", "See you later");
                phone1.listMessages("07123");
                phone1.listMessages("07456");

                phone1.call("07123");
                phone1.call("07321");
                phone1.viewHistory();
        }
}

