package napakalaki;

public class CultistPlayer extends Player {

    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;

    public CultistPlayer(Player p, Cultist c) {
        super(p);
        this.myCultistCard = c;
        ++totalCultistPlayers;
    }

    //¿NECESARIO NO???
    public Cultist getCultistCard(){    
        return myCultistCard;
    }
    
    public int getCombatLevel() {
        return (super.getCombatLevel() + myCultistCard.getSpecialValue());
    }

    @Override
    public boolean shouldConvert() {
        return false;
    }

    @Override
    public int getOponentLevel(Monster m) {
        return m.getSpecialValue();

    }

    public int computeGoldCoinsValue(Treasure t) {
        return t.getGoldCoins() * 2; 
    }

    public static int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
}