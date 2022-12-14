public class ArtAlbum extends Book{
        private String paperQuality;
        public ArtAlbum(String name,String author,int Pages,String paperQuality){
                super(name, author, Pages);
                this.paperQuality=paperQuality;
        }
        @Override
        public String toString() {
                return super.toString() + " \nPaper quality: "+this.paperQuality;
        }
}
