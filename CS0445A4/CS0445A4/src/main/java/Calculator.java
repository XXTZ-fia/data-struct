import stores.MyStack;

public class Calculator {

    public enum NotationMode {
        POSTFIX, PREFIX
    };

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();

        char c;
        while ((c = (char) System.in.read()) != 0) {
            calc.getToken(c);
        }
    }

    private MyStack<Integer> stack;
    private NotationMode mode;

    public Calculator() {
        stack = new MyStack<>();
        mode = NotationMode.POSTFIX;
    }

    public int passString(String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            getToken(calculation.charAt(i));
        }

        return evaluate();
    }

    public void setMode(NotationMode mode) {
        this.mode = mode;
    }

    public NotationMode getMode() {
        return mode;
    }

    public int getToken(char c) {
        if ('0' <= c && c <= '9') {
            return newValueToken((int) (c - '0'));
        } else {
            switch (c) {
                case '+':
                    return newPlus();
                case '-':
                    return newMinus();
                case '*':
                    return newMultiply();
                case '/':
                    return newDivide();
                case '=':
                    return evaluate();
                case '\n':
                case '\t':
                case '\r':
                case ' ':
                    return 0;
                default:
                    System.out.println("Error bad input!!! Allowed inputs are: 0-9,+,-,*,/ and =");
                    return 0;
            }
        }
    }

    protected int newValueToken(int d) {
        System.out.println("Digit " + d);
        stack.push(d);
        return d;
    }

    protected int newPlus() {
        System.out.println("Op +");
        if (stack.size() < 2) {
            return Integer.MIN_VALUE;
        }
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        int result = operand1 + operand2;
        stack.push(result);
        return result;
    }

    protected int newMinus() {
        System.out.println("Op -");
        if (stack.size() < 2) {
            return Integer.MIN_VALUE;
        }
        int a = stack.pop();
        int b = stack.pop();
        int result = b - a;
        stack.push(result);
        return result;
    }

    protected int newDivide() throws IllegalArgumentException {
        System.out.println("Op /");
        if (stack.size() < 2) {
            return Integer.MIN_VALUE;
        }
        int b = stack.pop();
        int a = stack.pop();
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        int result = a / b;
        stack.push(result);
        return result;
    }

    protected int newMultiply() {
        System.out.println("Op *");
        if (stack.size() < 2) {
            return Integer.MIN_VALUE;
        }
        int a = stack.pop();
        int b = stack.pop();
        int result = a * b;
        stack.push(result);
        return result;
    }

    protected int evaluate() {
        System.out.println("Value =");
        if (stack.size() != 1) {
            return Integer.MIN_VALUE;
        }
        return stack.pop(); 
    }

    public String toString() {
        return stack.toString();
    }

}