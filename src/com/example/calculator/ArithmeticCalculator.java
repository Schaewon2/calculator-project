package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class ArithmeticCalculator<T extends Number> {
    Scanner scanner = new Scanner(System.in);
    // 계산 결과를 담을 리스트 생성
    private List<Double> results = new ArrayList<>();
    private double num1;
    private double num2;
    OperatorType op;

    public void inputNumber(){
        System.out.print("첫 번째 숫자를 입력하세요: ");
        num1 = scanner.nextDouble();
        System.out.print("두 번째 숫자를 입력하세요: ");
        num2 = scanner.nextDouble();
    }

    public void inputOperator() {
        try {
            System.out.print("사칙연산 기호를 입력하세요: ");
            op = OperatorType.fromOperator(scanner.next().charAt(0));
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            System.out.println(message + " 다시 입력해주세요.");
        }
    }

    // 계산 메서드 (Generic 활용)
    public double calculate(T num1, T num2, OperatorType op) {
        double n1 = num1.doubleValue();
        double n2 = num2.doubleValue();
        switch (op) {
            case ADD:
                return n1 + n2;
            case SUBTRACT:
                return n1 - n2;
            case MULTIPLY:
                return n1 * n2;
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
                return n1 / n2;
            default:

        }
        return 0;
    }

    public void addResult(Double result) {
        System.out.println("계산 결과: " + result);
        results.add(result);
    }

    public void optionPrint() {
        System.out.println("==================== 목록 ====================");
        System.out.println("1. 가장 오래된 계산 기록 삭제");
        System.out.println("2. 저장된 연산 결과들 중 입력받은 값보다 큰 결과값들을 출력");
        System.out.println("3. 계산한 결과값 목록 조회");
        System.out.println("4. 계속 계산하기");
        System.out.println("--------------------------------------------");
        System.out.print("원하는 항목을 입력해주세요. (exit 입력 시 계산 종료): ");
        switch (scanner.next()) {
            case "1":
                removeResult();
                optionPrint();
                break;
            case "2":
                List<Double> resultGreaterThan = getResultGreaterThan(getNum1(), getNum2());
                System.out.println("입력받은 값보다 큰 결과값 목록: " + resultGreaterThan);
                break;
            case "3":
                System.out.println("현재 저장된 결과: " + getResults());
                optionPrint();
                break;
            case "4":
                System.out.println("계속 계산을 진행합니다.");
                break;
            case "exit":
                System.out.println("계산을 종료합니다.");
                return;
            default:
                System.out.println("잘못된 입력 값입니다. 다시 입력해주세요.");
                optionPrint();
        }
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

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public OperatorType getOp() {
        return op;
    }

    public List<Double> getResults() {
        return results;
    }
}
