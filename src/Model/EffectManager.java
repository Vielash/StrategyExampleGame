package Model;

import Effect.StatusEffect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EffectManager {
    private final List<StatusEffect> effectList = new ArrayList<>();

    public void addEffect(StatusEffect effect) {
        effectList.add(effect);
    }

    public void handleEffectsBeforeTurn(Mage caster, Mage target) {
        for (StatusEffect effect : effectList) {
            effect.beforeTurn(caster, target);
        }
    }

    public void handleEffectsAfterTurn(Mage caster, Mage target) {
        Iterator<StatusEffect> it = effectList.iterator();
        while (it.hasNext()) {
            StatusEffect effect = it.next();
            effect.afterTurn(caster, target);
            if (effect.isExpired()) {
                it.remove();
            }
        }
    }
}