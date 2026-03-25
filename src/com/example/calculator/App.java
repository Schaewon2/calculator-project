package com.example.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator();

        Scanner sc = new Scanner(System.in);

        while (true) {
            // 첫 번째, 두 번째 숫자 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            // 사칙연산 기호 입력 후에 char 타입에서 enum 타입으로 형변환
            System.out.print("사칙연산 기호를 입력하세요: ");
            OperatorType op = OperatorType.fromOperator(sc.next().charAt(0));

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

            // 더 계산할지 여부 체크 (exit 입력 시 반복문을 즉시 빠져나오고 계산 종료)
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equals("exit")) {
                System.out.println("계산을 종료합니다.");
                break;
            }
        }
    }
}
