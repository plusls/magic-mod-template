package com.plusls.template_mod;

import com.plusls.template_mod.config.Configs;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.hendrixshen.magiclib.config.ConfigHandler;
import top.hendrixshen.magiclib.config.ConfigManager;

public class TemplateMod implements ModInitializer, ClientModInitializer {

    private static final int CONFIG_VERSION = 1;

    public static final String MOD_ID = "template_mod";

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    //#if MC > 11802
    //$$ public static final String CURRENT_MOD_ID = MOD_ID + "-snapshot";
    //#elseif MC > 11701
    public static final String CURRENT_MOD_ID = MOD_ID + "-1_18_2";
    //#elseif MC > 11605
    //$$ public static final String CURRENT_MOD_ID = MOD_ID + "-1_17_1";
    //#elseif MC > 11502
    //$$ public static final String CURRENT_MOD_ID = MOD_ID + "-1_16_5";
    //#elseif MC > 11404
    //$$ public static final String CURRENT_MOD_ID = MOD_ID + "-1_15_2";
    //#else
    //$$ public static final String CURRENT_MOD_ID = MOD_ID + "-1_14_4";
    //#endif

    public static final String MOD_NAME = FabricLoader.getInstance().getModContainer(CURRENT_MOD_ID)
            .orElseThrow(RuntimeException::new).getMetadata().getName();
    public static final String MOD_VERSION = FabricLoader.getInstance().getModContainer(CURRENT_MOD_ID)
            .orElseThrow(RuntimeException::new).getMetadata().getVersion().getFriendlyString();

    public static ConfigHandler configHandler;

    public static String translate(String key, Object... objects) {
        return I18n.get(MOD_ID + "." + key, objects);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
    }

    @Override
    public void onInitializeClient() {
        ConfigManager cm = ConfigManager.get(MOD_ID);
        cm.parseConfigClass(Configs.class);
        configHandler = new ConfigHandler(MOD_ID, cm, CONFIG_VERSION, Configs::preDeserialize, Configs::postSerialize);
        ConfigHandler.register(configHandler);
        Configs.init(cm);
    }
}
