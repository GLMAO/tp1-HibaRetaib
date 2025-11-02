package org.emp.gl.core.launcher;

import org.emp.gl.timer.service.TimerService;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.clients.Horloge;

public class App {

    public static void main(String[] args) {

        // ✅ instancier le TimerService correct
        TimerService timerService = new DummyTimeServiceImpl();

        // ✅ créer plusieurs horloges
        new Horloge("H1", timerService);
        new Horloge("H2", timerService);
        new Horloge("H3", timerService);
        // 3. Démarrer le timer
       // timerService.start();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
