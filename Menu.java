import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame{
    JMenuBar barra = new JMenuBar();

    ImageIcon img = new ImageIcon(getClass().getResource(Main.IMAGEM_LENNA));
    JLabel labelImg = new JLabel(img);

    JMenu m1 = new JMenu("Dithering");
    JMenuItem i1m1 = new JMenuItem("Periódico Disperso - D2");
    JMenuItem i2m1 = new JMenuItem("Periódico Disperso - D3");
    JMenuItem i3m1 = new JMenuItem("Periódico Disperso - D4");
    JMenuItem i4m1 = new JMenuItem("Periódico Aglomerado - D2");
    JMenuItem i5m1 = new JMenuItem("Periódico Aglomerado - D3");
    JMenuItem i6m1 = new JMenuItem("Periódico Aglomerado - D4");
    JMenuItem i7m1 = new JMenuItem("Aperiódico");

    JMenu m2 = new JMenu("Iterpolação");
    JMenuItem i1m2 = new JMenuItem("Vizinhos mais Próximos");

    JMenu m3 = new JMenu("Moforlogia Binária");
    JMenuItem i1m3 = new JMenuItem("Erosõa");
    JMenuItem i2m3 = new JMenuItem("Dilatação");
    JMenuItem i3m3 = new JMenuItem("Abertura");
    JMenuItem i4m3 = new JMenuItem("Fechamento");
    JMenuItem i5m3 = new JMenuItem("Borda Interna");
    JMenuItem i6m3 = new JMenuItem("Borda Externa");
    JMenuItem i7m3 = new JMenuItem("Preenchimento de Regiões");

    JMenu m4 = new JMenu("Moforlogia");
    JMenuItem i1m4 = new JMenuItem("Erosõa");
    JMenuItem i2m4 = new JMenuItem("Dilatação");
    JMenuItem i3m4 = new JMenuItem("Abertura");
    JMenuItem i4m4 = new JMenuItem("Fechamento");
    JMenuItem i5m4 = new JMenuItem("Gradiente");
    JMenuItem i6m4 = new JMenuItem("Smoothing");

    JMenu m5 = new JMenu("Segmentação");
    JMenuItem i1m5 = new JMenuItem("Crescimento de Regiões");

    public Menu() {
        setJMenuBar(barra);
        // Adicionando ao Menu o Dithering e seus Itens
// ==========================================================================
        barra.add(m1);
        m1.add(i1m1);
        i1m1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuDithering(1);
            }
        });
        m1.add(i2m1);
        i2m1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuDithering(2);
            }
        });
        m1.add(i3m1);
        i3m1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuDithering(3);
            }
        });
        m1.add(i4m1);
        i4m1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuDithering(4);
            }
        });
        m1.add(i5m1);
        i5m1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuDithering(5);
            }
        });
        m1.add(i6m1);
        i6m1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuDithering(6);
            }
        });
        m1.add(i7m1);
        i7m1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuDithering(7);
            }
        });
// ==========================================================================
        barra.add(m2);
        m2.add(i1m2);
        i1m2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuInterpolação();
            }
        });
// ==========================================================================
        barra.add(m3);
        m3.add(i1m3);
        i1m3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologiaBin(1);
            }
        });
        m3.add(i2m3);
        i2m3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologiaBin(2);
            }
        });
        m3.add(i3m3);
        i3m3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologiaBin(3);
            }
        });
        m3.add(i4m3);
        i4m3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologiaBin(4);
            }
        });
        m3.add(i5m3);
        i5m3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologiaBin(5);
            }
        });
        m3.add(i6m3);
        i6m3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologiaBin(6);
            }
        });
        m3.add(i7m3);
        i7m3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologiaBin(7);
            }
        });
// ==========================================================================
        barra.add(m4);
        m4.add(i1m4);
        i1m4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologia(1);
            }
        });
        m4.add(i2m4);
        i2m4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologia(2);
            }
        });
        m4.add(i3m4);
        i3m4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologia(3);
            }
        });
        m4.add(i4m4);
        i4m4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologia(4);
            }
        });
        m4.add(i5m4);
        i5m4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologia(5);
            }
        });
        m4.add(i6m4);
        i5m4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuMorfologia(5);
            }
        });
// ==========================================================================
        barra.add(m5);
        m5.add(i1m5);
        i1m5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.menuSegmentacao();
            }
        });

        add(labelImg);

        setTitle("Menu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
