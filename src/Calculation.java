public class Calculation extends Thread {
    // Startwert , der getestet wird
    private static volatile int value = 20151221;
    private static final Object lock = 1;

    public Calculation(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            berechne();
        }
    }

    private  void berechne() {
        // Zaehlen der Teiler einer Zahl
        int temp;
        synchronized(lock) {
             temp = value;
                    value++;
        }

            int countTeiler = 0;
            for (int i = 1; i <= temp; i++) {
                if (temp % i == 0) {
                    countTeiler++;
                }
            }

            // Ausgabe des Ergebnis
            System.out.println(getName() + " : Die Zahl " + temp + " hat "
                    + countTeiler + " Teiler . ");

            // Naechsten Wert testen



    }

    public static void main (String[] args) throws InterruptedException {
        Calculation threadA = new Calculation(" A ");
        Calculation threadB = new Calculation(" B ");
        Calculation threadC = new Calculation(" C ");

        // Threads starten
        threadA.start();
        threadB.start();
        threadC.start();
        // kurz warten
        sleep(1000);
        // Threads unterbrechen
        threadA.interrupt();
        threadB.interrupt();
        threadC.interrupt();
        // warten bis Threads beendet
        threadA.join();
        threadB.join();
        threadC.join();
    }
}