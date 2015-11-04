package napakalaki;

import java.util.*;

public class BadStuff {
    //Atributos

    private String text;
    public int levels, nVisibleTreasures, nHiddenTreasures;
    private boolean death;
    public ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    public ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();

    public BadStuff() {
    }

    //Constructores
    public BadStuff(String t, int l, int nVisible, int nHidden) {
        this.text = t;
        this.levels = l;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.death = false;

    }

    public BadStuff(String t, int l, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h) {
        this.text = t;
        this.levels = l;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
        this.specificHiddenTreasures = h;
        this.specificVisibleTreasures = v;
        this.death = false;
    }

    public BadStuff(String t, boolean death) {
        this.text = t;
        this.death = death;
        this.levels = 0;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
    }

    public boolean isEmpty() {
        if ((nVisibleTreasures == 0) && (nHiddenTreasures == 0) && (levels == 0)
                && (specificHiddenTreasures.isEmpty()) && (specificVisibleTreasures.isEmpty())) {
            return true;
        }
        return false;
    }

    public int getLevels() {
        return levels;
    }

    public int getNVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getNHiddenTreasures() {
        return nHiddenTreasures;
    }

    public void setNHidden(int n) {
        nHiddenTreasures = n;
    }
    
    public void setNVisible(int n) {
        nVisibleTreasures = n;
    }
    

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }

    public void substractVisibleTreasure(Treasure t) {
        if (!death) {
            specificVisibleTreasures.remove(t);
        }
    }

    public void substractHiddenTreasure(Treasure t) {
        if (!death) {
            specificHiddenTreasures.remove(t);
        }
    }

    public String getText() {
        return text;
    }

    public boolean getDeath() {
        return death;
    }

    private void addHidden(TreasureKind t) {
        specificHiddenTreasures.add(t);
    }

    private void addVisible(TreasureKind t) {
        specificVisibleTreasures.add(t);
    }

    public BadStuff adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        //tenemos que devolver un badStuff que contenga los tesoros que coinciden 
        //con los que tenemos localmente y los que nos pasan
        //almacenamos lo que vamos a perder

        BadStuff objetosAPerder = new BadStuff("PERDER", 0, nVisibleTreasures, nHiddenTreasures);
        for (int i = 0; i < h.size(); i++) { //los que tiene current player
            for (int j = 0; j < specificHiddenTreasures.size(); j++) { //los que tiene el monstruo
                if (specificHiddenTreasures.get(j) == h.get(i).getType()) {
                    objetosAPerder.addHidden(specificHiddenTreasures.get(j));
                    specificHiddenTreasures.remove(j);
                }
            }
        }

        for (int i = 0; i < v.size(); i++) { //los que tiene current player
            for (int j = 0; j < specificVisibleTreasures.size(); j++) { //los que tiene el monstruo
                if (specificVisibleTreasures.get(j) == v.get(i).getType()) {
                    objetosAPerder.addVisible(specificVisibleTreasures.get(j));
                    specificVisibleTreasures.remove(j);
                }
            }
        }

        return objetosAPerder;
    }

    public boolean myBadStuffIsDeath() {

        if (death == true) {//devuelve true si en su mal rollo es muerte
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nTexto = " + text + "\nNiveles = " + Integer.toString(levels) + "\nTesoros visibles = " + Integer.toString(nVisibleTreasures) + "\nTesoros ocultos = " + Integer.toString(nHiddenTreasures) + "\nTesoros específicos ocultos = " + specificHiddenTreasures + "\nTesoros específicos visibles = " + specificVisibleTreasures + "\nMuerte = " + death;
    }
}