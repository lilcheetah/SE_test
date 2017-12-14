import java.util.HashMap;

public class Inventar {
    HashMap <String, Integer> inventar = new HashMap <>();

    public void buche (String posten, int anzahl) {
        int temp = 0;
        if(posten == null || posten.length() == 0){
            throw new RuntimeException("Hitler");
        }
        if(inventar.get(posten) != null){
            temp = inventar.get(posten);

        }
            temp = temp + anzahl;
            inventar.put(posten, temp);

    }

    public int bestand (String posten) {
        if(inventar.get(posten) == null){
            throw new RuntimeException("Hitler did");
        }else{
            return inventar.get(posten);
        }

    }
}
