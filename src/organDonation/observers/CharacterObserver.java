package organDonation.observers;

import organDonation.net.TCPClient;
import organDonation.entities.Character;

public class CharacterObserver extends SpriteObserver<Character> {

	public CharacterObserver(TCPClient tcpClient) {
		super(tcpClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void notified(Character provider) {
		System.out.println("Character updated!");
		System.out.println("health: " + provider.getHealth() + "/" + provider.getTotalHealth());
		System.out.println("energy: " + provider.getEnergy() + "/" + provider.getTotalEnergy());
		System.out.println("total organs: " + provider.getAllOrgans().length);
		_tcpClient.send("data printed to screen");
	}

}
