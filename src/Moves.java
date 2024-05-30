public class Moves {
    private String name;
    private String type;
    private String category;
    private int power;
    private int accuracy;
    public Moves(String name, String type, String category, int power, int accuracy) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
    }
    public Moves(String moveName) {
        this.name = moveName;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return new Type(type);
    }

    public String getCategory() {
        return category;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }


    public int getDamage() {
        return 0;
    }

    @Override
    public String toString() {
        return "Moves{" +
                "type=" + type +
                ", accuracy=" + accuracy +
                '}';
    }
}
