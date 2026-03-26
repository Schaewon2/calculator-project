package com.example.calculator;

import java.util.Optional;

public enum OperatorType {

    // 속성
    ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/'); // 상수와 그에 해당하는 실제 연산 기호 연결

    private final Character op; // 연산 기호 저장

    // 생성자
    OperatorType(Character op) {
        this.op = op;
    }

    // 기능
    public Optional<Character> getOp() {
        return Optional.ofNullable(op);     // NPE 막기 위해서 Optional 상자에 담기
    }

    public static OperatorType fromOperator(char op) { // char를 OperatorType으로 변환
        for (OperatorType type : OperatorType.values()) { // for-each문을 돌려서 입력한 연산기호와 OperatorType에 있는 상수와 일치하면 상수 반환
            if (type.getOp().get() == op) {
                return type;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자입니다."); // 상수가 없을 시 예외 발생
    }
}
