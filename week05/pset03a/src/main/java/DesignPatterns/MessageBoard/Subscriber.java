package DesignPatterns.MessageBoard;

public class Subscriber implements Observer {
	
	private Subject subject = null;
	private int observerId;
	private static int observerIdTrack =0;
	
	public Subscriber(Subject subject) {
		this.subject = subject;
		this.subject.register(this);  // register itself into the list of observers
		
		observerId = observerIdTrack++;
	}

	@Override
	public void update(String message) {
		System.out.println("subscriber " + observerId + " got notified: "+ message);
		
		
	}

	
}
