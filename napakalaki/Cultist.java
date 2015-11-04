
package napakalaki;

public class Cultist implements Card {
    private String name;
    private int gainedLevels;
    
    public Cultist(String name, int gainedLevels) {
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    public String getName() {
        return name;
    }
    public int getGainedLevels() {
        return gainedLevels;
    }
    
    @Override
    public int getBasicValue() {
        return gainedLevels;
    }
    
    @Override
    public int getSpecialValue(){
        return getBasicValue()*CultistPlayer.getTotalCultistPlayers();
    }
    
}