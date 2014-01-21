package com.caved_in.wizardrycubed.spells;

import com.caved_in.commons.Commons;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By: TheGamersCave (Brandon)
 * Date: 20/01/14
 * Time: 6:50 PM
 */
public class SpellManager {
	private static Map<String, Spell> spells = new HashMap<>();

	public static void addSpell(Spell spell) {
		spells.put(spell.getIdentifier().toLowerCase(),spell);
		Commons.messageConsole(String.format("&e[Spells] Loaded the \"&a%s&e\" Spell",spell.getName()));
	}

	public static boolean isSpell(String lookup) {
		return spells.containsKey(lookup.toLowerCase());
	}

	public static Spell getSpell(String lookup) {
		return spells.get(lookup.toLowerCase());
	}

	public static Collection<Spell> getSpells() {
		return spells.values();
	}
}
