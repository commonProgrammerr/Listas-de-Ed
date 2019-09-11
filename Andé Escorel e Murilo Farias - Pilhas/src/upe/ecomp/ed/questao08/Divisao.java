package upe.ecomp.ed.questao08;

public class Divisao {

	public static int div(int m, int n) {
		System.out.print("Dividindo "+m+" por "+n+": ");
		
		return divisao(m, n, 0);
	}

	private static int divisao(int m, int n, int times) {
		if (m == 1 || m == 0) {
			return times;
		} if(m<0) {
			return times-1;
		}
		else {
			return divisao(m - n, n, times+1);

		}
		
	}

}
