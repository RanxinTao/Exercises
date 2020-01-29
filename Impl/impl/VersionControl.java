package impl;

public abstract class VersionControl {
	public abstract int findFirstBadVersion(int n);
	
	public boolean isBadVersion(int version) {
		return true;
	}
}
