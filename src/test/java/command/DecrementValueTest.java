package command;

import command.impl.DecrementValue;
import memory.Memory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecrementValueTest {

    @Test
    void execute(){
        Memory memory = new Memory();
        DecrementValue decrementValue = new DecrementValue();

        memory.setCurrentCellValue(10);
        decrementValue.execute(memory);
        assertEquals(9, memory.getCurrentCellValue());

        decrementValue.execute(memory);
        assertEquals(8, memory.getCurrentCellValue());

        memory.setPointer(1);
        decrementValue.execute(memory);
        assertEquals(-1, memory.getCurrentCellValue());
    }
}
