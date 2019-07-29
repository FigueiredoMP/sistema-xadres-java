package xadres;

import boardgame.Posicao;

public class posicaoXadres {

	private char coluna;
	private int linha;

	public posicaoXadres(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new excessaoXadres("Erro ao instanciar posicaoXadres. Valores validos de a1 até h8");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}

	protected Posicao toPosicao() {
		return new Posicao(8 - linha, coluna - 'a');
	}

	protected static posicaoXadres fromPosicao(Posicao posicao) {
		return new posicaoXadres((char) ('a' - posicao.getColuna()), 8 - posicao.getLinha());
	}

	@Override
	public String toString() {
		return "" + coluna + linha;
	}

}
