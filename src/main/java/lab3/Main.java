package lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        River[] rivers = initRivers();

        System.out.println("Самая короткая река:");
        River shortestRiver = findShortestRiver(rivers);
        if(shortestRiver != null) {
            shortestRiver.printInfo();
        }

        System.out.println("Реки с длиной больше средней:");
        double averageLength = calculateAverageLength(rivers);
        printRiversLongerAverage(rivers, averageLength);

        System.out.println("Отсортированный список рек:");
        Arrays.sort(rivers, Comparator.comparing(River::getName));
        for(River river : rivers) {
            river.printInfo();
        }

    }

    private static River[] initRivers() {

        Vegetation kuvshinka = new Vegetation("Кувшинка", 1, 50, false, 10);
        Vegetation vodorosli = new Vegetation("Водоросли", 30, 10, false, 10);
        Vegetation ryaska = new Vegetation("Ряска", 1, 1, false, 1);
        Vegetation rogoz = new Vegetation("Рогоз", 40, 10, false, 10);
        Vegetation kamish = new Vegetation("Камыш", 45, 12, false, 11);

        Animal shuka = new Animal("Щука", "Рыба", 30, 100, true);
        Animal karas = new Animal("Карась", "Рыба", 20, 60, false);
        Animal okun = new Animal("Окунь", "Рыба", 24, 75, true);
        Animal karp = new Animal("Карп", "Рыба", 34, 500, false);
        Animal rak = new Animal("Рак", "Членистоногое", 10, 10, true);
        Animal frog = new Animal("Лягушка", "Земноводные", 10, 15, true);
        Animal prudovik = new Animal("Прудовик", "Брюхоногие", 5, 3, false);

        River sura = new River("Сура", 841, 160, 4,
                new Vegetation[] { kuvshinka, vodorosli, rogoz },
                new Animal[] { shuka, karas, okun, karp, rak }
        );

        River volga = new River("Волга", 3530, 1000, 17,
                new Vegetation[] { ryaska, kamish, vodorosli, kuvshinka },
                new Animal[] { prudovik, frog, karas, okun, karp, shuka }
        );

        River oka = new River("Ока", 1500, 120, 5,
                new Vegetation[] { vodorosli, rogoz, kamish, kuvshinka },
                new Animal[] { shuka, karas, okun, rak, frog, prudovik }
        );

        River moksha = new River("Мокша", 656, 200, 6,
                new Vegetation[] { ryaska, rogoz, kamish, vodorosli },
                new Animal[] { shuka, karas, rak, frog, karp }
        );

        River[] rivers = new River[] { sura, volga, oka, moksha };

        return rivers;
    }

    private static River findShortestRiver(River[] rivers) {
        if(rivers.length == 0)
            return null;
        River shortest = rivers[0];
        for(int i = 1; i < rivers.length; i++) {
            River river = rivers[i];
            if(river.getLength() < shortest.getLength()) {
                shortest = river;
            }
        }
        return shortest;
    }

    private static void printRiversLongerAverage(River[] rivers, double average) {
        for(River river : rivers) {
            if(river.getLength() > average) {
                river.printInfo();
            }
        }
    }

    private static double calculateAverageLength(River[] rivers) {
        double sum = 0;
        for(River river : rivers) {
            sum = sum + river.getLength();
        }
        return sum / rivers.length;
    }

}
