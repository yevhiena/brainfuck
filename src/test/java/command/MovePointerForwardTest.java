package command;

import command.impl.MovePointerForward;
import memory.Memory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MovePointerForwardTest {

    @Test
    void testMovePointerForwardExecute(){
        Memory memory = new Memory();
        MovePointerForward movePointerForward = new MovePointerForward();

        assertEquals(0, memory.getPointer());

        memory.setCurrentCellValue(10);
        movePointerForward.execute(memory);
        assertEquals(1, memory.getPointer());
        assertNotEquals(10, memory.getCurrentCellValue());
        assertEquals(0, memory.getCurrentCellValue());

        movePointerForward.execute(memory);
        assertEquals(2, memory.getPointer());
    }
}
