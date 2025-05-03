package Model;

import Effect.StatusEffect;
import Strategy.SpellStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mage {
    private int healthPoint = 100;
    SpellStrategy spell;
    String name;
    boolean canNotAttack = false;

    public Mage(String name ,SpellStrategy spell) {
        this.spell = spell;
        this.name = name;
    }
    public static class Key {
        private Key() {}
    }
    private static final Key KEY = new Key();
    public static Key getKey() {
        return KEY;
    }
    private final EffectManager effectManager = new EffectManager();
    public void addEffect(StatusEffect effect) {
        effectManager.addEffect(effect);
    }

    public void handleEffectsBeforeTurn(Mage target) {
        effectManager.handleEffectsBeforeTurn(this, target);
    }
    public void handleEffectsAfterTurn(Mage target) {
        effectManager.handleEffectsAfterTurn(this, target);
    }


    public void takeDamage(int damagePoint) {
        this.healthPoint -= damagePoint;
    }

    public boolean canNotAttack(boolean bool) {
        canNotAttack = bool;
        return canNotAttack;
    }
    public void attack(Mage target){
        if (canNotAttack == true) {
            return;
        }
        spell.castSpell(this, target);
    }
    public boolean isAlive() {
        if(healthPoint <= 0) {
            return false;
        }
        return true;
    }

    public void increaseHealth(int amount, Key key) {
        if (key != KEY) {
            throw new SecurityException("Unauthorized access to increaseHealth!");
        }
        this.healthPoint += amount;
    }

    @Override
    public String toString() {
        return name + " (" + spell.getClass().getSimpleName() + ")";
    }

    public int showHP() {
        System.out.println(name + "'s HP is: " + healthPoint);
        return healthPoint;
    }
}
