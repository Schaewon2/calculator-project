package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private List<Double> results = new ArrayList<>();

    public double calculate(T num1, T num2, OperatorType op) {
        double tmp = 0.0;
        double n1 = num1.doubleValue();
        double n2 = num2.doubleValue();
        switch (op) {
            case ADD:
                tmp = n1 + n2;
                break;
            case SUBTRACT:
                tmp = n1 - n2;
                break;
            case MULTIPLY:
                tmp = n1 * n2;
                break;
            case DIVIDE:
                if (n2 == 0) {
                    try {
                        if (n2 == 0) {
                            throw new ArithmeticException();
                        }
                    } catch (ArithmeticException e) {
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                        break;
                    }
                }
                tmp = n1 / n2;
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

    public List<Double> getResultGreaterThan(Double num1, Double num2) {
        return results.stream()
                .filter(result -> result > num1 && result > num2)
                .collect(Collectors.toList());
    }

    public List<Double> getResults() {
        return results;
    }
}
