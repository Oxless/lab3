package lab3new;

import java.util.Random;

public class RandomRiverGenerator {

    //класс для работы со случайными значениям
    private static final Random RANDOM = new Random();

    //заранее заданные страны
    private static final String[] COUNTRIES = new String [] { "Страна 1", "Страна 2", "Страна 3", "Страна 4" };
    //заранее заданные населенные пункты
    private static final String[] LOCALITIES = new String [] {
            "Населенный пункт 1", "Населенный пункт 2",
            "Населенный пункт 3", "Населенный пункт 4"
    };

    public static River generate(String riverName, String mouthName, String sourceName) {
        River river = new River();
        river.setName(riverName);
        river.setMouthName(mouthName);
        river.setSourceName(sourceName);
        river.setCountry(getRandomString(COUNTRIES)); //вызываем функцию для получения случайной строки из массива, передаем туда массив со странами
        river.setLocality(getRandomString(LOCALITIES)); //аналогично, но передаем массив с населенными пунктами
        //nextDouble(double bound) - функция, которая генерирует случайное значения от нуля до bound, не включая bound
        river.setLongitude(RANDOM.nextDouble(180)); //генерируем долготу
        river.setLatitude(RANDOM.nextDouble(90)); //генерируем широту
        river.setLength(RANDOM.nextDouble(5000)); //генерируем длину
        river.setWidth(RANDOM.nextDouble(500)); //генерируем ширину
        river.setDepth(RANDOM.nextDouble(30)); //генерируем глубину
        river.setAverageTemperature(RANDOM.nextDouble(25)); //генерируем среднюю температуру
        river.setFlowRate(RANDOM.nextDouble(10)); //генерируем скорость течения
        river.setFresh(RANDOM.nextBoolean()); //nextBoolean() случайным образом возвращает либо true, либо false. В нашем случае случайно задаем пресный это водоем или нет
        String randomType = RANDOM.nextBoolean() ? "горная" : "равнинная"; //если nextBoolean = true, то задаем значение, которое слева от двоеточия, в противном случае - которое справа
        river.setType(randomType);
        return river;
    }

    private static String getRandomString(String[] strings) {
        //генерируем случайное число от 0 до размера массива не включительно
        //таким образом, наше число не выйдет за пределы массива
        int randomIndex = RANDOM.nextInt(strings.length);
        //возвращаем случайную строку путем указания случайного индекса массива
        return strings[randomIndex];
    }

}
