package vtx.miritokaba.gachamasters.procedures;

import net.minecraft.world.entity.Entity;

public class PrevGachaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("selectedGacha") == 0) {
			entity.getPersistentData().putDouble("selectedGacha", 4);
		} else {
			entity.getPersistentData().putDouble("selectedGacha", (entity.getPersistentData().getDouble("selectedGacha") - 1));
		}
	}
}
