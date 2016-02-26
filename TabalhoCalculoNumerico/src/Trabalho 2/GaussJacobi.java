package Atualizado;

import java.util.Arrays;

public class GaussJacobi {	
	
	double x2[] ;
	Criterios c = new Criterios();	
	
	public double[] resolver(double[][] matriz,double[] result, double erro, int n,double[] x1){
		double dr=1000;	
		if(c.criterioDasLinhas(n, matriz) == true){
			while(dr>erro){
				x2 = new double[n];
				
				for(int i = 0 ; i < n ;i++){				
					x2[i] = (somar(matriz,result,i,x1))/matriz[i][i];					
				}
				System.out.println(Arrays.toString(x2));
				dr =(max(subtrariVetor(x1, x2, n)))/(max(x2));
				for(int i = 0 ; i < n ;i++){				
					x1[i] = x2[i];					
				}			
			}
			return x1;
		}else
			System.out.println("Não obedece o criterio das linhas");
		return null;
	}
	
	//Faz a soma do resultado com o negativo dos algarismos
	public double somar(double[][] matriz,double[] result,int i, double[] x1){
		double soma = result[i];
		System.out.println(soma);
		for (int j = 0; j < result.length; j++) {
			if(j != i){
				soma -= matriz[i][j]*x1[j] ;
				System.out.println(soma);
			}
		}
		return soma;
	}
	
	//Calcula o maior valor de um vetor
	public double max(double[] x){
		double maximo = x[0];
		for (int i = 1; i < x.length; i++) {
			if( Math.abs(x[i])>maximo){
				maximo = x[i];
			}
		}
		return maximo;
	}
	
	//Subtrai elemento a elemento de dois vetores 
	public double[] subtrariVetor(double[] x1, double[] x2,int n){
		double[] x = new double[n];
		for (int i = 0; i < x1.length; i++) {
			x[i] = Math.abs(x2[i] - x1[i]);
		}
		return x;
	}
}
