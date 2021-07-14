package command;

import command.impl.DecrementValue;
import command.impl.Loop;
import command.impl.PrintValue;
import memory.Memory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LoopTest {

    @Test
    void testLoopExecute(){
        Memory memory = new Memory();
        DecrementValue decrementValue = mock(DecrementValue.class);
        PrintValue printValue = mock(PrintValue.class);
        doCallRealMethod().when(decrementValue).execute(memory);
        doCallRealMethod().when(printValue).execute(memory);

        List<Command> commands = new ArrayList<>();
        commands.add(decrementValue);
        commands.add(printValue);
        Loop loop = new Loop(commands);

        assertEquals(0, memory.getCurrentCellValue());

        loop.execute(memory);
        verify(decrementValue, times(0)).execute(memory);
        verify(printValue, times(0)).execute(memory);

        memory.setCurrentCellValue(5);
        loop.execute(memory);
        verify(decrementValue, times(5)).execute(memory);
        verify(printValue, times(5)).execute(memory);

        assertEquals(0, memory.getCurrentCellValue());
    }
}
