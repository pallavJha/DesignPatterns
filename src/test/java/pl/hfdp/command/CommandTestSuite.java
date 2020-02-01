package pl.hfdp.command;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CameraStartRecordingCommandTest.class,
        CameraStopRecordingCommandTest.class,
        CameraTest.class,
        LightOffCommandTest.class,
        LightOnCommandTest.class,
        LightTest.class,
        MacroCommandTest.class,
        SpeakerTest.class,
        SpeakerVolDecreaseCommandTest.class,
        SpeakerVolIncreaseCommandTest.class,
        DashboardScreenTest.class
})
public class CommandTestSuite {
}