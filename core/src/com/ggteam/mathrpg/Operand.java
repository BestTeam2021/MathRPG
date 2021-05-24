package com.ggteam.mathrpg;

public enum Operand {
    PLUS, MINUS, MULTIPLE, DIVIDE;

    public char toChar() {
        switch (this) {
            case PLUS:
                return '+';
            case MINUS:
                return '-';
            case MULTIPLE:
                return '*';
            case DIVIDE:
                return '/';
            default:
                throw new UnsupportedOperationException();
        }
    }
}
