
package napakalaki;


public class Prize {
    //Atributos
    private int treasures, levels;
    
    //Constructor con parámetros
    Prize(int t, int l) {
        this.treasures = t;
        this.levels = l;
    }
    
    //Consultores básicos
    public int getTreasures() {
        return treasures;
    }
    
    public int getLevel() {
        return levels;
    }

    @Override
    public String toString() {
        return "Tesoros = " + Integer.toString(treasures) + "\nNiveles = " + Integer.toString(levels);
    }

}
