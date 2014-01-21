package com.caved_in.wizardrycubed.commands;

import com.caved_in.commons.Messages;
import com.caved_in.commons.commands.CommandController.CommandHandler;
import com.caved_in.commons.commands.HelpMenus;
import com.caved_in.commons.menu.HelpScreen;
import com.caved_in.commons.player.PlayerHandler;
import com.caved_in.commons.utilities.StringUtil;
import com.caved_in.wizardrycubed.spells.Spell;
import com.caved_in.wizardrycubed.spells.SpellManager;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created By: TheGamersCave (Brandon)
 * Date: 20/01/14
 * Time: 6:30 PM
 */
public class WizardryCommands {

	@CommandHandler(name = "spell")
	public void onSpellsCommand(Player player, String[] args) {
		if (args.length < 1) {
			PlayerHandler.sendMessage(player, "&ePlease use &a/spells");
		} else {
			String spellArg = args[0];
			if (!spellArg.equalsIgnoreCase("list")) {
				//Check if the spell inputted is a spell
				if (SpellManager.isSpell(spellArg)) {
					//Cast spell
					SpellManager.getSpell(spellArg).castSpell(player);
				} else {
					PlayerHandler.sendMessage(player, "Spell doesn't exist");
				}
			}
		}
	}

	@CommandHandler(name = "spells")
	public void onSpellsListCommand(CommandSender sender, String[] args) {
		int helpPageNumber = 1;
		if (args.length >= 1) {
			String helpPage = args[0];
			if (StringUtils.isNumeric(helpPage)) {
				helpPageNumber = Integer.parseInt(helpPage);
			} else {
				PlayerHandler.sendMessage(sender, Messages.INVALID_COMMAND_USAGE("page number"));
			}
		}
		spellHelpScreen().sendTo(sender, helpPageNumber, 6);
	}

	private HelpScreen spellHelpScreen() {
		HelpScreen helpScreen = HelpMenus.generateHelpScreen("Spells List", HelpMenus.PageDisplay.SHORTHAND, HelpMenus.ItemFormat.SINGLE_DASH, ChatColor.GREEN, ChatColor.DARK_GREEN);
		for (Spell spell : SpellManager.getSpells()) {
			String spellIdentifier = spell.getIdentifier();
			helpScreen.setEntry("/spell " + spellIdentifier, StringUtil.joinString(spell.getDescription(), " "));
		}
		return helpScreen;
	}
}
