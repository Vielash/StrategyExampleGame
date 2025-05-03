package Strategy;

import Effect.BurningStatusEffect;
import Effect.StatusEffect;
import Model.Mage;

public class Pyromancer implements SpellStrategy{
    int attackLowerBound = 15;
    int attackGap = 10;
    @Override
    public void castSpell(Mage caster, Mage target) {
        int damagePoint = attackLowerBound + (int)(Math.random() * attackGap);
        target.takeDamage(damagePoint);
        damageLog(damagePoint);

        double specialAttackChance = Math.random();
        if(specialAttackChance <= 0.2) {
            StatusEffect burning = new BurningStatusEffect();
            target.addEffect(burning);
        }
    }
    public void damageLog(int damagePoint) {
        System.out.println("Fireball damaged: " + damagePoint);
    }

}
