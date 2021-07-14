import program.Brainfuck;

public class Main {
    private static String program = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++" +
        ".>+.+++++++..+++.>++.<<+++++++++++++++.>.+++." +
        "------.--------.>+.>.";

    public static void main(String[] args) {
        Brainfuck brainfuck = new Brainfuck();
        brainfuck.execute(program);
    }

}
