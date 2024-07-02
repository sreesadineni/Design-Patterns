// Factory Pattern 
//The Factory Method Design Pattern encapsulates object creation logic in a separate method, promoting loose coupling between the creator and the created objects. 
//This pattern is particularly useful when the exact types of objects to be created may vary or need to be determined at runtime, enabling flexibility and extensibility in object creation.
import java.util.Scanner;
 abstract class CardType {
    protected double CreditLimit;
    public abstract void setCreditLimit();
    public String toString(){
        return "Your card is "+this.getClass().getSimpleName()+" & your credit limit is "+CreditLimit;
    }
}

class SilverCard extends CardType{
    public SilverCard() {
        setCreditLimit();
    } 
    @Override
    public void setCreditLimit() {
       CreditLimit=100000;
    }   
}

class GoldCard extends CardType{
    public GoldCard() {
        setCreditLimit();
    } 
    @Override
    public void setCreditLimit() {
       CreditLimit=100000;
    }   
}

class PlatinumCard extends CardType{
    public PlatinumCard() {
        setCreditLimit();
    } 
    @Override
    public void setCreditLimit() {
       CreditLimit=100000;
    }   
}
class Factory {
    public static CardType getcard(String type){
        switch(type){
            case "Silver": 
                return new SilverCard();
            case "Gold": 
                return new GoldCard();
            case "Platinum": 
                return new PlatinumCard();
            default : 
                return null;
        }
    }
}

public class FactoryPattern
{
	public static void main(String[] args) {
        String cardtype="";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your salary :");
        double salary=sc.nextDouble();
        if(salary<50000){
            cardtype="Silver";
        }else if(salary <100000){
            cardtype="Gold";
        }else{
            cardtype="Platinum";
        }
        sc.close();
        CardType mycard=Factory.getcard(cardtype);
        System.out.println(mycard);
	}
}
