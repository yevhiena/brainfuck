package command;

import memory.Memory;

public interface Command {
    void execute(Memory memory);
}
