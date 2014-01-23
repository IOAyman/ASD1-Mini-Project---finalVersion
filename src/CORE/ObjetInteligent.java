package CORE;

public class ObjetInteligent extends Objet{
    private String nom;

    public ObjetInteligent(String nom) { this.nom = nom; }

    @Override
    public String nom() { return this.nom; }

    /**
     * Fonction de hashage Ultime
     *
     * @ordre O(1)
     * @return hash
     */
    @Override
    public int hash() { return nom.length(); }
}
