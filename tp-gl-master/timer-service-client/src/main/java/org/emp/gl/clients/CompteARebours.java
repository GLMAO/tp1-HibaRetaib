package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import java.util.Random;

public class CompteARebours implements TimerChangeListener {

    private String name;
    private int compteur;
    private TimerService timerService;

    public CompteARebours(String name, int initialValue, TimerService timerService) {
        this.name = name;
        this.compteur = initialValue;
        this.timerService = timerService;

        // S'abonner au TimerService
        timerService.addTimeChangeListener(this);

        System.out.println(name + " initialisé avec compteur = " + compteur);
    }

    @Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {
        // Décrémenter uniquement à chaque seconde
        if (TimerChangeListener.SECONDE_PROP.equals(prop)) {
            if (compteur > 0) {
                compteur--;
                System.out.println(name + " => compteur = " + compteur);
            }

            // Se désinscrire lorsque compteur atteint 0
            if (compteur == 0) {
                timerService.removeTimeChangeListener(this);
                System.out.println(name + " => terminé et désinscrit");
            }
        }
    }

    public int getCompteur() {
        return compteur;
    }
}
