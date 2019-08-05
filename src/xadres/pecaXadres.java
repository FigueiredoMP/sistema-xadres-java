package xadres;

import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;

public abstract class pecaXadres extends Peca {

	private Cor cor;
	private int contMovimento;

	public pecaXadres(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	public int getContMovimento() {
		return contMovimento;
	}
	
	public void aumentarContMovimento() {
		contMovimento++;
	}
	
	public void diminuirContMovimento() {
		contMovimento++;
	}
	
	public posicaoXadres  getPosicaoXadres() {
		return posicaoXadres.fromPosicao(posicao);
	}
	
	protected boolean ePecaOponente(Posicao posicao) {
		pecaXadres p = (pecaXadres)getTabuleiro().peca(posicao);
		return  p != null && p.getCor() != cor;
	}

}
