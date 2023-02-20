package lab3;

public class Animal {

    private final String name; //название
    private final String type; //вид
    private final double size; //размер
    private final double weight; //вес
    private final boolean isPredator; //хищный

    public Animal(String name, String type, double size, double weight, boolean isPredator) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.weight = weight;
        this.isPredator = isPredator;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isPredator() {
        return isPredator;
    }

    public void printInfo() {
        System.out.print("- " + name);
        System.out.print(", вид: " + type);
        System.out.print(", размер: " + size);
        System.out.print(", вес: " + weight);
        System.out.println(", хищник: " + (isPredator ? "да" : "нет"));
    }

}
