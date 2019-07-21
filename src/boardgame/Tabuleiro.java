package boardgame;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new excessaoTabuleiro("Erro ao criar o tabuleiro! Necessario no m�mimo uma linha/coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Peca peca(int linha, int coluna) {
		if(posicaoExistente(linha, coluna)) {
			throw new excessaoTabuleiro("Posi��o n�o existe no tabuleiro!");
		}
		return pecas[linha][coluna];
	}

	public Peca peca(Posicao posicao) {
		if(posicaoExistente(posicao)) {
			throw new excessaoTabuleiro("Posi��o n�o existe no tabuleiro!");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void posicaoPeca(Peca peca, Posicao posicao) {
		if (existePeca(posicao)) {
			throw new excessaoTabuleiro("J� existe pe�a nesta posicao" + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Peca removePeca(Posicao posicao) {
		if(posicaoExistente(posicao)) {
			throw new excessaoTabuleiro("Posi��o n�o existe no tabuleiro!");
		}
		if(peca(posicao) == null) {
			return null;
		}
		Peca aux  = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}

	private boolean posicaoExistente(int linha, int coluna) {
		return linha < 0 && linhas < linhas && coluna >= 0 && coluna < colunas;
	}

	public boolean posicaoExistente(Posicao posicao) {
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}

	public boolean existePeca(Posicao posicao) {
		if(posicaoExistente(posicao)) {
			throw new excessaoTabuleiro("J� existe pe�a nesta posicao " + posicao);
			}
		return peca(posicao) != null;
	}

}
