public class Book {
        private String name,author;
        private int Pages;
        public Book(){
        }
        public Book(String name,String author,int Pages){
                this.name=name;
                this.author=author;
                this.Pages=Pages;
        }
        public String getName() {
                return name;
        }


        @Override
        public String toString() {
                return "Book title: "+this.name+" \nAuthor: "+this.author+" \nPages: "+this.Pages;
        }
}
