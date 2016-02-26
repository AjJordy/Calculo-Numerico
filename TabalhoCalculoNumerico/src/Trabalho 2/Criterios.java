package Atualizado;

public class Criterios {

	int i, j;
	double max, soma;

	public boolean criterioDasLinhas(int N, double a[][]) {
		boolean is = false;
		max = 0;
		for (i = 0; i < N; i++) {
			soma = 0;
			for (j = 0; j < N; j++) {
				if (i != j)
					soma += Math.abs(a[i][j]);
			}
			soma = soma / Math.abs(a[i][i]);
			if (max < soma)
				max = soma;
			if (max < 1)
				is = true;
			else {
				break;
			}
		}
		return is;

	}

	public boolean criterioDasColunas(int N, double a[][]) {
		max = 0;
		for (j = 0; j < N; j++) {
			soma = 0;
			for (i = 0; i < N; i++) {
				if (i != j)
					soma += Math.abs(a[i][j]); // calcula a soma para cada
												// coluna
			}
			soma = soma / Math.abs(a[j][j]);
			if (max < soma)// pega a maior soma
				max = soma;
		}
		if (max < 1)
			return true;
		else
			return false;
	}

	public boolean criterioSassenfeld(int N, double a[][]) {
		double[] beta = new double[N];
		boolean is = false;
		max = 0;
		for (i = 0; i < N; i++) {
			soma = 0;
			for (j = 0; j < N; j++) {
				if (i < j)
					soma += beta[i]*Math.abs(a[i][j]);
				if(i > j)
					soma += Math.abs(a[i][j]);
			}
			
			soma = soma / Math.abs(a[i][i]);
			if (max < soma)
				max = soma;
			if (max < 1)
				is = true;
			else {
				break;
			}
			beta[i] = soma;
		}
		return is;

	}

}
