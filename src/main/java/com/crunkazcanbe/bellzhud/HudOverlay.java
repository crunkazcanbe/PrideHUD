package com.crunkazcanbe.pridehud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.text.SimpleDateFormat;
import java.util.Date;

/** Draws the custom pixel-themed widgets and (optionally) hides vanilla HUD bits. */
@SideOnly(Side.CLIENT)
public class HudOverlay {
    private final Minecraft mc = Minecraft.getMinecraft();
    private final SimpleDateFormat clockFmt = new SimpleDateFormat("h:mm a");

    /** Hide vanilla elements by cancelling their render pass. */
    @SubscribeEvent
    public void onPre(RenderGameOverlayEvent.Pre e) {
        switch (e.getType()) {
            case HOTBAR:     if (HudConfig.hideVanillaHotbar) e.setCanceled(true); break;
            case HEALTH:     if (HudConfig.hideVanillaHealth) e.setCanceled(true); break;
            case FOOD:       if (HudConfig.hideVanillaFood)   e.setCanceled(true); break;
            case ARMOR:      if (HudConfig.hideVanillaArmor)  e.setCanceled(true); break;
            case EXPERIENCE: if (HudConfig.hideVanillaExp)    e.setCanceled(true); break;
            default: break;
        }
    }

    /** Draw our widgets on the TEXT overlay layer. */
    @SubscribeEvent
    public void onPost(RenderGameOverlayEvent.Post e) {
        if (e.getType() != ElementType.TEXT) return;
        if (mc.player == null || mc.world == null) return;
        if (mc.gameSettings.showDebugInfo) return; // stay out of the way of F3

        if (HudConfig.showCoords) {
            BlockPos p = new BlockPos(mc.player.posX, mc.player.posY, mc.player.posZ);
            draw("XYZ  " + p.getX() + "  " + p.getY() + "  " + p.getZ(),
                 HudConfig.coordsX, HudConfig.coordsY);
        }
        if (HudConfig.showFps)
            draw(Minecraft.getDebugFPS() + " fps", HudConfig.fpsX, HudConfig.fpsY);
        if (HudConfig.showClock)
            draw(clockFmt.format(new Date()), HudConfig.clockX, HudConfig.clockY);
        if (HudConfig.showDirection)
            draw("Facing " + mc.player.getHorizontalFacing().getName(),
                 HudConfig.dirX, HudConfig.dirY);
        if (HudConfig.showBiome)
            draw(mc.world.getBiome(new BlockPos(mc.player)).getBiomeName(),
                 HudConfig.biomeX, HudConfig.biomeY);
    }

    private void draw(String s, int x, int y) {
        if (HudConfig.panelBehindText) {
            int w = mc.fontRenderer.getStringWidth(s);
            Gui.drawRect(x - 3, y - 2, x + w + 3, y + 10, 0xB0101822); // dark pixel panel
            Gui.drawRect(x - 3, y - 2, x + w + 3, y - 1, 0xFF2ED6B0);   // teal accent line
        }
        mc.fontRenderer.drawString(s, x, y, HudConfig.textColor, HudConfig.textShadow);
    }
}
