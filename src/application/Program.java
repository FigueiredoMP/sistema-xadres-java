package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadres.excessaoXadres;
import xadres.partidaXadres;
import xadres.pecaXadres;
import xadres.posicaoXadres;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		partidaXadres partidaXadres = new partidaXadres();

		while (true) {
			try {
				UI.clearScreen();
				UI.imprimePartida(partidaXadres);
				System.out.println();
				System.out.print("Origem: ");
				posicaoXadres origem = UI.lePosicaoXadres(sc);
				

				boolean[][] movimentoPossivel = partidaXadres.movimentoPossivel(origem);
				UI.clearScreen();
				UI.imprimeTabuleiro(partidaXadres.getpecas(), movimentoPossivel);
				System.out.println();
				System.out.print("Destino: ");
				posicaoXadres destino = UI.lePosicaoXadres(sc);

				pecaXadres pecaCapturada = partidaXadres.performaceMovimentoXadres(origem, destino);
			} 
			catch (excessaoXadres e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
