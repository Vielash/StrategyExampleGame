package Strategy;

import Effect.ImmuneStatus;
import Effect.StatusEffect;
import Model.Mage;

public class Fartmancer implements SpellStrategy {
    int attackLowerBound = 13;
    int attackGap = 10;
    @Override
    public void castSpell(Mage caster, Mage target) {
        int damagePoint = attackLowerBound + (int)(Math.random() * attackGap);
        target.takeDamage(damagePoint);
        damageLog(damagePoint);

        double specialAttackChance = Math.random();
        if(specialAttackChance <= 0.2) {
            attackLowerBound += 3;
            attackGap += 3;
            System.out.println("My fart got upgrade. ");
        }
    }
    public void damageLog(int damagePoint) {
        System.out.println("my fart choked you and damaged: " + damagePoint);
    }
}
