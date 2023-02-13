package lab1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // класс для ввода с клавиатуры
        Scanner scanner = new Scanner(System.in);
        System.out.println("Лабораторная 1");
        System.out.println("Ввести с консоли n. Вычислить выражение n - n/2 + n/3 -n/4 + ... + n/9999 - n/10000");
        System.out.println("Работу выполнили: Басманова, Прошина");
        // переменная для проверки, завершена ли программа
        int stop = 0;
        // если переменная равна нулю, то программа выполняется
        // while - это цикл
        while(stop == 0) {
            System.out.println("Введите n:");
            // проверяем, ввели ли с клавиатуры целое число типа Integer
            if (scanner.hasNextInt()) {

                // вводим n с клавиатуры
                double n = scanner.nextInt();
                // вызываем функцию расчета нашего значения
                // передаем в нее введенное n, а результат пихаем в result
                double result = calculate(n);

                System.out.println("Результат: " + result);

            } else {
                System.out.println("Вы ввели не целое число (Integer)");
                scanner.next();
            }
            System.out.println();
            System.out.println("Введите 0, чтобы выполнить программу еще раз");
            System.out.println("Введите любой другой символ, чтобы завершить программу");
            // вывелось сообщение для пользователя, он выбирает что делать дальше
            // если ввел целое число, то условие цикла проверяется, равен ли stop нулю
            // если да, то запускаем программу еще раз, если нет, то завершаем программу
            if(scanner.hasNextInt()) {
                stop = scanner.nextInt();
            } else {
                // если введено не целое число, то задаем значение stop отличное от нуля, чтобы программа завершилась
                stop = 1;
            }
        }

    }

    /**
     * Рассчитывает значение по формуле n - n/2 + n/3 -n/4 + ... + n/9999 - n/10000
     * @param n - вводимый числитель
     * @return результат расчета
     */
    private static double calculate(double n) {

        // результирующая переменная
        double result = 0;

        // цикл со счетчиком от 1 до 10000, т.к. знаменатели должны быть в таком диапазоне
        for (int i = 1; i <= 10000; i++) {
            // если число четное, то мы отнимаем выражение n/i
            // число четное, если остаток после деления этого числа на два равен нулю
            // i % 2 - это получение остатка от деления на два
            if (i % 2 == 0) {
                result = result - (n / i);
            } else {
                result = result + (n / i);
            }
        }

        // возвращаем результат
        return result;
    }

}
