package lab3new;

//класс водоем
//наследуется от класса "географический объект"
//в нашем случае геогр. объект - родитель, а водоем - потомок
//это значит, что у потомка (водоема) будут все поля и методы родителя (геогр. объекта)
//и плюс еще свои поля и методы
public class Water extends GeographicalObject {

    private double length; //длина
    private double width; //ширина
    private double depth; //глубина
    private boolean isFresh; //пресный водоем или нет
    private double averageTemperature; //средняя температура воды

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public boolean isFresh() {
        return isFresh;
    }

    public void setFresh(boolean fresh) {
        isFresh = fresh;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("  длина: %f, ширина: %f, глубина: %f, пресный: %s, ср. температура: %f %n", length, width, depth, (isFresh ? "да" : "нет"), averageTemperature);
    }
}
