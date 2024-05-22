public class AttackingMoves extends Moves {
    private int power;
    private boolean isPhysical;
    private boolean recoil;
    public AttackingMoves(String moveName, String type, double accuracy, int Pdamage, boolean Physical, boolean hasRecoil) {
        super(moveName, type, accuracy);
        recoil = hasRecoil;
        power = Pdamage;
        isPhysical = Physical;
    }
    public AttackingMoves(String moveName, String type, double accuracy, int Pdamage, boolean Physical, int prio) {
        super(moveName, type, accuracy, prio);
        power = Pdamage;
        isPhysical = Physical;
    }
    public boolean getIsPhysical(){
        return isPhysical;
    }

    public boolean isRecoil() {
        return recoil;
    }

    public int getDamage() {
        return power;
    }

    @Override
    public String toString() {
        return "AttackingMoves{" +
                "power=" + power +
                ", isPhysical=" + isPhysical +
                ", recoil=" + recoil +
                "type=" + this.getType() +
                ", accuracy=" + this.getAccuracy() +
                ", priority=" + this.getType() +
                '}';
    }
}
