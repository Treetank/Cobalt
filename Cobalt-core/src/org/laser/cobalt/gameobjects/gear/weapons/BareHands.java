package org.laser.cobalt.gameobjects.gear.weapons;

import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.WeaponStats.BareHandStats.LEVEL_1_AGILITY;
import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.WeaponStats.BareHandStats.LEVEL_1_DAMAGE;
import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.WeaponStats.BareHandStats.LEVEL_1_INTELLECT;
import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.WeaponStats.BareHandStats.LEVEL_1_STAMINA;
import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.WeaponStats.BareHandStats.LEVEL_1_STRENGTH;
import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.WeaponStats.BareHandStats.LEVEL_1_VITALITY;
import static org.laser.cobalt.CobaltBasics.StatMetrics.GearStats.WeaponStats.BareHandStats.SWING_SPEED;

import org.laser.cobalt.CobaltBasics.Damage;
import org.laser.cobalt.CobaltBasics.ItemIndex;
import org.laser.cobalt.gameobjects.gear.Weapon;
import org.laser.cobalt.helpers.types.PrimaryStats;
import org.laser.cobalt.helpers.types.DamageArray;

public class BareHands extends Weapon {

	public BareHands(int level) {
		super(null, new PrimaryStats(LEVEL_1_STRENGTH, LEVEL_1_AGILITY, LEVEL_1_INTELLECT, LEVEL_1_STAMINA, LEVEL_1_VITALITY), level, SWING_SPEED);
	}

	@Override
	public void levelUp() {
	}

	@Override
	protected DamageArray setupDamage() {
		DamageArray retVal = new DamageArray();
		retVal.addDamage(Damage.PHYSICAL, LEVEL_1_DAMAGE);
		return retVal;
	}

	@Override
	public ItemIndex setupItemIndex() {
		return ItemIndex.BARE_HANDS;
	}

}
