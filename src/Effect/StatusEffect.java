package Effect;

import Model.Mage;

public interface StatusEffect {
    void beforeTurn(Mage caster, Mage target);
    void afterTurn(Mage caster, Mage target);
    boolean isExpired();
}
