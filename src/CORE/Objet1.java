package CORE;

/**
 * Implementation de la fonction de hashage standard de Java
 *      hash(s) = s[0]×31^(n−1) + ... + s[n−2]×31 + s[n−1]
 */
public class Objet1 extends Objet{
    private String nom;

    // Constructor
    public Objet1(String nom) { this.nom = nom; }

    @Override
    public String nom() { return this.nom; }

    /**
     * Fonction de hashage
     *
     * @ordre O(nom.length())
     * @return hash
     */
    @Override
    public int hash() {
        int hash=0;
        for (int i=0;i<nom.length();i++)
            hash+=nom.charAt(i)*power(31, nom.length() - 1 - i);
        return hash;
    }

    // Calculer a^n
    private int power(int a, int n) {
        int res = 1;
        for (int i=0; i<n; i++) res *=a;
        return res;
    }
}
