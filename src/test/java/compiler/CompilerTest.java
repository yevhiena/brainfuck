package compiler;

import command.Command;
import command.impl.*;
import exception.BrainfuckCompileCommandException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompilerTest {

    @Test
    void testCompile(){

        String program = "?";
        Compiler compiler = new Compiler();

        Exception exception = assertThrows(BrainfuckCompileCommandException.class, () ->
                compiler.compile(program));
        assertEquals("Invalid command: " + program, exception.getMessage());

        String secondProgram = "+-><.[]";

        List<Command> compiledCommands = compiler.compile(secondProgram);
        assertFalse(compiledCommands.isEmpty());
        assertEquals(6,compiledCommands.size());
        assertSame(compiledCommands.get(0).getClass(), IncrementValue.class);
        assertSame(compiledCommands.get(1).getClass(), DecrementValue.class);
        assertSame(compiledCommands.get(2).getClass(), MovePointerForward.class);
        assertSame(compiledCommands.get(3).getClass(), MovePointerBack.class);
        assertSame(compiledCommands.get(4).getClass(), PrintValue.class);
        assertSame(compiledCommands.get(5).getClass(), Loop.class);
    }
}
