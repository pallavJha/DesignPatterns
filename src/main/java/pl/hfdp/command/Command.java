package pl.hfdp.command;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The class for Camera Driver.
 */
class Camera {

    /**
     * This method starts recording.
     */
    public void startRecording() {
        System.out.println("Recording started.");
    }

    /**
     * This method stops recording
     */
    public void stopRecording() {
        System.out.println("Recording stopped.");
    }
}

/**
 * The class for Light Driver.
 */
class Light {

    /**
     * This method switches the light on.
     */
    public void turnOn() {
        System.out.println("the Light is on now");
    }

    /**
     * This method switches the light off.
     */
    public void turnOff() {
        System.out.println("the Light is off now");
    }
}

/**
 * The class for Speaker.
 */
class Speaker {

    /**
     * This method increases the speaker's volume.
     */
    public void increaseVolume() {
        System.out.println("The volume has been increased.");
    }

    /**
     * This method decreases the speaker's volume.
     */
    public void decreaseVolume() {
        System.out.println("The volume has been decreased.");
    }
}

public interface Command {
    void execute();

    void undo();
}

class CameraStartRecordingCommand implements Command {

    private Camera camera;

    public CameraStartRecordingCommand(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void execute() {
        camera.startRecording();
    }

    @Override
    public void undo() {
        camera.stopRecording();
    }
}

class CameraStopRecordingCommand implements Command {

    private Camera camera;

    public CameraStopRecordingCommand(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void execute() {
        camera.stopRecording();
    }

    @Override
    public void undo() {
        camera.startRecording();
    }
}

class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

class SpeakerVolIncreaseCommand implements Command {

    private Speaker speaker;

    public SpeakerVolIncreaseCommand(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.increaseVolume();
    }

    @Override
    public void undo() {
        speaker.decreaseVolume();
    }
}

class SpeakerVolDecreaseCommand implements Command {

    private Speaker speaker;

    public SpeakerVolDecreaseCommand(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.decreaseVolume();
    }

    @Override
    public void undo() {
        speaker.increaseVolume();
    }
}

class MacroCommand implements Command {

    private Command[] commands;

    public MacroCommand(Command... commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}

/**
 * The dashboard screen for the facility Manager
 */
class DashboardScreen {

    // the list of the commands
    private List<Command> commands = new ArrayList<>(20);

    // this attribute stores the command that was last executed.
    // it is used for undo
    private Command lastCommand;

    public Command getCommand(int i) {
        if (i > commands.size()) {
            throw new NoSuchElementException(String.format("The dashboard screen has only %d commands", commands.size()));
        }
        return commands.get(i);
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommand(int i) {
        if (i > commands.size()) {
            throw new NoSuchElementException(String.format("The dashboard screen has only %d commands", commands.size()));
        }
        commands.get(i).execute();
        lastCommand = commands.get(i);
    }

    public void undo() {
        lastCommand.undo();
    }
}