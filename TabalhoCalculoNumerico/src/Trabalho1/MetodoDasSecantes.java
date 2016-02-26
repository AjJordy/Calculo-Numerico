import java.util.Scanner;

public class MetodoDasSecantes {
	static int n = 2;
	
	public static void main(String[] args) {
		double vetor[] = new double[n+1], a,b,erro , raiz=0;
		Scanner scan = new Scanner(System.in);
		
		//Entrada de dados 		
		System.out.print("Digite o erro: ");
		erro = scan.nextDouble();
		
		// Preenchimento dos vetores
		vetor = preencherVetor(n+1);		
		
		// Calculo das raizes 
		for(int i = 0 ; i<n; i++){
			System.out.print("Digite o primeiro valor: ");
			a = scan.nextDouble();
			System.out.print("Digite o segundo valor: ");
			b = scan.nextDouble();
			do {
				raiz = Math.abs((resolverEquacao(vetor, b)-resolverEquacao(vetor, a))/(b - a));
				raiz = b - resolverEquacao(vetor, b)/raiz;				
				a = b;
				b = raiz;
			} while (Math.abs(raiz - a) > erro);		
			System.out.println("Valor da "+(i+1)+"° raiz é "+raiz);			
		}		
	}
	
	// Esse metodo recebe o polinomio desejado 
	public static double[] preencherVetor(int n){
		double[] v = new double[n];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i<v.length; i++) {
			System.out.print("Digite o A"+(v.length - i - 1)+": ");
			v[i] = scan.nextDouble();			
		}		
		return v;
	}
	
	// Esse metodo resolve o polinomio com o valor da variável 
	public static double resolverEquacao(double v[],double var){
		double result = v[0];		
		for (int i = 1; i < v.length; i++) {
			result = result*var + v[i];
		}
		return result;
	}	
}
