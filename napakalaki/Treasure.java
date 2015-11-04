package napakalaki;

public class Treasure implements Card {

    private String name;
    private int goldCoins, minBonus, maxBonus;
    TreasureKind type;

    public Treasure() {
    }

    //constructor con parametros
    public Treasure(String n, int g, int min, int max, TreasureKind t) {
        name = n;
        goldCoins = g;
        minBonus = min;
        maxBonus = max;
        type = t;
    }

    public String getName() {
        return name;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public int getMinBonus() {
        return minBonus;
    }

    public int getMaxBonus() {
        return maxBonus;
    }

    public TreasureKind getType() {
        return type;
    }

    @Override
    public String toString() {
        return "\n\nNombre = " + name + "\nPiezas de oro = " + Integer.toString(goldCoins) + "\nBonus mínimo = " + Integer.toString(minBonus) + "\nBonus máximo = " + Integer.toString(maxBonus) + "\nTipo de tesoro = " + type;
    }

    @Override
    public int getBasicValue() {
        return getMinBonus();
    }

    @Override
    public int getSpecialValue() {
        return getMaxBonus();
    }
}
