package Effect;

import Model.Mage;

public class BurningStatusEffect implements StatusEffect {
    int turnsLeft = 3;

    @Override
    public void beforeTurn(Mage caster, Mage target) {

    }

    @Override
    public void afterTurn(Mage caster, Mage target) {
        caster.takeDamage(5);
        System.out.println("Yanıyom le. +5 Damage");
        turnsLeft--;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
