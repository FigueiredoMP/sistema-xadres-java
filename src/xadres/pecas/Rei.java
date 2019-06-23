package xadres.pecas;

import boardgame.Tabuleiro;
import xadres.Cor;
import xadres.pecaXadres;

public class Rei extends pecaXadres{

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "R";
	}

}
