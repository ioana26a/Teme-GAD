public class Novel extends Book {
        private String genre;

        public Novel(String name, String author, int Pages, String genre) {
                super(name, author, Pages);
                this.genre = genre;
        }

        @Override
        public String toString() {
                return super.toString() + " \nGenre: " + this.genre;
        }

}
