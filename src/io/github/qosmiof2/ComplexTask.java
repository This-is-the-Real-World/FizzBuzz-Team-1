package io.github.qosmiof2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ADDED SOME NOTES * BY RAKEYJAKEY*
 *
 * 1. Not needed static variables.
 * 2. I don't think the LAF is really necessary in this case, but adding it is fine.
 * 3. Fizzbuzz numbers are also fizz and buzz numbers so you can either specify that it fizz and buzz counts exclude them or add them too.
 * 4. Learn to use lambdas to neaten up ActionListeners. I have put an example at the bottom.
 *
 */
public class ComplexTask {

    private static int fizz, buzz, fizzBuzz, num = 0;
    private static final Image image = Toolkit.getDefaultToolkit().getImage(
            "src/io/github/qosmiof2/java.png");
    final static TrayIcon tray = new TrayIcon(image, "FizzBuzz");

    private static PopupMenu menu = new PopupMenu("More info");
    private static MenuItem about = new MenuItem("About");
    private static MenuItem exit = new MenuItem("Exit");

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 1000; i++) {

            if ((i % 3 == 0) && (i % 5 == 0)) {
                fizzBuzz++;
                Gui.fizzBuzzModel.add(Gui.fizzBuzzModel.getSize(), i);
            } else if ((i % 3 == 0)) {
                fizz++;
                Gui.fizzModel.add(Gui.fizzModel.getSize(), i);
            } else if ((i % 5 == 0)) {
                buzz++;
                Gui.buzzModel.add(Gui.buzzModel.getSize(), i);

                /*
                Could have used else here instead of else if.
                 */
            } else if ((i % 3 != 0) || (i % 5 != 0)) {
                num++;
            }
        }

        try {
            SystemTray.getSystemTray().add(tray);
        } catch (AWTException e1) {
            e1.printStackTrace();
        }

        tray.setImageAutoSize(true);

        tray.displayMessage("FizzBuzz", (("Fizz numbers: " + fizz + "\n")
                + ("Buzz numbers: " + buzz + "\n")
                + ("FizzBuzz numbers: " + fizzBuzz + "\n") + ("Non-multiples: "
                + num + "\n")), TrayIcon.MessageType.INFO);

        tray.setPopupMenu(menu);
        menu.add(about);
        menu.addSeparator();
        menu.add(exit);

        about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        new Gui();

                    }

                });

            }

        });

        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }

        });

        /* LAMBDA EXAMPLE EG. THIS COULD REPLACE exit.addActionListener.
             e is just the name of the ActionEvent variable. It can be anything but I like to use e.

         exit.addActionListener(e -> System.exit(0));

         */

    }

}