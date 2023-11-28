# SMMobcoins-ISetsAddon
SuperMobCoins plugin is required

This addon allows the mobcoin currency from SuperMobCoins to be used as a currency to upgrade the armor set pieces.

```yaml
Cost:
  - Type: Gems
    Amount: 10000
```

You also have the ability to boost the amount of mobcoins the player receives when killing mobs. The namespace must be `CURRENCY` and type `MobCoins`.

```yaml
Boosts:
  - Namespace: CURRENCY
    Type: MobCoins
    Percent: false
    Settings:
      Boost_Amount: 10
```
