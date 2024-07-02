//State design pattern
/*The State design pattern is a behavioral software design pattern that allows an object to alter its behavior when its internal 
state changes. It achieves this by encapsulating the object’s behavior within different state objects, and the object itself 
dynamically switches between these state objects depending on its current state.*/
//  The pattern promotes loose coupling, improves code readability, and simplifies the management of complex conditional statements.

// State
interface MixerState {
    void handleRequest(Mixer mixer);
}
// Concrete States
class OffState implements MixerState {
    @Override
    public void handleRequest(Mixer mixer) {
        System.out.println("Fan turned on low.");
        mixer.setState(new LowState());
    }
}
class LowState implements MixerState {
    @Override
    public void handleRequest(Mixer mixer) {
        System.out.println("Fan turned on medium.");
        mixer.setState(new MediumState());
    }
}
class MediumState implements MixerState {
    @Override
    public void handleRequest(Mixer mixer) {
        System.out.println("Fan turned on high.");
        mixer.setState(new HighState());
    }
}
class HighState implements MixerState {
    @Override
    public void handleRequest(Mixer mixer) {
        System.out.println("Fan turned off.");
        mixer.setState(new OffState());
    }
}
// Context
class Mixer {
    private MixerState currentState;
    public Mixer() {
        this.currentState = new OffState();
    }
    public void setState(MixerState state) {
        this.currentState = state;
    }
    public void request() {
        currentState.handleRequest(this);
    }
}

public class StatePattern {
    public static void main(String[] args) {
        Mixer mixer=new Mixer();
        //The request() method allows the client to change the fan's state dynamically without client's intervention.
        mixer.request(); // Turns on low
        mixer.request(); // Turns on medium
        mixer.request(); // Turns on high
        mixer.request(); // Turns off
    }
}
