package Strategy;

import Effect.BurningStatusEffect;
import Effect.FrozenStatusEffect;
import Effect.StatusEffect;
import Model.Mage;

public class Cyromancer implements SpellStrategy {

    int attackLowerBound = 12;
    int attackGap = 10;
    @Override
    public void castSpell(Mage caster, Mage target) {
        int damagePoint = attackLowerBound + (int)(Math.random() * attackGap);
        target.takeDamage(damagePoint);
        damageLog(damagePoint);

        double specialAttackChance = Math.random();
        if(specialAttackChance <= 0.2) {
            StatusEffect frozen = new FrozenStatusEffect();
            target.addEffect(frozen);
            System.out.println("U got frozen XD ");
        }
    }
    public void damageLog(int damagePoint) {
        System.out.println("Frost Bolt damaged:  " + damagePoint);
    }
}
