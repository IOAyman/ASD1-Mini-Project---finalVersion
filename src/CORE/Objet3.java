package CORE;

public class Objet3 extends Objet {
    private String nom;

    public Objet3(String n) {
        nom = n;
    }

    /**
     * Fonction de hashage
     *
     * @ordre O(nom.length())
     * @return hash
     */
    public int hash() {
        int h = 0;
        for (int i = 0; i < nom.length(); ++i) {
            int ki = nom.charAt(i);
            h = (h << 4) + ki;
            int g = h & 0xf0000000;
            if (g != 0) {
                h = h ^ (g >> 24);
                h = h ^ g;
            }
        }
        return h;
    }

    public String nom() {
        return nom;
    }
}
