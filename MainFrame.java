import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("System Obsługi Sklepu");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuSklep = new JMenu("Operacje");
        
        JMenuItem itemSprzedaz = new JMenuItem("Sprzedaż");
        JMenuItem itemRaporty = new JMenuItem("Raporty");
        JMenuItem itemZarzadzanie = new JMenuItem("Zarządzanie Użytkownikami");

        menuSklep.add(itemSprzedaz);
        menuSklep.add(itemRaporty);
        menuSklep.add(itemZarzadzanie);
        menuBar.add(menuSklep);
        setJMenuBar(menuBar);

        String role = Session.getRole();
        if (role.equals("USER")) {
            itemZarzadzanie.setVisible(false);
            itemRaporty.setEnabled(false);
        }

        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel statusLabel = new JLabel("Zalogowano jako: " + Session.getUsername() + " | Rola: " + role);
        statusBar.add(statusLabel);
        add(statusBar, BorderLayout.SOUTH);
    }
}
