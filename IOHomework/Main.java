package IOHomework;

import java.io.*;
import java.util.List;
import java.util.TreeSet;

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

                        for(Athlete a:athletes){
                                a.shootingRange();
                        }

                        TreeSet<Athlete> athletes1 = new TreeSet<>(new SkiTimeResultComparator());
                        for(Athlete a:athletes){
                                athletes1.add(a);
                        }
                        for(Athlete a:athletes1){
                                System.out.println(a.getSkiTimeResult());
                        }

                } finally {
                        if (is != null) {
                                is.close();
                        }
                }


        }
}
