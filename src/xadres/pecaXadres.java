package xadres;

import boardgame.Peca;
import boardgame.Tabuleiro;

public abstract class pecaXadres extends Peca {

	private Cor cor;

	public pecaXadres(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

}
