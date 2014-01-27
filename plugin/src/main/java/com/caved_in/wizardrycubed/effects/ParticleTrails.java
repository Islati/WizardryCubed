package com.caved_in.wizardrycubed.effects;

import com.caved_in.wizardrycubed.WizardryCubed;
import com.caved_in.wizardrycubed.spells.Spell;
import org.bukkit.entity.Entity;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.WeakHashMap;

/**
 * Created By: TheGamersCave (Brandon)
 * Date: 26/01/14
 * Time: 12:31 PM
 */
public class ParticleTrails {
	private static final String particleEntityMetadata = "particleentity";
	private static final String particleEntitySpellName = "spellname";
	private static WeakHashMap<Entity, ParticleEntity> particleEntities = new WeakHashMap<>();

	public static void initParticleEntity(Spell spell, Entity entity) {
		WizardryCubed plugin = WizardryCubed.getPlugin();
		//Set the entity as a particleentity
		entity.setMetadata(particleEntityMetadata, new FixedMetadataValue(plugin,true));
		//Set the spellname metadata to what the spells name actually is
		entity.setMetadata(particleEntitySpellName, new FixedMetadataValue(plugin, spell.getIdentifier()));
		particleEntities.put(entity, new ParticleEntity(entity.getLocation(),spell.castRange(),spell.damage()));

	}

}
