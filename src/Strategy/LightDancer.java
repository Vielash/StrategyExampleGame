package Strategy;

import Effect.ImmuneStatus;
import Effect.StatusEffect;
import Model.Mage;

public class LightDancer implements SpellStrategy {
    int attackLowerBound = 12;
    int attackGap = 10;
    @Override
    public void castSpell(Mage caster, Mage target) {
        int damagePoint = attackLowerBound + (int)(Math.random() * attackGap);
        target.takeDamage(damagePoint);
        damageLog(damagePoint);

        double specialAttackChance = Math.random();
        if(specialAttackChance <= 0.2) {
            StatusEffect immune = new ImmuneStatus();
            caster.addEffect(immune);
        }
    }
    public void damageLog(int damagePoint) {
        System.out.println("By the holy light damaged:  " + damagePoint);
    }
}
