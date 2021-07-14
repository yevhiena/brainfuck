package command.impl;

import command.Command;
import memory.Memory;

public class PrintValue implements Command {

    @Override
    public void execute(Memory memory) {
        int currentCellValue = memory.getCurrentCellValue();
        System.out.print((char) currentCellValue);
    }
}
