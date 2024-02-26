package vtx.miritokaba.gachamasters.procedures;

import net.minecraft.world.entity.Entity;

public class NextGachaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("selectedGacha") == 4) {
			entity.getPersistentData().putDouble("selectedGacha", 0);
		} else {
			entity.getPersistentData().putDouble("selectedGacha", (entity.getPersistentData().getDouble("selectedGacha") + 1));
		}
	}
}
