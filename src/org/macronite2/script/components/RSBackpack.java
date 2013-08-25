package org.macronite2.script.components;

import java.util.List;

public class RSBackpack implements RSItemArea{
	public static final int BACKPACK_ID = 1473;
	public static final int BACKPACK_MAIN_ID = 8;
	
	public RSBackpack() {
		super();
	}

	@Override
	public int itemCount() {
		int c = 0;
		for (RSComponent comp : children())
			if (comp.getItemID() != -1)
				c++;
		return c;
	}

	@Override
	public RSItemSlot findItem(String name) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	@Override
	public RSItemSlot findItem(int id) {
		int i = 0;
		for (RSComponent comp : children()) {
			if (comp.getItemID() == id)
				return new RSItemSlot(comp, i);
			i++;
		}
		return null;
	}

	@Override
	public RSItemSlot getItemSlot(int slot) {
		return new RSItemSlot(children().get(slot), slot);
	}
	
	private List<RSComponent> children() {
		return RSComponent.getWidget(BACKPACK_ID).getChild(BACKPACK_MAIN_ID).children;
	}
}