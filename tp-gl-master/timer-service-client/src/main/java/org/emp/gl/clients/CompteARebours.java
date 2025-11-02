package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;
import java.beans.PropertyChangeEvent;

public class CompteARebours implements TimerChangeListener {

    private int valeur;
    private TimerService timerService;
    private String name;

    public CompteARebours(String name, int valeurInitiale, TimerService timerService) {
        this.name = name;
        this.valeur = valeurInitiale;
        this.timerService = timerService;

        timerService.addTimeChangeListener(this);
        System.out.println("Compte à rebours " + name + " démarré à " + valeur);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(TimerChangeListener.SECONDE_PROP)) {
            tick();
        }
    }

    private void tick() {
        if (valeur > 0) {
            valeur--;
            System.out.println(name + " => " + valeur);
        }

        if (valeur == 0) {
            System.out.println(name + " terminé ✅");
            timerService.removeTimeChangeListener(this);
        }
    }
}
