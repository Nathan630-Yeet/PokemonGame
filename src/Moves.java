public class Moves {
    private String name;
    private Type type;
    private double accuracy;
    private int priority;
    public Moves() {
        type = new Type();
        priority = 0;
    }
    public Moves(String moveName, String moveType, double Paccuracy) {
        type = new Type(moveType);
        accuracy = Paccuracy/100.0;
        priority = 0;
        name = moveName;
    }
    public Moves(String moveName, String moveType, double Paccuracy, int prio) {
        type = new Type(moveType);
        accuracy = Paccuracy/100.0;
        priority = prio;
        name = moveName;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public Type getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }
    public boolean getIsPhysical(){
        return true;
    }
    public boolean isRecoil() {
        return false;
    }


    public int getDamage() {
        return 0;
    }

    @Override
    public String toString() {
        return "Moves{" +
                "type=" + type +
                ", accuracy=" + accuracy +
                ", priority=" + priority +
                '}';
    }
}
