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
    private JTextField CzasField;
    private JTextField TemperaturaField;
    private JLabel TemperaturaLabel;
    private JLabel CzasLabel;
    private JTextField NazwaField;
    private int TemperaturaMin;
    private int TemperaturaMax;
    private int CzasMin;
    private int CzasMax;
    private ImageIcon iconMicrowave = new ImageIcon(getClass().getResource("microwave-oven.png"));


    public PrzygotowaniePotrawy() {
        super("Program Kuchenka Mikrofalowa - Przygotowanie potrawy");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        iconLabel.setIcon(resize(iconMicrowave, 60, 60));


        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwaPotrawy = NazwaField.getText();
                int Temperatura = Integer.parseInt(TemperaturaField.getText());
                int Czas = Integer.parseInt(CzasField.getText());


                if (!nazwaPotrawy.isEmpty()) {
                    if (czyPotrawaZnajdujeSieWBazieDanychDoPotrawy(nazwaPotrawy)) {
                        if (Temperatura > TemperaturaMax || Czas > CzasMax) {
                            System.out.println("Potrawa spaliła się");
                        } else if (Temperatura < TemperaturaMin || Czas < CzasMin){
                            System.out.println("Potrawa nie jest gotowa");
                        } else {
                            System.out.println("Potrawa gotowa");
                        }
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



    public boolean czyPotrawaZnajdujeSieWBazieDanychDoPotrawy(String nazwaPotrawy) {
        File plik = new File("BazaDoProjektuZPO.txt");
        if (plik.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(plik))) {
                String aktualnaLinia;
                while ((aktualnaLinia = reader.readLine()) != null) {
                    String[] dane = aktualnaLinia.split(",");
                    if (aktualnaLinia.split(",")[0].equals(nazwaPotrawy)) {
                        TemperaturaMin = Integer.parseInt(dane[1]);
                        TemperaturaMax = Integer.parseInt(dane[2]);
                        CzasMin = Integer.parseInt(dane[3]);
                        CzasMax = Integer.parseInt(dane[4]);
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
