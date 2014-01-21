package com.caved_in.wizardrycubed;

import com.caved_in.commons.commands.CommandController;
import com.caved_in.wizardrycubed.commands.WizardryCommands;
import com.caved_in.wizardrycubed.spells.Spell;
import com.caved_in.wizardrycubed.spells.SpellManager;
import net.xeoh.plugins.base.Plugin;
import net.xeoh.plugins.base.impl.PluginManagerFactory;
import net.xeoh.plugins.base.util.PluginManagerUtil;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created By: TheGamersCave (Brandon)
 * Date: 20/01/14
 * Time: 10:45 AM
 */
public class WizardryCubed extends JavaPlugin {
	private PluginManagerUtil pluginManager;
	private static String spellPluginFolder = "spells/";
	@Override
	public void onEnable() {
		//Register Commands
		CommandController.registerCommands(this, new WizardryCommands());
		//Create a plugin manager
		pluginManager = new PluginManagerUtil(PluginManagerFactory.createPluginManager());
		//If our data folder doesn't exist, create it
		if (!getDataFolder().exists()) {
			getDataFolder().mkdirs();
		}
		//If our spells folder doesn't exist, create it
		File spellsFolder = new File(getDataFolder().getPath() + File.separator + spellPluginFolder);
		if (!spellsFolder.exists()) {
			spellsFolder.mkdirs();
		}

		//Load plugins from the spells folder
		pluginManager.addPluginsFrom(spellsFolder.toURI());

		//Loop through all the plugins
		for(Plugin plugin : pluginManager.getPlugins()) {
			//Check if the plugin is a spell
			if (plugin instanceof Spell) {
				//Cast our plugin to a spell and add it to the spellmanager
				SpellManager.addSpell((Spell)plugin);
			}
		}
	}

	@Override
	public void onDisable() {

	}

}
