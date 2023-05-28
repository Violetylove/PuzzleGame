package org.atovio.pg.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Winter Yuan
 * @version 1.0
 */
public class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("The button has pressed.");
    }
}
