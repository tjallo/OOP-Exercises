package geometric;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {

    public Sort() {
    }

    public ArrayList<Geometric> sortByArea(ArrayList<Geometric> shapes) {
        Geometric[] shapeArray = toArray(shapes);
        Arrays.sort(shapeArray);
        ArrayList<Geometric> g = new ArrayList<Geometric>(Arrays.asList(shapeArray));
        return g;
    }
    
    // public ArrayList<Geometric> sortByX(ArrayList<Geometric> shapes) {
    //     Geometric[] shapeArray = toArray(shapes);
    // }
    
    // public ArrayList<Geometric> sortByY(ArrayList<Geometric> shapes) {
    //     Geometric[] shapeArray = toArray(shapes);
    // }

    private Geometric[] toArray(ArrayList<Geometric> shapes) {
        Geometric[] result = new Geometric[shapes.size()];

        for (int i =0; i< shapes.size(); i++){
            result[i] = shapes.get(i);
        }

        return result;
    } 
}
