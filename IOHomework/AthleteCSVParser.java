package IOHomework;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AthleteCSVParser {
        public List<Athlete> parsePlayers(InputStream csvInputStream) throws IOException {
                byte [] buffer = new byte [5];
                int readBytes = csvInputStream.read(buffer);
                StringBuilder builder = new StringBuilder();
                while(readBytes > 0) {
                        builder.append(new String(buffer, 0, readBytes, "UTF-8"));
                        readBytes = csvInputStream.read(buffer);
                }
                String readContent = builder.toString();
                String[] lines = readContent.split("\n");
                int i = 0;
                ArrayList<Athlete> athletes = new ArrayList<Athlete>();
                for(String line : lines){
                        //System.out.println(line);
                        String[] tokens = line.split(",");
                        Athlete player = new Athlete(
                                Integer.parseInt(tokens[0]),
                                tokens[1],
                                tokens[2],
                                LocalTime.parse(tokens[3]),
                                tokens[4],
                                tokens[5],
                                tokens[6]);
                        athletes.add(player);
                }
                return athletes;
        }
}
