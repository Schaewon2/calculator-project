package com.example.calculator;

public class App {

    public static void main(String[] args) {
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>(); // ArithmeticCalculator 객체 생성

        while (true) {
            calculator.inputNumber(); // 첫 번째, 두 번째 숫자 입력

            if (!calculator.inputOperator()) { // 연산 기호 입력
                continue;
            }

            // calculate 메서드로 계산 후, result에 저장
            double result = calculator.calculate(calculator.getNum1(), calculator.getNum2(), calculator.getOp());

            calculator.addResult(result); // 리스트에 계산한 결과 추가

            if (!calculator.optionPrint()) { // 목록 출력
                break;
            }
        }
    }
}
