public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", "electric", "bold", 35, 55, 40, 50, 50,90);
        Pokemon chesnaught = new Pokemon("Chesnaught", "grass", "fighting", "hardy", 88, 107, 122,74,75,64);
        System.out.println(pikachu.toString());
        pikachu.initializeNature();
        System.out.println(pikachu.toString());

        AttackingMoves tackle = new AttackingMoves("normal", 1.00, 40, true);
        System.out.println(pikachu.toString());
        chesnaught.damageCalc(pikachu, tackle);
        System.out.println(pikachu.toString());
        System.out.println(chesnaught.toString());


        Type A = new Type("electric");
        Type B = new Type("ground");
        DualType C = new DualType("water","flying");
        System.out.println(A.effectiveMultiplier(B));
    }
}