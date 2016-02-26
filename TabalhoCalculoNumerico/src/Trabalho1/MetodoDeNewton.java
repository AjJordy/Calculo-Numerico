import java.util.Arrays;
import java.util.Scanner;

public class MetodoDeNewton {
	static int n = 2;
	
	public static void main(String[] args) {
		double x,vetor[] = new double[n+1], vetorD[] = new double[n], erro , resultado=0;
		Scanner scan = new Scanner(System.in);
		
		//Entrada de dados 		
		System.out.print("Digite o erro: ");
		erro = scan.nextDouble();
		
		// Preenchimento dos vetores
		vetor = preencherVetor(n+1);
		System.out.println("o vetor é: "+Arrays.toString(vetor));		
		vetorD = vetorDerivada(n, vetor);
		System.out.println("o vetorD é: "+Arrays.toString(vetorD));
		
		// Calculo das raizes 
		for(int i = 0 ; i<n; i++){
			System.out.print("Digite o valor de entrada: ");
			x = scan.nextDouble();
			while(true){			
				resultado = calcularResultado(x, vetor, vetorD);
				if(x - resultado > erro)
					x = resultado;
				else 
					break;				
			}			
			System.out.println("Valor da "+(i+1)+"° raiz é "+resultado);
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
	
	// // Esse metodo calcula  x - (f(x)/f'(x)) 
	public static double calcularResultado(double x, double vetor[], double vetorD[]){
		double resultado = x - (resolverEquacao(vetor, x)/resolverEquacao(vetorD, x));
		return resultado;
	}
	
	public static double[] vetorDerivada(int n,double[] vetor){
		double[] v = new double[n];
		for (int i = 0; i < v.length; i++) {
			v[i] = (n-i)*vetor[i]; 
		}
		return v;
	}
}
