public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", "electric", "bold", 35, 55, 40, 50, 50,90);
        Pokemon chesnaught = new Pokemon("Chesnaught", "grass", "fighting", "hardy", 88, 107, 122,74,75,64);
        Pokemon weavile = new Pokemon("weavile","ice","dark", "hardy", 70, 120, 65,45,85,125);
        System.out.println(pikachu.toString());
        pikachu.initializeNature();
        System.out.println(pikachu.toString());
        System.out.println(weavile.toString());
        System.out.println(chesnaught.toString());

        AttackingMoves tackle = new AttackingMoves("tackle","normal", 1.00, 40, true);
        AttackingMoves iceShard = new AttackingMoves("iceShard","ice", 1.00, 40, true, 1);

        System.out.println(pikachu.toString());
        chesnaught.damageCalc(pikachu, tackle);
        System.out.println(pikachu.toString());
        System.out.println(chesnaught.toString());



    }
}