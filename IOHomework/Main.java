package IOHomework;

import java.io.*;
import java.util.List;

public class Main {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
                String fileName = "athletes.csv";
                InputStream is = null;
                try {
                        is = new FileInputStream(fileName);

                        //AthleteCSVParser parser = new AthleteCSVParser();
                        //List<Athlete> athletes1 = parser.parseAthletes(is);

                        AthleteCSVReader reader = new AthleteCSVReader();
                        List<Athlete> athletes = reader.readAthletes(new FileReader(fileName));

                        Athlete simo = athletes.get(1);
                        System.out.println(simo);

                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("simo.obj"));
                        Object o = ois.readObject();
                        Athlete simo2 = (Athlete) o;
                        System.out.println(simo2);

                } finally {
                        if (is != null) {
                                is.close();
                        }
                }


        }
}
