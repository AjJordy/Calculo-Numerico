import java.util.Arrays;
import java.util.Scanner;

public class MetodoDaBisseccao {
	static int n = 2;
	public static void main(String[] args) {
		
		double x[] = new double[n+1] , y[] = new double[n+1], e , a , b, aux;
		int k = 0;
		double[] vetor;
		
		Scanner scan = new Scanner(System.in);// entrada de dados
		System.out.print("Digite o erro: ");// saida de dados
		e = scan.nextDouble();	// recebe o proximo valor double
		vetor = preencherVetor(n);
		
		
		//Recebe a equação
		for (int i = 0; i < n; i++) {
			System.out.print("Digite o primeiro valor do "+(i+1)+"° intervalo: ");
			x[i] = scan.nextDouble();// recebe o proximo valor double
			System.out.print("Digite o segundo valor do "+(i+1)+"° intervalo: ");
			y[i] = scan.nextDouble();// recebe o proximo valor double
			k = iteracoes(e,x[i],y[i]);
			System.out.println("O processo realizará "+k+" iterações;");				
		}
		
		//Calcula as raízes 
		for (int i = 0; i < n; i++){
			
			a = x[i];
			b = y[i];
			if(resolverEquacao(vetor, a)*resolverEquacao(vetor, b) < 0 ){ // verifica se a raiz está no intervalo 			
				aux = (b + a)/2; 
				for(int j = 0; j < k ; j++){					
					if(resolverEquacao(vetor,a)*resolverEquacao(vetor, b)<0){ 
						a = aux;						
					}else {
						b = aux;						
					}
					aux = (b + a)/2;				
				}			
				System.out.println("A "+(i+1)+"° Raiz aproximada é: "+aux);				
			}else
				System.out.println("Intervalo não possui raiz:");
			
		}		
	}
	
	// Esse metodo verifica quantas iterações iram acontecer 
	public static int iteracoes(double e,double x,double y){
		double aux = 0;
		int k = 0;
		aux = (Math.log10(y-x) - Math.log10(e))/Math.log10(2);
		k = (int)aux;
		return k;
	}
	
	// Esse metodo recebe o polinomio desejado 
	public static double[] preencherVetor(int n){
		double[] v = new double[n+1];
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
		for (int i = 1; i < v.length ; i++) {
			result = result*var + v[i];			
		}
		return result;
	}

}
