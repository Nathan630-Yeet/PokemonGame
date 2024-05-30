import org.json.JSONArray;
import org.json.JSONObject;

public class Moves {
    private String name;
    private Type mType;
    private String cat;
    private int power;
    private int accuracy;
    public Moves(String name, Type type, DamageClass damage_class, int power, int accuracy) {
        this.name = name;
        this.mType = type;
        this.cat = damage_class.getName();
        this.power = power;
        this.accuracy = accuracy;
    }
    public static Moves fetchMoveDataFromAPI(JSONObject moveData) throws Exception {
        String name = moveData.getString("name");

        JSONObject typeObject = moveData.getJSONObject("type");
        Type type = new Type(typeObject.getString("name"));

        JSONObject damageClassObject = moveData.getJSONObject("damage_class");
        DamageClass damageClass = new DamageClass();
        damageClass.name = damageClassObject.getString("name");

        int power = moveData.has("power") ? moveData.getInt("power") : 0;
        int accuracy = moveData.has("accuracy") ? moveData.getInt("accuracy") : 100;

        return new Moves(name, type, damageClass, power, accuracy);
    }

    public Type getType() {
        return mType;
    }

    public String getName() {
        return name;
    }


    public String getCategory() {
        return cat;
    }

    public void setCategory(String category) {
        this.cat = category;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }




    @Override
    public String toString() {
        return "Moves{" +
                ", accuracy=" + accuracy +
                '}';
    }
}
