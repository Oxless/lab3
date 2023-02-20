package lab3;

public class Vegetation {

    private final String name; //название
    private final double height; //высота
    private final double area; //площадь
    private final boolean edible; //съедобность
    private final double weight; //вес

    public Vegetation(String name, double height, double area, boolean edible, double weight) {
        this.name = name;
        this.height = height;
        this.area = area;
        this.edible = edible;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return area;
    }

    public boolean isEdible() {
        return edible;
    }

    public double getWeight() {
        return weight;
    }

    public void printInfo() {
        System.out.print("- " + name);
        System.out.print(", высота: " + height);
        System.out.print(", площадь: " + area);
        System.out.print(", съедобное: " + (edible ? "да" : "нет"));
        System.out.println(", вес: " + weight);
    }

}
