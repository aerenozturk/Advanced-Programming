package yemekex;

public class Food {
    private final String name;
    private final int time;

    public Food(String name, int time) {
        this.name = name;
        this.time = time;
        }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }


    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", time=" + time;
            
    }
}