package IOHomework;

import org.jetbrains.annotations.NotNull;
import java.time.LocalTime;

public class Athlete implements Comparable<Athlete>{
        private String athleteName,countryCode,firstShootingRange,secondShootingRange,thirdShootingRange;
        private int athleteNumber;
        private LocalTime skiTimeResult;
        public Athlete(int athleteNumber,String athleteName,String countryCode,LocalTime skiTimeResult,String firstShootingRange,String secondShootingRange,
                       String thirdShootingRange){
                this.athleteName=athleteName;
                this.athleteNumber=athleteNumber;
                this.countryCode=countryCode;
                this.firstShootingRange=firstShootingRange;
                this.secondShootingRange=secondShootingRange;
                this.thirdShootingRange=thirdShootingRange;
                this.skiTimeResult=skiTimeResult;
        }

        public LocalTime getSkiTimeResult() {
                return skiTimeResult;
        }

        @Override
        public String toString() {
                return "No.athlete:"+athleteNumber+"\nName:"+athleteName+"\nCountry:"+athleteName+"\nTime result:"+skiTimeResult +
                "\nFirst shooting range:"+firstShootingRange+"\nSecond shooting range:"+secondShootingRange+
                        "\nThird shooting range:"+thirdShootingRange;
        }

        @Override
        public int compareTo(@NotNull Athlete o) {
                return this.skiTimeResult.compareTo(o.skiTimeResult);
        }
}
