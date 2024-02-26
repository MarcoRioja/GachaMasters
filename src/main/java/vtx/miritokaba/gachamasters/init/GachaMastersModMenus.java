
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package vtx.miritokaba.gachamasters.init;

import vtx.miritokaba.gachamasters.world.inventory.GachaGUIMenu;
import vtx.miritokaba.gachamasters.GachaMastersMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class GachaMastersModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, GachaMastersMod.MODID);
	public static final RegistryObject<MenuType<GachaGUIMenu>> GACHA_GUI = REGISTRY.register("gacha_gui", () -> IForgeMenuType.create(GachaGUIMenu::new));
}
