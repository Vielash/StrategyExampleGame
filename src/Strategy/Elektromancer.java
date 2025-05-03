package Strategy;

import Effect.ImmuneStatus;
import Effect.StatusEffect;
import Model.Mage;

import java.sql.SQLOutput;

public class Elektromancer implements SpellStrategy {
    int attackLowerBound = 14;
    int attackGap = 10;
    @Override
    public void castSpell(Mage caster, Mage target) {
        int damagePoint = attackLowerBound + (int)(Math.random() * attackGap);
        target.takeDamage(damagePoint);;
        damageLog(damagePoint);

        double specialAttackChance = Math.random();
        if(specialAttackChance <= 0.2) {
            target.takeDamage(damagePoint);
            System.out.println("AGAINNNN ZIPTTTTT. Damaged: " + damagePoint);
        }
    }
    public void damageLog(int damagePoint) {
        System.out.println("Electrowizary: " + damagePoint);
    }
}
