package invoker;

import impl.NoCommand;
import inter.Command;

public class RemoteController {
    private Command[] onCommands;
    private Command[] offCommands;

    private Command undoCommand;
    public RemoteController(){
        onCommands =  new Command[3];
        offCommands =  new Command[3];

        for(int i = 0 ;i < 3; i++){
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();

        }

        undoCommand = new NoCommand();
    }
    public void setCommand(int slot,Command onCommand,Command offCommand){
        if(slot < 0 || slot >= 3) return;
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;

    }

    public void onButtonWasPushed(int slot){
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }
    public void offButtonWasPushed(int slot){
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed(){
        undoCommand.undo();
    }

}
