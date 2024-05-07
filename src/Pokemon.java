public class Pokemon {


    private String name;
    private Type type;
    private int totHP, remainHP, att, def, speAtt, speDef, speed;



    public Pokemon(String pokeName){
        name = pokeName;
    }
    public Pokemon(String pokeName, int totalHP, int attack, int defence, int specialAttack, int specialDefence, int spe) {
        name = pokeName;
        //insert type
        totHP = totalHP;
        remainHP = totalHP;
        att = attack;
        def = defence;
        speAtt = specialAttack;
        speDef = specialDefence;
        speed = spe;
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

}
