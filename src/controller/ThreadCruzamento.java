package controller;
import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {

	int idcarro;
	Semaphore semaforo;
	String direção;
	static int aguardar = 100;
	
	public ThreadCruzamento(int i, Semaphore semaforo, String direcao) {
		this.semaforo = semaforo;
		idcarro = i;
		direção = direcao;
	}
	
	@Override
	public void run() {
		carroDireção();
		
		try {
			semaforo.acquire();
			entrarCruzamento();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();

		}
	}
	
	public void carroDireção() {
		int sentido = (int) (Math.random()*4)+1;
		switch (sentido) {
		case 1: direção = "Norte";
		break;
		case 2: direção = "Sul";
		break;
		case 3: direção = "Leste";
		break;
		case 4: direção = "Oeste";
		break;
		}
		
	}
	
	public void entrarCruzamento() {
		
		System.out.println("O carro "+idcarro+" entrou no cruzamento");
		System.out.println("Direcao "+direção);
		sairCruzamento();
	}
	
	public void sairCruzamento() {
		int tempoEspera = (int) (Math.random()*2001);
		try {
			Thread.sleep(tempoEspera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Carro "+idcarro+" saiu do cruzamento");
	}
	
}
