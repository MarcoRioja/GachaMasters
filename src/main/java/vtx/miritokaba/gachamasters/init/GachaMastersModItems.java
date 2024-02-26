
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package vtx.miritokaba.gachamasters.init;

import vtx.miritokaba.gachamasters.item.SilverKeyItem;
import vtx.miritokaba.gachamasters.item.GoldKeyItem;
import vtx.miritokaba.gachamasters.GachaMastersMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

public class GachaMastersModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, GachaMastersMod.MODID);
	public static final RegistryObject<Item> GOLD_KEY = REGISTRY.register("gold_key", () -> new GoldKeyItem());
	public static final RegistryObject<Item> SILVER_KEY = REGISTRY.register("silver_key", () -> new SilverKeyItem());
}
