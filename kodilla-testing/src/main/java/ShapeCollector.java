
import java.util.ArrayList;

public class ShapeCollector {

    ArrayList<Shape> list = new ArrayList<>();

    void addFigure(Shape shape){
        list.add(shape);
    }
    void removeFigure(Shape shape){
        list.remove(shape);
    }
    Shape getFigure(int n){
        return list.get(n);
    }
    String showFigures(){
        return list.get(0).getFigureName() + "," + list.get(1).getFigureName() + "," +
                list.get(2).getFigureName();
    }
}



