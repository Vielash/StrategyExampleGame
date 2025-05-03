package Effect;

import Model.Mage;

public class HealthStealEffect implements InstanceEffect {
    @Override
    public void apply(Mage caster, Mage target) {
        int healAmount = 20;
        caster.increaseHealth(healAmount, Mage.getKey());
    }
}
