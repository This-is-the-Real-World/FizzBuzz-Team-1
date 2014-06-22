package io.github.qosmiof2;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.Window.Type;

/**
 * ADDED SOME NOTES * BY RAKEYJAKEY*
 *
 * 1. Not needed static variables.
 * 2. Need to comment some more than you already are.
 * 3. You could learn to double brace {{ }} which would neaten it up, but this is purely stylistic.
 * 4. In my opinion this could have easily been done in one class because ComplexTask doesn't do much other than control things on here.
 *
 */
public class Gui {

    public Gui() {
        init();
    }

    private JFrame frame = new JFrame("About");
    private JPanel panel = new JPanel();
    private FlowLayout layout = new FlowLayout(FlowLayout.LEFT);

    /*
     * I don't understand why these need to be static.
     */
    public static DefaultListModel<Integer> fizzModel = new DefaultListModel<Integer>();
    public static DefaultListModel<Integer> buzzModel = new DefaultListModel<Integer>();
    public static DefaultListModel<Integer> fizzBuzzModel = new DefaultListModel<Integer>();


    private JList<Integer> listFizz = new JList<Integer>(fizzModel);
    private JList<Integer> listBuzz = new JList<Integer>(buzzModel);
    private JList<Integer> listFizzBuzz = new JList<Integer>(fizzBuzzModel);

    /*
     * I don't understand why these need to be static.
     */
    private static JLabel labelFizz = new JLabel("Fizz numbers: ");
    private static JLabel labelBuzz = new JLabel("Buzz numbers: ");
    private static JLabel labelFizzBuzz = new JLabel("FizzBuzz numbers: ");

    private JScrollPane scrollPaneFizz = new JScrollPane(listFizz);
    private JScrollPane scrollPaneBuzz = new JScrollPane(listBuzz);
    private JScrollPane scrollPaneFizzBuzz = new JScrollPane(listFizzBuzz);

    private void init() {
        frame.setType(Type.UTILITY);
        frame.setVisible(true);
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(layout);
        panel.add(labelFizz);
        panel.add(scrollPaneFizz);
        panel.add(labelBuzz);
        panel.add(scrollPaneBuzz);
        panel.add(labelFizzBuzz);
        panel.add(scrollPaneFizzBuzz);

        /* fizz numbers list */
        scrollPaneFizz.setPreferredSize(new Dimension(280, 50));
        scrollPaneFizz.setBorder(BorderFactory
                .createEtchedBorder(EtchedBorder.LOWERED));
        scrollPaneFizz.setFocusable(false);
        listFizz.setFocusable(false);
        /* buzz number list */
        scrollPaneBuzz.setPreferredSize(new Dimension(280, 50));
        scrollPaneBuzz.setBorder(BorderFactory
                .createEtchedBorder(EtchedBorder.LOWERED));
        scrollPaneBuzz.setFocusable(false);
        listBuzz.setFocusable(false);

        /* fizz buzz number list */
        scrollPaneFizzBuzz.setPreferredSize(new Dimension(280, 50));
        scrollPaneFizzBuzz.setBorder(BorderFactory
                .createEtchedBorder(EtchedBorder.LOWERED));
        scrollPaneFizzBuzz.setFocusable(false);
        listFizzBuzz.setFocusable(false);

    }
}