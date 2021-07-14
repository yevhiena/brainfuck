package command.impl;

import command.Command;
import memory.Memory;

public class MovePointerBack implements Command {
    @Override
    public void execute(Memory memory) {
        int currentPointer = memory.getPointer();
        int newPointer = currentPointer - 1;
        memory.setPointer(newPointer);
    }
}
