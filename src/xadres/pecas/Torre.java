package xadres.pecas;

import boardgame.Tabuleiro;
import xadres.Cor;
import xadres.pecaXadres;

public class Torre extends pecaXadres{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}
	
}
