package org.laser.cobalt.helpers.types;

public class DamageArray {

	protected float physical, fire, water, earth, lightning;

	public DamageArray() {
		physical = 0;
		fire = 0;
		water = 0;
		earth = 0;
		lightning = 0;
	}
	
	public void addDamage(Damage damageType, float amount){
		switch (damageType) {
			case PHYSICAL: modifyPhysical(amount);
			break;
			default:
			break;
		}
	}
	
	private void modifyPhysical(float amount){
		
	}
	
	public float getDamage(Damage damageType) {
		switch (damageType) {
			case PHYSICAL: return getPhysical();
			default: return getAlldamage();
		}
	}
	
	private float getPhysical() {
		return physical;
	}
	
	private float getAllDamage() {
		return getPhysical();
	}
}
