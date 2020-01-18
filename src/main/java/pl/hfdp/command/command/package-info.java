/**
 * In this section we'll look into <b>Command Design Pattern</b>.
 * <p>
 * While learning the Command design pattern we'll try to implement a Facility Dashboard for a company's Facility team.
 * <p>
 * <b>Requirements:</b>
 * <ol>
 *     <li>
 *         The Facility team want a dashboard through which they want to control all the equipments that are present in
 *         the building of the company. For example, they want the control over the security cameras, lights and the
 *         speakers.
 *      </li>
 *      <li>
 *          In order to take the actions on these devices they require buttons. Those buttons will interface the devices
 *      </li>
 *      <li>
 *          They don't want to reconfigure the dashboard when new devices are added or removed.
 *      </li>
 * </ol>
 * <img src="./doc-files/CommandWireframe.png">
 * <p>
 * The wireframe tells that there would be blocks for each of the devices and inside those blocks there would be buttons
 * to control the device.
 * <p>
 * You can already reckon that for all of this to work the dashboard requires integration of multiple types of devices.
 * <p>
 * Also, the APIs for these connected devices do not follow a regular pattern. For example, the Cameras have a method
 * named `startRecording` that starts the recording while the Lights have an another method, turnOn, to switch it on.
 * <pre>
 * //The class for Camera Driver.
 * class Camera {
 *
 *      // This method starts recording.
 *      public void startRecording() {
 *           System.out.println("Recording started.");
 *      }
 *
 *      //This method stops recording
 *      public void stopRecording() {
 *          System.out.println("Recording stopped.");
 *      }
 * }
 * </pre>
 * <pre>
 * // The class for Light Driver.
 * class Light {
 *
 *      // This method switches the light on.
 *      public void turnOn() {
 *          System.out.println("the Light is on now");
 *      }
 *
 *      // This method switches the light off.
 *      public void turnOff() {
 *          System.out.println("the Light is off now");
 *      }
 * }
 * </pre>
 *
 * <p>
 * From the first look the solution that we seems to involve if/else if cases based on the type of the button pressed:
 * <pre>
 * if(pressedButton.equals(hallwayButton)){
 *      light.turnOn();
 * } else if(pressedButton.equals(roofTopCameraButton)){
 *      camera.startRecording();
 * }
 * </pre>
 * <p>
 * If you're following our previous tutorials then you would have already found out the problems that we might face
 * while try to find out the best solution. Let's look into them.
 * <ol>
 *     <li>
 *          The dashboard doesn't need to know about the type of the device or equipment. All it needs is a listener so
 *          that it can delegate the events of button clicks whenever the button is pressed. But the different type of
 *          methods that the devices have provided are not aligned to it.
 *     </li>
 *     <li>
 *          The dashboard only supports two types of event per device, i.e., on and off, but the camera supports start
 *          recording while the speakers are supporting volume up and volume down actions.
 *     </li>
 *     <li>
 *         <b>If the devices' methods can be encapsulated in such a way that the dashboard doesn't need to know about the
 *         owner of the methods but still it can execute them then we can bring loose couping in here.</b>
 *     </li>
 * </ol>
 * <p>
 * In order to encapsulate the methods from the device we can create an interface named <b>Command</b> with a method
 * <b>execute()<b/> and then create multiple classes that implement the execute method by interfacing the execution to
 * the actual devices.
 * <pre>
 *     interface Command {
 *          void execute();
 *          void undo();
 *      }
 * </pre>
 * <p>
 * The following class implements the Command interface and then delegates the execute() method's responsibility to
 * Camera devices's startRecording() method.
 *
 * <pre>
 *      class CameraStartRecordingCommand implements Command {
 *
 *          private Camera camera;
 *
 *          public CameraStartRecordingCommand(Camera camera) {
 *              this.camera = camera;
 *          }
 *
 *          @Override
 *          public void execute() {
 *              camera.startRecording();
 *          }
 *
 *          @Override
 *          public void undo() {
 *              camera.stopRecording();
 *          }
 *      }
 * </pre>
 * <p>
 * And let the dashboard have these commands.
 * <pre>
 *     class DashboardScreen {
 *
 *     private List<Command> commands = new ArrayList<>();
 *     // this attribute stores the command that was last executed.
 *     // it is used for undo
 *     private Command lastCommand;
 *
 *     public Command getCommand(int i) {
 *         if (i > commands.size()) {
 *             throw new NoSuchElementException(String.format("The dashboard screen has only %d commands", commands.size()));
 *         }
 *         return commands.get(i);
 *     }
 *
 *     public void addCommand(Command command) {
 *         commands.add(command);
 *     }
 *
 *     public void setCommand(int i, Command command) {
 *         commands.add(i, command);
 *     }
 *
 *     public void executeCommand(int i) {
 *         if (i > commands.size()) {
 *             throw new NoSuchElementException(String.format("The dashboard screen has only %d commands", commands.size()));
 *         }
 *         commands.get(i).execute();
 *         lastCommand = commands.get(i);
 *     }
 *
 *     public void undo() {
 *         lastCommand.undo();
 *     }
 * }
 * </pre>
 * <img src="./doc-files/CommandWireframe.png">
 * So now whenever a dashboard user presses any button, the dashboard can then call the execute method without actually
 * knowing the receiver of method, the device. And the device doesn't need to know if the caller is a dashboard user or
 * any other user.
 *
 * This is Command Design Pattern.
 */
package pl.hfdp.command.command;