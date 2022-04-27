package com.plusls.template_mod.compat.modmenu;

import com.plusls.template_mod.TemplateMod;

public class WrapperModMenuApiImpl extends ModMenuApiImpl {

    @Override
    public String getModIdCompat() {
        return TemplateMod.MOD_ID;
    }

}