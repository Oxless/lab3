package lab3new;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //инициализация (создание) объектов рек
        //реки хранятся в массиве
        //массив - такая структура, которая состоит из какого-то количества ячеек
        //каждая ячейка что-то содержит
        //пример: коробка для лекарств, разбитая на дни недели
        //в этом случае день недели будет являться индексом массива,
        //а содержимое каждой ячейки - это элементы массива
        //в нашем случае создаем массив из 4 рек
        //в массив можно только вставить что-то по индексу, добавить новое нельзя,
        //т.е. если массив из 4 элементов, то пятый вставить нельзя, только заменить один из существующих
        River[] rivers = initializeRivers();

        System.out.println("Самая коротка река:");
        //Функция ищет самую короткую реку и помещает ее в переменную ссылочного типа shortestRiver
        River shortestRiver = findShortestRiver(rivers);
        //Если из функции вернулся null, значит что объекта не существует
        //В таком случае, если он не равен null, то выводим информацию о реке через метод print
        if(shortestRiver != null) {
            shortestRiver.print();
        }

        //С помощью функции рассчитали среднюю длину реки среди наших четырех рек
        double averageLength = calculateAverageLength(rivers);

        System.out.println();
        System.out.println("Реки с длиной больше средней:");
        //Выводим список рек, длина которых выше средней
        printRiversLongerAverage(rivers, averageLength);

        System.out.println();
        System.out.println("Отсортированный список рек:");
        //Сортировка встроенным инструментом джавы
        //Есть класс Arrays, у которого статический метод sort сортирует массив
        //Первым параметром указывается сам массив, который нужно отсортировать
        //Вторым параметром класс компаратор, в нашем случае он сравнивает между собой названия рек и сортирует по этому свойству
        //Если че скажете, что в интернете нашли, чтобы не писать свою сортировку
        //Если попросит написать самим, напишите мне в вк, я накидаю
        Arrays.sort(rivers, Comparator.comparing(River::getName));
        for(River river : rivers) {
            //проходимся по всему массиву и выводим информацию по каждой реке
            river.print();
        }
        //for(Object object : objects) - такой цикл, перебирающий каждый элемент из массива/списка objects

        //Обработка поиска по названию
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

            //Задаем изначальное значение ссылочной переменной null, т.к. изначально там ничего нет
            //Затем в цикле перебираем наш список рек
            River founded = null;
            for (River river : rivers) {
                //Если название реки равно названию, которое мы ввели, без учета регистра, то записываем эту реку в нашу переменную founded
                //и останавливаем перебор списка командой break
                //equals - сравнивает строки с учетом регистра (пример, настя = настя, но Настя не равно настя)
                //equalsIgnoreCase игнорирует регистр слов и для него "Настя = настя"
                if (river.getName().equalsIgnoreCase(name)) {
                    founded = river;
                    break;
                }
            }

            //если по результату перебора мы дошли до конца массива, но так и не нашли совпадений по имени, то founded так и останется null
            //в таком случае, нам нужно вывести сообщение, что река не найдена
            if (founded == null) {
                System.out.println("Такая река не найдена");
            } else {
                //в противном случае выводим информацию
                System.out.println("Информация о реке: " + founded.getName());
                founded.print();
                System.out.println();
                //даем пользователю выбор: изменить название реки или пропустить это действие
                System.out.println("Введите 1, чтобы изменить название реки");
                System.out.println("Введите любой другой символ, чтобы пропустить");
                if(scanner.hasNextInt()) { //если ввели целое число
                    int action = scanner.nextInt();
                    //если ввели единицу
                    if(action == 1) {
                        scanner.nextLine();
                        System.out.println("Введите новое название реки:");
                        //то вводим новое название реки
                        String newName = scanner.nextLine();
                        //и изменяем его у объекта, который хранится в founded
                        //название поменяется у этого объекта и в массиве, т.к. это ссылочный тип данных (вдруг спросит, а вы хоба и шарите)
                        founded.setName(newName);
                        System.out.println("Обновленная информация о реке:");
                        founded.print();
                    }
                } else {
                    //если ввели какой-то символ или строку, то просто пропускаем ее
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
        //если у нас пустой массив рек, то возвращаем null (см. строку 25)
        if(rivers.length == 0)
            return null;
        //создаем переменную, в которой будет храниться кратчайшая река
        //изначально кладем в нее первый элемент массива (индексация массива начинается с нуля)
        River shortestRiver = rivers[0];
        //и дальше начинаем цикл с единички, потому что нулевой элемент мы уже положили в переменную
        //цикл продолжается, пока наш счетчик меньше количества элементов массива, чтобы не выйти за его пределы
        for(int i = 1; i < rivers.length; i++) {
            River currentRiver = rivers[i];
            //если река под i-тым индексом меньше текущей наименьшей, то заменяем наименьшую на эту, т.к. она меньше
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
        //проходимся по массиву и складываем все длины рек
        for(River river : rivers) {
            sum = sum + river.getLength();
        }
        //потом делим на кол-во рек и получаем среднее значение
        return sum/rivers.length;
    }

    /**
     * Выводит информацию о реках, длина которых выше средней
     * @param rivers - массив рек
     * @param averageLength - средняя длина реки
     */
    private static void printRiversLongerAverage(River[] rivers, double averageLength) {
        //проходим по массиву и если длина реки больше средней длины, то выводим информацию
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

        //создали объект реки
        River sura = new River();
        //для каждого поля у нас есть метод, который позволяет этому полю задать значение
        //называет такой метод "сеттер" (сэттер)
        sura.setName("Сура");
        sura.setCountry("Россия"); //задаем страну
        sura.setLocality("Пенза"); //задаем населенный пункт
        sura.setLatitude(54.173195); //широту
        sura.setLongitude(46.023926); //долготу
        sura.setLength(841); //длину
        sura.setWidth(100); //ширину
        sura.setDepth(4); //глубину
        sura.setFlowRate(0.8); //скорость течения
        sura.setFresh(true); //пресный или нет
        sura.setAverageTemperature(24); //средняя температура
        sura.setSourceName("Приволжская возвышенность"); //название истока реки
        sura.setMouthName("Волга"); //название устья реки (куда впадает)
        sura.setTributaries(new String[] { "Труёв", "Пенза", "Урга" }); // притоки реки (массив строк)
        sura.setType("равнинная"); //вид реки (равнинная или горная)

        //повторяем вышеизложенное для других рек
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

        //создаем массив из 4 элементов
        //где 0 - sura
        //1 - moksha
        //2 - oka
        //3 - volga
        return new River[] { sura, moksha, oka, volga };

    }

}
