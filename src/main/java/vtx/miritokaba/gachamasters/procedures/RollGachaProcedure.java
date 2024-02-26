package vtx.miritokaba.gachamasters.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class RollGachaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject gachaObj = new com.google.gson.JsonObject();
		com.google.gson.JsonObject rarityObj = new com.google.gson.JsonObject();
		com.google.gson.JsonObject prizeObj = new com.google.gson.JsonObject();
		String rarity = "";
		String command = "";
		String random_prize_txt = "";
		String prize_text = "";
		double random_rarity = 0;
		double epic_prizes = 0;
		double legendary_prizes = 0;
		double rare_prizes = 0;
		double random_prize = 0;
		double legendary_not_rate = 0;
		double epic_not_rate = 0;
		double actualGacha = 0;
		ItemStack keyItem = ItemStack.EMPTY;
		actualGacha = Math.round(entity.getPersistentData().getDouble("selectedGacha"));
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/gachas"), File.separator + ((actualGacha + ".json").replace(".0", "")));
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
					keyItem = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((gachaObj.get("key").getAsString()).toLowerCase(java.util.Locale.ENGLISH))));
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(keyItem) : false) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = keyItem;
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						entity.getPersistentData().putDouble("gachaRolls", (entity.getPersistentData().getDouble("gachaRolls") + 1));
						entity.getPersistentData().putDouble("gachaRollsReset", (entity.getPersistentData().getDouble("gachaRollsReset") + 1));
						legendary_not_rate = entity.getPersistentData().getDouble("legendary_not_rate");
						if (legendary_not_rate == 0 || entity.getPersistentData().getDouble("gachaRollsReset") == 0) {
							entity.getPersistentData().putDouble("legendary_not_rate", 99.4);
						}
						if (entity.getPersistentData().getDouble("gachaRollsReset") >= 75) {
							legendary_not_rate = legendary_not_rate - 0.6;
							entity.getPersistentData().putDouble("legendary_not_rate", legendary_not_rate);
						}
						epic_not_rate = entity.getPersistentData().getDouble("epic_not_rate");
						if (epic_not_rate == 0) {
							entity.getPersistentData().putDouble("epic_not_rate", 94.9);
						}
						legendary_prizes = gachaObj.get("legendary_prizes").getAsDouble();
						epic_prizes = gachaObj.get("epic_prizes").getAsDouble();
						rare_prizes = gachaObj.get("rare_prizes").getAsDouble();
						random_rarity = Mth.nextDouble(RandomSource.create(), 1, 100.01);
						if (random_rarity > legendary_not_rate) {
							rarity = "legendary";
							random_prize = Mth.nextInt(RandomSource.create(), 1, (int) legendary_prizes);
							entity.getPersistentData().putDouble("gachaRollsReset", (-1));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon firework_rocket ~ ~1 ~ {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:2,Flicker:1,Trail:1,Colors:[I;14602026],FadeColors:[I;14602026]},{Type:1,Flicker:0,Trail:0,Colors:[I;11250603],FadeColors:[I;11250603]}]}}}}");
						} else if (random_rarity > epic_not_rate) {
							rarity = "epic";
							random_prize = Mth.nextInt(RandomSource.create(), 1, (int) epic_prizes);
							entity.getPersistentData().putDouble("epics_in_ten", (entity.getPersistentData().getDouble("epics_in_ten") + 1));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon firework_rocket ~ ~1 ~ {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:2,Flicker:1,Trail:1,Colors:[I;8073150],FadeColors:[I;8073150]},{Type:1,Flicker:0,Trail:0,Colors:[I;11250603],FadeColors:[I;11250603]}]}}}}");
						} else {
							rarity = "rare";
							random_prize = Mth.nextInt(RandomSource.create(), 1, (int) rare_prizes);
						}
						if (entity.getPersistentData().getDouble("gachaRolls") % 10 == 0) {
							if (entity.getPersistentData().getDouble("epics_in_ten") == 0) {
								rarity = "epic";
								random_prize = Mth.nextInt(RandomSource.create(), 1, (int) epic_prizes);
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon firework_rocket ~ ~1 ~ {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:2,Flicker:1,Trail:1,Colors:[I;8073150],FadeColors:[I;8073150]},{Type:1,Flicker:0,Trail:0,Colors:[I;11250603],FadeColors:[I;11250603]}]}}}}");
							}
							entity.getPersistentData().putDouble("epics_in_ten", 0);
						}
						if (entity.getPersistentData().getDouble("gachaRollsReset") == 90) {
							rarity = "legendary";
							random_prize = Mth.nextInt(RandomSource.create(), 1, (int) legendary_prizes);
							entity.getPersistentData().putDouble("gachaRollsReset", (-1));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon firework_rocket ~ ~1 ~ {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:2,Flicker:1,Trail:1,Colors:[I;14602026],FadeColors:[I;14602026]},{Type:1,Flicker:0,Trail:0,Colors:[I;11250603],FadeColors:[I;11250603]}]}}}}");
						}
						rarityObj = gachaObj.get(rarity).getAsJsonObject();
						random_prize_txt = "" + random_prize;
						random_prize_txt = random_prize_txt.replace(".0", "");
						prizeObj = rarityObj.get(random_prize_txt).getAsJsonObject();
						command = prizeObj.get("command").getAsString();
						command = command.replace("%player%", entity.getDisplayName().getString());
						if (!(rarity).equals("rare")) {
							prize_text = prizeObj.get("text").getAsString();
							prize_text = prize_text.replace("%player%", entity.getDisplayName().getString());
							if (!world.isClientSide() && world.getServer() != null)
								world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(prize_text), false);
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									command);
					} else {
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(Component.literal(("\u00A7cNedesitas " + keyItem.getDisplayName().getString())), false);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cGacha No Disponible!"), false);
		}
	}
}
