import java.util.ArrayList;
import java.util.Scanner;

public class Library {
        private String name;
        private ArrayList<Book>books=new ArrayList<>();
        public Library(String name){
                this.name=name;
        }
        private Scanner sc=new Scanner(System.in);

        public ArrayList<Book> getBooks() {
                return books;
        }

        public void addBook(){
                System.out.print("Choice:\n1.Create Novel\n2.Create Art Album\n");
                int pages,n=0;
                int choice = sc.nextInt();
                        if(choice==1){
                                System.out.print("Name: ");
                                String name = sc.next();
                                System.out.print("Author: ");
                                String author = sc.next();
                                System.out.print("Pages: ");
                                do{
                                        if(n>0){
                                                System.out.println("Enter positive integer");
                                        }
                                        pages = sc.nextInt();
                                        n++;
                                }while (pages<1);
                                System.out.print("Genre: ");
                                String genre = sc.next();
                                Novel novel=new Novel(name,author,pages,genre);
                                books.add(novel);
                        }
                        if (choice==2) {
                                System.out.print("Name: ");
                                String name = sc.next();
                                System.out.print("Author: ");
                                String author = sc.next();
                                System.out.print("Pages: ");
                                do{
                                        if(n>0){
                                                System.out.println("Enter positive integer");
                                        }
                                        pages = sc.nextInt();
                                        n++;
                                }while (pages<1);
                                System.out.print("Quality paper: ");
                                String quality = sc.next();
                                ArtAlbum album = new ArtAlbum(name, author, pages, quality);
                                books.add(album);
                        }
        }
        public void deleteBook(String name){
                for(Book book:books){
                        if(book.getName().equals(name)) {
                                books.remove(book);
                                System.out.println("The book was deleted.");
                                return;
                        }
                }
                System.out.println("The book doesn't exist");
        }
        public void list(){
                if(books.isEmpty()){
                        System.out.println("The library has no books");
                        return;
                }
                System.out.println("Library "+ this.name +" has the following books ");
                for(Book book:books){
                        System.out.print(books.indexOf(book)+".");
                        System.out.println(book);
                }
        }

}
