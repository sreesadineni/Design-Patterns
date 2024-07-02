//  Decorator Pattern
// Decorator pattern allows a user to add new functionality to an existing object without altering its structure.This pattern
//creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.
//This pattern enables the design principle that classes should be open for extension closed for modification.

interface Shape{
    public void Draw();
}

class Sqaure implements Shape{
    public void Draw(){
        System.out.println("Shape is a Sqaure");
    }
}

class Circle implements Shape{
    public void Draw(){
        System.out.println("Shape is a Circle");
    }
}

abstract class ShapeDecorator implements Shape{
    Shape shape;
    public ShapeDecorator(Shape s){
        this.shape=s;
    }
    public void Draw(){
        shape.Draw();
    }
}
// We can add as many decorations we want without making changes to initial object
class RedDecoration extends ShapeDecorator{
     public RedDecoration(Shape s) {
      super(s);		
   }

   @Override
   public void Draw() {
      shape.Draw();	       
      setRedBorder(shape);
   }

   private void setRedBorder(Shape decoratedShape){
      System.out.println("Border Color: Red");
   }
}

class BlueDecoration extends ShapeDecorator{
     public BlueDecoration(Shape s) {
      super(s);		
   }

   @Override
   public void Draw() {
      shape.Draw();	       
      setRedBorder(shape);
   }

   private void setRedBorder(Shape decoratedShape){
      System.out.println("Border Color: Blue");
   }
}


public class DecoratorPattern
{
	public static void main(String[] args) {
		Shape circle=new Circle();
		Shape redCircle = new RedDecoration(new Circle());
		Shape redRectangle = new BlueDecoration(new Sqaure());
		 System.out.println("Circle with normal border");
         circle.Draw();
    
         System.out.println("\nCircle of red border");
         redCircle.Draw();
    
          System.out.println("\nRectangle of Blue border");
          redRectangle.Draw();
	}
}
