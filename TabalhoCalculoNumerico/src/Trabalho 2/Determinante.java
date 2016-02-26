package Atualizado;

public class Determinante {

	public double calculaDeterminante(double m[][], int n) {
		double det = 1;
		double v;
		for (int k = 0; k < n; k++) {
			for (int i = k + 1; i < n; i++) {
				v = m[i][k];
				for (int j = k; j < n; j++) {
					m[i][j] = m[i][j] + (-v / m[k][k]) * m[k][j];
					
					System.out.println(m[i][j]);
				}
			}
		}

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (i == j)
					det *= m[i][j];
			}
		}

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println("");
		}

		return det;
	}
}
