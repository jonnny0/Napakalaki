package napakalaki;

import java.util.ArrayList;
import java.util.Random;

public class Napakalaki {

    private static final Napakalaki instance = new Napakalaki();
    //atributos de referencia
    private Monster currentMonster;
    private CardDealer dealer;
    private ArrayList<Player> players;
    private Player currentPlayer;

    private void initPlayers(ArrayList<String> names) {
        players = new ArrayList();
        for (int i = 0; i < names.size(); i++) {   //crea jugadores
            players.add(new Player(names.get(i)));
        }        
    }

    private Player nextPlayer() {
        int indice = 0;
        
        if (currentPlayer == null) {//condicion de empezar la partida) //Se elige al primer jugador de forma aleatoria
            Random r = new Random();
            indice = r.nextInt(players.size());
        } else {   //Se pasa al siguiente jugador, si es el ultimo se pasa al primero USO EQUALS para comprobar estado, no identidad
            if (currentPlayer.equals(players.get(players.size() - 1))) {
                indice = 0;
            } else {
                indice = players.indexOf(currentPlayer);
                indice++;
            }
        }
        return players.get(indice);
    }

    private boolean nextTurnAllowed() {
        return currentPlayer.validState();   //comprueba si el jugador activo cumple con las reglas de juego
        //devuelve false si el jugador actual no puede pasar turno
    }

    public static Napakalaki getInstance() {
        return instance;
    }

    public CombatResult developCombat() {
        CombatResult combatResult = currentPlayer.combat(currentMonster);
        if (combatResult == CombatResult.LoseAndConvert) {
            Cultist cartaRobada = dealer.nextCultist();
            CultistPlayer nuevoCultist = new CultistPlayer(currentPlayer, cartaRobada);
            players.remove(currentPlayer);
            players.add(nuevoCultist);
            currentPlayer = nuevoCultist;            
        }
        dealer.giveMonsterBack(currentMonster);
        return combatResult;
    }

    public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
        for (Treasure t : treasures) {
            currentPlayer.discardVisibleTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }

    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
        
        for (Treasure t : treasures) {
            currentPlayer.discardHiddenTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }

    public void makeTreasuresVisible(ArrayList<Treasure> treasures) {
        
        for (Treasure t : treasures) {
            currentPlayer.makeTreasureVisible(t);
        }
    }

    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        return currentPlayer.buyLevels(visible, hidden);
    }

    public void initGame(ArrayList<String> names) {
        dealer = CardDealer.getInstance();
        this.initPlayers(names);
        dealer.initCards();
        this.nextTurn();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Monster getCurrentMonster() {
        return currentMonster;
    }

    public boolean nextTurn() {
        boolean stateOK;
        
        if (currentPlayer != null) {
            stateOK = this.nextTurnAllowed(); 
        } else {
            stateOK = true;
        }
        
        if (stateOK) {
            currentMonster = dealer.nextMonster();
            currentPlayer = this.nextPlayer();
            boolean dead = currentPlayer.isDead();

            if (dead) {
                currentPlayer.initTreasures();
            }
        }        
        return stateOK;
    }

    public boolean endOfGame(CombatResult result) {
        return result == CombatResult.WinAndWinGame;
    }
}
