package com.example.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrepareServeProblem {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		CountDownLatch latch = new CountDownLatch(1);
		
		Runnable prepareService = new Runnable()
		{
			public void run()
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Preparing Food");
				latch.countDown();
			}
		};
		
		
		Runnable serveService = new Runnable()
		{
			public void run()
			{
				try {
					latch.await();
					System.out.println("wating for prepareService to finish");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Serving the Food");
				
			}
		};
		
		service.execute(serveService);
		service.execute(prepareService);
		
		
	}

}
