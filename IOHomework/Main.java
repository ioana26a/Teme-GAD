package IOHomework;

import java.io.*;
import java.time.LocalTime;
import java.util.List;
import java.util.TreeSet;

public class Main {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
                String fileName = "athletes.csv";
                InputStream is = null;
                try {
                        is = new FileInputStream(fileName);

                        /*AthleteCSVParser parser = new AthleteCSVParser();
                        List<Athlete> athletes1 = parser.parseAthletes(is);*/

                        AthleteCSVReader reader = new AthleteCSVReader();
                        List<Athlete> athletes = reader.readAthletes(new FileReader(fileName));

                        for(Athlete a:athletes){
                                a.shootingRange();
                        }

                      TreeSet<Athlete> athletes1 = new TreeSet<>(new SkiTimeResultComparator());
                        for(Athlete a:athletes){
                                athletes1.add(a);
                        }
                        int i=0;
                        for(Athlete a:athletes1){
                                if(i==0){
                                        System.out.print("Winner - ");
                                }
                                if(i==1){
                                        System.out.print("Runner-up - ");
                                }
                                if(i==2){
                                        System.out.print("Third Place - ");
                                }
                                System.out.println(a.getAthleteName()+" - "+a.getSkiTimeResult());
                                i++;
                        }

                } finally {
                        if (is != null) {
                                is.close();
                        }
                }


        }
}
