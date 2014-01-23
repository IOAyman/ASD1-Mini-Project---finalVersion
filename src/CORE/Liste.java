package CORE;

import java.util.NoSuchElementException;

/**
 * Liste Lineaire Chainee
 *
 * Voici notre propre implementation des LLC Imperatives
 *
 * toute insertion/suppression est faite sur place
 *
 * @author linuxer
 * @since 12/21/2013
 */
public class Liste {
    private Node head;  // tete de Liste
    private int size;   // longeur de Liste

    // Constructor
    public Liste(){
        head=new Node(null,null);
        size=0;
    }

    /**
     * How long is my List?
     *
     * @ordre O(1)
     * @return size // The Liste size
     */
    public int longueur() { return this.size; }


    /**
     * Ajouter un element a la Liste,  sur place!
     *  autrement dit, l'ajouter en tete de la Liste
     *
     * @ordre O(1)
     * @param itemToAdd //Objet a ajouter
     * @return initial given list
     */
    public Liste ajouteTete(Objet itemToAdd){
        /*Lier la tete vers le nouveau Node, juste cree,
        et etablir le lien avec l'ancien 1er element (head.next)*/
        this.head.next = new Node(itemToAdd, this.head.next);

        size++; // et bien sur incrementer l'indice de taille

        return this;    // renvoyer la liste tout entiere, comme demande
    }


    /**
     * Supprimer un element de la Liste, sur place!
     *   autrement dit, supprimer le 1er element
     *
     * @ordre O(1)
     * @return initial given Liste
     * @throws NoSuchElementException
     */
    public Liste supprimeTete() throws NoSuchElementException{
        /* Une exception de non-existance de l'element dans le
        * cas ou il n'y a pas d'element suivant (Liste est vide) */
        if (!this.head.hasNext() ) throw new NoSuchElementException();
        else {
            Node oldFirstNode = this.head.next;
            this.head.next = oldFirstNode.next;


            /* supprimer le lien entre les anciens 1er & 2e elements
            * pour qu'il soit libere au prochain tour du Runtime.gc()
            * mais en tous cas, il sera libere a la fin de l'execution de la methode */
            oldFirstNode = null;

            size--;
        }
        return this;
    }


    /**
     * Verifier si, ou pas, la Liste contient un Objet donne
     *
     * @ordre O(size) ~> Worst Case
     * @param item  // Objet donne a chercher
     * @return wheather item is member of the List or not
     */
    public boolean contient(Objet item){
        /* Pour chaque Node (step) de la liste (commençons par la tete
        * et tanque le Node existe)   Comparer les noms!
        * */
        for (Node step=this.head.next; step!=null; step=step.next)
                if (step.getNodeValue().equals(item.nom())) return true;

        return false;   // le cas ou l'element n'est pas trouve
    }


    /**
     * Les Cellules de la LLC
     */
    private class Node{
        private Objet field;    // Champ d'info
        private Node next;

        // Constructor
        Node(Objet newField, Node newNext){
            this.field=newField;
            this.next=newNext;
        }

        /* Peut etre compris de deux facons:
        * Y a-t-il un element suivant?
        * NON ( Est-ce la fin de la Liste? ) */
        private boolean hasNext(){ return this.next != null; }

        // Quelle est la valeur de la cellule courante?
        private String getNodeValue() { return this.field.nom(); }
    }
}