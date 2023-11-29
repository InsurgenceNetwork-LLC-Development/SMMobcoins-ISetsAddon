package org.insurgencedev.mobcoins;

import org.bukkit.Bukkit;
import org.insurgencedev.insurgencesets.api.ISetsAPI;
import org.insurgencedev.insurgencesets.api.addon.ISetsAddon;
import org.insurgencedev.insurgencesets.api.addon.InsurgenceSetsAddon;

@ISetsAddon(name = "SM-Mobcoins", version = "1.0.0", author = "Insurgence Dev Team", description = "Use SuperMobCoins's mobcoins as a currency")
public class MobCoinsCurrencyAddon extends InsurgenceSetsAddon {

    @Override
    public void onAddonReloadablesStart() {
        if (isDependentEnabled()) {
            registerEvent(new MobCoinReceiveListener());
            ISetsAPI.getCurrencyManager().registerCurrency(new MobCoinCurrency());
        }
    }

    public static boolean isDependentEnabled() {
        return Bukkit.getPluginManager().isPluginEnabled("SuperMobCoins");
    }

}
