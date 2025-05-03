package Effect;

import Model.Mage;

public class ImmuneStatus implements StatusEffect {
    int turnsLeft = 2;
    @Override
    public void beforeTurn(Mage caster, Mage target) {
        target.canNotAttack(true);
        System.out.println("I have Divine Shield, no damage can hurt me.");
    }

    @Override
    public void afterTurn(Mage caster, Mage target) {
        target.canNotAttack(false);
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
