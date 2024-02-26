
package vtx.miritokaba.gachamasters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class GoldKeyItem extends Item {
	public GoldKeyItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).stacksTo(50).fireResistant().rarity(Rarity.EPIC));
	}
}
