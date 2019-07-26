package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadres.excessaoXadrez;
import xadres.partidaXadres;
import xadres.pecaXadres;
import xadres.posicaoXadrez;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		partidaXadres partidaXadres = new partidaXadres();

		while (true) {
			try {
				UI.clearScreen();
				UI.imprimeTabuleiro(partidaXadres.getpecas());
				System.out.println();
				System.out.print("Origem: ");
				posicaoXadrez origem = UI.lePosicaoXadrez(sc);

				boolean[][] possivelMovimento = partidaXadres.possivelMovimento(origem);
				UI.clearScreen();
				UI.imprimeTabuleiro(partidaXadres.getpecas(), possivelMovimento);
				
				
				
				System.out.println();
				System.out.print("Destino: ");
				posicaoXadrez destino = UI.lePosicaoXadrez(sc);

				pecaXadres pecaCapturada = partidaXadres.performaceMovimentoXadrez(origem, destino);
			} catch (excessaoXadrez e) {
				System.out.println(e.getMessage());
				sc.hasNextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.hasNextLine();
			}
		}
	}

}
