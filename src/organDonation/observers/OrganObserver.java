package organDonation.observers;

import organDonation.entities.Organ;
import organDonation.net.TCPClient;

public class OrganObserver extends SpriteObserver<Organ> {

	public OrganObserver(TCPClient tcpClient) {
		super(tcpClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void notified(Organ provider) {
		System.out.println("Organ updated!");
		System.out.println("health: " + provider.getHealth() + "/" + provider.getTotalHealth());
		_tcpClient.send("data printed to screen");
	}

}
