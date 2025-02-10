import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangleArrayList = new ArrayList<>();
        //too lazy to manually make and add the rectangles in array ,
        // this generates rectangles few small few big, total 10
        for (int i = 1; i < 12; i++) {
            Rectangle rectangle = new Rectangle(i+1,i);
            // System.out.println(rectangle + "generated rectangles");
            if (rectangle.width <= 9) {
                i -= 1;
                rectangleArrayList.add(rectangle);
            }
            i += 1;
        }

        BigRectangleFilter filter = new BigRectangleFilter();
        System.out.println("Rectangles with perimeter grater than 10: ");
        for (Rectangle x: rectangleArrayList){
            if (filter.accept(x)){
                System.out.println("Rectangle: "+x);
            }
        }
    }
}
