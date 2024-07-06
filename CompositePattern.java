/*The Composite Design Pattern lets you compose objects into tree-like structures to represent part-whole hierarchies. It allows clients 
to treat individual objects and compositions of objects(group of objects ) uniformly.
The key concept is that you can manipulate a single instance of the object just as you would manipulate a group of them.*/
import java.util.*;

abstract class MenuComponent {
    public abstract String getName();

    public double getPrice() { // both leaf and Node may not implement same method so by default throw an
                               // exception
        throw new UnsupportedOperationException();
    }

    public void addChild(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void removeChild(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void display();
}

// MenuItem is a leaf component which is individual menu item in this case
class MenuItem extends MenuComponent {
    String Name;
    double price;

    public MenuItem(String name, double price) {
        this.Name = name;
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println(getName() + "--->" + " " + getPrice() + "\n");
    }
}

// SubMenu is the node element of a tree which has children or it can also be
// the root of tree.
class SubMenu extends MenuComponent {
    List<MenuComponent> menulist = new ArrayList<MenuComponent>();
    String Name;

    public SubMenu(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public MenuComponent getChild(int i) {
        return menulist.get(i);
    }

    public void addChild(MenuComponent menuitem) {
        menulist.add(menuitem);
    }

    public void removechild(MenuComponent menuitem) {
        menulist.remove(menuitem);
    }

    public void display() {
        System.out.println(getName() + "\n" + "____________________" + "\n");
        for (MenuComponent mi : menulist) { // This can also be implemented using iterators i.e Iterator design pattern
            mi.display();
        }
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        // In this case submenu like starters,mains,desserts are composites which
        // consists of individual menuitems are root elements of tree
        MenuComponent starters = new SubMenu("starters");
        starters.addChild(new MenuItem("Soup", 150));
        starters.addChild(new MenuItem("Veg Kebab", 250));
        starters.addChild(new MenuItem("NonVeg Kebab", 285));

        MenuComponent Mains = new SubMenu("Mains");
        Mains.addChild(new MenuItem("Biryani", 350));
        Mains.addChild(new MenuItem("Roti", 50));
        Mains.addChild(new MenuItem("Curry", 325));

        MenuComponent Desserts = new SubMenu("Desserts");
        Desserts.addChild(new MenuItem("IceCream", 180));
        Desserts.addChild(new MenuItem("MilkShake", 230));
        Desserts.addChild(new MenuItem("Fruit Custard", 275));

        MenuComponent MainMenu = new SubMenu("Restaurants Menu");
        MainMenu.addChild(starters);
        MainMenu.addChild(Mains);
        MainMenu.addChild(Desserts);

        MainMenu.display();
    }
}
