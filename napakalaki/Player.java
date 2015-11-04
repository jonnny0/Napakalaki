package napakalaki;

import java.util.ArrayList;

public class Player {

    private boolean dead = true;
    private String name;
    private int level = 0;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private BadStuff pendingBadStuff = new BadStuff();

    public Player() {
    }

    //constructor
    public Player(String name) {
        this.name = name;
        level = 1;
        pendingBadStuff = new BadStuff("", false); //no hay constructor por defecto

    }
    //en el constructor de copia lo hacemos así

    public Player(Player p) {
        this.dead = p.dead;
        this.hiddenTreasures = new ArrayList<Treasure>(p.hiddenTreasures);
        this.level = p.level;
        this.name = new String(p.name);
        this.pendingBadStuff.equals(p.pendingBadStuff);
        this.visibleTreasures = new ArrayList<Treasure>(p.visibleTreasures);
    }

    private void bringToLife() {
        dead = false;
    }

    public int getCombatLevel() {
        ArrayList<Treasure> tesorosEquipados = getVisibleTreasures();
        int bonusMin = 0;
        int bonusMax = 0;
        int tengoCollar = 0;
        int nivelTotal = level;

        for (int i = 0; i < tesorosEquipados.size(); i++) {
            bonusMin += tesorosEquipados.get(i).getMinBonus();
            bonusMax += tesorosEquipados.get(i).getMaxBonus();
            if (tesorosEquipados.get(i).getType() == TreasureKind.necklace) {
                tengoCollar++;
            }
        }
        if (tengoCollar > 0) {
            nivelTotal += bonusMax;
        } else {
            nivelTotal += bonusMin;
        }

        return nivelTotal;
    }

    private void incrementLevels(int i) {
        level += i;

    }

    private void decrementLevels(int i) {
        level -= i;
        if (level < 1) {
            level = 1;
        }
    }

    private void setPendingBadStuff(BadStuff b) {
        pendingBadStuff = b;

    }

    public BadStuff getPendingBadStuff() {
        return pendingBadStuff;
    }

    private void dieIfNoTreasures() {
        if (visibleTreasures.isEmpty() && visibleTreasures.isEmpty()) {
            dead = true;
        }
    }

    private void discardNecklaceIfVisible() {
        boolean encontrado = false;
        for (int i = 0; i < visibleTreasures.size() && encontrado == false; i++) {
            if (visibleTreasures.get(i).getType() == TreasureKind.necklace) {
                encontrado = true;
                CardDealer.getInstance().giveTreasureBack(visibleTreasures.get(i));
                visibleTreasures.remove(visibleTreasures.get(i));
            }
        }

    }

    private void die() {
        setLevel(1);
        CardDealer dealer = CardDealer.getInstance();
        for (int i = 0; i < visibleTreasures.size(); ++i) {
            Treasure treasure = visibleTreasures.get(i);
            dealer.giveTreasureBack(treasure);
        }

        visibleTreasures.clear();

        for (int i = 0; i < hiddenTreasures.size(); ++i) {
            Treasure treasure = hiddenTreasures.get(i);
            dealer.giveTreasureBack(treasure);
        }
        hiddenTreasures.clear();

        dieIfNoTreasures();

    }

    private int computeGoldCoinsValue(ArrayList<Treasure> t) {
        int oro = 0;
        for (int i = 0; i < t.size(); i++) {
            oro += t.get(i).getGoldCoins();
        }
        return oro / 1000;
    }

    private boolean canIBuyLevels(int l) {
        if (level + l >= 10) {
            return false;
        } else {
            return true;
        }
    }

    public void applyPrize(Monster m) {
        int levelsGanados = m.getLevelsGained();
        incrementLevels(levelsGanados);
        int nTreasures = m.getTreasuresGained();
        if (nTreasures > 0) {
            CardDealer dealer = CardDealer.getInstance();
            for (int i = 0; i < nTreasures; ++i) {
                Treasure treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }

    public void applyBadStuff(BadStuff bad) {
        int nLevels = bad.getLevels();
        decrementLevels(nLevels);
        BadStuff pendingBad = bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadStuff(pendingBad);
        aplicarBadStuff();
    }

    private void aplicarBadStuff() {
        //hago el pendingBadStuff para los ocultos
        if (getPendingBadStuff().getSpecificHiddenTreasures().isEmpty()) { //si tengo ocultos pendientes
            for (int i = 0; i < getPendingBadStuff().specificHiddenTreasures.size(); i++) { //para cada oculto pendiente
                for (int j = 0; j < hiddenTreasures.size(); j++) { //para cada oculto que tiene currentPlayer
                    if (getPendingBadStuff().getSpecificHiddenTreasures().get(i) == hiddenTreasures.get(j).getType()) {
                        hiddenTreasures.remove(j);
                        pendingBadStuff.specificHiddenTreasures.remove(i);
                    }
                }

            }
        }

        //hago el pendingBadStuff para los visibles
        if (getPendingBadStuff().getSpecificVisibleTreasures().isEmpty()) { //si tengo ocultos pendientes
            for (int i = 0; i < getPendingBadStuff().specificVisibleTreasures.size(); i++) { //para cada oculto pendiente
                for (int j = 0; j < visibleTreasures.size(); j++) { //para cada oculto que tiene currentPlayer
                    if (getPendingBadStuff().getSpecificVisibleTreasures().get(i) == visibleTreasures.get(j).getType()) {
                        visibleTreasures.remove(j);
                        pendingBadStuff.specificVisibleTreasures.remove(i);
                    }
                }

            }
        }

        int nHidden = getPendingBadStuff().getNHiddenTreasures();
        if (nHidden > 0) {
            if (hiddenTreasures.size() <= nHidden) {
                hiddenTreasures.clear();
                getPendingBadStuff().nHiddenTreasures = 0;
            } else {
                for (int i = 0; i < nHidden; i++) {
                    hiddenTreasures.remove(i);
                }
                pendingBadStuff.nHiddenTreasures = 0;
            }
        }

        int nVisible = getPendingBadStuff().getNVisibleTreasures();
        if (nVisible > 0) {
            if (visibleTreasures.size() <= nVisible) {
                visibleTreasures.clear();
                pendingBadStuff.nVisibleTreasures = 0;
            } else {
                for (int i = 0; i < nVisible; i++) {
                    visibleTreasures.remove(i);
                }
                pendingBadStuff.nVisibleTreasures = 0;
            }
        }
    }

    public boolean canMakeTreasureVisible(Treasure t) {
        boolean puedo = true;
        int numeroArmasUnaMano = 0;

        for (int i = 0; (i < visibleTreasures.size()) && (puedo == true); i++) {
            //si es de tipo armor, helmet, necklace o shoe, y además está equipado no se puede hacer visible
            if ((t.getType() == TreasureKind.armor || t.getType() == TreasureKind.helmet || t.getType() == TreasureKind.necklace || t.getType() == TreasureKind.shoe) && (t.getType() == visibleTreasures.get(i).getType())) {
                puedo = false;
            }
            //si es de tipo 2 manos y tengo algo equipado en las manos, no puedo hacerlo visible
            if (t.getType() == TreasureKind.bothHand && (visibleTreasures.get(i).getType() == TreasureKind.bothHand || visibleTreasures.get(i).getType() == TreasureKind.oneHand)) {
                puedo = false;
            }
            //si es de 1 mano y tengo algo de 2 manos, no puedo hacerlo visible
            if (t.getType() == TreasureKind.oneHand && visibleTreasures.get(i).getType() == TreasureKind.bothHand) {
                puedo = false;
            }
            //cuento las armas de 1 mano que tengo
            if (visibleTreasures.get(i).getType() == TreasureKind.oneHand) {
                numeroArmasUnaMano++;
            }

        }

        //si tengo 2 armas de una mano no puedo añadir otra arma de una mano
        if (t.getType() == TreasureKind.oneHand && numeroArmasUnaMano > 1) {
            puedo = false;
        }

        return puedo;
    }

    public int howManyVisibleTreasures(TreasureKind t) {
        int contador = 0;
        for (int i = 0; i < visibleTreasures.size(); i++) {
            if (visibleTreasures.get(i).getType() == t) {
                contador++;
            }
        }
        return contador;
    }

    public boolean isDead() {
        return dead;
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }

    public CombatResult combat(Monster m) {
        int myLevel = getCombatLevel();
        int nivelOponente = getOponentLevel(m);
        int escape;
        CombatResult combatResult;
        if (myLevel > nivelOponente) {
            applyPrize(m);
            if (level >= 10) {
                combatResult = CombatResult.WinAndWinGame;
            } else {
                combatResult = CombatResult.Win;
                discardNecklaceIfVisible();
            }
        } else {
            escape = Dice.getInstance().nextNumber();
            if (escape < 5) {
                boolean amIDead = m.kills();

                if (amIDead) {
                    die();
                    combatResult = CombatResult.LoseAndDie;
                } else {
                    BadStuff bad = m.getBadStuff();
                    applyBadStuff(bad);
                    combatResult = CombatResult.Lose;
                    if (!(this instanceof CultistPlayer)) {
                        if (this.shouldConvert()) {
                            combatResult = CombatResult.LoseAndConvert;
                        }
                    }
                }
            } else {
                combatResult = CombatResult.LoseAndScape;
            }
        }

        return combatResult;
    }

    public void makeTreasureVisible(Treasure t) {
        boolean canI = canMakeTreasureVisible(t);
        if (canI) {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }

    public void discardVisibleTreasure(Treasure t) {
        visibleTreasures.remove(t);
        if (pendingBadStuff != null && !pendingBadStuff.isEmpty()) {
            pendingBadStuff.substractVisibleTreasure(t);
        }
        dieIfNoTreasures();
    }

    public void discardHiddenTreasure(Treasure t) {
        hiddenTreasures.remove(t);
        if (pendingBadStuff != null && !pendingBadStuff.isEmpty()) {
            pendingBadStuff.substractHiddenTreasure(t);
        }
        dieIfNoTreasures();
    }

    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        int levelsMayBought = computeGoldCoinsValue(visible);
        levelsMayBought += computeGoldCoinsValue(hidden);
        boolean canI = canIBuyLevels(levelsMayBought);
        if (canI) {
            incrementLevels(levelsMayBought);
        }

        visibleTreasures.removeAll(visible);
        hiddenTreasures.removeAll(hidden);

        CardDealer dealer = CardDealer.getInstance();

        for (int i = 0; i < visible.size(); ++i) {
            Treasure treasure = visible.get(i);
            dealer.giveTreasureBack(treasure);
        }

        for (int i = 0; i < hidden.size(); ++i) {
            Treasure treasure = hidden.get(i);
            dealer.giveTreasureBack(treasure);
        }


        return canI;
    }

    public boolean validState() {
        if (pendingBadStuff.isEmpty() && hiddenTreasures.size() <= 4) {
            return true;
        } else {
            return false;
        }
    }

    public void initTreasures() {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();

        if (number > 1) {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }

        if (number == 6) { //metemos 3 tesoros
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }

    public boolean hasVisibleTreasures() {
        if (visibleTreasures.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public int getLevels() {
        return level;
    }

    public void setLevel(int l) {
        level = l;
    }

    public String getName() {
        return name;
    }

    public int getOponentLevel(Monster m) {
        return m.getBasicValue();
    }

    public boolean shouldConvert() {
        if (Dice.getInstance().nextNumber() == 6) {
            return true;
        }
        return false;
    }
}
