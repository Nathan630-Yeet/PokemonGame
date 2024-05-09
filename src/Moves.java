public class Moves {
    private Type type;
    public Moves() {
        type = new Type();
    }
    public Moves(String moveType) {
        type = new Type(moveType);
    }
}
