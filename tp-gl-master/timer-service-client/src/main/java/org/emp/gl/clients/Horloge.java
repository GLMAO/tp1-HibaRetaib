package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;
import java.time.LocalTime;

public class Horloge implements TimerChangeListener{

    String name; 
    TimerService timerService ; 


    public Horloge(String name, TimerService timerService) {
        this.name = name ; 
        timerService.addTimeChangeListener(this);
        System.out.println ("Horloge "+name+" initialized!") ;
    }

    public void afficherHeure () {
        if (timerService != null)
            System.out.println (name + " affiche " + 
                                timerService.getHeures() +":"+
                                timerService.getMinutes()+":"+
                                timerService.getSecondes()) ;
    }
    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
    if (evt.getPropertyName().equals(TimerChangeListener.SECONDE_PROP)) {
        afficherHeure();
    }
}    

}


