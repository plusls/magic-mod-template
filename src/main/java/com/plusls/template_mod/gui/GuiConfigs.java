package com.plusls.template_mod.gui;

import com.plusls.template_mod.TemplateMod;
import com.plusls.template_mod.config.Configs;
import top.hendrixshen.magiclib.config.ConfigManager;
import top.hendrixshen.magiclib.gui.ConfigGui;

public class GuiConfigs extends ConfigGui {

    private static GuiConfigs INSTANCE;

    private GuiConfigs(String identifier, String defaultTab, ConfigManager configManager) {
        super(identifier, defaultTab, configManager, () -> TemplateMod.translate("gui.title.configs", TemplateMod.MOD_VERSION));
    }

    public static GuiConfigs getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GuiConfigs(TemplateMod.MOD_ID, Configs.ConfigCategory.GENERIC, ConfigManager.get(TemplateMod.MOD_ID));
        }
        return INSTANCE;
    }
}