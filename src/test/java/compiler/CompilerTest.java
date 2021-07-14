package compiler;

import command.Command;
import command.impl.*;
import exception.BrainfuckCompileCommandException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompilerTest {
    private static Compiler compiler = new Compiler();

    @ParameterizedTest
    @ValueSource(strings = {"?", "/", "@"})
    void testShouldThrowExceptionForInvalidCommandCompile(String instruction){

        Exception exception = assertThrows(BrainfuckCompileCommandException.class, () ->
                compiler.compile(instruction));
        assertEquals("Invalid command: " + instruction, exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", ">", "<", ".", "[]"})
    void testShouldReturnCompiledCommand(String instruction){

        List<Command> compiledCommands = compiler.compile(instruction);
        assertEquals(1,compiledCommands.size());
        assertTrue(Command.class.isAssignableFrom(compiledCommands.get(0).getClass()));
    }

    @Test
    void testChecksCompiledCommandsOrder(){
        String program = "+-><.[]";

        List<Command> compiledCommands = compiler.compile(program);

        assertEquals(6,compiledCommands.size());
        assertSame(compiledCommands.get(0).getClass(), IncrementValue.class);
        assertSame(compiledCommands.get(1).getClass(), DecrementValue.class);
        assertSame(compiledCommands.get(2).getClass(), MovePointerForward.class);
        assertSame(compiledCommands.get(3).getClass(), MovePointerBack.class);
        assertSame(compiledCommands.get(4).getClass(), PrintValue.class);
        assertSame(compiledCommands.get(5).getClass(), Loop.class);
    }
}
