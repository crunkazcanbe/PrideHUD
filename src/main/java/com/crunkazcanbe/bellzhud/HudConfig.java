package com.crunkazcanbe.pridehud;

import net.minecraftforge.common.config.Configuration;
import java.io.File;

/**
 * Simple config for Pride HUD. Each widget has an enable flag + x/y anchor.
 * Vanilla-hide flags let you remove default HUD pieces so your custom layout
 * is clean. Edit config/pridehud.cfg or (later) the in-game editor.
 */
public class HudConfig {
    // custom widgets
    public static boolean showCoords = true;
    public static boolean showFps = true;
    public static boolean showClock = true;      // real-world time
    public static boolean showDirection = true;  // facing N/E/S/W
    public static boolean showBiome = false;

    // widget anchor positions (pixels from top-left; -1 x = auto right-align)
    public static int coordsX = 4,  coordsY = 4;
    public static int fpsX = 4,     fpsY = 16;
    public static int clockX = 4,   clockY = 28;
    public static int dirX = 4,     dirY = 40;
    public static int biomeX = 4,   biomeY = 52;

    // styling
    public static boolean textShadow = true;
    public static int textColor = 0xFFFFFF;       // white
    public static boolean panelBehindText = true; // dark pixel panel behind widgets

    // hide vanilla elements
    public static boolean hideVanillaHotbar = false;
    public static boolean hideVanillaHealth = false;
    public static boolean hideVanillaFood = false;
    public static boolean hideVanillaArmor = false;
    public static boolean hideVanillaExp = false;

    private static Configuration cfg;

    public static void load(File file) {
        cfg = new Configuration(file);
        cfg.load();
        String w = "widgets", p = "positions", s = "style", v = "hide_vanilla";

        showCoords    = cfg.getBoolean("showCoords", w, showCoords, "Show XYZ coordinates");
        showFps       = cfg.getBoolean("showFps", w, showFps, "Show FPS");
        showClock     = cfg.getBoolean("showClock", w, showClock, "Show real-world clock");
        showDirection = cfg.getBoolean("showDirection", w, showDirection, "Show facing direction");
        showBiome     = cfg.getBoolean("showBiome", w, showBiome, "Show current biome");

        coordsX = cfg.getInt("coordsX", p, coordsX, -10000, 10000, "");
        coordsY = cfg.getInt("coordsY", p, coordsY, -10000, 10000, "");
        fpsX = cfg.getInt("fpsX", p, fpsX, -10000, 10000, "");
        fpsY = cfg.getInt("fpsY", p, fpsY, -10000, 10000, "");
        clockX = cfg.getInt("clockX", p, clockX, -10000, 10000, "");
        clockY = cfg.getInt("clockY", p, clockY, -10000, 10000, "");
        dirX = cfg.getInt("dirX", p, dirX, -10000, 10000, "");
        dirY = cfg.getInt("dirY", p, dirY, -10000, 10000, "");
        biomeX = cfg.getInt("biomeX", p, biomeX, -10000, 10000, "");
        biomeY = cfg.getInt("biomeY", p, biomeY, -10000, 10000, "");

        textShadow      = cfg.getBoolean("textShadow", s, textShadow, "Drop shadow on text");
        panelBehindText = cfg.getBoolean("panelBehindText", s, panelBehindText, "Dark pixel panel behind widgets");
        textColor       = (int) Long.parseLong(
                cfg.getString("textColorHex", s, "FFFFFF", "Text color, RRGGBB hex"), 16);

        hideVanillaHotbar = cfg.getBoolean("hideHotbar", v, hideVanillaHotbar, "");
        hideVanillaHealth = cfg.getBoolean("hideHealth", v, hideVanillaHealth, "");
        hideVanillaFood   = cfg.getBoolean("hideFood", v, hideVanillaFood, "");
        hideVanillaArmor  = cfg.getBoolean("hideArmor", v, hideVanillaArmor, "");
        hideVanillaExp    = cfg.getBoolean("hideExp", v, hideVanillaExp, "");

        if (cfg.hasChanged()) cfg.save();
    }
}
