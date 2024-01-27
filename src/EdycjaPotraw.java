import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class EdycjaPotraw extends JFrame {
    private JPanel JPanel1;
    private JPanel Jpanel2;
    private JPanel JPanel3;
    private JPanel JPanel4;
    private JLabel EdycjaPotrawLabel;
    private JLabel iconLabel;
    private JTextField NazwaField;
    private JTextField TemperaturaMinField;
    private JTextField CzasMinField;
    private JTextField TemperaturaMaxField;
    private JTextField CzasMaxField;
    private JButton DodajButton;
    private JButton UsunButton;
    private JButton WyjdzButton;
    private JLabel NazwaLabel;
    private JLabel CzasMinLabel;
    private JLabel CzasMaxLabel;
    private JLabel TemperaturaMinLabel;
    private JLabel TemperaturaMaxLabel;
    private ImageIcon iconDish = new ImageIcon(getClass().getResource("serving-dish.png"));


    public EdycjaPotraw() {
        super("Program Kuchenka Mikrofalowa - Edytowanie potraw w bazie");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        iconLabel.setIcon(resize(iconDish, 60, 60));

       DodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwaPotrawy = NazwaField.getText();
                String temperaturaMin = (TemperaturaMinField.getText());
                String temperaturaMax = (TemperaturaMaxField.getText());
                String czasMin = (CzasMinField.getText());
                String czasMax = (CzasMaxField.getText());

                if (!nazwaPotrawy.isEmpty() && !temperaturaMin.isEmpty() && !temperaturaMax.isEmpty() && !czasMin.isEmpty() && !czasMax.isEmpty()) {
                    if (czyPotrawaZnajdujeSieWBazieDanych(nazwaPotrawy)) {

                        JOptionPane.showMessageDialog(EdycjaPotraw.this,
                                "Ta potrawa została już wcześniej wprowadzona do bazy danych.", "Uwaga",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        zapisDoPliku(nazwaPotrawy, temperaturaMin, temperaturaMax, czasMin, czasMax);
                    }
                } else {
                    JOptionPane.showMessageDialog(EdycjaPotraw.this,
                            "Nie wypełniłeś wszystkich pól!", "Błąd",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        UsunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwaPotrawy = NazwaField.getText();
                String temperaturaMin = (TemperaturaMinField.getText());
                String temperaturaMax = (TemperaturaMaxField.getText());
                String czasMin = (CzasMinField.getText());
                String czasMax = (CzasMaxField.getText());

                if (!nazwaPotrawy.isEmpty()) {
                    if (czyPotrawaZnajdujeSieWBazieDanych(nazwaPotrawy)) {
                        if (usunPotraweZBazyDanych(nazwaPotrawy, temperaturaMin, temperaturaMax, czasMin, czasMax)) {
                            JOptionPane.showMessageDialog(EdycjaPotraw.this,
                                    "Potrawa została pomyślnie usunięta z bazy danych.", "Sukces",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(EdycjaPotraw.this,
                                    "Wystąpił błąd podczas usuwania potrawy.", "Błąd",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(EdycjaPotraw.this,
                                "Taka potrawa nie istnieje w bazie danych!", "Błąd",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(EdycjaPotraw.this,
                            "Wszystkie pola muszą być wypełnione!", "Błąd",
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



    public void zapisDoPliku(String nazwaPotrawy, String temperaturaMin, String temperaturaMax, String czasMin, String czasMax) {
        try (FileWriter fw = new FileWriter("BazaDoProjektuZPO.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println("\n" + nazwaPotrawy + "," + temperaturaMin + "," + temperaturaMax + "," + czasMin + "," + czasMax);
            JOptionPane.showMessageDialog(EdycjaPotraw.this,
                    "Potrawa została dodana do pliku!", "Sukces",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean czyPotrawaZnajdujeSieWBazieDanych(String nazwaPotrawy) {
        File plik = new File("BazaDoProjektuZPO.txt");
        if (plik.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(plik))) {
                String aktualnaLinia;
                while ((aktualnaLinia = reader.readLine()) != null) {
                    if (aktualnaLinia.split(",")[0].equals(nazwaPotrawy)) {
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean usunPotraweZBazyDanych(String nazwaPotrawy, String temperaturaMin, String temperaturaMax, String czasMin, String czasMax) {
        File plik = new File("BazaDoProjektuZPO.txt");
        if (plik.exists()) {
            try {
                File temporaryFile = new File("Temporary.txt");
                BufferedReader reader = new BufferedReader(new FileReader(plik));
                BufferedWriter writer = new BufferedWriter(new FileWriter(temporaryFile));

                String aktualnaLinia;
                while ((aktualnaLinia = reader.readLine()) != null) {
                    if (aktualnaLinia.split(",")[0].equals(nazwaPotrawy) && aktualnaLinia.split(",")[1].equals(temperaturaMin) && aktualnaLinia.split(",")[2].equals(temperaturaMax) && aktualnaLinia.split(",")[3].equals(czasMin) && aktualnaLinia.split(",")[4].equals(czasMax)) {

                        continue;
                    }
                    writer.write(aktualnaLinia + System.getProperty("line.separator"));
                }

                reader.close();
                writer.close();


                if (plik.delete() && temporaryFile.renameTo(plik)) {
                    return true;
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
