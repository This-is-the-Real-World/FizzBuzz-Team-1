package io.github.qosmiof2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    }

}