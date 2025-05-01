package obj;

import java.awt.Dimension;
import javax.swing.JButton;

public class Casilla extends JButton {
	private static final long serialVersionUID = 1L;
	
	int numero;
	boolean abierto;
	boolean bomba;
	boolean bandera;

	public Casilla() {
		bomba = false;
		numero = 0;
		inicializar();
	}
	
	public void inicializar(){
		setPreferredSize(new Dimension(40, 40));
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}

	public boolean isBomba() {
		return bomba;
	}

	public void setBomba(boolean bomba) {
		this.bomba = bomba;
	}

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}
}
