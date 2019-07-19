package xadres;

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

	private void posicaoPeca(char coluna, int linha, pecaXadres peca) {
		tabuleiro.posicaoPeca(peca, new posicaoXadrez(coluna, linha).toPosicao());
	}

	private void configuracaoInicial() {
		posicaoPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
		posicaoPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
		posicaoPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));

	}

}
