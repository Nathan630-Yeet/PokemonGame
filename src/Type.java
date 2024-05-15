import java.util.Arrays;

public class Type {
    int typeIndex;
    double[][] chart = {
            {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.5,0.0,1.0,1.0,0.5,1.0},
            {1.0,0.5,0.5,2.0,1.0,2.0,1.0,1.0,1.0,1.0,1.0,2.0,0.5,1.0,0.5,1.0,2.0,1.0},
            {1.0,2.0,0.5,0.5,1.0,1.0,1.0,1.0,2.0,1.0,1.0,1.0,2.0,1.0,0.5,1.0,1.0,1.0},
            {1.0,0.5,2.0,0.5,1.0,1.0,1.0,0.5,2.0,0.5,1.0,0.5,2.0,1.0,0.5,1.0,0.5,1.0},
            {1.0,1.0,2.0,0.5,0.5,1.0,1.0,1.0,0.0,2.0,1.0,1.0,1.0,1.0,0.5,1.0,1.0,1.0},
            {1.0,0.5,0.5,2.0,1.0,0.5,1.0,1.0,2.0,2.0,1.0,1.0,1.0,1.0,2.0,1.0,0.5,1.0},
            {2.0,1.0,1.0,1.0,1.0,2.0,1.0,0.5,1.0,0.5,0.5,0.5,2.0,0.0,1.0,2.0,2.0,0.5},
            {1.0,1.0,1.0,2.0,1.0,1.0,1.0,0.5,0.5,1.0,1.0,1.0,0.5,0.5,1.0,1.0,0.0,2.0},
            {1.0,2.0,1.0,0.5,2.0,1.0,1.0,2.0,1.0,0.0,1.0,0.5,2.0,1.0,1.0,1.0,2.0,1.0},
            {1.0,1.0,1.0,2.0,0.5,1.0,2.0,1.0,1.0,1.0,1.0,2.0,0.5,1.0,1.0,1.0,0.5,1.0},
            {1.0,1.0,1.0,1.0,1.0,1.0,2.0,2.0,1.0,1.0,0.5,1.0,1.0,1.0,1.0,0.0,0.5,1.0},
            {1.0,0.5,1.0,2.0,1.0,1.0,0.5,0.5,1.0,0.5,2.0,1.0,1.0,0.5,1.0,2.0,0.5,0.5},
            {1.0,2.0,1.0,1.0,1.0,2.0,0.5,1.0,0.5,2.0,1.0,2.0,1.0,1.0,1.0,1.0,0.5,1.0},
            {0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,1.0,2.0,1.0,0.5,1.0,1.0},
            {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,0.5,0.0},
            {1.0,1.0,1.0,1.0,1.0,1.0,0.5,1.0,1.0,1.0,2.0,1.0,1.0,2.0,1.0,0.5,1.0,0.5},
            {1.0,0.5,0.5,1.0,0.5,2.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,1.0,1.0,0.5,2.0},
            {1.0,0.5,1.0,1.0,1.0,1.0,2.0,0.5,1.0,1.0,1.0,1.0,1.0,1.0,2.0,2.0,0.5,1.0}
        //Normal, Fire, Water, Grass, Eletric, Ice, Fighting, Poison, Ground, Flying, psychic,bug,rock,ghost,dragon,dark,steel, fairy
    };
    public Type() {
        typeIndex = 0;
    }
    public Type(String type) {
        if(type.equalsIgnoreCase("normal")) {
            typeIndex = 0;
        }
        else if(type.equalsIgnoreCase("fire")) {
            typeIndex = 1;
        }
        else if(type.equalsIgnoreCase("water")) {
            typeIndex = 2;
        }
        else if(type.equalsIgnoreCase("grass")) {
            typeIndex = 3;
        }
        else if(type.equalsIgnoreCase("electric")) {
            typeIndex = 4;
        }
        else if(type.equalsIgnoreCase("ice")) {
            typeIndex = 5;
        }
        else if(type.equalsIgnoreCase("fighting")) {
            typeIndex = 6;
        }
        else if(type.equalsIgnoreCase("poison")) {
            typeIndex = 7;
        }
        else if(type.equalsIgnoreCase("ground")) {
            typeIndex = 8;
        }
        else if(type.equalsIgnoreCase("flying")) {
            typeIndex = 9;
        }
        else if(type.equalsIgnoreCase("psychic")) {
            typeIndex = 10;
        }
        else if(type.equalsIgnoreCase("bug")) {
            typeIndex = 11;
        }
        else if(type.equalsIgnoreCase("rock")) {
            typeIndex = 12;
        }
        else if(type.equalsIgnoreCase("ghost")) {
            typeIndex = 13;
        }
        else if(type.equalsIgnoreCase("dragon")) {
            typeIndex = 14;
        }
        else if(type.equalsIgnoreCase("dark")) {
            typeIndex = 15;
        }
        else if(type.equalsIgnoreCase("steel")) {
            typeIndex = 16;
        }
        else if(type.equalsIgnoreCase("fairy")) {
            typeIndex = 17;
        }
        else {
            typeIndex = 0;
        }

    }

    public int getTypeIndex() {
        return typeIndex;
    }

    public int getType2Index() {
        return 0;
    }

    public void setTypeIndex(int typeIndex) {
        this.typeIndex = typeIndex;
    }

    public double effectiveMultiplier(Type B) {

        return chart[this.getTypeIndex()][B.getTypeIndex()]* chart[this.getTypeIndex()][B.getType2Index()];
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeIndex=" + typeIndex +
                '}';
    }
}
