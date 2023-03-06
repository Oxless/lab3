package lab3new;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserMenu {

    private static final Scanner SCANNER = new Scanner(System.in);

    //список рек
    //List - список, это интерфейс, у которого есть разные реализации
    //ArrayList - конкретный класс, который реализует интерфейс List, в нашем случае он создает список на основе массива
    //(также бывают односвязные и двусвязные списки, они реализованы по-другому)
    //в скобках < > указывается тип данных, который будет храниться в нашем списке
    //это называется обобщение или generics

    private static final List<River> RIVERS = new ArrayList<>();

    /**
     * Запускает пользовательское консольное меню
     */
    public static void start() {
        initializeRivers();
        handleConsoleInput();
    }

    /**
     * Обрабатывает пользовательский ввод с клавиатуры
     */
    private static void handleConsoleInput() {
        //запускается цикл, у которого условие всегда истинно, значит цикл будет выполняться бесконечно, пока
        //не будет вызвана команда break или return
        while(true) {
            printMenu();
            if(SCANNER.hasNextInt()) {
                int action = SCANNER.nextInt();
                SCANNER.nextLine();
                //конструкция switch-case позволяет не создавать кучу if-else, а перебрать всевозможные значения переменной более лаконично
                //в switch могут передаваться только переменные типа char, byte, short, int, enum и String
                //после того, как передали переменную, мы прописываем case, т.е. конкретные частные случае
                //например, если мы проверяем число и оно равно единице, то вызовется блок case 1, если в переменной у нас двойка, то вызовется case 2 и т.д.
                //со строками так же
            /*
            switch (какая-то строка) {
                case "значение1":
                    что-то делаем, если строка равна "значение1";
                    break;
                case "значение2":
                    что-то делаем, если строка равна "значение2";
                    break;
                default:
                    что-то делаем, если строка не попала под первые два условия;
                    break;
             }
             если не стоит break в конце блока, то программа пойдет дальше проверять строку/число по всем остальным условиям и если дойдет до блока default,
             то выполнится еще и код из этого блока
             */
                switch (action) {
                    case 1:
                        addNewRiver(); //если action = 1, то вызываем функцию добавления
                        break;
                    case 2:
                        removeRiver(); //если action = 2, то вызываем функцию удаления
                        break;
                    case 3:
                        updateRiverName(); //если action = 3, то вызываем функцию изменения названия
                        break;
                    case 4:
                        River river = findShortestRiver(); //если action = 4, то ищем кратчайшую реку
                        if (river == null) {
                            System.out.println("Вы не добавили ни одной реки");
                        } else {
                            System.out.println("Наикратчайшая река:");
                            river.print();
                        }
                        break;
                    case 5:
                        //если action = 5, то вызываем выводим все реки длиннее средней
                        double averageLength = calculateAverageLength();
                        printRiversLongerAverage(averageLength);
                        break;
                    case 6:
                        printSortedRivers(); //если action = 6, то выводим отсортированный список
                        break;
                    case 0:
                        //если action = 0, то вызываем команду return, которая останавливает наш бесконечный цикл while и завершает программу, т.к. после цикла нет никаких действий
                        return;
                    default:
                        //если action не равно ни одному из частных случаев, которые мы указали выше, выводим сообщение об ошибке
                        System.out.println("Неизвестное действие");
                }
            } else {
                System.out.println("Неизвестное действие");
                SCANNER.nextLine();
            }
        }
    }

    /**
     * Выводит главное меню на экран
     */
    private static void printMenu() {
        System.out.println("Главное меню: ");
        System.out.println("1 - Добавить новую реку");
        System.out.println("2 - Удалить реку по названию");
        System.out.println("3 - Изменить название реки");
        System.out.println("4 - Найти кратчайшую реку");
        System.out.println("5 - Вывести на экран все реки, длины которых больше средней");
        System.out.println("6 - Вывести отсортированный список рек");
        System.out.println("0 - Завершить программу");
        System.out.println();
    }

    /**
     * Добавляет новую реку
     */
    private static void addNewRiver() {
        System.out.println("Введите название реки:");
        String riverName = SCANNER.nextLine();
        System.out.println("Введите название устья реки:");
        String mouthName = SCANNER.nextLine();
        System.out.println("Введите название истока реки:");
        String sourceName = SCANNER.nextLine();

        //Создаем новую реку путем генерации случайных данных
        River newRiver = RandomRiverGenerator.generate(riverName, mouthName, sourceName);
        //Добавляем новую реку в список
        RIVERS.add(newRiver);

        System.out.println("Вы добавили новую реку под названием " + riverName);
        newRiver.print();
    }

    /**
     * Удаляет реку по названию
     */
    private static void removeRiver() {
        System.out.println("Введите название реки:");
        String riverName = SCANNER.nextLine();

        //Функция removeIf позволяет удалить все данные из списка которые соответствуют условию
        //внутри функции программа проходит по всему списку и если река river, которая слева от стрелочки
        //соответствует условию, которое справа от стрелочки, то эта река удаляется
        //условие тут - "если название реки совпадает со строкой riverName"
        boolean removed = RIVERS.removeIf(river -> river.getName().equalsIgnoreCase(riverName));

        //переменная removed дает понять, было ли что-то удалено из списка
        //если removed = true, то минимум одна запись, которая соответствовала условию, была удалена
        //если removed = false, то ни одна запись не совпала по этому условию, и значит не была удалена
        if(removed) {
            System.out.println("Река с названием `" + riverName + "` удалена");
        } else {
            System.out.println("Река с названием `" + riverName + "` не найдена");
        }
    }

    /**
     * Изменить название реки
     */
    private static void updateRiverName() {
        System.out.println("Введите название реки:");
        String riverName = SCANNER.nextLine();

        River founded = null;
        for (River river : RIVERS) {
            //Если название реки равно названию, которое мы ввели, без учета регистра, то записываем эту реку в нашу переменную founded
            //и останавливаем перебор списка командой break
            //equals - сравнивает строки с учетом регистра (пример, настя = настя, но Настя не равно настя)
            //equalsIgnoreCase игнорирует регистр слов и для него "Настя = настя"
            if (river.getName().equalsIgnoreCase(riverName)) {
                founded = river;
                break;
            }
        }

        if(founded == null) {
            System.out.println("Река под названием `" + riverName + "` не найдена");
        } else {
            System.out.println("Введите новое название реки: ");
            //вводим новое название реки
            String newName = SCANNER.nextLine();
            //и изменяем его у объекта, который хранится в founded
            //название поменяется у этого объекта и в списке, т.к. это ссылочный тип данных
            founded.setName(newName);
            System.out.println("Обновленная информация о реке:");
            founded.print();
        }

    }

    /**
     * Найти кратчайшую реку
     * @return кратчайшая река
     */
    private static River findShortestRiver() {
        if(RIVERS.size() == 0)
            return null;
        //создаем переменную, в которой будет храниться кратчайшая река
        //изначально кладем в нее первый элемент списка (индексация списка начинается с нуля)
        River shortestRiver = RIVERS.get(0);
        //и дальше начинаем цикл с единички, потому что нулевой элемент мы уже положили в переменную
        //цикл продолжается, пока наш счетчик меньше количества элементов списка, чтобы не выйти за его пределы
        for(int i = 1; i < RIVERS.size(); i++) {
            River currentRiver = RIVERS.get(i);
            //если река под i-тым индексом меньше текущей наименьшей, то заменяем наименьшую на эту, т.к. она меньше
            if(currentRiver.getLength() < shortestRiver.getLength()) {
                shortestRiver = currentRiver;
            }
        }
        return shortestRiver;
    }

    /**
     * Вывести на экран все реки, длины которых больше средних
     * @param averageLength - средняя длина всех рек
     */
    private static void printRiversLongerAverage(double averageLength) {
        System.out.println("Список рек, длины которых больше средней");
        //проходим по списку и если длина реки больше средней длины, то выводим информацию
        for(River river : RIVERS) {
            if(river.getLength() > averageLength) {
                river.print();
            }
        }
    }

    /**
     * Рассчитать среднюю длину реки
     * @return средняя длина
     */
    private static double calculateAverageLength() {
        double sum = 0;
        //проходимся по списку и складываем все длины рек
        for(River river : RIVERS) {
            sum = sum + river.getLength();
        }
        //потом делим на кол-во рек и получаем среднее значение
        return sum/RIVERS.size();
    }

    /**
     * Вывести отсортированный список рек
     */
    private static void printSortedRivers() {
        System.out.println("Отсортированный список рек:");
        RIVERS.sort(Comparator.comparing(River::getName));
        for(River river : RIVERS) {
            river.print();
        }
    }

    /**
     * Генерирует изначально заданные реки
     */
    private static void initializeRivers() {
        RIVERS.add(RandomRiverGenerator.generate("Сура", "Волга", "Приволжская возвышенность"));
        RIVERS.add(RandomRiverGenerator.generate("Ока", "Волга", "Среднерусская возвышенность"));
        RIVERS.add(RandomRiverGenerator.generate("Нева", "Невская губа", "Ладожское озеро"));
        RIVERS.add(RandomRiverGenerator.generate("Енисей", "Енисейский залив", "озеро Кара-Балык"));
    }

}
