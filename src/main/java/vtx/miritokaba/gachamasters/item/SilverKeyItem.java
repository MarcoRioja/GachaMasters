
package vtx.miritokaba.gachamasters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class SilverKeyItem extends Item {
	public SilverKeyItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).stacksTo(50).fireResistant().rarity(Rarity.RARE));
	}
}
