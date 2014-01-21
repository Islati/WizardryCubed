package com.caved_in.wizardrycubed;

import com.caved_in.commons.Commons;
import com.caved_in.commons.player.PlayerHandler;
import com.caved_in.commons.sound.SoundHandler;
import com.caved_in.wizardrycubed.spells.Spell;
import net.xeoh.plugins.base.annotations.PluginImplementation;
import net.xeoh.plugins.base.annotations.events.Init;
import net.xeoh.plugins.base.annotations.meta.Author;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

/**
 * Created By: TheGamersCave (Brandon)
 * Date: 20/01/14
 * Time: 10:59 AM
 */
@PluginImplementation
@Author(name="Brandon Curtis")
public class FireballSpell implements Spell {
	@Override
	public String getIdentifier() {
		return "fireballi";
	}

	@Override
	public String getName() {
		return "Fireball I";
	}

	@Override
	public String[] getDescription() {
		return new String[] {"Casts a mighty fireball"};
	}

	@Override
	public void castSpell(Player player) {
		//Launch a fireball and make it 2x faster
		Fireball fireball = player.launchProjectile(Fireball.class);
		fireball.setVelocity(fireball.getVelocity().multiply(2));
		SoundHandler.playSound(player, Sound.GHAST_FIREBALL);
		PlayerHandler.sendMessage(player, "&7Pew pew!");
	}

	@Init
	public void init() {
		Commons.messageConsole("Loaded fireball spell");
	}
}
