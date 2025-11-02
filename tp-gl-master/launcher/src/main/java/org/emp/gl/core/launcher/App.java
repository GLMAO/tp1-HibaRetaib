package org.emp.gl.core.launcher;

import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.CompteARebours;
import java.util.Random;

public class App {
    public static void main(String[] args) {

        TimerService timerService = new DummyTimeServiceImpl();

        // Horloges (affichent l'heure)
        new Horloge("Horloge A", timerService);
        new Horloge("Horloge B", timerService);
        new Horloge("Horloge C", timerService);

        // Compte à rebours simple
        new CompteARebours("Timer 1", 5, timerService);

        // 10 compteurs aléatoires entre 10 et 20
        Random r = new Random();
        for (int i = 1; i <= 10; i++) {
            int init = 10 + r.nextInt(11); // 10 à 20
            new CompteARebours("C" + i, init, timerService);
        }

        // Laisser tourner l'application
        while (true) {}
    }
}
