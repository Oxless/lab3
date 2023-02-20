package lab3new;

//географический объект
public class GeographicalObject {

    private String name = "unknown"; //название
    private String country = "unknown"; //страна
    private String locality = "unknown"; //населенный пункт
    private double latitude; //широта
    private double longitude; //долгота

    //геттер для поля "название"
    public String getName() {
        return name;
    }

    //сеттер для поля "название"
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void print() {
        System.out.printf("- %s, страна: %s, населенный пункт: %s, координаты: %f %f %n", name, country, locality, latitude, longitude);
    }

}
