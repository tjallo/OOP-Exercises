package geometric;

import java.util.Comparator;

public class GeometricXComparator implements Comparator<Geometric> {

    public GeometricXComparator() {
    }

    @Override
    public int compare(Geometric o1, Geometric o2) {
        double o1X = o1.bottomBorder();
        double o2X = o2.bottomBorder();

        if (o1X < o2X) {
            return -1;
        } else if (o1X > o2X) {
            return 1;
        }
        return 0;
    }
}
