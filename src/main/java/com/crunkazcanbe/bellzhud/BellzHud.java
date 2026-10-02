package com.crunkazcanbe.pridehud;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

/**
 * Pride HUD — a client-side HUD customizer for Minecraft 1.12.2.
 * Inspired by Keksuccino's Spiffy HUD (which has no 1.12.2 build), written from
 * scratch. v1: config-driven — hide/keep vanilla HUD elements and draw custom
 * pixel-themed info widgets (coords, FPS, clock, real time, direction).
 */
@Mod(modid = PrideHud.MODID, name = PrideHud.NAME, version = PrideHud.VERSION,
     clientSideOnly = true, acceptedMinecraftVersions = "[1.12.2]")
public class PrideHud {
    public static final String MODID = "pridehud";
    public static final String NAME = "Pride HUD";
    public static final String VERSION = "0.1.0";

    public static Logger LOGGER;

    @Mod.EventHandler
    @SideOnly(Side.CLIENT)
    public void preInit(FMLPreInitializationEvent e) {
        LOGGER = e.getModLog();
        HudConfig.load(e.getSuggestedConfigurationFile());
        LOGGER.info("Pride HUD loading — config ready");
    }

    @Mod.EventHandler
    @SideOnly(Side.CLIENT)
    public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new HudOverlay());
        LOGGER.info("Pride HUD overlay registered");
    }
}
