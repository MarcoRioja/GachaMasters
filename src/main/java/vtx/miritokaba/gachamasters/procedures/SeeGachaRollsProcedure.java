package vtx.miritokaba.gachamasters.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class SeeGachaRollsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A7b\u00A7lRolls: " + ("" + entity.getPersistentData().getDouble("gachaRolls")).replace(".0", ""))), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A7b\u00A7lRolls without 5*: " + ("" + entity.getPersistentData().getDouble("gachaRollsReset")).replace(".0", ""))), false);
	}
}
