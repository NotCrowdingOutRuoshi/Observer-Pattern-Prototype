package organDonation.observers;

public interface ObservableInterface<ObservableType> {
	public void attach(ObserverInterface<ObservableType> observer);

	public void detach(ObserverInterface<ObservableType> observer);

	public void notifyAllObservers();
}
