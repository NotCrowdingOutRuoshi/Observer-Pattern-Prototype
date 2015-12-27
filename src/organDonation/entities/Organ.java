package organDonation.entities;

import organDonation.observers.ObserverInterface;

public class Organ extends Sprite<Organ> {

	public Organ() {
		_health = 100;
		_totalHealth = 100;
	}

	@Override
	public void notifyAllObservers() {
		for (ObserverInterface<Organ> observer : _observers) {
			observer.notified(this);
		}
	}

}
