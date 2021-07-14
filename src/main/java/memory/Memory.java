package memory;

public class Memory {

    private int[] cells = new int[256];
    private int pointer = 0;

    public void setPointer(int newKey) {
        pointer = newKey;
    }

    public int getPointer() {
        return pointer;
    }

    public int getCurrentCellValue() {
        return cells[pointer];
    }

    public void setCurrentCellValue(int value) {
        cells[pointer] = value;
    }

}
