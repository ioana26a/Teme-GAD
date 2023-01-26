package IOHomework;

import java.util.Comparator;

public class SkiTimeResultComparator implements Comparator<Athlete> {
        @Override
        public int compare(Athlete o1, Athlete o2) {
                return o1.getSkiTimeResult().compareTo(o2.getSkiTimeResult());
        }
}
