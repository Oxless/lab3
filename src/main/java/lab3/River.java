package lab3;

import java.util.List;

public class River {

    private final String name; //название
    private final double length; //длина (в км)
    private final double width; //ширина
    private final double depth; //глубина
    private final Vegetation[] vegetation; //растительность
    private final Animal[] animals; //обитатели

    public River(String name, double length, double width, double depth, Vegetation[] vegetation, Animal[] animals) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.vegetation = vegetation;
        this.animals = animals;
    }

    public double getArea() {
        return length * 1000 * width;
    }

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public Vegetation[] getVegetation() {
        return vegetation;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void printInfo() {
        System.out.println("Название реки: " + name);
        System.out.println("Длина: " + length);
        System.out.println("Ширина: " + width);
        System.out.println("Глубина: " + depth);
        System.out.println("Растительность:");
        for(Vegetation veget : vegetation) {
            veget.printInfo();
        }
        System.out.println("Обитатели:");
        for(Animal animal : animals) {
            animal.printInfo();
        }
        System.out.println("------------------");
    }

}
