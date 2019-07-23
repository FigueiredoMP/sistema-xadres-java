package xadres;

import boardgame.Peca;
import boardgame.Posicao;
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
	
	protected boolean ePecaOponente(Posicao posicao) {
		pecaXadres p = (pecaXadres)getTabuleiro().peca(posicao);
		return  p != null && p.getCor() != cor;
	}

}
