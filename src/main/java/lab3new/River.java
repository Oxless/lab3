package lab3new;

import java.util.Arrays;

public class River extends Water {

    private double flowRate; //скорость течения
    private String sourceName = "unknown"; //название истока
    private String mouthName = "unknown"; //название устья (куда впадает)
    private String[] tributaries = {}; //притоки реки
    private String type; //вид: горная/равнинная

    public double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(double flowRate) {
        this.flowRate = flowRate;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getMouthName() {
        return mouthName;
    }

    public void setMouthName(String mouthName) {
        this.mouthName = mouthName;
    }

    public String[] getTributaries() {
        return tributaries;
    }

    public void setTributaries(String[] tributaries) {
        this.tributaries = tributaries;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("  скорость течения: %f, исток: %s, устье: %s, вид: %s, притоки: %s %n", flowRate, sourceName, mouthName, type, Arrays.toString(tributaries));
    }
}
