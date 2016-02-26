package Atualizado;

import javax.swing.JOptionPane;

public class testarDeterminante {

	public static void main(String[] args) {
		Determinante d = new Determinante();
		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho da matriz"));
		double matriz[][] = new double[n][n];

		// Entrada da matriz
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matriz[i][j] = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para a matriz"));
			}
			JOptionPane.showMessageDialog(null, "Proxima linha");
		}
		
		
		
		System.out.println("O determinante é: "+d.calculaDeterminante(matriz, n));
		
	}

}
