package program;

import command.Command;
import compiler.Compiler;
import memory.Memory;

import java.util.List;

public class Brainfuck {

    public void execute(String brainfuckChain){
        List<Command> commands = new Compiler().compile(brainfuckChain);

        Memory memory = new Memory();

        for (Command command : commands) {
            command.execute(memory);
        }
    }
}
