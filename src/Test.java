import CORE.Liste;
import CORE.TableDeHachage;

import java.util.NoSuchElementException;

public class Test {

    public static void main(String[] args) {
        test1a();
        test1b();
        test2();
        test3();
        ExtraClass.reponseAVotreQuestion();
        test4();
        ExtraClass.test4_forObjetUltime();


        /*
        SVP, activez chaque test à part =)
        Je pige bien la raison des resultats des trois premiers tests
        C'est principalement a cause de la class Prng et c'est variable Statiques


        Le truc que je ne comprend pas est dans le TEST 04.
        Je ne comprend pas pourquoi ça genere une exception [ArrayIndexOutOfBoundsException]
        Je crois que c'est qqchose du genre saturation mémoire :/
        Mais comment? plus en detaille!
        J'ai aussi re-verifie l'implementation de la TableDeHachage.



         */

        // TEST 01 ---------------------------------------------------------------
//        test4();                       //  873 5
//        ExtraClass.test4_forObjet1();  // 1506 4
//        ExtraClass.test4_forObjet2();  // 2067 5
//        System.out.println();
        // FIN 01 ----------------------------------------------------------------

        // TEST 02 ---------------------------------------------------------------
//        test4();                        // 873  5
//        ExtraClass.test4_forObjet2();   // 905  4
//        ExtraClass.test4_forObjet1();   // 269  4
//        System.out.println();
        // FIN 02 ----------------------------------------------------------------

        // TEST 03 ---------------------------------------------------------------
//        test4();                       // 873  5
//        ExtraClass.test4_forObjet1();  // 1506 4
//        ExtraClass.test4_forObjet2();  // 2067 5
//        System.out.println();
//
//        test4();                       // 2393 5
//        System.out.println();
//
//        test4();                       //  742 5
//        ExtraClass.test4_forObjet2();  //  104 6
//        ExtraClass.test4_forObjet1();  // 2765 5
//        System.out.println();
//
//        ExtraClass.test4_forObjet1();  //  291 4
//        ExtraClass.test4_forObjet2();  //  559 5
//        ExtraClass.test4_forObjet2();  //  139 5
//        test4();                       //  257 4
//        System.out.println();
        // FIN 03 ----------------------------------------------------------------

        // TEST 04 ---------------------------------------------------------------
//        test4();
//        test4();
        // FIN 04 ----------------------------------------------------------------

        // TEST 05 ---------------------------------------------------------------
//        ExtraClass.test4_forObjet1();
//        test4();
        // FIN 05 ----------------------------------------------------------------

    }

    /* Cette fonction vérifie que les fonctions de hash se comportent bien de la
     * manière attendue. */
    public static void test1a() {
        System.out.print("test1a ");

        System.out.print(new CORE.Objet1("").hash()+" ");
        System.out.print(new CORE.Objet1("coucou").hash()+" ");
        System.out.print(new CORE.Objet1("Quelques tests").hash()+" ");
        System.out.print(new CORE.Objet1("pour s'assurer").hash()+" ");
        System.out.print(new CORE.Objet1("que le travail").hash()+" ");
        System.out.print(new CORE.Objet1("est personnel").hash()+" ");
        System.out.print(new CORE.Objet1("sortie").hash()+" ");

        System.out.println("end");
    }


    public static void test1b() {
        System.out.print("test1b ");

        System.out.print(new CORE.Objet2("").hash()+" ");
        System.out.print(new CORE.Objet2("coucou").hash()+" ");
        System.out.print(new CORE.Objet2("Quelques tests").hash() + " ");
        System.out.print(new CORE.Objet2("pour s'assurer").hash()+" ");
        System.out.print(new CORE.Objet2("que le travail").hash() + " ");
        System.out.print(new CORE.Objet2("est personnel").hash()+" ");
        System.out.print(new CORE.Objet2("sortie").hash()+" ");

        System.out.println("end");
    }


    /* Cette fonction vérifie votre implémentation des listes. */
    public static void test2() {
        System.out.print("test2 ");
        Liste l = new Liste();
        CORE.Objet o = new CORE.Objet2("1");
        l.ajouteTete(o);
        System.out.print(l.longueur()+" ");
        l.ajouteTete(new CORE.Objet2("2")).ajouteTete(new CORE.Objet2("3"));
        System.out.print(l.contient(o)+" ");
        System.out.print(l.longueur()+" ");
        System.out.print(l.contient(new CORE.Objet2("4"))+" ");
        System.out.print(l.contient(new CORE.Objet2("2"))+" ");
        System.out.print(l.supprimeTete().longueur()+" ");
        System.out.print(l.contient(new CORE.Objet2("3"))+" ");
        System.out.print(l.contient(o)+" ");
        try {
           System.out.print("1 ");
           l.supprimeTete();
           System.out.print(l.longueur()+" ");
           System.out.print("2 ");
           l.supprimeTete();
           System.out.print(l.longueur()+" ");
           System.out.print("3 ");
           l.supprimeTete();
           System.out.print("4 ");
        } catch (NoSuchElementException e) {
           System.out.print("5 ");
           System.out.print(l.longueur()+" ");
        } catch (Exception e) {
           System.out.print("6 ");
           System.out.print(l.longueur()+" ");
        }
        l.ajouteTete(new CORE.Objet2("5"));
        System.out.print(l.longueur()+" ");
        System.out.print(l.contient(new CORE.Objet2("5"))+" ");
        System.out.println("end");
    }


    /* Cette fonction vérifie votre gestion des collisions. Ces deux chaînes ont
     * quelque chose de particulier. Quoi donc ? */
    public static void test3() {
        System.out.print("test3 ");
        TableDeHachage t = new TableDeHachage(10);
        t.ajoute(new CORE.Objet1("FB"));
        System.out.print(t.contient(new CORE.Objet1("Ea")));
        System.out.println(" end");
    }
      

    /* Cette fonction vérifie que la table de hachage se comporte de la manière
     * attendue, en générant des chaînes aléatoires, et en les ajoutant
     * successivement dans la table de hachage. Cette fonction utilise CORE.Objet3,
     * avec une fonction de hash déjà écrite, pour ne pas vous pénaliser si vous
     * n'avez pas réussi à faire la partie 1. */
    public static void test4() {
        System.out.print("test4 ");
        TableDeHachage t = new TableDeHachage(3000);
        String[] ts = new String[1500];
        for (int i = 0; i < 1500; i++) {
            t.ajoute(new CORE.Objet3("chaine"+Prng.next()));
            ts[i] = new CORE.Objet3("chaine"+Prng.next()).nom();
        }

        System.out.print(t.contient(new CORE.Objet3(""))+" ");
        System.out.print(t.contient(new CORE.Objet3("chaine"))+" ");
        System.out.print(t.contient(new CORE.Objet3("eniach"))+" ");
        System.out.print(t.contient(new CORE.Objet3("chaine877819790"))+" ");
        System.out.print(t.contient(new CORE.Objet3("chaine878197790"))+" ");
        System.out.print(t.contient(new CORE.Objet3("chaine1517273377"))+" ");
        System.out.print(t.contient(new CORE.Objet3("chaine1168753377"))+" ");
        System.out.print(t.contient(new CORE.Objet3("chaine1477863342"))+" ");
        System.out.print(t.contient(new CORE.Objet3("chaine1338643342"))+" ");
        System.out.print(t.contient(new CORE.Objet3("chaine1715469037"))+" ");
        int[] remplissage = t.remplissageMax();
        assert remplissage.length == 2;
        System.out.println(remplissage[0] + " " + remplissage[1] + " end");
    }

}

class Prng {
    static int seed = 1;
    static int m = 2147483647;  // == Integer.MAX_VALUE
    static int a = 16807;       //
    static int b = 0;

    static int next() {
        seed = (int) ((((long) seed) * a + b) % m);
        /*  Le truc que je ne peux comprendre c'est que pourquoi l'addtion
         * du b tanqu'il sera toujour le mm 0 ?
         * a moins que le casting y joue un role dont je ne pige pas :/ */
        return seed;
    }
}
