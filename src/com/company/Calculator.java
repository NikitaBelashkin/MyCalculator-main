package com.company;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        startCalc();

        while (true) {

            System.out.println("Input: ");
            String line = scanner.nextLine();

            if (line.equals("exit")) {
                exitCalc();
                break;
            }

            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("Некорректное кол-во символов");

                Number firstNumber = NumberService.parseAndValidate(symbols[0]);
                Number secondNumber = NumberService.parseAndValidate(symbols[2], firstNumber.getType());
                String result = ActionService.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println("Output: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                exitCalc();
                break;
            }
        }

        scanner.close();
    }

    private static void startCalc() {
        System.out.println("Добро пожаловать в приложение калькулятор");
        System.out.println("Приложение работает только с римискими и арабскими цифрами, диапазон между символами должен составлять 1 пробел");
        System.out.println("Введите сперва число, затем через пробел символ, и через пробел последнее число");

    }

    private static void exitCalc() {

        System.out.println("?? ?????? ??????!");

    }
}
