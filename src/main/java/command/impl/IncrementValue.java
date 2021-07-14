package command.impl;

import command.Command;
import memory.Memory;

public class IncrementValue implements Command {

    @Override
    public void execute(Memory memory) {
        int currentCellValue = memory.getCurrentCellValue();
        int newValue = currentCellValue + 1;
        memory.setCurrentCellValue(newValue);
    }
}
