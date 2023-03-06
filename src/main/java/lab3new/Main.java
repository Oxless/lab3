package lab3new;

public class Main {

    /**
     * Выводит на экран задание и тех, кто его выполнил
     */
    private static void printTask() {
        System.out.println("Лабораторная 3");
        System.out.println("Задание: Реки\n" +
                "- определить самую короткую реку;\n" +
                "- вывести информацию о реках с длиной больше средней;\n" +
                "- упорядочить список рек по названиям в алфавитном порядке;\n" +
                "- организовать поиск по названию реки, исправление одного из полей и вывод полной информации о реке после редактирования.");
        System.out.println("Задание выполнили: Басманова, Прошина");
        System.out.println();
    }

    public static void main(String[] args) {
        printTask();
        UserMenu.start();
    }

}
