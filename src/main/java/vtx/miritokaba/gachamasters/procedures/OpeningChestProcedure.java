package vtx.miritokaba.gachamasters.procedures;

import net.minecraft.world.entity.Entity;

public class OpeningChestProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getPersistentData().getBoolean("rollingGacha");
	}
}
