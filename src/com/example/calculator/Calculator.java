package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Double> results = new ArrayList<>();

    public double calculate(int num1, int num2, char op) {
        double tmp = 0.0;
        switch (op) {
            case '+':
                tmp = num1 + num2;
                break;
            case '-':
                tmp = num1 - num2;
                break;
            case '*':
                tmp = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                    return 0;
                }
                tmp = num1 / (double) num2;
                break;
            default:
                System.out.println("잘못된 연산자입니다.");
                return 0;
        }
        return tmp;
    }

    public void addResult(Double result) {
        results.add(result);
    }

    public void removeResult() {
        results.remove(0);
        System.out.println("가장 오래된 기록을 삭제했습니다.");
    }

    // getter
    public List<Double> getResults() {
        return results;
    }

    // setter
    public void setResults(List<Double> results) {
        this.results = results;
    }
}
