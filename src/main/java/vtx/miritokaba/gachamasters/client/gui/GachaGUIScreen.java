package vtx.miritokaba.gachamasters.client.gui;

import vtx.miritokaba.gachamasters.world.inventory.GachaGUIMenu;
import vtx.miritokaba.gachamasters.procedures.SelectGacha9GUIProcedure;
import vtx.miritokaba.gachamasters.procedures.SelectGacha8GUIProcedure;
import vtx.miritokaba.gachamasters.procedures.SelectGacha7GUIProcedure;
import vtx.miritokaba.gachamasters.procedures.SelectGacha6GUIProcedure;
import vtx.miritokaba.gachamasters.procedures.SelectGacha5GUIProcedure;
import vtx.miritokaba.gachamasters.procedures.SelectGacha4GUIProcedure;
import vtx.miritokaba.gachamasters.procedures.SelectGacha3GUIProcedure;
import vtx.miritokaba.gachamasters.procedures.SelectGacha2GUIProcedure;
import vtx.miritokaba.gachamasters.procedures.SelectGacha1GUIProcedure;
import vtx.miritokaba.gachamasters.procedures.SelectGacha10GUIProcedure;
import vtx.miritokaba.gachamasters.network.GachaGUIButtonMessage;
import vtx.miritokaba.gachamasters.GachaMastersMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class GachaGUIScreen extends AbstractContainerScreen<GachaGUIMenu> {
	private final static HashMap<String, Object> guistate = GachaGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_empty1;
	Button button_x;
	Button button_1;
	Button button_10;

	public GachaGUIScreen(GachaGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("gacha_masters:textures/screens/gacha_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("gacha_masters:textures/screens/gacha_gui.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + 0, 0, 0, 400, 200, 400, 200);

		if (SelectGacha1GUIProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("gacha_masters:textures/screens/gacha_1.png"));
			this.blit(ms, this.leftPos + 5, this.topPos + 5, 0, 0, 390, 190, 390, 190);
		}
		if (SelectGacha2GUIProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("gacha_masters:textures/screens/gacha_2.png"));
			this.blit(ms, this.leftPos + 4, this.topPos + 3, 0, 0, 390, 190, 390, 190);
		}
		if (SelectGacha3GUIProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("gacha_masters:textures/screens/gacha_3.png"));
			this.blit(ms, this.leftPos + 4, this.topPos + 3, 0, 0, 390, 190, 390, 190);
		}
		if (SelectGacha4GUIProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("gacha_masters:textures/screens/gacha_4.png"));
			this.blit(ms, this.leftPos + 4, this.topPos + 3, 0, 0, 390, 190, 390, 190);
		}
		if (SelectGacha5GUIProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("gacha_masters:textures/screens/gacha_5.png"));
			this.blit(ms, this.leftPos + 4, this.topPos + 3, 0, 0, 390, 190, 390, 190);
		}
		if (SelectGacha6GUIProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("gacha_masters:textures/screens/gacha_6.png"));
			this.blit(ms, this.leftPos + 4, this.topPos + 3, 0, 0, 390, 190, 390, 190);
		}
		if (SelectGacha7GUIProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("gacha_masters:textures/screens/gacha_7.png"));
			this.blit(ms, this.leftPos + 4, this.topPos + 3, 0, 0, 390, 190, 390, 190);
		}
		if (SelectGacha8GUIProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("gacha_masters:textures/screens/gacha_8.png"));
			this.blit(ms, this.leftPos + 4, this.topPos + 3, 0, 0, 390, 190, 390, 190);
		}
		if (SelectGacha9GUIProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("gacha_masters:textures/screens/gacha_9.png"));
			this.blit(ms, this.leftPos + 4, this.topPos + 3, 0, 0, 390, 190, 390, 190);
		}
		if (SelectGacha10GUIProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("gacha_masters:textures/screens/gacha_10.png"));
			this.blit(ms, this.leftPos + 4, this.topPos + 3, 0, 0, 390, 190, 390, 190);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_empty = new Button(this.leftPos + 359, this.topPos + 176, 35, 20, Component.translatable("gui.gacha_masters.gacha_gui.button_empty"), e -> {
			if (true) {
				GachaMastersMod.PACKET_HANDLER.sendToServer(new GachaGUIButtonMessage(0, x, y, z));
				GachaGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new Button(this.leftPos + 3, this.topPos + 176, 35, 20, Component.translatable("gui.gacha_masters.gacha_gui.button_empty1"), e -> {
			if (true) {
				GachaMastersMod.PACKET_HANDLER.sendToServer(new GachaGUIButtonMessage(1, x, y, z));
				GachaGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		button_x = new Button(this.leftPos + 364, this.topPos + 3, 30, 20, Component.translatable("gui.gacha_masters.gacha_gui.button_x"), e -> {
			if (true) {
				GachaMastersMod.PACKET_HANDLER.sendToServer(new GachaGUIButtonMessage(2, x, y, z));
				GachaGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_x", button_x);
		this.addRenderableWidget(button_x);
		button_1 = new Button(this.leftPos + 169, this.topPos + 176, 30, 20, Component.translatable("gui.gacha_masters.gacha_gui.button_1"), e -> {
			if (true) {
				GachaMastersMod.PACKET_HANDLER.sendToServer(new GachaGUIButtonMessage(3, x, y, z));
				GachaGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_10 = new Button(this.leftPos + 200, this.topPos + 176, 35, 20, Component.translatable("gui.gacha_masters.gacha_gui.button_10"), e -> {
			if (true) {
				GachaMastersMod.PACKET_HANDLER.sendToServer(new GachaGUIButtonMessage(4, x, y, z));
				GachaGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_10", button_10);
		this.addRenderableWidget(button_10);
	}
}
