package org.insurgencedev.mobcoins;

import lombok.NonNull;
import me.swanis.mobcoins.MobCoinsAPI;
import org.bukkit.entity.Player;
import org.insurgencedev.insurgencesets.api.ISetsAPI;
import org.insurgencedev.insurgencesets.models.currency.Currency;
import org.insurgencedev.insurgencesets.models.currency.TransactionTypes;

public class MobCoinCurrency extends Currency {

    public MobCoinCurrency() {
        super("Mobcoins", "SM");
    }

    @Override
    public boolean canAfford(@NonNull Player player, @NonNull Object o) {
        return MobCoinsAPI.getProfileManager().getProfile(player).getMobCoins() >= ((Number) o).longValue();
    }

    @NonNull
    @Override
    public TransactionTypes handleDeposit(@NonNull Player player, @NonNull Object o, String s) {
        if (!ISetsAPI.getArmorSetManager().isArmorSetValid(s)) {
            return TransactionTypes.FAIL;
        }

        MobCoinsAPI.getProfileManager().getProfile(player).setMobCoins(MobCoinsAPI.getProfileManager().getProfile(player).getMobCoins() + ((Number) o).longValue());
        return TransactionTypes.SUCCESS;
    }

    @NonNull
    @Override
    public TransactionTypes handleTransaction(@NonNull Player player, @NonNull Object o, String s) {
        if (!ISetsAPI.getArmorSetManager().isArmorSetValid(s)) {
            return TransactionTypes.FAIL;
        }

        long amount = ((Number) o).longValue();
        if (MobCoinsAPI.getProfileManager().getProfile(player).getMobCoins() < amount) {
            return TransactionTypes.FAIL_INSUFFICIENT_FUNDS;
        }

        MobCoinsAPI.getProfileManager().getProfile(player).setMobCoins(MobCoinsAPI.getProfileManager().getProfile(player).getMobCoins() - ((Number) o).longValue());
        return TransactionTypes.SUCCESS;
    }
}
