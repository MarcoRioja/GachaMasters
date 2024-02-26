package vtx.miritokaba.gachamasters.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetPorcentagesProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((StringArgumentType.getString(arguments, "rarity")).equals("legendary")) {
			(new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getPersistentData().putDouble("legendary_not_rate", (DoubleArgumentType.getDouble(arguments, "number")));
		} else if ((StringArgumentType.getString(arguments, "rarity")).equals("epic")) {
			(new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getPersistentData().putDouble("epic_not_rate", (DoubleArgumentType.getDouble(arguments, "number")));
		} else if ((StringArgumentType.getString(arguments, "rarity")).equals("rare")) {
			(new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getPersistentData().putDouble("rare_not_rate", (DoubleArgumentType.getDouble(arguments, "number")));
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7c" + StringArgumentType.getString(arguments, "rarity") + " parametro erroneo")), false);
		}
	}
}
