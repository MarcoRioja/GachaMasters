
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package vtx.miritokaba.gachamasters.init;

import vtx.miritokaba.gachamasters.client.gui.GachaGUIScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GachaMastersModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(GachaMastersModMenus.GACHA_GUI.get(), GachaGUIScreen::new);
		});
	}
}
