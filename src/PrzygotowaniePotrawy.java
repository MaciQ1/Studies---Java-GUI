import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PrzygotowaniePotrawy extends JFrame{
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JPanel JPanel4;
    private JLabel iconLabel;
    private JLabel PrzygotowaniePotrawyLabel;
    private JButton WyjdzButton;
    private JButton StartButton;
    private JPanel JPanel5;
    private JLabel NazwaLabel;
    private JPanel JPanel6;
    private JTextField CzasMinField;
    private JTextField TemperaturaMinField;
    private JTextField CzasMaxField;
    private JTextField TemperaturaMaxField;
    private JLabel TemperaturaMinLabel;
    private JLabel TemperaturaMaxLabel;
    private JLabel CzasMinLabel;
    private JLabel CzasMaxLabel;
    private JTextField NazwaField;
    private ImageIcon iconMicrowave = new ImageIcon(getClass().getResource("microwave-oven.png"));


    public PrzygotowaniePotrawy() {
        super("Program Kuchenka Mikrofalowa - Przygotowanie potrawy");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        iconLabel.setIcon(resize(iconMicrowave, 60, 60));


        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwaPotrawy = NazwaField.getText();
                String temperaturaMin = (TemperaturaMinField.getText());
                String temperaturaMax = (TemperaturaMaxField.getText());
                String czasMin = (CzasMinField.getText());
                String czasMax = (CzasMaxField.getText());

                if (!nazwaPotrawy.isEmpty() && !temperaturaMin.isEmpty() && !temperaturaMax.isEmpty() && !czasMin.isEmpty() && !czasMax.isEmpty()) {
                    if (czyPotrawaZnajdujeSieWBazieDanych(nazwaPotrawy, temperaturaMin, temperaturaMax, czasMin, czasMax)) {

                        JOptionPane.showMessageDialog(PrzygotowaniePotrawy.this,
                                "Ta potrawa została już wcześniej wprowadzona do bazy danych.", "Uwaga",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(PrzygotowaniePotrawy.this,
                                "Potrawy nie ma w bazie danych!", "Błąd",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(PrzygotowaniePotrawy.this,
                            "Nie wypełniłeś wszystkich pól!", "Błąd",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        WyjdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                WyborFunkcjonalnosci funkcjonalnosc = new WyborFunkcjonalnosci();
                funkcjonalnosc.setVisible(true);
            }
        });
    }


    public boolean czyPotrawaZnajdujeSieWBazieDanych(String nazwaPotrawy, String temperaturaMin, String temperaturaMax, String czasMin, String czasMax) {
        File plik = new File("BazaDoProjektuZPO.txt");
        if (plik.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(plik))) {
                String aktualnaLinia;
                while ((aktualnaLinia = reader.readLine()) != null) {
                    if (aktualnaLinia.split(",")[0].equals(nazwaPotrawy) && aktualnaLinia.split(",")[1].equals(temperaturaMin) && aktualnaLinia.split(",")[2].equals(temperaturaMax) && aktualnaLinia.split(",")[3].equals(czasMin) && aktualnaLinia.split(",")[4].equals(czasMax)) {
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    private static ImageIcon resize(ImageIcon src, int destWidth, int destHeight) {
        return new ImageIcon(src.getImage().getScaledInstance(destWidth, destHeight, Image.SCALE_SMOOTH));
    }


}
