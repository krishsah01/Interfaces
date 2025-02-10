import java.awt.*;

public class BigRectangleFilter implements Filter{
    @Override
    public boolean accept(Object x){

        if (x instanceof Rectangle rectangle){
            return perimeter(rectangle) > 10;
        }
        return false;
    }
    private double perimeter(Rectangle x){
        return 2 * (x.getWidth() + x.getHeight());
    }

}
