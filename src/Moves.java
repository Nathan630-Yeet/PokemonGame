public class Moves {
    private Type type;
    private double accuracy;
    private int priority;
    public Moves() {
        type = new Type();
        priority = 0;
    }
    public Moves(String moveType, double Paccuracy) {
        type = new Type(moveType);
        accuracy = Paccuracy;
        priority = 0;
    }
    public Moves(String moveType, double Paccuracy, int prio) {
        type = new Type(moveType);
        accuracy = Paccuracy;
        priority = prio;
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
}
