package xadres;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadres.pecas.Rei;
import xadres.pecas.Torre;

public class partidaXadres {

	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	private boolean check;
	
	private List<Peca> pecasTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();

	public partidaXadres() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Cor.BRANCO;
		configuracaoInicial();

	}

	public int getTurno() {
		return turno;
	}

	public Cor getJogadaorAtual() {
		return jogadorAtual;
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

	public boolean[][] movimentoPossivel(posicaoXadres posicaoOrigem) {
		Posicao posicao = posicaoOrigem.toPosicao();
		validarPosicaoOrigem(posicao);
		return tabuleiro.peca(posicao).movimentoPossivel();
	}

	public pecaXadres performaceMovimentoXadres(posicaoXadres posicaoOrigem, posicaoXadres posicaoDestino) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino);
		Peca pecaCapturada = facaMovimento(origem, destino);
		proximoTurno();
		return (pecaXadres) pecaCapturada;
	}

	private Peca facaMovimento(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem);
		Peca pecaCapturada = tabuleiro.removePeca(destino);
		tabuleiro.posicaoPeca(p, destino);
		
		if(pecaCapturada != null) {
			pecasTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		return pecaCapturada;
	}
	
	private void desfacaMovimento(Posicao origem, Posicao destino, Peca pecaCapturada) {
		Peca p = tabuleiro.removePeca(destino);
		tabuleiro.posicaoPeca(p, origem);
		
		if (pecaCapturada != null) {
			tabuleiro.posicaoPeca(pecaCapturada, destino);
			pecasCapturadas.remove(pecaCapturada);
			pecasTabuleiro.add(pecaCapturada);
		}
	}

	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.existePeca(posicao)) {
			throw new excessaoXadres("Nao ha uma peca na posicao de origem");
		}
		if (jogadorAtual != ((pecaXadres)tabuleiro.peca(posicao)).getCor()){
			throw new excessaoXadres("A peca escolhida não é sua!");
		}
		if (tabuleiro.peca(posicao).existeMovimentoPossivel()) {
			throw new excessaoXadres("Nao existe movimentos para a peca escolhida!");
		}
	}

	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if (tabuleiro.peca(origem).movimentoPossivel(destino)) {
			throw new excessaoXadres("Peca escolhida nao pode se mover para posicao de destino");
		}
	}
	
	private void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private Cor oponente(Cor cor) {
		return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private pecaXadres rei(Cor cor) {
		List<Peca> list = pecasTabuleiro.stream().filter(x -> ((pecaXadres)x).getCor() == cor).collect(Collectors.toList());
		for(Peca p : list) {
			if(p instanceof Rei) {
				return (pecaXadres)p;
			}
		}
		throw new IllegalStateException("Não existe o rei de cor"+ cor);
	}

	private void posicaoNovaPeca(char coluna, int linha, pecaXadres peca) {
		tabuleiro.posicaoPeca(peca, new posicaoXadres(coluna, linha).toPosicao());
		pecasTabuleiro.add(peca);
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
