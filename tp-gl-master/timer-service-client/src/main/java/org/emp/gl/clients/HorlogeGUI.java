package org.emp.gl.clients;

import javax.swing.*;
import java.awt.*;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;
import java.beans.PropertyChangeEvent;

public class HorlogeGUI extends JFrame implements TimerChangeListener {

    private TimerService timerService;
    private JLabel timeLabel;

    public HorlogeGUI(TimerService timerService) {
        this.timerService = timerService;
        timerService.addTimeChangeListener(this);

        setTitle("Horloge Simple");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(timeLabel);

        setVisible(true);
    }

    private void updateTime() {
        String time = String.format("%02d:%02d:%02d",
                timerService.getHeures(),
                timerService.getMinutes(),
                timerService.getSecondes());
        timeLabel.setText(time);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(TimerChangeListener.SECONDE_PROP)) {
            updateTime();
        }
    }
}
