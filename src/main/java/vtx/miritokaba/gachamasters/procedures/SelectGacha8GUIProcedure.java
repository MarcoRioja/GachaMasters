package vtx.miritokaba.gachamasters.procedures;

import net.minecraft.world.entity.Entity;

public class SelectGacha8GUIProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("selectedGacha") >= 0) {
			if (entity.getPersistentData().getDouble("selectedGacha") == 7) {
				return true;
			}
		}
		return false;
	}
}
