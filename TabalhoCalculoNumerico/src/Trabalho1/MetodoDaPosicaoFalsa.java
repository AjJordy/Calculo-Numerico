import java.util.Scanner;

public class MetodoDaPosicaoFalsa {

	static int n = 2;

	public static void main(String[] args) {
		double x[] = new double[n + 1], y[] = new double[n + 1], e, a, b, aux, raiz = 0;
		double[] vetor;
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite o primeiro erro: ");
		e = scan.nextDouble(); // recebe o proximo valor double
		vetor = preencherVetor(n);

		// Recebe a equação
		for (int i = 0; i < n; i++) {
			System.out.print("Digite o primeiro valor do " + (i + 1) + "° intervalo: ");
			x[i] = scan.nextDouble();// recebe o proximo valor double
			System.out.print("Digite o segundo valor do " + (i + 1) + "° intervalo: ");
			y[i] = scan.nextDouble();// recebe o proximo valor double
		}

		// Calculo das raizes
		for (int i = 0; i < n; i++) {
			a = x[i];
			b = y[i];
			do {
				aux = ((b - a) * Math.abs(resolverEquacao(vetor, b)))
						/ (Math.abs(resolverEquacao(vetor, b)) + Math.abs(resolverEquacao(vetor, a)));
				raiz = b - aux;
				if (resolverEquacao(vetor, raiz) * resolverEquacao(vetor, b) < 0) {
					a = raiz;
				} else {
					b = raiz;
				}
				aux = ((b - a) * Math.abs(resolverEquacao(vetor, b)))
						/ (Math.abs(resolverEquacao(vetor, b)) + Math.abs(resolverEquacao(vetor, a)));
			} while (Math.abs(a - b) > e && Math.abs(resolverEquacao(vetor, raiz)) > e);
			System.out.println("A " + (i + 1) + "° Raiz aproximada é: " + raiz);
		}
	}

	public static double[] preencherVetor(int n) {
		double[] v = new double[n + 1];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < v.length; i++) {
			System.out.print("Digite o A" + (v.length - i - 1) + ": ");
			v[i] = scan.nextDouble();
		}
		return v;
	}

	public static double resolverEquacao(double v[], double var) {
		double result = v[0];
		for (int i = 1; i < v.length; i++) {
			result = result * var + v[i];
		}
		return result;
	}

}
