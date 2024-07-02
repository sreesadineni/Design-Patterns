/* Adapter Pattern
The Adapter design pattern is a structural pattern that allows the interface of an existing class to be used as another interface.
It acts as a bridge between two incompatible interfaces, making them work together. This pattern involves a single class, known as 
the adapter, which is responsible for joining functionalities of independent or incompatible interfaces.*/

interface NewPrinter{
    public void print();
    public void UserInfo();
} 

interface LegacyPrinter{
    public void printDoc();
    public void UserName();
    public void UserEmail();
    public void UserID();
}

class legacyCode implements LegacyPrinter{
     public void printDoc(){
         System.out.println("Print the document");
     }
    public void UserName(){
        System.out.println("Username is sree sadineni");
    }
    public void UserEmail(){
        System.out.println("UserEmail is sreesadineni@gmail.com");
    }
    public void UserID(){
        System.out.println("UserID is 556");
    }
}
// client interacts with LegacyPrinterAdapter which is a bridge between legacy printer and new printer.
class LegacyPrinterAdapter implements NewPrinter{
    LegacyPrinter legacy;
    LegacyPrinterAdapter(LegacyPrinter legacy){
        this.legacy=legacy;
    }
    public void print(){
        legacy.printDoc();
    }
    public void UserInfo(){
        legacy.UserID();
        legacy.UserName();
        legacy.UserEmail();
    }
}
public class AdapterPattern
{
	public static void main(String[] args) {
	    LegacyPrinter oldprinter=new legacyCode();
	    LegacyPrinterAdapter adapter=new LegacyPrinterAdapter(oldprinter);
	    adapter.print();
	    adapter.UserInfo();
	}
}
