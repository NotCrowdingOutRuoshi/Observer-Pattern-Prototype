package test.entities;

import java.util.ArrayList;

import test.observers.ObserverInterface;

public class Character extends Sprite<Character> {
	protected ArrayList<Organ> _organs;

	protected int _energy;
	protected int _totalEnergy;

	public Character() {
		_organs = new ArrayList<Organ>();
		_energy = 500;
		_totalEnergy = 500;
	}

	public int getEnergy() {
		return _energy;
	}

	public int getTotalEnergy() {
		return _totalEnergy;
	}

	public void setEnergy(int energy) {
		_energy = energy;
	}

	@Override
	public int getHealth() {
		int health = 0;

		for (Organ organ : _organs) {
			health += organ.getHealth();
		}

		return health;
	}

	@Override
	public int getTotalHealth() {
		int totalHealth = 0;

		for (Organ organ : _organs) {
			totalHealth += organ.getTotalHealth();
		}

		return totalHealth;
	}

	@Override
	public void setHealth(int health) {
		int currentHealth = getHealth();
		int diff = currentHealth - health;

		if (diff > 0) {
			int organIndex = (new Double(Math.random() * _organs.size())).intValue();
			Organ organ = _organs.get(organIndex);
			organ.setHealth(organ.getHealth() - diff);
		}
	}

	public Organ[] getAllOrgans() {
		Organ[] organs = new Organ[_organs.size()];

		_organs.toArray(organs);

		return organs;
	}

	public void addOrgan(Organ organ) {
		_organs.add(organ);
	}

	public boolean removeOrgan(Organ organ) {
		return _organs.remove(organ);
	}

	@Override
	public void notifyAllObservers() {
		for (ObserverInterface<Character> observer : _observers) {
			observer.notified(this);
		}
	}

}
