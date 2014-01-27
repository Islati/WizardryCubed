package com.caved_in.wizardrycubed.effects;

import org.bukkit.Location;

/**
 * Created By: TheGamersCave (Brandon)
 * Date: 26/01/14
 * Time: 12:33 PM
 */
public class ParticleEntity {
	private Location firedFrom;
	private int range;
	private double damage;

	public ParticleEntity(Location firedFrom, int range, double damage) {
		this.firedFrom = firedFrom;
		this.range = range;
		this.damage = damage;
	}

	public Location getFiredFrom() {
		return firedFrom;
	}

	public int getRange() {
		return range;
	}

	public double getDamage() {
		return damage;
	}
}
