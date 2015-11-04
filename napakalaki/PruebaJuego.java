package napakalaki;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/**
 *
 * @author Antonio Espinosa Jiménez, Silvia Mikue Yembi Abaga, Mario Andrés
 * Pérez Batanero
 */
//El esquema del napakalakiModel es el siguiente:
//
//(0) initGame() rellena el ArrayList de jugadores, inicializa las cartas,  
//        En el primer turno de cada jugador, tira un dado:
//        si sale 1, empieza con un tesoro oculto
//        si sale de 2 a 5, empieza con 2 tesoros ocultos
//        si sale un 6, empieza con 3 tesoros ocultos
//        
//        + Se repite hasta el que jugador alcanza el nivel 10:
//        
//            (1) Comprar niveles con las cartas ocultas o visibles actuales (debe poder elegir).
//
//            (2) Sacar un monstruo de la baraja de unusedMonster.
//
//            (3) Combatir con el monstruo (una vez terminado el combate se mete en la baraja usedMonster).
//
//            (4) Al final del turno el jugador puede equiparse con nuevos tesoros ocultos (debe poder elegir).
public class PruebaJuego {

    public static void main(String[] args) {

        //la única instancia de Napakalaki se llama napakalakiModel
        Napakalaki napakalakiModel = Napakalaki.getInstance();

        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance(napakalakiView);
 
        

        //creo la colección con el nombre de los jugadores
        ArrayList<String> names = new ArrayList<String>();

        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        names = namesCapture.getNames();
//        names.add("jugagor 1");
//        names.add("jugador 2");     //*********** NOMBRES manual para probar mas rapido
////        names.add("jugador 3");
        
        napakalakiModel.initGame(names);
        
   
        napakalakiView.setNapakalaki(napakalakiModel);

        napakalakiView.showView();

    }
}