package exception;

public class BrainfuckCompileCommandException extends RuntimeException{
    public BrainfuckCompileCommandException(char brainfuckInstruction) {
        super("Invalid command: " + brainfuckInstruction);
    }
}
