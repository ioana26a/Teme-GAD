import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                int meniu;
                Library l = null;
                Scanner sc = new Scanner(System.in);
                do {
                        System.out.println("\n1.Create library");
                        System.out.println("2.Add book");
                        System.out.println("3.Delete book");
                        System.out.println("4.List books in the library");
                        System.out.println("5.Exit");
                        System.out.print("Case:");
                        meniu = sc.nextInt();
                        switch (meniu) {
                                case 1:
                                        if(l!=null){
                                                System.out.println("The library already exists");
                                                break;
                                        }
                                        System.out.print("Enter library name ");
                                        String name = sc.next();
                                        l = new Library(name);
                                        break;

                                case 2:
                                        if (l != null)
                                                l.addBook();
                                        else System.out.println("The library doesn't exist");
                                        break;
                                case 3:
                                        if (l != null) {
                                                if(l.getBooks().isEmpty()){
                                                        System.out.println("The library has no books");
                                                        break;
                                                }
                                                System.out.print("Enter name of book ");
                                                String nameBook = sc.next();
                                                l.deleteBook(nameBook);
                                        }
                                        else System.out.println("The library doesn't exist");
                                        break;
                                case 4:
                                        if (l != null)
                                                l.list();
                                        else System.out.println("The library doesn't exist");
                                        break;
                                case 5:
                                        break;
                                default:
                                        System.out.println("Wrong choice");
                        }
                }
                while (meniu != 5);

        }

}
