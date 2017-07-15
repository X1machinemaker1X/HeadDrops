/*
 *  Copyright:
 *  2013 Darius Mewes
 */

package me.x1machinemaker1x.headdrops;

import org.bukkit.inventory.ItemStack;

public enum CustomSkullType {

    BAT("Bat Head"),
	BLAZE("Blaze Head"),
    CAVE_SPIDER("Cave Spider Head", "cavespider"),
    CHICKEN("Chicken Head"),
    COW("Cow Head"),
    ELDER_GUARDIAN("Elder Guardian Head", "elderguardian", "elderguardian_head"),
    ENDERMAN("Enderman Head"),
    ENDERMITE("Endermite Head"),
    EVOKER("Evoker Head"),
    GHAST("Ghast Head"),
    GUARDIAN("Guardian Head"),
    HUSK("Husk Head"),
    IRON_GOLEM("Iron Golem Head", "irongolem", "golem"),
    LLAMA("Llama Head"),
    MAGMA_CUBE("Magma Cube Head", "magmacube", "lava_slime", "lavaslime"),
    MUSHROOM_COW("Mushroom Cow Head", "mushroomcow", "mooshrom"),
    OCELOT("Ocelot Head"),
    PARROT("Parrot Head"),
    PIG("Pig Head"),
    PIG_ZOMBIE("Pig Zombie Head", "pigzombie", "pigman", "zombie_pigman", "zombiepigman"),
    POLAR_BEAR("Polar Bear Head", "polarbear", "bearhead", "polarbear_head"),
    RABBIT("Rabbit Head"),
    SHEEP("Sheep Head"),
    SHULKER("Shulker Head"),
    SILVERFISH("Silverfish Head"),
    SLIME("Slime Head"),
    SPIDER("Spider Head"),
    SQUID("Squid Head"),
    STRAY("Stray Head"),
    VEX("Vex Head"),
    VILLAGER("Villager Head"),
    VINDICATOR("Vindicator Head"),
    WITCH("Witch Head"),
    WITHER("Wither Head"),
    WOLF("Wolf Head"),
    ZOMBIE_VILLAGER("Zombie Villager Head", "zombievillager", "zombie_villager"),
	
    ALEX("Alex Head"),
    HEROBRINE("Herobrine Head"),
    ILLUSIONER("Illusioner Head"),
	STEVE("Steve Head");

	private ItemStack skull;
	private String displayName;
	private String[] otherNames;
	
	private CustomSkullType(ItemStack skull, String displayName, String... otherNames) {
		this.skull = skull;
		this.displayName = displayName;
		this.otherNames = otherNames;
	}
	
	private CustomSkullType(String displayName, String... otherNames) {
		this.displayName = displayName;
		this.otherNames = otherNames;
	}
	
	public void setSkull(ItemStack skull) {
		this.skull = skull;
	}
	
	public ItemStack getSkull() {
		return this.skull;
	}
	
	public static CustomSkullType getCST(String displayName) {
		for (CustomSkullType cst : values()) {
			if (cst.getDisplayName().equals(displayName))
				return cst;
		}
		return null;
	}

	public String getDisplayName() {
		return this.displayName;
	}

//	public static CustomSkullType forSkullOwnerString(String skullOwner) {
//		for (CustomSkullType t : values())
//			if (t.getSkinName().equalsIgnoreCase(skullOwner))
//				return t;
//
//		return null;
//	}

	public static CustomSkullType forGeneralEntityName(String entityName) {
		for (CustomSkullType t : values()) {
			if (entityName.equalsIgnoreCase(t.toString()))
				return t;
			else
				for (String otherName : t.otherNames)
					if (otherName.equalsIgnoreCase(entityName))
						return t;
		}
		return null;
	}
}
