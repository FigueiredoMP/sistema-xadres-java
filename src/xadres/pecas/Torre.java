package xadres.pecas;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadres.Cor;
import xadres.pecaXadres;

public class Torre extends pecaXadres {

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] movimentoPossivel() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);

		// acima
		p.setValores(posicao.getLinha() - 1, posicao.getColuna());
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setlinha(p.getLinha() - 1);
		}
		if (getTabuleiro().posicaoExistente(p) && ePecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda
		p.setValores(posicao.getLinha(), posicao.getColuna() -1);
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setcoluna(p.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExistente(p) && ePecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//direita
		p.setValores(posicao.getLinha(), posicao.getColuna() +1);
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setcoluna(p.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExistente(p) && ePecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//baixo
		p.setValores(posicao.getLinha() + 1, posicao.getColuna());
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().existePeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setlinha(p.getLinha() + 1);
		}
		if (getTabuleiro().posicaoExistente(p) && ePecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		

		return mat;
	}

}
