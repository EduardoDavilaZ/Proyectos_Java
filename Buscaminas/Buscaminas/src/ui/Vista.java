package ui;

import java.awt.*;
import java.awt.event.MouseListener;
import javax.swing.*;
import obj.TableroGrafico;

public class Vista extends JFrame implements Estilos {
    private static final long serialVersionUID = 1L;

    private JPanel jpnNorte;
    private JPanel jpnCentro;
    private JLabel jlbTiempo;
    private JLabel jlbBanderas;
    public JButton jbtCara;
    private final TableroGrafico tg;

    public Vista(TableroGrafico tg) {
        this.tg = tg;
        inicializarFrame();
    }

    private void inicializarFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        inicializarPaneles();
        setVisible(true);
    }

    private void inicializarPaneles() {
        jpnNorte = new JPanel();
        jpnCentro = new JPanel(new BorderLayout());

        jpnNorte.setPreferredSize(new Dimension(500, 70));
        jpnCentro.setPreferredSize(new Dimension(500, 430));

        jpnNorte.setBackground(fondo1);
        jpnCentro.setBackground(fondo2);

        componentesNorte();
        componentesCentro();

        add(jpnNorte, BorderLayout.NORTH);
        add(jpnCentro, BorderLayout.CENTER);
    }

    private void componentesNorte() {
        jlbTiempo = new JLabel("00:00");
        jlbBanderas = new JLabel("0");
        jbtCara = new JButton();

        jlbTiempo.setFont(fuente2);
        jlbBanderas.setFont(fuente2);

        Estilos.configurarBoton(jbtCara);
        jbtCara.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("/img/caraFeliz.png"))
            .getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)
        ));

        jpnNorte.setLayout(new GridLayout(1, 3, 20, 0));
        jpnNorte.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel jpnTiempo = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JPanel jpnCara   = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JPanel jpnBanderas = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        jpnTiempo.setOpaque(false);
        jpnCara.setOpaque(false);
        jpnBanderas.setOpaque(false);

        Dimension tam = new Dimension(80, 50);
        jbtCara.setPreferredSize(tam);

        jpnTiempo.add(jlbTiempo);
        jpnCara.add(jbtCara);
        jpnBanderas.add(jlbBanderas);

        jpnNorte.add(jpnTiempo);
        jpnNorte.add(jpnCara);
        jpnNorte.add(jpnBanderas);
    }

    private void componentesCentro() {
        jpnCentro.add(tg, BorderLayout.CENTER);
    }

    // MÉTODOS PÚBLICOS PARA EL CONTROLADOR

    public void setTiempo(String tiempo) {
        jlbTiempo.setText(tiempo);
    }

    public void setContadorBanderas(int restantes) {
    	jlbBanderas.setText(String.valueOf(restantes));
    }

    public void setCaraFeliz() {
        jbtCara.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("/img/caraFeliz.png"))
            .getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)
        ));
    }

    public void setCaraTriste() {
        jbtCara.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource("/img/caraTriste.png"))
            .getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)
        ));
    }

    public void setListenerCasilla(int i, int j, MouseListener listener) {
    	tg.getTablero().casillas[i][j].addMouseListener(listener);
    }
}