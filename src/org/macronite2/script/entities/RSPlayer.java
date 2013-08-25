package org.macronite2.script.entities;

import org.macronite2.hooks.Client;
import org.macronite2.hooks.Player;
import org.macronite2.script.RuneScape;


public class RSPlayer extends RSCharacter{

	private Player player;

	public RSPlayer(Player player) {
		super(player);
		this.player = player;
	}

	@Override
	public String getName() {
		return player.getName();
	}

	@Override
	public int getCombatLevel() {
		return player.getCombatLevel();
	}
	
	public int[] getEquipmentIDs() {
		return player.getComposite().getEquipment();
	}
	
	public long getModelID() {
		return player.getComposite().getModelID();
	}
	
	public static final RSPlayer findPlayer(String name) {
		Client client = RuneScape.getClient();
		int[] ints = client.getPlayerIndices();
		Player[] players = client.getPlayers();
		for (int i = 0; i < client.getPlayerCount(); i++) {
			Player p = players[ints[i]];
			if (p.getName().contains(name))
				return new RSPlayer(p);
		}
		return null;
	}

	public boolean isAnimating() {
		return getAnimation() > -1;
	}
}
