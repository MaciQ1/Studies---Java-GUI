import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WyborFunkcjonalnosci extends JFrame{
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JPanel JPanel4;
    private JLabel KuchenkaMikrofalowaLabel;
    private JButton PrzygotowaniePotrawyButton;
    private JButton EdycjaPotrawButton;
    private JLabel iconLabel1;
    private JLabel iconLabel2;

    private ImageIcon iconMicrowave = new ImageIcon(getClass().getResource("microwave-oven.png"));

    private ImageIcon iconDish = new ImageIcon(getClass().getResource("serving-dish.png"));



    public WyborFunkcjonalnosci() {
        super("Program Kuchenka Mikrofalowa - Wybór funkcjonalności");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        iconLabel1.setIcon(resize(iconMicrowave, 60, 60));
        iconLabel2.setIcon(resize(iconDish, 60, 60));

       PrzygotowaniePotrawyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                PrzygotowaniePotrawy przygotowaniePotrawy = new PrzygotowaniePotrawy();
                przygotowaniePotrawy.setVisible(true);
            }
        });

        EdycjaPotrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                EdycjaPotraw edycjaPotraw = new EdycjaPotraw();
                edycjaPotraw.setVisible(true);
            }
        });

    }

    private static ImageIcon resize(ImageIcon src, int destWidth, int destHeight) {
        return new ImageIcon(src.getImage().getScaledInstance(destWidth, destHeight, Image.SCALE_SMOOTH));
    }

}
