package geometria.geo2D.ui;

import geometria.geo2D.Punto;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

//è la "cornice" (Frame) che contiene la "tela" (Canvas) su cui disegnerò
public class Frame extends JFrame {
	public Frame(ArrayList<Punto> punti) {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//come JPanel metto un Canvas da canvasLxcanvasH che visualizza punti compresi
		//tra -max e max, Canvas si occuperà della proporzione
		JPanel panel = new Canvas2D(punti,50,500,500);
		panel.setPreferredSize(new Dimension(500, 500));
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		this.pack();

		/*
		 * JButton btnNewButton = new JButton("New button");
		 * btnNewButton.addActionListener(new ActionListener() {
		 * public void actionPerformed(ActionEvent e) {
		 * CartesianPlane.a=(float)-30.0;
		 * }
		 * });
		 * panel_1.add(btnNewButton);
		 */
	}

}