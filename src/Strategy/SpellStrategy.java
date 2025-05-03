package Strategy;

import Model.Mage;

public interface SpellStrategy  {
    void castSpell(Mage caster, Mage target);
}
