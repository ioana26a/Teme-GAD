package IOHomework;
import java.time.LocalTime;

public class Athlete {
        private String athleteName,athleteNumber,countryCode,firstShootingRange,secondShootingRange,thirdShootingRange;
        private LocalTime skiTimeResult;
        public Athlete(String athleteNumber,String athleteName,String countryCode,LocalTime skiTimeResult,String firstShootingRange,String secondShootingRange,
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
                return "No.athlete:"+athleteNumber+"\nName:"+athleteName+"\nCountry:"+countryCode+"\nTime result:"+skiTimeResult +
                "\nFirst shooting range:"+firstShootingRange+"\nSecond shooting range:"+secondShootingRange+
                        "\nThird shooting range:"+thirdShootingRange;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Athlete that = (Athlete) o;

                if (athleteNumber != that.athleteNumber) return false;
                if (!athleteName.equals(that.athleteName)) return false;
                if (!countryCode.equals(that.countryCode)) return false;
                if (!skiTimeResult.toString().equals(that.skiTimeResult.toString())) return false;
                if (!firstShootingRange.equals(that.firstShootingRange)) return false;
                if (!secondShootingRange.equals(that.secondShootingRange)) return false;
                if (!thirdShootingRange.equals(that.thirdShootingRange)) return false;
                return true;
        }

        public void shootingRange() {
                for (int i = 0; i < 5; i++) {
                        if(firstShootingRange.charAt(i) == 'o'){
                                skiTimeResult=skiTimeResult.plusSeconds(10);
                        }
                        if(secondShootingRange.charAt(i) == 'o'){
                                skiTimeResult=skiTimeResult.plusSeconds(10);
                        }
                        if(thirdShootingRange.charAt(i) == 'o'){
                                skiTimeResult=skiTimeResult.plusSeconds(10);
                        }
                }
        }
}
