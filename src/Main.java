import Model.Mage;
import Service.BattleEngine;
import Strategy.*;

public class Main {   public static void main(String[] args) {

    Mage pyromancer = new Mage("WARLOCK", new Necromancer());
    Mage necromancer = new Mage("PALADIN", new LightDancer());


    BattleEngine engine = new BattleEngine(pyromancer, necromancer);
    engine.startGame();
}
}
