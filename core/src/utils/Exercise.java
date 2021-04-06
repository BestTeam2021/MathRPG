package utils;

public class Exercise {

    private int left, right, result;
    private Operand operand;

    public Exercise(int left, int right, Operand operand) {
        this.left = left;
        this.right = right;
        this.operand = operand;

        this.result = calcResult();
    }

    private int calcResult() {
        if (operand == Operand.PLUS) {
            return left + right;
        }
        if (operand == Operand.MINUS) {
            return left - right;
        }
        if (operand == Operand.MULTIPLE) {
            return left * right;
        }
        if (operand == Operand.DIVIDE) {
            return left / right;
        }
        return 0;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getResult() {
        return result;
    }

    public Operand getOperand() {
        return operand;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "left=" + left +
                ", right=" + right +
                ", result=" + result +
                ", operand=" + operand +
                '}';
    }
}