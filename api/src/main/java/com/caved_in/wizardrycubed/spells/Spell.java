package com.caved_in.wizardrycubed.spells;

import net.xeoh.plugins.base.Plugin;
import org.bukkit.entity.Player;

/**
 * Created By: TheGamersCave (Brandon)
 * Date: 20/01/14
 * Time: 10:54 AM
 */
public interface Spell extends Plugin {

	/**
	 * The spells identifier; Not what'll be seen in public display, but rather
	 * how the spell is called via the spellmanager, items, commands, etc
	 * @return Spells identifier. Ex:
	 * "FireballI" would be "FireBall I"'s identifier
	 */
	public String getIdentifier();

	/**
	 * The spells name; What will be used in public display.
	 *
	 * @return Example: "Fireball I" or "Ice Storm I"
	 */
	public String getName();

	/**
	 * The spells description to be used in menus, shops, and other displays
	 * where the description may or be required
	 * @return
	 */
	public String[] getDescription();

	/**
	 * Forces a player to cast the spell
	 *
	 * @param player
	 */
	public void castSpell(Player player);
}
