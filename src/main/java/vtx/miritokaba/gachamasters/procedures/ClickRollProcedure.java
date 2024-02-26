package vtx.miritokaba.gachamasters.procedures;

import vtx.miritokaba.gachamasters.GachaMastersMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class ClickRollProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.getPersistentData().getBoolean("rollingGacha")) {
			entity.getPersistentData().putBoolean("rollingGacha", true);
			GachaMastersMod.queueServerWork(80, () -> {
				RollGachaProcedure.execute(world, x, y, z, entity);
				entity.getPersistentData().putBoolean("rollingGacha", false);
			});
		}
	}
}
