package napakalaki;

public class Monster implements Card {
    //Atributos

    private String name;
    private int combatLevel;
    private Prize prize;
    private BadStuff badStuff;
    private int levelChangeAgainstCultistPlayer;

    //Constructor
    Monster(String n, int l, BadStuff b, Prize p, int levelChange) {
        this.name = n;
        this.combatLevel = l;
        this.badStuff = b;
        this.prize = p;
        this.levelChangeAgainstCultistPlayer = levelChange;
    }

    //Consultores básicos
    public String getName() {
        return name;
    }

    public int getLevel() {
        return combatLevel;
    }

    public BadStuff getBadStuff() {
        return badStuff;
    }

    public int getLevelsGained() {
        return prize.getLevel();
    }

    public int getTreasuresGained() {
        return prize.getTreasures();
    }

    //Consultores de las clases
    public Prize getPrize() {
        return prize;
    }

    //devuelve true cuando mal rollo del monstruo es muerte
    public boolean kills() {
        return badStuff.getDeath();
    }

    @Override
    public String toString() {
        return "\n\nNombre = " + name + "\nNivel de combate = " + Integer.toString(combatLevel) + "\n\nBuen rollo : \n" + prize + "\n\nMal rollo : " + badStuff;
    }

    @Override
    public int getBasicValue() {
        return getLevel();
    }

    @Override
    public int getSpecialValue() {
        return getLevel() + levelChangeAgainstCultistPlayer;
    }
    
}
