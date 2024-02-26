package vtx.miritokaba.gachamasters.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class RollGachax10Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject gachaObj = new com.google.gson.JsonObject();
		ItemStack item = ItemStack.EMPTY;
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/gachas"), File.separator + ((Math.round(entity.getPersistentData().getDouble("selectedGacha")) + ".json").replace(".0", "")));
		if (file.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					gachaObj = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					item = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((gachaObj.get("key").getAsString()).toLowerCase(java.util.Locale.ENGLISH))));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == item.getItem() && ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getCount() >= 10) {
						for (int index0 = 0; index0 < 10; index0++) {
							RollGachaProcedure.execute(world, x, y, z, entity);
						}
					} else {
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(Component.literal(("\u00A7cNedesitas 10 de " + item.getDisplayName().getString() + " en la mano")), false);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
