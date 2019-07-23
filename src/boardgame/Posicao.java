package boardgame;

public class Posicao {

	private int linha;
	private int coluna;

	public Posicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public void setlinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setcoluna(int coluna) {
		this.coluna = coluna;
	}
	
	public void setValores(int coluna, int linha) {
		this.coluna = coluna;
		this.linha = linha;
	}

	@Override
	public String toString() {
		return linha + "," + coluna;
	}

}
