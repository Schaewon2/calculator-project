package com.example.calculator;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            calculator.inputNumber();
            calculator.inputOperator();

            double result = calculator.calculate(calculator.getNum1(), calculator.getNum2(), calculator.getOp());

            calculator.addResult(result); // 리스트에 계산한 결과 추가

            calculator.optionPrint(); // 목록 출력
        }
    }
}
