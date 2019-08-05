package xadres.pecas;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadres.Cor;
import xadres.pecaXadres;

public class Bispo extends pecaXadres {

	public Bispo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] movimentoPossivel() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);

		// NW
		p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha() - 1, p.getColuna() - 1);
			;
		}
		if (getTabuleiro().posicaoExistente(p) && ePecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// NE
		p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha() - 1, p.getColuna() + 1);
			;
		}
		if (getTabuleiro().posicaoExistente(p) && ePecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// SE
		p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha() + 1, p.getColuna() + 1);
			;
		}
		if (getTabuleiro().posicaoExistente(p) && ePecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// SW
		p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha() + 1, p.getColuna() - 1);
			if (getTabuleiro().posicaoExistente(p) && ePecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}

		}
		return mat;
	}
}
