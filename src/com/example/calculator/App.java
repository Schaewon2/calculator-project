package com.example.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char op = sc.next().charAt(0);

            double result = calculator.calculate(num1, num2, op);
            calculator.addResult(result);
            System.out.println("계산 결과: " + result);
            System.out.println("현재 저장된 결과: " + calculator.getResults());

            System.out.println("가장 오래된 계산 기록을 삭제하시겠습니까? (yes 입력 시 삭제)");
            if (sc.next().equals("yes")) {
                calculator.removeResult();
                System.out.println("가장 오래된 계산 기록을 삭제했습니다.");
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equals("exit")) {
                System.out.println("계산을 종료합니다.");
                break;
            }
        }
    }
}
