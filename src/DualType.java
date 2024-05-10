public class DualType extends Type {
    int type2Index;
    public DualType(String typeA, String type) {
        super(typeA);
        if(type.equalsIgnoreCase("normal")) {
            type2Index = 0;
        }
        else if(type.equalsIgnoreCase("fire")) {
            type2Index = 1;
        }
        else if(type.equalsIgnoreCase("water")) {
            type2Index = 2;
        }
        else if(type.equalsIgnoreCase("grass")) {
            type2Index = 3;
        }
        else if(type.equalsIgnoreCase("electric")) {
            type2Index = 4;
        }
        else if(type.equalsIgnoreCase("ice")) {
            type2Index = 5;
        }
        else if(type.equalsIgnoreCase("fighting")) {
            type2Index = 6;
        }
        else if(type.equalsIgnoreCase("poison")) {
            type2Index = 7;
        }
        else if(type.equalsIgnoreCase("ground")) {
            type2Index = 8;
        }
        else if(type.equalsIgnoreCase("flying")) {
            type2Index = 9;
        }
        else if(type.equalsIgnoreCase("psychic")) {
            type2Index = 10;
        }
        else if(type.equalsIgnoreCase("bug")) {
            type2Index = 11;
        }
        else if(type.equalsIgnoreCase("rock")) {
            type2Index = 12;
        }
        else if(type.equalsIgnoreCase("ghost")) {
            type2Index = 13;
        }
        else if(type.equalsIgnoreCase("dragon")) {
            type2Index = 14;
        }
        else if(type.equalsIgnoreCase("dark")) {
            type2Index = 15;
        }
        else if(type.equalsIgnoreCase("steel")) {
            type2Index = 16;
        }
        else if(type.equalsIgnoreCase("fairy")) {
            type2Index = 17;
        }
        else {
            type2Index = 0;
        }

    }
    public DualType(){
        typeIndex = 0;
        type2Index = 1;
    }
    public DualType(String A){
        super(A);

    }

    @Override
    public int getTypeIndex() {
        return super.getTypeIndex();
    }

    public int getType2Index() {
        return type2Index;
    }

    public double effectiveMultiplier(DualType B) {
        return chart[this.getTypeIndex()][B.getTypeIndex()] * chart[this.getTypeIndex()][B.getType2Index()];
    }
}
