package com.plusls.template_mod.config;

import com.plusls.template_mod.TemplateMod;
import com.plusls.template_mod.gui.GuiConfigs;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import top.hendrixshen.magiclib.config.ConfigHandler;
import top.hendrixshen.magiclib.config.ConfigManager;
import top.hendrixshen.magiclib.config.annotation.Config;
import top.hendrixshen.magiclib.config.annotation.Hotkey;

public class Configs {
    @Config(category = ConfigCategory.GENERIC)
    public static boolean debug = false;

    @Hotkey(hotkey = "E,M,P")
    @Config(category = ConfigCategory.GENERIC)
    public static ConfigHotkey openConfigGui;

    public static class ConfigCategory {
        public static final String GENERIC = "generic";
    }

    public static void init(ConfigManager cm) {
        cm.setValueChangeCallback("debug", option -> {
            if (debug) {
                Configurator.setLevel(TemplateMod.MOD_ID, Level.toLevel("DEBUG"));
            } else {
                Configurator.setLevel(TemplateMod.MOD_ID, Level.toLevel("INFO"));
            }
            GuiConfigs.getInstance().reDraw();
        });

        if (debug) {
            Configurator.setLevel(TemplateMod.MOD_ID, Level.toLevel("DEBUG"));
        }

        openConfigGui.getKeybind().setCallback((keyAction, iKeybind) -> {
            GuiConfigs screen = GuiConfigs.getInstance();
            screen.setParentGui(Minecraft.getInstance().screen);
            Minecraft.getInstance().setScreen(screen);
            return true;
        });
    }

    public static void preDeserialize(ConfigHandler configHandler) {
    }

    public static void postSerialize(ConfigHandler configHandler) {
    }
}