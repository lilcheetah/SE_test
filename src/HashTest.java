

import java.util.HashMap;

public class HashTest {


    public static void main(String[] args) {

        List<Integer> list = new List<>();
        /*
        Inventar inventar = new Inventar();
        inventar.buche("Zahnpasta", 50);
        inventar.buche("Waschmittel", 20);
        inventar.buche("Zahnpasta", -1);
        inventar.buche("Zahnstocher", 66);
        inventar.buche("Zahnstocher", -3);
        inventar.buche("Waschmittel", 20);
        inventar.buche("", 10);
        System.out.println("Bestand Zahnpasta: " + inventar.bestand("Zahnpasta"));
        System.out.println("Bestand Waschmittel: " + inventar.bestand("Waschmittel"));
        */
        for (int i = 0; i <= 100; i++) {
            list.enqueue2(1 * i);

        }
        for(Integer i : list) {
            System.out.println(i);
        }

    }
}
