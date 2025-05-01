package obj;

import java.awt.GridLayout;
import javax.swing.JPanel;
import ui.Estilos;

/**
 * Panel gráfico del tablero: dibuja casillas según el objeto Tablero.
 */
public class TableroGrafico extends JPanel implements Estilos {
	private static final long serialVersionUID = 1L;
	
	private int num;
    private int bombas;
    private Tablero tablero;

    public TableroGrafico(int num, int bombas) {
        this.num = num;
        this.bombas = bombas;
        this.tablero = new Tablero(num, bombas);
        configurarPanel();
    }

    public void redibujar(Tablero nuevoTablero) {
        this.tablero = nuevoTablero;
        removeAll();
        configurarPanel();
        revalidate();
        repaint();
    }

    private void configurarPanel() {
        setLayout(new GridLayout(num, num, 2, 2));
        setBackground(fondo1);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                Casilla c = tablero.casillas[i][j];
                Estilos.configurarCasilla(c);
                add(c);
            }
        }
    }

    public int getNum() {
        return num;
    }

    public int getBombas() {
        return bombas;
    }

    public Tablero getTablero() {
        return tablero;
    }
}
