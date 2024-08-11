// The Command Design Pattern turns a request into a stand-alone object, allowing parameterization 
// of clients with different requests, queuing of requests, and support for undoable operations.

// The Command Pattern encapsulates a request as an object, allowing for the separation of 
// sender and receiver.
// Components of the Command Design Pattern
// 1. Command Interface
// 2. Concrete Command Classes
// 3. Invoker (Remote Control)
// 4. Receiver (Devices)

// Command interface
interface Command {
	void execute();
}

// Concrete command for turning a device on
class TurnOnCommand implements Command {
	private Device device;

	public TurnOnCommand(Device device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.turnOn();
	}
}

// Concrete command for turning a device off
class TurnOffCommand implements Command {
	private Device device;

	public TurnOffCommand(Device device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.turnOff();
	}
}

// Concrete command for adjusting the volume of a stereo
class AdjustVolumeCommand implements Command {
	private Stereo stereo;

	public AdjustVolumeCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.adjustVolume();
	}
}

// Concrete command for changing the channel of a TV
class ChangeChannelCommand implements Command {
	private TV tv;

	public ChangeChannelCommand(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.changeChannel();
	}
}

// Receiver interface
interface Device {
	void turnOn();
	void turnOff();
}

// Concrete receiver for a TV
class TV implements Device {
	@Override
	public void turnOn() {
		System.out.println("TV is now on");
	}

	@Override
	public void turnOff() {
		System.out.println("TV is now off");
	}

	public void changeChannel() {
		System.out.println("Channel changed");
	}
}

// Concrete receiver for a stereo
class Stereo implements Device {
	@Override
	public void turnOn() {
		System.out.println("Stereo is now on");
	}

	@Override
	public void turnOff() {
		System.out.println("Stereo is now off");
	}

	public void adjustVolume() {
		System.out.println("Volume adjusted");
	}
}

// Invoker
class RemoteControl {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
	}
}

// Example usage
public class CommandPattern{

	public static void main(String[] args) {
		// Create devices
		TV tv = new TV();
		Stereo stereo = new Stereo();

		// Create command objects
		Command turnOnTVCommand = new TurnOnCommand(tv);
		Command turnOffTVCommand = new TurnOffCommand(tv);
		Command adjustVolumeStereoCommand = new AdjustVolumeCommand(stereo);
		Command changeChannelTVCommand = new ChangeChannelCommand(tv);

		// Create remote control
		RemoteControl remote = new RemoteControl();

		// Set and execute commands
		remote.setCommand(turnOnTVCommand);
		remote.pressButton(); // Outputs: TV is now on

		remote.setCommand(adjustVolumeStereoCommand);
		remote.pressButton(); // Outputs: Volume adjusted

		remote.setCommand(changeChannelTVCommand);
		remote.pressButton(); // Outputs: Channel changed

		remote.setCommand(turnOffTVCommand);
		remote.pressButton(); // Outputs: TV is now off
	}
}
