// Singleton Design Pattern

//Singleton Design Pattern - Only allows one instance or one object of a class to exist and provide global access point to it
class Singleton {
  private static Singleton uniqueInstance;

  private Singleton() {
    // some code which only executes once
  }

  public static Singleton getInstance() {
    if (uniqueInstance == null) {
      System.out.println("Unique instance of class is created");
      uniqueInstance = new Singleton();
      return uniqueInstance;
    }
    System.err.println("Unique version already exists so returning the same object");
    return uniqueInstance; // each time same object is returned
  }
}

// Singleton patterns can also be implemented using Enums which hanfles in
// synchronizing,class loders,serialization,reflecction issues
enum Single {
  uniqueInstance;

  int value;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}

public class SingletonPattern {
  public static void main(String[] args) {
    Singleton single = Singleton.getInstance();
    Singleton single2 = Singleton.getInstance();
    // implementing Singleton Pattern using enums
    Single obj = Single.uniqueInstance;
    obj.setValue(12);
    System.out.println(obj.getValue());

  }
}
