package command;

import command.impl.PrintValue;
import memory.Memory;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PrintValueTest {

    @Test
    void execute(){
        Memory memory = new Memory();
        PrintValue printValue = mock(PrintValue.class);
        doNothing().when(printValue).execute(memory);

        printValue.execute(memory);
        verify(printValue, times(1)).execute(memory);
    }

}
