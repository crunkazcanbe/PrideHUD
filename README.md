# Pride HUD

A small client-side HUD customizer for Minecraft 1.12.2. It draws pixel-style info widgets (coordinates, FPS, clock, facing, biome) and can hide parts of the vanilla HUD.

## About

This mod adds a few compact text widgets to your screen, each on a dark panel with a teal accent line, and lets you switch off vanilla HUD pieces so you can make your own layout. It was written from scratch and is inspired by Spiffy HUD, which has no 1.12.2 version.

It was built for the Pride modpack, a 1.12.2 pack with about 750 mods. It is client-only, has no dependencies and works in any 1.12.2 pack. Servers do not need it.

This is version 0.1.0. Everything is set in the config file; there is no in-game editor yet.

## Features

- **Widgets**, each with its own on/off switch and screen position:

  | Widget | Shows | On by default |
  |---|---|---|
  | Coordinates | `XYZ  x  y  z` (block position) | Yes |
  | FPS | `<n> fps` | Yes |
  | Clock | Real-world time, e.g. `9:41 PM` | Yes |
  | Direction | `Facing north/east/south/west` | Yes |
  | Biome | Current biome name | No |

- **Styling**: a dark panel behind each widget, an optional text shadow, and any text colour (hex).
- **Hide vanilla elements**: hotbar, health, food, armor and experience bar, each separately.
- Widgets hide themselves while the F3 debug screen is open.
- Client-side only (`clientSideOnly = true`).

## Commands

None.

## Keybinds

None.

## Config

The config is the mod's `.cfg` file in the `config/` folder. It is created on first launch. Restart the game after editing it.

**widgets**

| Key | Default | Effect |
|---|---|---|
| `showCoords` | `true` | Show XYZ coordinates |
| `showFps` | `true` | Show FPS |
| `showClock` | `true` | Show the real-world clock |
| `showDirection` | `true` | Show facing direction |
| `showBiome` | `false` | Show the current biome |

**positions** (pixels from the top-left of the screen, range −10000 to 10000)

| Key | Default |
|---|---|
| `coordsX` / `coordsY` | `4` / `4` |
| `fpsX` / `fpsY` | `4` / `16` |
| `clockX` / `clockY` | `4` / `28` |
| `dirX` / `dirY` | `4` / `40` |
| `biomeX` / `biomeY` | `4` / `52` |

**style**

| Key | Default | Effect |
|---|---|---|
| `textShadow` | `true` | Drop shadow on text |
| `panelBehindText` | `true` | Dark panel with a teal top line behind each widget |
| `textColorHex` | `FFFFFF` | Text colour as RRGGBB hex |

**hide_vanilla**

| Key | Default | Effect |
|---|---|---|
| `hideHotbar` | `false` | Hide the vanilla hotbar |
| `hideHealth` | `false` | Hide hearts |
| `hideFood` | `false` | Hide the hunger bar |
| `hideArmor` | `false` | Hide the armor bar |
| `hideExp` | `false` | Hide the experience bar |

## Requirements

- Minecraft 1.12.2
- Forge 14.23.5.2860 or newer, or Cleanroom
- No other mods

## Install

1. Download the jar from the releases page.
2. Put it in your client's `mods/` folder.
3. Launch once, then edit the config file in `config/` to taste.

## Building

```sh
./gradlew build
```

The jar is written to `build/libs/`. The build targets Java 8.

## License

MIT License. © 2026 crunkazcanbe.

## Credits

Made by crunkazcanbe, with Claude. Inspired by Spiffy HUD.
