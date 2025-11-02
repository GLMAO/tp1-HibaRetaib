package org.emp.gl.core.launcher;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

import java.util.Random;

public class App {
    public static void main(String[] args) throws InterruptedException {
        TimerService timerService = new DummyTimeServiceImpl();

        // 2 instances avec compteur fixe
        CompteARebours c1 = new CompteARebours("Compteur 1", 5, timerService);
        CompteARebours c2 = new CompteARebours("Compteur 2", 5, timerService);

        // 10 instances avec compteur aléatoire [10, 20]
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int value = rand.nextInt(11) + 10; // génère un nombre entre 10 et 20
            new CompteARebours("Compteur " + (i + 3), value, timerService);
        }

        // Laisser tourner 25 secondes pour observer le comportement
        Thread.sleep(25000);
    }
}
