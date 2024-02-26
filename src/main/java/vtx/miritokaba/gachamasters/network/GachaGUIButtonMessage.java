
package vtx.miritokaba.gachamasters.network;

import vtx.miritokaba.gachamasters.world.inventory.GachaGUIMenu;
import vtx.miritokaba.gachamasters.procedures.RollGachax10Procedure;
import vtx.miritokaba.gachamasters.procedures.RollGachaProcedure;
import vtx.miritokaba.gachamasters.procedures.QuitGachaGUIProcedure;
import vtx.miritokaba.gachamasters.procedures.PrevGachaProcedure;
import vtx.miritokaba.gachamasters.procedures.NextGachaProcedure;
import vtx.miritokaba.gachamasters.GachaMastersMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GachaGUIButtonMessage {
	private final int buttonID, x, y, z;

	public GachaGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public GachaGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(GachaGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(GachaGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = GachaGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			NextGachaProcedure.execute(entity);
		}
		if (buttonID == 1) {

			PrevGachaProcedure.execute(entity);
		}
		if (buttonID == 2) {

			QuitGachaGUIProcedure.execute(entity);
		}
		if (buttonID == 3) {

			RollGachaProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			RollGachax10Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		GachaMastersMod.addNetworkMessage(GachaGUIButtonMessage.class, GachaGUIButtonMessage::buffer, GachaGUIButtonMessage::new, GachaGUIButtonMessage::handler);
	}
}
