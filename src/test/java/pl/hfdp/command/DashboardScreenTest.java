package pl.hfdp.command;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class DashboardScreenTest {

    private DashboardScreen dashboardScreen;

    @Before
    public void setup() {
        dashboardScreen = new DashboardScreen();
    }

    @Test
    public void addCommand() {
        Command actualCommand = new LightOnCommand(new Light());
        dashboardScreen.addCommand(actualCommand);
        Command expectedCommand = dashboardScreen.getCommand(0);
        TestCase.assertEquals(actualCommand, expectedCommand);
    }


    @Test
    public void getCommand() {
        Command actualCommand = new LightOnCommand(new Light());
        dashboardScreen.addCommand(actualCommand);
        dashboardScreen.addCommand(actualCommand);
        dashboardScreen.addCommand(actualCommand);
        dashboardScreen.addCommand(actualCommand);
        Command expectedCommand1 = dashboardScreen.getCommand(0);
        TestCase.assertEquals(actualCommand, expectedCommand1);
        Command expectedCommand2 = dashboardScreen.getCommand(1);
        TestCase.assertEquals(actualCommand, expectedCommand2);
        Command expectedCommand3 = dashboardScreen.getCommand(2);
        TestCase.assertEquals(actualCommand, expectedCommand3);
        Command expectedCommand4 = dashboardScreen.getCommand(3);
        TestCase.assertEquals(actualCommand, expectedCommand4);
    }

    @Test(expected = NoSuchElementException.class)
    public void getCommandWithNSEE() {
        dashboardScreen.getCommand(27);
    }

    @Test
    public void executeCommand() {
        Command actualCommand = new LightOnCommand(new Light());
        dashboardScreen.addCommand(actualCommand);
        dashboardScreen.executeCommand(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void executeCommandWithNSEE() {
        dashboardScreen.executeCommand(27);
    }

    @Test
    public void undo() {
        Command actualCommand = new LightOnCommand(new Light());
        dashboardScreen.addCommand(actualCommand);
        dashboardScreen.executeCommand(0);
    }

    @Test(expected = NullPointerException.class)
    public void undoWithNoLastCommand() {
        dashboardScreen.undo();
    }
}