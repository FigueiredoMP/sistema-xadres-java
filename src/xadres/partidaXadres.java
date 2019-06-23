package xadres;

import boardgame.Tabuleiro;

public class partidaXadres {

	private Tabuleiro tabuleiro;

	public partidaXadres() {

		tabuleiro = new Tabuleiro(8, 8);

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

}
