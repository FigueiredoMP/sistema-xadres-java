package xadres;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadres.pecas.Rei;
import xadres.pecas.Torre;

public class partidaXadres {

	private Tabuleiro tabuleiro;

	public partidaXadres() {

		tabuleiro = new Tabuleiro(8, 8);
		configuracaoInicial();

	}

	public pecaXadres[][] getpecas() {
		pecaXadres[][] mat = new pecaXadres[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (pecaXadres) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}

	private void configuracaoInicial() {
		tabuleiro.posicaoPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(7, 1));
		tabuleiro.posicaoPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(7,1));
		tabuleiro.posicaoPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(7,4));
	}

}
