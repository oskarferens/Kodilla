
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ShapeCollectorTestSuite {

    @DisplayName("Collector's addFigure method collects input shape in owns memory.")
    @Test
    void addFigureTest () {
        //Given
        Shape square = new Square(10);
        ShapeCollector collector = new ShapeCollector();
        //When
        collector.addFigure(square);
        Shape firstShape = collector.getFigure(0);
        //Then
        Assertions.assertNotNull(firstShape);
        Assertions.assertEquals(firstShape.getFigureName(),"square");
    }

    @DisplayName("collector removes Figure method; delete input shape from it owns memory.")
    @Test
    void removeFigureTest () {
        Shape square = new Square(10);
        Shape circle = new Circle(4);
        Shape triangle = new Triangle(5,10);
        ShapeCollector collector = new ShapeCollector();

        collector.addFigure(square);
        collector.addFigure(circle);
        collector.addFigure(triangle);

        collector.removeFigure(square);

        Assertions.assertEquals(2,collector.list.size());
    }

    @DisplayName("Using getFigure to take one from the ArrayList.")
    @Test
    void getFigure () {
        Shape square = new Square(10);
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(square);

        collector.getFigure(0);

        Assertions.assertEquals(square,collector.getFigure(0));
    }

    @DisplayName("Printing all objects in ArrayList (shapes) as one String.")
    @Test
    void showFigures () {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Triangle triangle = new Triangle(5,10);
        Square square = new Square(10);
        Circle circle = new Circle(4);


        collector.addFigure(triangle);
        collector.addFigure(square);
        collector.addFigure(circle);
        //When
        collector.showFigures();
        String expected = "triangle,square,circle";
        //Then
        Assertions.assertEquals(expected,collector.showFigures());
    }
}