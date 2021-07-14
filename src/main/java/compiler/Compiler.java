package compiler;

import command.Command;
import command.impl.*;
import exception.BrainfuckCompileCommandException;

import java.util.*;

public class Compiler {


    private Map<Character, InstructionProcessor> processors = new HashMap<>();

    public Compiler() {

        processors.put('>', commandStack -> commandStack.peek().add(new MovePointerForward()));
        processors.put('<', commandStack -> commandStack.peek().add(new MovePointerBack()));
        processors.put('+', commandStack -> commandStack.peek().add(new IncrementValue()));
        processors.put('-', commandStack -> commandStack.peek().add(new DecrementValue()));
        processors.put('.', commandStack -> commandStack.peek().add(new PrintValue()));
        processors.put('[', commandStack -> commandStack.push(new ArrayList<>()));
        processors.put(']', commandStack -> {
            List<Command> loopInnerCommands = commandStack.pop();
            commandStack.peek().add(new Loop(loopInnerCommands));
        });
    }

    public List<Command> compile(String program) {

        Deque<List<Command>> stack = new ArrayDeque<>();
        stack.push(new ArrayList<>());

        for (char brainfuckInstruction : program.toCharArray()) {

            InstructionProcessor instructionProcessor = processors.get(brainfuckInstruction);

            if (instructionProcessor == null) {

                throw new BrainfuckCompileCommandException(brainfuckInstruction);
            }

            instructionProcessor.process(stack);
        }

        return Collections.unmodifiableList(stack.pop());
    }

    interface InstructionProcessor {

        void process(Deque<List<Command>> commandStack);
    }
}
