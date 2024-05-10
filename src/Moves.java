public class Moves {
    private Type type;
    private double accuracy;
    public Moves() {
        type = new Type();
    }
    public Moves(String moveType, double Paccuracy) {
        type = new Type(moveType);
        accuracy = Paccuracy;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public Type getType() {
        return type;
    }
}
