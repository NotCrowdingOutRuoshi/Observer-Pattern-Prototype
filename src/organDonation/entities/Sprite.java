package organDonation.entities;

import java.util.ArrayList;

import organDonation.observers.ObservableInterface;
import organDonation.observers.ObserverInterface;

public abstract class Sprite<SpriteType> implements ObservableInterface<SpriteType> {
	protected ArrayList<ObserverInterface<SpriteType>> _observers;

	protected int _health;
	protected int _totalHealth;

	protected Sprite() {
		_observers = new ArrayList<ObserverInterface<SpriteType>>();
		_health = 500;
		_totalHealth = 500;
	}

	public int getHealth() {
		return _health;
	}

	public void setHealth(int health) {
		_health = health;
	}

	public int getTotalHealth() {
		return _totalHealth;
	}

	@Override
	public void attach(ObserverInterface<SpriteType> observer) {
		if (!_observers.contains(observer)) {
			_observers.add(observer);
			observer.observe(this);
		}
	}

	@Override
	public void detach(ObserverInterface<SpriteType> observer) {
		if (_observers.contains(observer)) {
			_observers.remove(observer);
			observer.unobserve();
		}
	}

}
