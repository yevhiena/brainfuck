package command;

import command.impl.IncrementValue;
import memory.Memory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncrementValueTest {

    @Test
    void execute(){
        Memory memory = new Memory();
        IncrementValue incrementValue = new IncrementValue();

        incrementValue.execute(memory);
        assertEquals(1, memory.getCurrentCellValue());

        incrementValue.execute(memory);
        assertEquals(2, memory.getCurrentCellValue());

        memory.setPointer(1);
        incrementValue.execute(memory);
        assertEquals(1, memory.getCurrentCellValue());
    }
}
