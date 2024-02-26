package vtx.miritokaba.gachamasters.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class SeePorcentagesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A7b\u00A7lLegendary %: " + ("" + (100 - entity.getPersistentData().getDouble("legendary_not_rate"))).replace(".0", ""))), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A7b\u00A7lEpic %: " + ("" + (100 - entity.getPersistentData().getDouble("epic_not_rate"))).replace(".0", ""))), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					Component.literal(("\u00A7b\u00A7lRare %: " + ("" + (100 - (100 - entity.getPersistentData().getDouble("epic_not_rate") + 100 - entity.getPersistentData().getDouble("legendary_not_rate")))).replace(".0", ""))), false);
	}
}
