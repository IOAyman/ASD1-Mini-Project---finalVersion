package CORE;

/**
 * Imlementation de la TableDeHachage
 *
 */
public class TableDeHachage {
    int tableSize;  // taille de la TableDeHachage
    Liste[] table;

    // Constructor
    public TableDeHachage(int tableSize) {
        this.tableSize = tableSize;

        this.table = new Liste[tableSize];  // Initialisation de la TableDeHachage
    }

    /**
     * Une methode qui renvoit le bon index pour un Objet dans la TableDeHachage
     *
     * @ordre Depend de item.getClass
     * @param item  //L'Objet dont on cherche la bonne position
     * @return position
     */
    private int getTheRightPosition(Objet item) {
        int hash = item.hash();
//        return (hash < 0)? hash*-1%tableSize : hash%tableSize;
        return (hash < 0) ? ((hash % tableSize) + tableSize):(hash % tableSize);
    }

    /**
     * Ajouter un Objet a la TableDeHachage
     *
     * @ordre Depend de objetToAdd.getClass
     * @param objetToAdd //Objet a ajouter
     */
    public void ajoute(Objet objetToAdd){
        // Trouver la bonne position pour le nouveau element
        int position = getTheRightPosition(objetToAdd);

        // Si on a deja ajouter d'autres elements dans la meme position
        if (table[position]!=null) {
            // la redendance des elements n'est la bienvenue
            if (!table[position].contient(objetToAdd)) {
                table[position].ajouteTete(objetToAdd);
            }
        } else { // pas encore rien ajoute aucun element a cette position

            table[position] = new Liste();
            table[position].ajouteTete(objetToAdd);
        }


        //incrementer le cpt de la longueur de la Liste a cette position
//        tablePositionSize[position]++;
    }

    /**
     * Recherche d'element dans la TableDeHachage
     *
     * @ordre O(table[position].length^2) ~> Worst Case
     * @param wantedObjet //Objet a chercher
     * @return wheather it does exist or not
     */
    public boolean contient(Objet wantedObjet){
        int position = getTheRightPosition(wantedObjet);
        return table[position] != null && table[position].contient(wantedObjet);

        /* Ce qui peut etre traduit exactement commInteger.MAX_VALUEe suit:

        if (table[position]!=null)
            return table[position].contient(wantedObjet);
        else return false;*/
    }

    /**
     * Quelle est la Liste la plus remplie?
     *
     * @ordre ~2*tableSize = O(tableSize) ~> Worst case
     * @return {indice de la Liste la plus longue dans TableDeHachage , sa taille}
     */
    public int[] remplissageMax(){
        int positionMax = 0;
        // On veut bien commencer par la premiere case non null
        // pour ne pas avoir des problemes a la comparaison plus tard
        for (int i=0; i<table.length; i++)
            if (table[i] != null){
                positionMax = i;
                break;  // Interrempre la boucle for
            }

        /* Dans le cas ou tout la TableDeHachage est vide
        * l'index positionMax sera surement ==0
        * et la Liste associee surement null ! */
        if ( table[positionMax] == null ) return new int[] {0, 0};

        else {
            for (int i=positionMax+1; i<table.length; i++)
                if (table[i]!=null)  // Eviter NullPointerException !
                    if  (table[i].longueur() > table[positionMax].longueur())
                        positionMax = i;

            return new int[] {positionMax, table[positionMax].longueur()};
        }
    }
}