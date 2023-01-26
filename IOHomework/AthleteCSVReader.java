package IOHomework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AthleteCSVReader {
        public List<Athlete> readPlayers(Reader reader) throws IOException {
                ArrayList<Athlete> athletes = new ArrayList<Athlete>();
                BufferedReader bufReader = new BufferedReader(reader);
                String line = bufReader.readLine();
                while (line != null) {
                        String[] tokens = line.split(",");
                        for (int j = 0; j < tokens.length; j++) {
                                System.out.println(tokens[j]);
                        }
                        Athlete athlete = new Athlete(
                                Integer.parseInt(tokens[0]),
                                tokens[1],
                                tokens[2],
                                parseHelper(tokens[3]),
                                tokens[4],
                                tokens[5],
                                tokens[6]);
                        athletes.add(athlete);
                        line = bufReader.readLine();
                }
                return athletes;
        }
        private static LocalTime parseHelper(String str) {
                return LocalTime.parse("00:" + str);
        }
}
