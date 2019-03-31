import impl.LightOffCommand;
import impl.LightOnCommand;
import inter.Command;
import invoker.RemoteController;
import receiver.Light;

public class Main {

    public static void main(String[] args) {

        Light light = new Light();
        Command onCommand = new LightOnCommand(light);
        Command offCommand = new LightOffCommand(light);
        RemoteController remoteController = new RemoteController();
        remoteController.setCommand(0,onCommand,offCommand);

        remoteController.onButtonWasPushed(0); //开灯

        remoteController.undoButtonWasPushed();//撤销

        remoteController.offButtonWasPushed(0); //关灯

        remoteController.undoButtonWasPushed();//撤销

    }
}
