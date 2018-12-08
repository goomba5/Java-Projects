package ch09_prj1_AnimalCounter;

public abstract class Animal implements Countable {

	protected int count;
	
	public Animal() {
		count++;
	}

	@Override
	public void incrementCount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetCount() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCountString() {
		// TODO Auto-generated method stub
		return null;
	}

}
