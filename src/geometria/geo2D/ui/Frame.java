package geometria.geo2D.ui;


import geometria.geo2D.Punto;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

//è la "cornice" (Frame) che contiene la "tela" (Canvas) su cui disegnerò
public class Frame extends JFrame {
	public Frame(ArrayList<Punto> punti, double max) {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//come JPanel metto un Canvas da canvasLxcanvasH che visualizza punti compresi
		//tra -max e max, Canvas si occuperà della proporzione
		JPanel panel = new Canvas2D(punti, (int) max,500,500);
		panel.setPreferredSize(new Dimension(500, 500));
		getContentPane().add(panel);
		
		this.pack();
	}

}