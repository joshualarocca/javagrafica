package geometria.geo2D.ui;

import geometria.geo2D.Punto;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

//è la "cornice" (Frame) che contiene la "tela" (Canvas) su cui disegnerò
public class Cornice extends JFrame {
	public Cornice(ArrayList<Punto> punti, double max) {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cosa fare se premo la X
		setBounds(100, 100, 1200, 600);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//come JPanel metto un Canvas da canvasLxcanvasH che visualizza punti compresi
		//tra -max e max, Canvas si occuperà della proporzione
		JPanel postIt = new Canvas2D(punti, (int) max,500,500);
		
		JPanel postIt2 = new Canvas2D(punti, (int) max,500,500);

		postIt.setPreferredSize(new Dimension(500, 500));
		
		getContentPane().add(postIt);
		getContentPane().add(postIt2);
		
		this.pack();
	}

}