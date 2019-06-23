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

	@Override
	public String toString() {
		return linha + "," + coluna;
	}
	
}
