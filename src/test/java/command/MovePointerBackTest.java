package command;

import command.impl.MovePointerBack;
import memory.Memory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MovePointerBackTest {
    @Test
    void execute(){
        Memory memory = new Memory();
        MovePointerBack movePointerBack = new MovePointerBack();

        memory.setPointer(10);
        assertEquals(10, memory.getPointer());

        movePointerBack.execute(memory);
        assertEquals(9, memory.getPointer());

        memory.setCurrentCellValue(1);
        movePointerBack.execute(memory);
        assertEquals(8, memory.getPointer());
        assertNotEquals(1, memory.getCurrentCellValue());
        assertEquals(0, memory.getCurrentCellValue());
    }
}
