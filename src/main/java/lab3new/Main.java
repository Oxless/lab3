package lab3new;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        River[] rivers = initializeRivers();

        System.out.println("Самая коротка река:");
        River shortestRiver = findShortestRiver(rivers);
        if(shortestRiver != null) {
            shortestRiver.print();
        }

        double averageLength = calculateAverageLength(rivers);

        System.out.println();
        System.out.println("Реки с длиной больше средней:");
        printRiversLongerAverage(rivers, averageLength);

        System.out.println();
        System.out.println("Отсортированный список рек:");
        Arrays.sort(rivers, Comparator.comparing(River::getName));
        for(River river : rivers) {
            river.print();
        }

        processFindingByName(rivers);

    }

    /**
     * Обрабатывает поиск реки по названию и изменение названия
     * @param rivers - массив рек
     */
    private static void processFindingByName(River[] rivers) {

        Scanner scanner = new Scanner(System.in);
        int stop = 0;
        // если переменная равна нулю, то программа выполняется
        // while - это цикл
        while(stop == 0) {
            System.out.println("Введите название реки:");
            String name = scanner.nextLine();

            River founded = null;
            for (River river : rivers) {
                if (river.getName().equalsIgnoreCase(name)) {
                    founded = river;
                }
            }

            if (founded == null) {
                System.out.println("Такая река не найдена");
            } else {
                System.out.println("Информация о реке: " + founded.getName());
                founded.print();
                System.out.println();
                System.out.println("Введите 1, чтобы изменить название реки");
                System.out.println("Введите любой другой символ, чтобы пропустить");
                if(scanner.hasNextInt()) {
                    int action = scanner.nextInt();
                    if(action == 1) {
                        scanner.nextLine();
                        System.out.println("Введите новое название реки:");
                        String newName = scanner.nextLine();
                        founded.setName(newName);
                        System.out.println("Обновленная информация о реке:");
                        founded.print();
                    }
                } else {
                    scanner.nextLine();
                }
            }

            System.out.println();
            System.out.println("Введите 0, чтобы ввести название реки еще раз");
            System.out.println("Введите любой другой символ, чтобы завершить программу");
            if(scanner.hasNextInt()) {
                stop = scanner.nextInt();
                scanner.nextLine();
            } else {
                // если введено не целое число, то задаем значение stop отличное от нуля, чтобы программа завершилась
                stop = 1;
            }
        }

    }

    /**
     * Находит самую короткую реку
     * @param rivers - массив рек, среди которых нужно искать
     * @return объект реки или null, если в массиве нет ни одной реки
     */
    private static River findShortestRiver(River[] rivers) {
        if(rivers.length == 0)
            return null;
        River shortestRiver = rivers[0];
        for(int i = 1; i < rivers.length; i++) {
            River currentRiver = rivers[i];
            if(currentRiver.getLength() < shortestRiver.getLength()) {
                shortestRiver = currentRiver;
            }
        }
        return shortestRiver;
    }

    /**
     * Рассчитывает среднюю длину реки
     * @param rivers - исходный массив рек
     * @return средняя длина реки
     */
    private static double calculateAverageLength(River[] rivers) {
        double sum = 0;
        for(River river : rivers) {
            sum = sum + river.getLength();
        }
        return sum/rivers.length;
    }

    /**
     * Выводит информацию о реках, длина которых выше средней
     * @param rivers - массив рек
     * @param averageLength - средняя длина реки
     */
    private static void printRiversLongerAverage(River[] rivers, double averageLength) {
        for(River river : rivers) {
            if(river.getLength() > averageLength) {
                river.print();
            }
        }
    }

    /**
     * Функция создающая массив рек
     * @return массив рек
     */
    private static River[] initializeRivers() {

        River sura = new River();
        sura.setName("Сура");
        sura.setCountry("Россия");
        sura.setLocality("Пенза");
        sura.setLatitude(54.173195);
        sura.setLongitude(46.023926);
        sura.setLength(841);
        sura.setWidth(100);
        sura.setDepth(4);
        sura.setFlowRate(0.8);
        sura.setFresh(true);
        sura.setAverageTemperature(24);
        sura.setSourceName("Приволжская возвышенность");
        sura.setMouthName("Волга");
        sura.setTributaries(new String[] { "Труёв", "Пенза", "Урга" });
        sura.setType("равнинная");

        River moksha = new River();
        moksha.setName("Мокша");
        moksha.setCountry("Россия");
        moksha.setLocality("Республика Мордовия");
        moksha.setLatitude(54.744804);
        moksha.setLongitude(41.894469);
        moksha.setLength(656);
        moksha.setWidth(200);
        moksha.setDepth(6);
        moksha.setFlowRate(0.5);
        moksha.setFresh(true);
        moksha.setAverageTemperature(25);
        moksha.setSourceName("Елизаветино");
        moksha.setMouthName("Ока");
        moksha.setTributaries(new String[] { "Сивинь", "Сатис", "Ермишь" });
        moksha.setType("равнинная");

        River volga = new River();
        volga.setName("Волга");
        volga.setCountry("Россия");
        volga.setLocality("Нижний новгород");
        volga.setLatitude(49.550996);
        volga.setLongitude(45.139993);
        volga.setLength(3530);
        volga.setWidth(1800);
        volga.setDepth(14);
        volga.setFlowRate(1.1);
        volga.setFresh(true);
        volga.setAverageTemperature(25);
        volga.setSourceName("Волговерховье");
        volga.setMouthName("Каспийское море");
        volga.setTributaries(new String[] { "Сура", "Ветлуга", "Кама" });
        volga.setType("равнинная");

        River oka = new River();
        oka.setName("Ока");
        oka.setCountry("Россия");
        oka.setLocality("Орловская область");
        oka.setLatitude(54.532526);
        oka.setLongitude(40.033807);
        oka.setLength(1500);
        oka.setWidth(120);
        oka.setDepth(3);
        oka.setFlowRate(0.3);
        oka.setFresh(true);
        oka.setAverageTemperature(22);
        oka.setSourceName("Орловская область");
        oka.setMouthName("Волга");
        oka.setTributaries(new String[] { "Лопасня", "Угра" });
        oka.setType("равнинная");

        return new River[] { sura, moksha, oka, volga };

    }

}
