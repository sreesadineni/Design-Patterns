//Strategy Pattern
/* The Strategy Design Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable, allowing clients to switch algorithms dynamically 
without altering the code structure.This pattern lets the algorithm vary independently from clients that use it.*/
// Example of SimUDuck simulation game shows duck species flying and quacking.
interface FlyBehavior{
    public void fly();
} 

interface quackbehavior{
    public void quack();
}

abstract class Duck {
    FlyBehavior fb;
    quackbehavior qb;
    public Duck(){}
        // if user wants to change behavior of duck during runtime they can use these set methods.
    public void setFlyBehavior(FlyBehavior fb){
        this.fb=fb;
    }
    public void setQuackBehavior(quackbehavior qb){
        this.qb=qb;
    }
    public void performfly(){
        fb.fly();
    }
    public void performQuack(){
        qb.quack();
    }
    public abstract void display();
}

class FlyWithWings implements FlyBehavior{
    public void fly(){
        System.out.println("I am flying");   
    }
}

class FlyNoWay implements FlyBehavior{
    public void fly(){
        System.out.println("I can't fly");   
    }
}

class Quack implements quackbehavior{
    public void quack(){
        System.out.println("Quack");
    }
}

class Squeak implements quackbehavior{
    public void quack(){
        System.out.println("Squeak");
    }
}

class MallardDuck extends Duck{
    
    public MallardDuck(){
        this.fb=new FlyWithWings();
        this.qb=new Quack();
    }
    @Override
    public void display(){
        System.out.println("This is a Mallard Duck");
    }
}

class RubberDuck extends Duck{
    
    public RubberDuck(){
        this.fb=new FlyNoWay();
        this.qb=new Squeak();
    }
    @Override
    public void display(){
        System.out.println("This is a Rubber Duck");
    }
} 
public class StrategyPattern
{
	public static void main(String[] args) {
	   Duck mallard=new MallardDuck();
	   mallard.display();
	   mallard.performfly();
	   mallard.performQuack();
	   System.out.println("Client wants to change the behavior at runtime");   // this pattern enables flexibility and change in behavior of objects dynamically
	   mallard.display();
	   mallard.setFlyBehavior(new FlyNoWay());
	   mallard.setQuackBehavior(new Squeak());
	   mallard.performfly();
	   mallard.performQuack();
	}
}
