package blabla;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallWorth implements Callable<Integer> {

	static int i = 0;

	@Override
	public Integer call() throws Exception {
		System.out.println("called");
		Thread.sleep(1000);
		return i++;
	}

}


public class Ajeb {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			Future<Integer> f = ex.submit(new CallWorth());
			System.out.println(f.get());
		}
	}

}
