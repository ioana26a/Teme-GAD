package Object_Containers;

import java.util.Comparator;

public class PersoanaVarstaComparator implements Comparator<Persoana> {
        @Override
        public int compare(Persoana o1, Persoana o2) {
                return o1.getVarsta() - o2.getVarsta();
        }
}