package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private List<Double> results = new ArrayList<>();

    public double calculate(int num1, int num2, OperatorType op) {
        double tmp = 0.0;
        switch (op) {
            case ADD:
                tmp = num1 + num2;
                break;
            case SUBTRACT:
                tmp = num1 - num2;
                break;
            case MULTIPLY:
                tmp = num1 * num2;
                break;
            case DIVIDE:
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                    return 0;
                }
                tmp = num1 / (double) num2;
        }
        return tmp;
    }

    public void addResult(Double result) {
        results.add(result);
    }

    public void removeResult() {
        results.remove(0);
        System.out.println("가장 오래된 계산 기록을 삭제했습니다.");
    }

    public List<Double> getResults() {
        return results;
    }
}
