package gui;

import java.awt.*;
 import java.awt.event.*;

 import javax.swing.*;
import javax.swing.event.*;

public class MyPanel extends JPanel {
private JTextField How;
private JLabel jcomp2;
private JLabel jcomp3;
private JButton jcomp4;

public MyPanel() {
    //construct components
    How = new JTextField (1);
    jcomp2 = new JLabel ("How long were you parked?");
    jcomp3 = new JLabel ("Minutes");
    jcomp4 = new JButton ("openNewWindow");

    jcomp4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame ("MyPanel");
            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add (new MyPanel());
            frame.pack();
            frame.setVisible (true);

        }
    });

    //adjust size and set layout
    setPreferredSize (new Dimension (315, 85));
    setLayout (null);

    //add components
    add (How);
    add (jcomp2);
    add (jcomp3);
    add (jcomp4);

    //set component bounds (only needed by Absolute Positioning)
    How.setBounds (245, 50, 60, 25);
    jcomp2.setBounds (35, 30, 185, 50);
    jcomp3.setBounds (250, 30, 60, 20);
    jcomp4.setBounds (0, 0, 315, 25);

       jcomp4.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    });
}


public static void main (String[] args) {
    JFrame frame = new JFrame ("MyPanel");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add (new MyPanel());
    frame.pack();
    frame.setVisible (true);
}
}