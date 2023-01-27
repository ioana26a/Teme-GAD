package IOHomework;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AthleteCSVParserTest {

        @Test
        public void parseAthletes() throws IOException {
                // given
                String content = "23,Jimmy Smiles,UK,29:34,xxxxx,xxxxx,xxxxx";/* +
                        "\n34,Piotr Smitzer,CZ,24:40,xxxxx,xxxxx,xxxxx";*/
                InputStream is = new ByteArrayInputStream(content.getBytes("UTF-8"));
                AthleteCSVParser parser = new AthleteCSVParser();

                // when
                List<Athlete> athletes = parser.parseAthletes(is);

                // then
                ArrayList<Athlete> expectedAthletes = new ArrayList<Athlete>();
                expectedAthletes.add(new Athlete("23","Jimmy Smiles", "UK",
                        AthleteCSVReader.parseHelper("29:34"),"xxxxx","xxxxx",
                        "xxxxx" ));
                /*expectedAthletes.add(new Athlete("34","Piotr Smitzer", "CZ",
                        AthleteCSVReader.parseHelper("24:40"), "xxxxx","xxxxx",
                        "xxxxx"));*/
                Assert.assertEquals(athletes, expectedAthletes);
               /* assertEquals(true, athletes.size() == expectedAthletes.size() &&
                        athletes.containsAll(expectedAthletes) && expectedAthletes.containsAll(athletes));*/
        }
}