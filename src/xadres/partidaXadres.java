package xadres;

import boardgame.Peca;
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

	public pecaXadres performaceMovimentoXadrez(posicaoXadrez posicaoOrigem, posicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validarPosicaoOrigem(origem);
		Peca pecaCapturada = facaMovimento(origem, destino);
		return (pecaXadres)pecaCapturada;
	}
	
	private Peca facaMovimento(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem);
		Peca pecaCapturada = tabuleiro.removePeca(destino);
		tabuleiro.posicaoPeca(p, destino);
		return pecaCapturada;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if(!tabuleiro.existePeca(posicao)) {
			throw new excessaoXadrez("Não há uma peça na posição de origem");
		}
	}
	
	private void posicaoNovaPeca(char coluna, int linha, pecaXadres peca) {
		tabuleiro.posicaoPeca(peca, new posicaoXadrez(coluna, linha).toPosicao());
	}

	private void configuracaoInicial() {
		posicaoNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		posicaoNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		posicaoNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		posicaoNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		posicaoNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		posicaoNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		posicaoNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		posicaoNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		posicaoNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		posicaoNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		posicaoNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		posicaoNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));

	}

}
