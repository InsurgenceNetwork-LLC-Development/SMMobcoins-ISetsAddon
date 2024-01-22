package org.insurgencedev.mobcoins;

import org.insurgencedev.insurgencesets.api.ISetsAPI;
import org.insurgencedev.insurgencesets.api.addon.ISetsAddon;
import org.insurgencedev.insurgencesets.api.addon.InsurgenceSetsAddon;
import org.insurgencedev.insurgencesets.libs.fo.Common;

@ISetsAddon(name = "SM-Mobcoins", version = "1.0.1", author = "Insurgence Dev Team", description = "Use SuperMobCoins's mobcoins as a currency")
public class MobCoinsCurrencyAddon extends InsurgenceSetsAddon {

    @Override
    public void onAddonReloadablesStart() {
        if (Common.doesPluginExist("SuperMobcoins")) {
            registerEvent(new MobCoinReceiveListener());
            ISetsAPI.getCurrencyManager().registerCurrency(new MobCoinCurrency());
        }
    }
}
