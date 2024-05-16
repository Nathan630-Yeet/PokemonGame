public class AttackingMoves extends Moves {
    private int damage;
    private boolean isPhysical;
    private boolean recoil;
    public AttackingMoves(String moveName, String type, double accuracy, int Pdamage, boolean Physical, boolean hasRecoil) {
        super(moveName, type, accuracy);
        recoil = hasRecoil;
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

    public boolean isRecoil() {
        return recoil;
    }

    public int getDamage() {
        return damage;
    }

}
