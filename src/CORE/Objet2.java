package CORE;

/**
 * Imlementation de la fonction de hashage proposee
 *      if ( i == -1 ) Hash = 5381
 *      else Hash(i)=Hash(i-1)+33^s[i]
 */
public class Objet2 extends Objet {
    private String nom;

    // Constructor
    public Objet2(String nom) { this.nom = nom; }

    @Override
    public String nom() { return this.nom; }

    /**
     * Fonction de hashage
     *
     * @ordre O(nom.length())
     * @return hash
     */
    @Override
    public int hash() { return hash(this.nom.length()-1); }

    // Implementation de Hash()
    private int hash(int i)
        { return (i==-1)? 5381 : hash(i-1)*33^this.nom.charAt(i); }
}