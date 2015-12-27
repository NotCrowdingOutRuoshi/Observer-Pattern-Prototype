package organDonation.observers;

import organDonation.net.TCPClient;

public abstract class SpriteObserver<SpriteType> implements ObserverInterface<SpriteType> {
	protected ObservableInterface<SpriteType> _provider;
	protected TCPClient _tcpClient;

	protected SpriteObserver(TCPClient tcpClient) {
		_tcpClient = tcpClient;
	}

	@Override
	public void observe(ObservableInterface<SpriteType> provider) {
		provider.attach(this);
		_provider = provider;
	}

	@Override
	public void unobserve() {
		_provider.detach(this);
		_provider = null;
	}

	@Override
	public abstract void notified(SpriteType provider);

}
