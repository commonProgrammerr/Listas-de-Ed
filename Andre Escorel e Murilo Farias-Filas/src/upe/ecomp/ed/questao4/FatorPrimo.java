package upe.ecomp.ed.questao4;

import upe.ecomp.ed.EscorelD.DinamicQueue;

public class FatorPrimo extends DinamicQueue<Integer> {

	public FatorPrimo() {
		super();
	}

	public void fatorPrimo(int num) {

		enqueue(num);
		enqueue(-1);

		int div = num;

		while (num != 1) {

			if (num % div == 0 && isNumPrimo(div, 1)) {
				enqueue(div);
				num /= div;
			} else {
				div--;
			}
		}
		enqueue(0);
	}

	@Override
	public String toString() {
		String out = "";
		for (Integer var : this) {
			if (var != 0 && var != -1)
				out += var.toString() + "*";
			else if (var == 0) {
				out += "\n";

			} else
				out += "-->";
		}
		return out;
	}

	private boolean isNumPrimo(int x, int num) {
		if (num <= 1) {
			num = 2;
		}
		if (x == 1) {
			return true;
		}
		if (x > num) {
			return x % num != 0 && isNumPrimo(x, ++num);
		} else
			return x % num == 0;
	}

}
