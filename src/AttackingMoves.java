public class AttackingMoves extends Moves {
    private int damage;
    private boolean isPhysical;
    public AttackingMoves(String type, double accuracy, int Pdamage, boolean Physical) {
        super(type, accuracy);
        damage = Pdamage;
        isPhysical = Physical;
    }
    public boolean getIsPhysical(){
        return isPhysical;
    }

    public int getDamage() {
        return damage;
    }
}
