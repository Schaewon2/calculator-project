package com.example.calculator;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
        OperatorType op;

        Scanner sc = new Scanner(System.in);

        while (true) {
            // 첫 번째, 두 번째 숫자 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = sc.nextDouble();
            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = sc.nextDouble();

            // 사칙연산 기호 입력 후에 char 타입에서 enum 타입으로 형변환
            try {
                System.out.print("사칙연산 기호를 입력하세요: ");
                op = OperatorType.fromOperator(sc.next().charAt(0));
            } catch (IllegalArgumentException e) {
                String message = e.getMessage();
                System.out.println(message + " 다시 입력해주세요.");
                continue;
            }

            // 사칙연산 메서드 실행하여 result 변수에 담아줌.
            double result = calculator.calculate(num1, num2, op);

            // result를 calculator 객체의 리스트에 추가
            calculator.addResult(result);
            System.out.println("계산 결과: " + result);
            System.out.println("현재 저장된 결과: " + calculator.getResults());

            // 가장 오래된 계산 기록 삭제
            System.out.println("가장 오래된 계산 기록을 삭제하시겠습니까? (yes 입력 시 삭제)");
            if (sc.next().equals("yes")) {
                calculator.removeResult();
            }

            // 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값들을 출력
            System.out.println("저장된 연산 결과들 중 입력 받은 값보다 큰 결과값들을 출력하시겠습니까? (yes 입력 시 출력)");
            if (sc.next().equals("yes")) {
                List<Double> resultGreaterThan = calculator.getResultGreaterThan(num1, num2);
                System.out.println("저장된 연산 결과들 중 입력 받은 값보다 큰 결과값: " + resultGreaterThan);
            }

            // 더 계산할지 여부 체크 (exit 입력 시 반복문을 즉시 빠져나오고 계산 종료)
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equals("exit")) {
                System.out.println("계산을 종료합니다.");
                break;
            }
        }
    }
}
