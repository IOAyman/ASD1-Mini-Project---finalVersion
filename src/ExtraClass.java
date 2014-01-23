import CORE.Objet1;
import CORE.ObjetInteligent;
import CORE.TableDeHachage;

/**
 * Created by linuxer on 1/7/14.
 */
public class ExtraClass {

    public static void reponseAVotreQuestion() {
        System.out.printf("\nPardon pour cette interruption :/ Mais pour réponse " +
                "à la question posée (au commentaire) à propos de cette étape là,\nVoici votre réponse:\n" +
                "FB=%d  its hash is  %d\nEa=%d  its hash is  %d\n\n",
                'F' + 'B', new Objet1("FB").hash(),
                'E' + 'a', new Objet1("Ea").hash());
    }

    public static void test4_forObjet1(){
        System.out.print("test4[1] ");
        TableDeHachage table = new TableDeHachage(3000);
        String[] tsO1 = new String[1500];
        for (int i = 0; i < 1500; i++) {
            table.ajoute(new CORE.Objet1("chaine"+Prng.next()));
            tsO1[i] = new CORE.Objet1("chaine"+Prng.next()).nom();
        }

        System.out.print(table.contient(new CORE.Objet1(""))+" ");
        System.out.print(table.contient(new CORE.Objet1("chaine"))+" ");
        System.out.print(table.contient(new CORE.Objet1("eniach"))+" ");
        System.out.print(table.contient(new CORE.Objet1("chaine877819790"))+" ");
        System.out.print(table.contient(new CORE.Objet1("chaine878197790"))+" ");
        System.out.print(table.contient(new CORE.Objet1("chaine1517273377"))+" ");
        System.out.print(table.contient(new CORE.Objet1("chaine1168753377"))+" ");
        System.out.print(table.contient(new CORE.Objet1("chaine1477863342"))+" ");
        System.out.print(table.contient(new CORE.Objet1("chaine1338643342"))+" ");
        System.out.print(table.contient(new CORE.Objet1("chaine1715469037"))+" ");
        int[] remplissage = table.remplissageMax();
        assert remplissage.length == 2;
        System.out.println(remplissage[0] + " " + remplissage[1] + " end");
    }

    public static void test4_forObjet2(){
        System.out.print("test4[2] ");
        TableDeHachage table = new TableDeHachage(3000);
        String[] tsO2 = new String[1500];
        for (int i = 0; i < 1500; i++) {
            table.ajoute(new CORE.Objet2("chaine"+Prng.next()));
            tsO2[i] = new CORE.Objet2("chaine"+Prng.next()).nom();
        }

        System.out.print(table.contient(new CORE.Objet2(""))+" ");
        System.out.print(table.contient(new CORE.Objet2("chaine"))+" ");
        System.out.print(table.contient(new CORE.Objet2("eniach"))+" ");
        System.out.print(table.contient(new CORE.Objet2("chaine877819790"))+" ");
        System.out.print(table.contient(new CORE.Objet2("chaine878197790"))+" ");
        System.out.print(table.contient(new CORE.Objet2("chaine1517273377"))+" ");
        System.out.print(table.contient(new CORE.Objet2("chaine1168753377"))+" ");
        System.out.print(table.contient(new CORE.Objet2("chaine1477863342"))+" ");
        System.out.print(table.contient(new CORE.Objet2("chaine1338643342"))+" ");
        System.out.print(table.contient(new CORE.Objet2("chaine1715469037"))+" ");
        int[] remplissage = table.remplissageMax();
        assert remplissage.length == 2;
        System.out.println(remplissage[0] + " " + remplissage[1] + " end");
    }

    public static void test4_forObjet3() {
        Test.test4();
    }

    public static void test4_forObjetUltime(){
        System.out.print("test4[Ultime] ");
        TableDeHachage table = new TableDeHachage(3000);
        String[] tsO2 = new String[1500];
        for (int i = 0; i < 1500; i++) {
            table.ajoute(new ObjetInteligent("chaine"+Prng.next()));
            tsO2[i] = new ObjetInteligent("chaine"+Prng.next()).nom();
        }

        System.out.print(table.contient(new CORE.ObjetInteligent(""))+" ");
        System.out.print(table.contient(new CORE.ObjetInteligent("chaine"))+" ");
        System.out.print(table.contient(new CORE.ObjetInteligent("eniach"))+" ");
        System.out.print(table.contient(new CORE.ObjetInteligent("chaine877819790"))+" ");
        System.out.print(table.contient(new CORE.ObjetInteligent("chaine878197790"))+" ");
        System.out.print(table.contient(new CORE.ObjetInteligent("chaine1517273377"))+" ");
        System.out.print(table.contient(new CORE.ObjetInteligent("chaine1168753377"))+" ");
        System.out.print(table.contient(new CORE.ObjetInteligent("chaine1477863342"))+" ");
        System.out.print(table.contient(new CORE.ObjetInteligent("chaine1338643342"))+" ");
        System.out.print(table.contient(new CORE.ObjetInteligent("chaine1715469037"))+" ");
        int[] remplissage = table.remplissageMax();
        assert remplissage.length == 2;
        System.out.println(remplissage[0] + " " + remplissage[1] + " end");
    }

    public static void main(String[]foo){
        test4_forObjet3();
        test4_forObjet1();
        test4_forObjet2();
        test4_forObjetUltime();
    }
}
