public class AttackingMoves extends Moves {
    private int damage;
    private boolean isPhysical;
    public AttackingMoves(String moveName, String type, double accuracy, int Pdamage, boolean Physical) {
        super(moveName, type, accuracy);
        damage = Pdamage;
        isPhysical = Physical;
    }
    public AttackingMoves(String moveName, String type, double accuracy, int Pdamage, boolean Physical, int prio) {
        super(moveName, type, accuracy, prio);
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
