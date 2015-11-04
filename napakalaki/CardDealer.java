package napakalaki;

import java.util.ArrayList;
import java.util.Collections;

public class CardDealer {

    private static final CardDealer instance = new CardDealer();
    //atributos
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    public ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Cultist> unusedCultists = new ArrayList();

    private CardDealer() {
    }

    private void initTreasureCardDeck() {
        Treasure nuevo;

        //¡Sí mi amo!
        nuevo = new Treasure("Si mi amo", 0, 4, 7, TreasureKind.helmet);
        unusedTreasures.add(nuevo);

        //Botas de investigación
        nuevo = new Treasure("Botas de investigacion", 600, 3, 4, TreasureKind.shoe);
        unusedTreasures.add(nuevo);

        //Capucha de Cthulhu
        nuevo = new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.helmet);
        unusedTreasures.add(nuevo);

        //A prueba de babas
        nuevo = new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.armor);
        unusedTreasures.add(nuevo);

        //Botas de lluvia ácida
        nuevo = new Treasure("Botas de lluvia acida", 800, 1, 1, TreasureKind.shoe);
        unusedTreasures.add(nuevo);

        //Casco minero
        nuevo = new Treasure("Casco minero", 400, 2, 4, TreasureKind.helmet);
        unusedTreasures.add(nuevo);

        //Ametralladora Thompson
        nuevo = new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.bothHand);
        unusedTreasures.add(nuevo);

        //Camiseta de la UGR
        nuevo = new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.armor);
        unusedTreasures.add(nuevo);

        //Clavo de rail ferroviario
        nuevo = new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.oneHand);
        unusedTreasures.add(nuevo);

        //Cuchillo de sushi arcano
        nuevo = new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.oneHand);
        unusedTreasures.add(nuevo);

        //Fez alópodo
        nuevo = new Treasure("Fezalopodo", 700, 3, 5, TreasureKind.helmet);
        unusedTreasures.add(nuevo);

        //Hacha prehistórica
        nuevo = new Treasure("Hacha prehistorica", 500, 2, 5, TreasureKind.oneHand);
        unusedTreasures.add(nuevo);

        //El aparato del Pr. Tesla
        nuevo = new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.armor);
        unusedTreasures.add(nuevo);

        //Gaita
        nuevo = new Treasure("Gaita", 500, 4, 5, TreasureKind.bothHand);
        unusedTreasures.add(nuevo);

        //Insecticida
        nuevo = new Treasure("insecticida", 300, 2, 3, TreasureKind.oneHand);
        unusedTreasures.add(nuevo);

        //Escopeta de 3 cañones
        nuevo = new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.bothHand);
        unusedTreasures.add(nuevo);

        //Garabato místico
        nuevo = new Treasure("Garabato mistico", 300, 2, 2, TreasureKind.oneHand);
        unusedTreasures.add(nuevo);

        nuevo = new Treasure("La fuerza de Mr. T", 1000, 0, 0, TreasureKind.necklace);
        unusedTreasures.add(nuevo);

        //La rebeca metálica
        nuevo = new Treasure("Rebeca metalica", 400, 2, 3, TreasureKind.armor);
        unusedTreasures.add(nuevo);

        //Mazo de los antiguos
        nuevo = new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.oneHand);
        unusedTreasures.add(nuevo);

        //Necroplayboycón
        nuevo = new Treasure("Necroplayboycon", 300, 3, 5, TreasureKind.oneHand);
        unusedTreasures.add(nuevo);

        //Lanzallamas
        nuevo = new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.bothHand);
        unusedTreasures.add(nuevo);

        //Necrocomicón
        nuevo = new Treasure("Necrocomicon", 100, 1, 1, TreasureKind.oneHand);
        unusedTreasures.add(nuevo);

        //Necronomicón
        nuevo = new Treasure("Necronomicon", 800, 5, 7, TreasureKind.bothHand);
        unusedTreasures.add(nuevo);

        //Linterna a 2 manos
        nuevo = new Treasure("Linterna a 2 manos", 400, 3, 6, TreasureKind.bothHand);
        unusedTreasures.add(nuevo);

        //Necrognomicón
        nuevo = new Treasure("Necrognomicon", 200, 2, 4, TreasureKind.oneHand);
        unusedTreasures.add(nuevo);

        //Necrotelecom
        nuevo = new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.helmet);
        unusedTreasures.add(nuevo);

        //Porra preternatural
        nuevo = new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.oneHand);
        unusedTreasures.add(nuevo);

        //Tentáculo de pega
        nuevo = new Treasure("Tentaculo de pega", 200, 0, 1, TreasureKind.helmet);
        unusedTreasures.add(nuevo);

        //Zapato deja-amigos
        nuevo = new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.shoe);
        unusedTreasures.add(nuevo);

        //Shogulador
        nuevo = new Treasure("Shogulador", 600, 1, 1, TreasureKind.bothHand);
        unusedTreasures.add(nuevo);

        //Varita de atizamiento
        nuevo = new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.oneHand);
        unusedTreasures.add(nuevo);
    }

    private void initMonsterCardDeck() {
        //Defino los objetos Mal rollo y buen rollo
        BadStuff badStuff;
        Prize prizes;

        //Los array de los tipos de tesoro (visibles y no visibles)
        ArrayList<TreasureKind> tvp;
        ArrayList<TreasureKind> top;

        //3 Byakhees de bonanza
        tvp = new ArrayList();
        tvp.add(TreasureKind.armor);
        top = new ArrayList();
        top.add(TreasureKind.armor);
        badStuff = new BadStuff("Pierdes tu armadura visible y otra oculta", 0, tvp, top);
        prizes = new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badStuff, prizes, 0));

        //Chibithulhu
        tvp.clear();
        tvp.add(TreasureKind.helmet);
        badStuff = new BadStuff("Embobados con el lindo primigenio te descartas de tu casco visible.", 0, tvp, new ArrayList());
        prizes = new Prize(1, 1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badStuff, prizes, 0));

        //El sopor de Dunwich
        tvp.clear();
        tvp.add(TreasureKind.shoe);
        badStuff = new BadStuff("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, tvp, new ArrayList());
        prizes = new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badStuff, prizes, 0));

        //Ángeles de la noche ibicenca
        tvp.clear();
        tvp.add(TreasureKind.oneHand);
        top.clear();
        top.add(TreasureKind.oneHand);
        badStuff = new BadStuff("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta una mano visible y una mano oculta.", 0, tvp, top);
        prizes = new Prize(4, 1);
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, badStuff, prizes, 0));

        //El gorrón en el umbral
        badStuff = new BadStuff("Pierdes todos tus tesoros visibles.", 0, 6, 0); //tienes como mucho 6 visibles 
        prizes = new Prize(4, 1);
        unusedMonsters.add(new Monster("El gorron en el umbral", 10, badStuff, prizes, 0));

        //H. P. Munchcraft
        tvp.clear();
        tvp.add(TreasureKind.armor);
        badStuff = new BadStuff("Pierdes la armadura visible.", 0, tvp, new ArrayList());
        prizes = new Prize(2, 1);
        unusedMonsters.add(new Monster("HP Munchcraft", 6, badStuff, prizes, 0));

        //Bichgooth
        tvp.clear();
        tvp.add(TreasureKind.armor);
        badStuff = new BadStuff("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0, tvp, new ArrayList());
        prizes = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badStuff, prizes, 0));

        //El rey de rosa
        badStuff = new BadStuff("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        prizes = new Prize(4, 2);
        unusedMonsters.add(new Monster("El rey de la rosa", 13, badStuff, prizes, 0));

        //La que redacta en las tinieblas
        badStuff = new BadStuff("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prizes = new Prize(1, 1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badStuff, prizes, 0));

        //Los hondos
        badStuff = new BadStuff("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        prizes = new Prize(2, 1);
        unusedMonsters.add(new Monster("Los hondos", 8, badStuff, prizes, 0));

        //Semillas Cthulu
        badStuff = new BadStuff("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        prizes = new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badStuff, prizes, 0));

        //Dameargo
        tvp.clear();
        tvp.add(TreasureKind.oneHand);
        badStuff = new BadStuff("Te intentas escaquear. Pierdes una mano visible", 0, tvp, new ArrayList());
        prizes = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, badStuff, prizes, 0));

        //Pollipólipo volante
        badStuff = new BadStuff("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prizes = new Prize(1, 1);
        unusedMonsters.add(new Monster("Pollipolipo volante", 3, badStuff, prizes, 0));

        //Familia feliz
        badStuff = new BadStuff("La familia te atrapa. Estás muerto.", true);
        prizes = new Prize(4, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badStuff, prizes, 0));

        //Roboggoth
        tvp.clear();
        tvp.add(TreasureKind.bothHand);
        badStuff = new BadStuff("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, tvp, new ArrayList());
        prizes = new Prize(2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badStuff, prizes, 0));

        //El espia
        tvp.clear();
        tvp.add(TreasureKind.helmet);
        badStuff = new BadStuff("Te asusta en la noche. Pierdes un casco visible", 2, tvp, new ArrayList());
        prizes = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espia", 5, badStuff, prizes, 0));

        //El lenguas
        badStuff = new BadStuff("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prizes = new Prize(1, 1);
        unusedMonsters.add(new Monster("El lenguas", 20, badStuff, prizes, 0));

        //Bicéfalo
        tvp.clear();
        tvp.add(TreasureKind.bothHand);
        tvp.add(TreasureKind.oneHand);
        tvp.add(TreasureKind.oneHand);
        badStuff = new BadStuff("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, tvp, new ArrayList());
        prizes = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bicefalo", 20, badStuff, prizes, 0));

        //El mal indecible impronunciable
        tvp.clear();
        tvp.add(TreasureKind.oneHand);
        badStuff = new BadStuff("Pierdes una mano visible.", 0, tvp, new ArrayList());
        prizes = new Prize(3, 1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badStuff, prizes, -2));

        //Testigos oculares
        badStuff = new BadStuff("Pierdes tus tesoros visibles. Jajaja.", 0, 6, 0); //tienes como mucho 6 visibles 
        prizes = new Prize(2, 1);
        unusedMonsters.add(new Monster("Testigos oculares", 6, badStuff, prizes, +2));

        //El gran Cthulhu
        badStuff = new BadStuff("Hoy no es tu día de suerte. Mueres.", true);
        prizes = new Prize(2, 5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, badStuff, prizes, +4));

        //Serpiente politico
        tvp.clear();
        badStuff = new BadStuff("Tu gobierno te recorta 2 niveles.", 2, 0, 0);
        prizes = new Prize(2, 1);
        unusedMonsters.add(new Monster("Serpiente politico", 8, badStuff, prizes, -2));

        //Felpuggoth
        tvp.clear();
        tvp.add(TreasureKind.helmet);
        tvp.add(TreasureKind.armor);
        top.clear();
        top.add(TreasureKind.oneHand);
        top.add(TreasureKind.bothHand);
        badStuff = new BadStuff("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 2, tvp, top);
        prizes = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badStuff, prizes, +5));

        //Shoggoth
        badStuff = new BadStuff("Pierdes 2 niveles.", 2, 0, 0);
        prizes = new Prize(4, 2);
        unusedMonsters.add(new Monster("Shoggoth", 16, badStuff, prizes, -5));

        //Lolitagooth
        badStuff = new BadStuff("Pintalabios negro. Pierdes 2 niveles.", 2, 0, 0);
        prizes = new Prize(1, 1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badStuff, prizes, +3));

    }

    private void shuffleTreasures() {
        //Ordenar forma aleatoria   unusedTreasures
        Collections.shuffle(unusedTreasures);
    }

    private void shuffleMonsters() {
        Collections.shuffle(unusedMonsters);
    }

    public static CardDealer getInstance() {
        return instance;
    }

    public Treasure nextTreasure() {

        if (unusedTreasures.isEmpty()) {
            unusedTreasures = new ArrayList(usedTreasures);
            usedTreasures.clear();
            this.shuffleMonsters();
        }

        this.giveTreasureBack(unusedTreasures.get(0));
        unusedTreasures.remove(0);

        return usedTreasures.get(usedTreasures.size() - 1);
    }

    public Monster nextMonster() {

        if (unusedMonsters.isEmpty()) {
            unusedMonsters = new ArrayList(usedMonsters);
            usedMonsters.clear();
            this.shuffleMonsters();
        }

        this.giveMonsterBack(unusedMonsters.get(0));
        unusedMonsters.remove(0);

        return usedMonsters.get(usedMonsters.size() - 1);
    }

    public void giveTreasureBack(Treasure t) {
        usedTreasures.add(t);
    }

    public void giveMonsterBack(Monster m) {
        usedMonsters.add(m);
    }

    public void initCards() {//se inicializan las cartas
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
        this.initCultistCardDeck();
        this.shuffleTreasures();
        this.shuffleMonsters();
        this.shuffleCultist();
    }

    private void shuffleCultist() {
        Collections.shuffle(unusedCultists);
    }

    private void initCultistCardDeck() {
        Cultist nuevo;

        nuevo = new Cultist("Sectario1", 1);
        unusedCultists.add(nuevo);

        nuevo = new Cultist("Sectario2", 2);
        unusedCultists.add(nuevo);

        nuevo = new Cultist("Sectario3", 1);
        unusedCultists.add(nuevo);

        nuevo = new Cultist("Sectario4", 2);
        unusedCultists.add(nuevo);

        nuevo = new Cultist("Sectario5", 1);
        unusedCultists.add(nuevo);

        nuevo = new Cultist("Sectario6", 1);
        unusedCultists.add(nuevo);
    }

    public Cultist nextCultist() { //no es necesario devolver las cartas al mazo
        Cultist next = unusedCultists.get(0);
        unusedCultists.remove(0);
        return next;
    }
}
