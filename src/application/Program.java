package application;

import xadres.partidaXadres;

public class Program {

	public static void main(String[] args) {
		
		partidaXadres partida = new partidaXadres();
		UI.imprimeTabuleiro(partida.getpecas());
		
	}

}
