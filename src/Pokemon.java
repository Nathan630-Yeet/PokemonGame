public class Pokemon {


    private String name;
    private DualType type;
    private int totHP, remainHP, att, def, speAtt, speDef, speed;
    private String nature;
    private Moves move1, move2, move3, move4;
    private int level = 50;



    public Pokemon(String pokeName){
        name = pokeName;
    }
    public Pokemon(String pokeName, String pokeType, String pokeNature, int totalHP, int attack, int defence, int specialAttack, int specialDefence, int spe) {
        name = pokeName;
        type = new DualType(pokeType);

        totHP = (2 * totalHP) * level/100 + level + 10;
        remainHP = totHP;
        nature = pokeNature;
        att = attack * 2 * level/100 + 5;
        def = defence * 2 * level/100 + 5;
        speAtt = specialAttack * 2 * level/100 + 5;
        speDef = specialDefence * 2 * level/100 + 5;
        speed = spe * 2 * level/100 + 5;
    }
    public Pokemon(String pokeName, String pokeType,String pokeTypeB, String pokeNature, int totalHP, int attack, int defence, int specialAttack, int specialDefence, int spe) {
        name = pokeName;
        type = new DualType(pokeType,pokeTypeB);
        totHP = totalHP * 2 * level/100 + level + 10;
        nature = pokeNature;
        remainHP = totHP;
        att = attack * 2 * level/100 + 5;
        def = defence * 2 * level/100 + 5;
        speAtt = specialAttack * 2 * level/100 + 5;
        speDef = specialDefence * 2 * level/100 + 5;
        speed = spe * 2 * level/100 + 5;
    }
    public Pokemon(String pokeName, String pokeType,String pokeTypeB, String pokeNature, int totalHP, int attack, int defence, int specialAttack, int specialDefence, int spe, Moves moveA, Moves moveB, Moves moveC, Moves moveD) {
        name = pokeName;
        type = new DualType(pokeType,pokeTypeB);
        totHP = totalHP * 2 * level/100 + level + 10;
        nature = pokeNature;
        remainHP = totHP;
        att = attack * 2 * level/100 + 5;
        def = defence * 2 * level/100 + 5;
        speAtt = specialAttack * 2 * level/100 + 5;
        speDef = specialDefence * 2 * level/100 + 5;
        speed = spe * 2 * level/100 + 5;
        move1 = moveA;
        move2 = moveB;
        move3 = moveC;
        move4 = moveD;
    }

    public String initializeNature() {
        if(nature.equalsIgnoreCase("bold")) {
            att = (int)(0.9 * att);
            def = (int)(1.1*def);
        }
        else if(nature.equalsIgnoreCase("modest")) {
            att = (int)(0.9 * att);
            speAtt = (int)(1.1*speAtt);
        }
        else if(nature.equalsIgnoreCase("mild")) {
            def = (int)(0.9 * def);
            speAtt = (int)(1.1*speAtt);
        }
        else if(nature.equalsIgnoreCase("calm")) {
            att = (int)(0.9 * att);
            speDef = (int)(1.1*speDef);
        }
        else if(nature.equalsIgnoreCase("gentle")) {
            def = (int)(0.9 * def);
            speDef = (int)(1.1*speDef);
        }
        else if(nature.equalsIgnoreCase("careful")) {
            speAtt = (int)(0.9 * speAtt);
            speDef = (int)(1.1*speDef);
        }
        else if(nature.equalsIgnoreCase("timid")) {
            att = (int)(0.9 * att);
            speed = (int)(1.1*speed);
        }
        else if(nature.equalsIgnoreCase("hasty")) {
            def = (int)(0.9 * def);
            speed = (int)(1.1*speed);
        }
        else if(nature.equalsIgnoreCase("jolly")) {
            speAtt = (int)(0.9 * speAtt);
            speed = (int)(1.1*speed);
        }
        else if(nature.equalsIgnoreCase("naive")) {
            speDef = (int)(0.9 * speDef);
            speed = (int)(1.1*speed);
        }
        else if(nature.equalsIgnoreCase("lonely")) {
            att = (int)(1.1 * att);
            def = (int)(0.9 *def);
        }
        else if(nature.equalsIgnoreCase("adamant")) {
            att = (int)(1.1 * att);
            speAtt = (int)(0.9* speAtt);
        }
        else if(nature.equalsIgnoreCase("naughty")) {
            att = (int)(1.1 * att);
            speDef = (int)(0.9*speDef);
        }
        else if(nature.equalsIgnoreCase("brave")) {
            att = (int)(1.1 * att);
            speed = (int)(0.9*speed);
        }
        else if(nature.equalsIgnoreCase("impish")) {
            speAtt = (int)(0.9 * speAtt);
            def = (int)(1.1*def);
        }
        else if(nature.equalsIgnoreCase("lax")) {
            speDef = (int)(0.9 * speDef);
            def = (int)(1.1*def);
        }
        else if(nature.equalsIgnoreCase("relaxed")) {
            speed = (int)(0.9 * speed);
            def = (int)(1.1*def);
        }
        else if(nature.equalsIgnoreCase("rash")) {
            speAtt = (int)(1.1 * speAtt);
            speDef = (int)(0.9*speDef);
        }
        else if(nature.equalsIgnoreCase("quiet")) {
            speAtt = (int)(1.1 * speAtt);
            speed = (int)(0.9*speed);
        }
        else if(nature.equalsIgnoreCase("sassy")) {
            speed = (int)(0.9 * speed);
            speDef = (int)(1.1*speDef);
        }
        return nature;
    }

    public Moves getMove1() {
        return move1;
    }

    public Moves getMove2() {
        return move2;
    }

    public Moves getMove3() {
        return move3;
    }

    public Moves getMove4() {
        return move4;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotHP() {
        return totHP;
    }

    public void setTotHP(int totHP) {
        this.totHP = totHP;
    }

    public int getRemainHP() {
        return remainHP;
    }

    public void setRemainHP(int remainHP) {
        this.remainHP = remainHP;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpeAtt() {
        return speAtt;
    }

    public void setSpeAtt(int speAtt) {
        this.speAtt = speAtt;
    }

    public int getSpeDef() {
        return speDef;
    }

    public void setSpeDef(int speDef) {
        this.speDef = speDef;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public boolean goFirst(Pokemon opp) {
        if(this.getSpeed() > opp.getSpeed()) {
            return true;
        }
        return false;
    }
    public int damageCalc(Pokemon B, Moves move) {
        int damageTaken = 0;
        if(Math.random() < move.getAccuracy()){
            double random = (Math.random() * 16 + 85)/100.0;
            if(move.getIsPhysical() == true){
                damageTaken = ((2*level/5 + 2) * move.getDamage() * att / B.getDef())/50 + 2;
            }
            else{
                damageTaken = ((2*level/5 + 2) * move.getDamage() * speAtt / B.getSpeDef())/50 + 2;
            }
            if(move.getType().getTypeIndex() == type.getTypeIndex()||move.getType().getTypeIndex() == type.getType2Index()) {
                damageTaken = (int)(damageTaken * 1.5);
                System.out.println("stab");
            }
            damageTaken = (int)(damageTaken * random);
            damageTaken = (int)(damageTaken* move.getType().effectiveMultiplier(B.getType()));
            if(move.getType().effectiveMultiplier(B.getType()) == 2.0) {
                System.out.println("super effective!");
            }
            else if(move.getType().effectiveMultiplier(B.getType()) == 4.0) {
                System.out.println("super SUPER effective!");
            }
            else if(move.getType().effectiveMultiplier(B.getType()) == 0.5) {
                System.out.println("not very effective");
            }
            else if(move.getType().effectiveMultiplier(B.getType()) == 0.25) {
                System.out.println("burh");
            }
            else if(move.getType().effectiveMultiplier(B.getType()) == 0.0) {
                System.out.println("no effect");
            }
        }
        B.setRemainHP(B.getRemainHP()-damageTaken);
        if(B.getRemainHP() <= 0) {
            System.out.println(B.getName() + " has fainted");
            B.setRemainHP(0);
        }
        return damageTaken;
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", remaining Hp =" + remainHP +
                ", totHP=" + totHP +
                ", att=" + att +
                ", def=" + def +
                ", speAtt=" + speAtt +
                ", speDef=" + speDef +
                ", speed=" + speed +
                '}';
    }
}
