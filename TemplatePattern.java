//Template Pattern
// The Template Method defines the skeleton of an algorithm in a superclass but allows subclasses to override specific steps of the 
// algorithm without changing its structure. It promotes code reuse by encapsulating the common algorithmic structure in the superclass 
// while allowing subclasses to provide concrete implementations for certain steps, thus enabling customization and flexibility.
abstract class Beverage{
    final void prepare(){       // skeleton or structure the subclasses need to follow 
         BoilWater();
         Brew();
         addExtra();
         PourInCup();
    }
    void BoilWater(){
        System.out.println("Water is Boiling");
    }
    void PourInCup(){
        System.out.println("Pour the drink in cup");
    }
    abstract void Brew();
    abstract void addExtra();
    void OptionalIngredients(){}  // hook is an optional method subclasses can Override ?
}
class Tea extends Beverage{
    @Override
    void Brew(){
        System.out.println("Add Tea leaves to boliing water");
    }
    @Override
    void addExtra(){
        System.out.println("Add Sugar to tea");
    }
}
class Coffee extends Beverage{
     @Override
    void Brew(){
        System.out.println("Add Coffee powder to boliing water");
    }
    @Override
    void addExtra(){
        System.out.println("Add Milk and Sugar to Coffee");
    }
}
public class TemplatePattern
{
	public static void main(String[] args) {
	    System.out.println("Tea preparation.....");
		Tea tea=new Tea();
		tea.prepare();
	    System.out.println("Coffee preparation.....");
		Coffee coffee=new Coffee();
		coffee.prepare();
	}
}
