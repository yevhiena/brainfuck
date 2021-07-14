package command;

import command.impl.DecrementValue;
import command.impl.Loop;
import memory.Memory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LoopTest {

    @Test
    void execute(){
        Memory memory = new Memory();
        DecrementValue decrementValue = mock(DecrementValue.class);
        doCallRealMethod().when(decrementValue).execute(memory);

        List<Command> commands = new ArrayList<>();
        commands.add(decrementValue);
        Loop loop = new Loop(commands);

        assertEquals(0, memory.getCurrentCellValue());

        loop.execute(memory);
        verify(decrementValue, times(0)).execute(memory);

        memory.setCurrentCellValue(5);
        loop.execute(memory);
        verify(decrementValue, times(5)).execute(memory);

        assertEquals(0, memory.getCurrentCellValue());
    }
}
