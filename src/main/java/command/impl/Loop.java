package command.impl;

import command.Command;
import memory.Memory;

import java.util.ArrayList;
import java.util.List;

public class Loop implements Command {
    private List<Command> innerLoopCommands;

    public Loop(List<Command> innerLoopCommands) {
        this.innerLoopCommands = new ArrayList<>(innerLoopCommands);
    }

    @Override
    public void execute(Memory memory) {
        while (memory.getCurrentCellValue() > 0) {
            for(Command command : innerLoopCommands){
                command.execute(memory);
            }
        }
    }
}
