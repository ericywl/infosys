package Part_A.MessageBoard;

import java.util.ArrayList;

public class Topic implements Subject{

	private String message = null;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	@Override
	public void notifyObservers() {
		for (Observer o: observers)
			o.update(message);
	}
	@Override
	public void register(Observer o) {
		observers.add(o);
	}
	@Override
	public void unregister(Observer o) {
		observers.remove(o);
		
	}
	
	public void postMessage(String message){
		this.message = message;
		notifyObservers();
		
	}
	
	
	
}
