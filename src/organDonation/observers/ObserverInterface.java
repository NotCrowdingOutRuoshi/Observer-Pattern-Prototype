package organDonation.observers;

public interface ObserverInterface<ObservableType> {
	public void observe(ObservableInterface<ObservableType> provider);

	public void unobserve();

	public void notified(ObservableType provider);
}
