package organDonation;

import organDonation.entities.Character;
import organDonation.entities.Organ;
import organDonation.net.TCPClient;
import organDonation.observers.CharacterObserver;
import organDonation.observers.OrganObserver;

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
