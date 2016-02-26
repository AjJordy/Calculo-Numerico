package Atualizado;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Teste {
	public static void main(String[] args) {
		GaussJacobi gj = new GaussJacobi();	
		
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho da matriz"));
		double erro = Double.parseDouble(JOptionPane.showInputDialog("Digite o erro"));
		double matriz[][] = new double[n][n] ;
		double result[] = new double[n];
		double x1[] = new double[n];
		double resultado[] = new double[n];
		
		
		//Entrada da matriz
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matriz[i][j] = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para a matriz"));
			}
			JOptionPane.showMessageDialog(null, "Proxima linha");
		}
		//Entrada da matriz resultante 
		for (int i = 0; i < n; i++) {
			result[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para a matriz resultado"));
		}
		//Entrada dos valores de teste 
		for (int i = 0; i < n; i++) {
			x1[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para a matriz de teste"));
		}
		
		resultado = gj.resolver(matriz, result, erro, n, x1);
		System.out.println(Arrays.toString(resultado));
		
	}	
}
