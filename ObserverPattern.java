//Observer Pattern 

/*Observer pattern-defines one to many relation between objects such that when one changes the state all dependent objects are 
                   notified and updated automatically. Helps in loose coupling between objects i.e publisher and 
                   observer */
import java.util.ArrayList;

interface publisher {
  public void addObserver(observer ob);

  public void removeObserver(observer ob);

  public void notifyObserver();

  public void setWeather(float temperature, float humidity, float pressure);
}

interface observer {
  public void update(float temperature, float humidity, float pressure);
}

// Weather app whenever there is change in weather it automatically notifies the
// observer classes
class Weather implements publisher {
  private ArrayList<observer> ObserversList;
  private float temperature;
  private float humidity;
  private float pressure;

  public Weather() {
    ObserversList = new ArrayList<observer>();
  }

  public void addObserver(observer obs) {
    ObserversList.add(obs);
  }

  public void removeObserver(observer obs) {
    ObserversList.remove(obs);
  }

  public void notifyObserver() {
    for (observer ob : ObserversList) {
      ob.update(temperature, humidity, pressure);
    }
  }

  public void setWeather(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    notifyObserver();
  }
}

// each observer class have their own version of update method.
class TVnews implements observer {
  public void update(float temperature, float humidity, float pressure) {
    System.out.println("TV1 Weather Update\n" + "temperature is: " + temperature + "\n" + "Humidity is:" + humidity
        + "\n" + "pressure is:" + pressure);
  }
}

class MobileApp implements observer {
  public void update(float temperature, float humidity, float pressure) {
    System.out.println("App Weather Update\n" + "temperature is: " + temperature + "\n" + "Humidity is:" + humidity
        + "\n" + "pressure is:" + pressure);
  }
}

class NewsPaper implements observer {
  public void update(float temperature, float humidity, float pressure) {
    System.out.println("NewsPaper Weather Update\n" + "temperature is: " + temperature + "\n" + "Humidity is:"
        + humidity + "\n" + "pressure is:" + pressure);
  }
}

public class ObserverPattern {
  public static void main(String[] args) {
    Weather w = new Weather();
    w.addObserver(new MobileApp());
    w.addObserver(new NewsPaper());
    w.addObserver(new TVnews());
    w.setWeather(2, 4, 8);
  }
}
