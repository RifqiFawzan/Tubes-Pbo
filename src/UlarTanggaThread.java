package src;
import src.Game.UlarTangga;

public class UlarTanggaThread implements Runnable {
    public void run() {
        try {
            while (!Thread.interrupted() && !UlarTangga.temp) {
                UlarTangga.dc1 = (int) (Math.random() * 6.0D);
                UlarTangga.dice1.setIcon(UlarTangga.dadu[UlarTangga.dc1]);

                UlarTangga.dc2 = (int) (Math.random() * 6.0D);
                UlarTangga.dice2.setIcon(UlarTangga.dadu[UlarTangga.dc2]);

                Thread.sleep(10); // Menambahkan jeda untuk memberikan kesan dadu berputar
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}