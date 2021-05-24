package com.ggteam.mathrpg;

import java.util.Random;



public class ArithmeticGenerator {
    private Random random;

    public ArithmeticGenerator() {
        random = new Random();
    }

    public Exercise getTask() {
        Operand randomOperand = getRandomOperand();
        if (randomOperand == Operand.PLUS
                || randomOperand == Operand.MULTIPLE) {
            int left = random.nextInt(10);
            int right = random.nextInt(10);
            return new Exercise(left, right, randomOperand);
        }
        return null;
    }

    private Operand getRandomOperand() {
        int intOperand = random.nextInt(2);
        Operand operand;
        switch (intOperand) {
            case 0:
                operand = Operand.PLUS;
                break;
            case 1:
                operand = Operand.MULTIPLE;
                break;
            case 2:
                operand = Operand.MINUS;
                break;
            case 3:
                operand = Operand.DIVIDE;
                break;
            default:
                operand = Operand.PLUS;
        }
        return operand;
    }
}
