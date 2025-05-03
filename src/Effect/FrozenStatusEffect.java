package Effect;

import Model.Mage;

public class FrozenStatusEffect implements StatusEffect{

    int turnsLeft = 2;
    int tempHealth;
    @Override
    public void beforeTurn(Mage caster, Mage target) {
        caster.canNotAttack(true);

    }

    @Override
    public void afterTurn(Mage caster, Mage target) {
        caster.canNotAttack(false);
        turnsLeft--;

    }

    @Override
    public boolean isExpired() {
        if (turnsLeft == 0) {
            return true;
        }
        return false;
    }
}
