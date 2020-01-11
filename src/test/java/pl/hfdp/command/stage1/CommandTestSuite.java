package pl.hfdp.command.stage1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.hfdp.decorator.stage1.DarkRoastTest;
import pl.hfdp.decorator.stage1.DecalWithSoyAndMochaTest;
import pl.hfdp.decorator.stage1.HouseBlendTest;
import pl.hfdp.decorator.stage1.HouseBlendWithMochaAndStreamedMilkTest;

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
        SpeakerVolIncreaseCommandTest.class
})
public class CommandTestSuite {
}