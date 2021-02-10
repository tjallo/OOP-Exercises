package geometric;

import java.util.Comparator;

public class GeometricYComparator implements Comparator<Geometric> {

    public GeometricYComparator() {
    }

    @Override
    public int compare(Geometric o1, Geometric o2) {
        double o1Y = o1.getYval();
        double o2Y = o2.getYval();

        if (o1Y < o2Y) {
            return -1;
        } else if (o1Y > o2Y) {
            return 1;
        }
        return 0;
    }
}
