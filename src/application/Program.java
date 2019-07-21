package application;

import java.util.Scanner;

import xadres.partidaXadres;
import xadres.pecaXadres;
import xadres.posicaoXadrez;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		partidaXadres partidaXadres = new partidaXadres();

		while (true) {
			UI.imprimeTabuleiro(partidaXadres.getpecas());
			System.out.println();
			System.out.println("Origem: ");
			posicaoXadrez origem = UI.lePosicaoXadrez(sc);
			
			System.out.println();
			
			System.out.println("Destino: ");
			posicaoXadrez destino = UI.lePosicaoXadrez(sc);
			
			pecaXadres pecaCapturada = partidaXadres.performaceMovimentoXadrez(origem, destino);
			
		}
	}

}
