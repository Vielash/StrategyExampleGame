package Strategy;

import Effect.HealthStealEffect;
import Effect.InstanceEffect;
import Model.Mage;

public class Necromancer implements SpellStrategy {
    int attackLowerBound = 12;
    int attackGap = 11;
    @Override
    public void castSpell(Mage caster, Mage target) {
        int damagePoint = attackLowerBound + (int)(Math.random() * attackGap);
        target.takeDamage(damagePoint);
        damageLog(damagePoint);


        double specialAttackChance = Math.random();
        if(specialAttackChance <= 0.16) {
            InstanceEffect stealHealth = new HealthStealEffect();
            stealHealth.apply(caster, target);
            System.out.println("I stole your 26 healthPoint HAHAHAHAHHA");
        }
    }
    public void damageLog(int damagePoint) {
        System.out.println("Blood splash damaged: " + damagePoint);
    }

}
