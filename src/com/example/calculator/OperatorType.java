package com.example.calculator;

import java.util.Optional;

public enum OperatorType {
    ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/'); // 상수와 그에 해당하는 실제 연산 기호 연결

    private final Character op; // 연산 기호 저장

    OperatorType(Character op) {
        this.op = op;
    }

    public Optional<Character> getOp() {
        return Optional.ofNullable(op);     // NPE 막기 위해서 Optional 상자에 담기
    }

    public static OperatorType fromOperator(char op) { // char를 OperatorType으로 변환
        for (OperatorType type : OperatorType.values()) {
            if (type.getOp().get() == op) {
                return type;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자입니다.");
    }
}
