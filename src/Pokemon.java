import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

        private Type type;
        private String name;
        private int totHP, remainHP, att, def, speAtt, speDef, speed;
        private String nature;
        private List<String> moves;
        private List<String> types;
        private int level = 50;
        private boolean fainted;




        public Pokemon(String name) throws Exception {
            this.name = name;
            this.types = new ArrayList<>();
            this.moves = new ArrayList<>();
            fetchDataFromApi();
            this.remainHP = totHP;
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
            fainted = false;
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
            fainted = false;
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

            fainted = false;
        }
        private void fetchDataFromApi() throws Exception {
            JSONObject pokemonData = PokeApi.getPokemonData(this.name);

            JSONArray typesArray = pokemonData.getJSONArray("types");
            for (int i = 0; i < typesArray.length(); i++) {
                types.add(typesArray.getJSONObject(i).getJSONObject("type").getString("name"));
            }
            if (types.size() > 1){
                type = new DualType(types.get(0),types.get(1));
            }
            else {
                type = new DualType(types.get(0));
            }


            JSONArray statsArray = pokemonData.getJSONArray("stats");
            for (int i = 0; i < statsArray.length(); i++) {
                JSONObject stat = statsArray.getJSONObject(i);
                String statName = stat.getJSONObject("stat").getString("name");
                int baseStat = stat.getInt("base_stat");

                switch (statName) {
                    case "hp":
                        this.totHP = baseStat * 2 * level/100 + level + 10;
                        break;
                    case "attack":
                        this.att = baseStat + 5;
                        break;
                    case "defense":
                        this.def = baseStat + 5;
                        break;
                    case "special-attack":
                        this.speAtt = baseStat + 5;
                        break;
                    case "special-defense":
                        this.speDef = baseStat + 5;
                        break;
                    case "speed":
                        this.speed = baseStat + 5;
                        break;
                }
            }

            JSONArray movesArray = pokemonData.getJSONArray("moves");
            for (int i = 0; i < movesArray.length() && i < 4; i++) {
                moves.add(movesArray.getJSONObject(i).getJSONObject("move").getString("name"));
            }
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


        public boolean isFainted() {
            return fainted;
        }

        public String getMove1() {
            return moves.get(0);
        }
        public String getMove2() {
            return moves.get(1);
        }

        public String getMove3() {
            return moves.get(2);
        }

        public String getMove4() {
            return moves.get(3);
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
        public String damageCalc(Pokemon B, Moves move) {
            int damageTaken = 0;
            String temp = "";
            if(Math.random() < move.getAccuracy()){
                double random = (Math.random() * 16 + 85)/100.0;
                if(move.getCategory().equals("physical")){
                    damageTaken = ((2*level/5 + 2) * move.getPower() * att / B.getDef())/50 + 2;
                }
                else{
                    damageTaken = ((2*level/5 + 2) * move.getPower() * speAtt / B.getSpeDef())/50 + 2;
                }
                if(move.getType().getTypeIndex() == type.getTypeIndex()||move.getType().getTypeIndex() == type.getType2Index()) {
                    damageTaken = (int)(damageTaken * 1.5);
                    System.out.println("stab");
                }
                damageTaken = (int)(damageTaken * random);
                damageTaken = (int)(damageTaken* move.getType().effectiveMultiplier(B.getType()));
                if(move.getType().effectiveMultiplier(B.getType()) == 2.0) {
                    temp = "super effective!";
                }
                else if(move.getType().effectiveMultiplier(B.getType()) == 4.0) {
                    temp = "super SUPER effective!";
                }
                else if(move.getType().effectiveMultiplier(B.getType()) == 0.5) {
                    temp = "not very effective";
                }
                else if(move.getType().effectiveMultiplier(B.getType()) == 0.25) {
                    temp = "burh";
                }
                else if(move.getType().effectiveMultiplier(B.getType()) == 0.0) {
                    temp = "no effect";
                }
            }
            else{
                temp = "the move missed";
                System.out.println(move.getAccuracy());
            }
            B.setRemainHP(B.getRemainHP()-damageTaken);
            if(B.getRemainHP() <= 0) {
                System.out.println(B.getName() + " has fainted");
                B.fainted = true;
                B.setRemainHP(0);
            }
            if(remainHP <= 0) {
                System.out.println(B.getName() + " has fainted");
                B.setRemainHP(0);
                fainted = true;
            }
            System.out.println(temp);
            return temp;
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
