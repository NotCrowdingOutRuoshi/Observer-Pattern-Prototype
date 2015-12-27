package test;

import test.entities.Character;
import test.entities.Organ;
import test.net.TCPClient;
import test.observers.CharacterObserver;
import test.observers.OrganObserver;

public class Main {

	public static void main(String[] args) {
		TCPClient tcpClient = new TCPClient();

		Character character = new Character();
		CharacterObserver characterObserver = new CharacterObserver(tcpClient);
		characterObserver.observe(character);

		Organ organ = new Organ();
		OrganObserver organObserver = new OrganObserver(tcpClient);
		organObserver.observe(organ);

		character.addOrgan(organ);

		character.setEnergy(100);
		character.notifyAllObservers();

		organ.setHealth(30);
		organ.notifyAllObservers();

		return;
	}

}
