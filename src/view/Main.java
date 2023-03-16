package view;
import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class Main {

	public static Semaphore semaforo;
		
	public static void main(String[] args) {
		String direcao="";
		int carros=10;
		semaforo = new Semaphore(1);
		
		for(int i=1;i<=carros;i++) {
			Thread cruzamento = new ThreadCruzamento(i, semaforo, direcao);
			cruzamento.start();
		}
		
	}
}
