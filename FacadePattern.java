/* Facade Pattern

Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system. 
This pattern involves a single class which provides simplified methods required by client and delegates calls to methods of existing system classes
 Facade basically decouples the client from complex subsystem*/


interface Order_Facade{
    public void Order();
}

interface waiter{
    public void takeOrder();
    public void sendToKitchen();
    public void serve();
}

interface kitchen{
    public void receiveOrder();
    public void prepare();
    public void CallWaiter();
}

class WaiterClass implements waiter{
    public void takeOrder(){
        System.out.println("waiter takes the order from the customer");
    }
    public void sendToKitchen(){
        System.out.println("Waiter sends Order details to kitchen");
    }
    public void serve(){
        System.out.println("Waiter servers the order");
    }
}

class kitchenclass implements kitchen{
     public void receiveOrder(){
         System.out.println("order received from the waiter");
     }
    public void prepare(){
        System.out.println("Food is getting prepared");
    }
    public void CallWaiter(){
        System.out.println("call the waiter to take the food");
    }
}

class FacadeClass implements Order_Facade{
    kitchen kitchenobj;
    waiter waiterobj;
    FacadeClass(){
         this.kitchenobj = new kitchenclass();
        this.waiterobj = new WaiterClass();
    }
    public void Order(){
        waiterobj.takeOrder();
        waiterobj.sendToKitchen();
        kitchenobj.receiveOrder();
        kitchenobj.prepare();
        kitchenobj.CallWaiter();
        waiterobj.serve();
    }
}
//client doesnot know about waiterclass or kitchenclass, it just interacts with facade class which makees the task easier.
public class FacadePattern
{
	public static void main(String[] args) {
	   FacadeClass Facade=new FacadeClass();
	   Facade.Order();
	}
}
