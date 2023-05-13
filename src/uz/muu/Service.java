package uz.muu;

public class Service {
    private int ID;
    private String name;
    private double cost;

    public Service(int ID, String name, double cost) {
        this.ID = ID;
        this.name = name;
        this.cost = cost;
    }


    public long getCost() {
        return -1;
    }
}
