package Service;

import Model.Mage;

public class BattleEngine {

    private Mage player1;
    private Mage player2;
    private int turnCounter;

    public BattleEngine(Mage player1, Mage player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.turnCounter = 1;
    }

    public void startGame() {

        while (player1.isAlive() && player2.isAlive()) {
            System.out.println();
            System.out.println("Turn " + turnCounter + " begin!");

            player1.handleEffectsBeforeTurn(player2);
            waitForSeconds(1);
            player2.handleEffectsBeforeTurn(player1);
            waitForSeconds(2);

            System.out.println();

            player1.attack(player2);
            waitForSeconds(1);
            player2.attack(player1);
            waitForSeconds(2);

            System.out.println();

            player1.handleEffectsAfterTurn(player2);
            waitForSeconds(1);
            player2.handleEffectsAfterTurn(player1);

            waitForSeconds(2);
            player1.toString();
            player1.showHP();
            waitForSeconds(1);
            player2.toString();
            player2.showHP();

            checkGameStatus();
            turnCounter++;
        }
    }

    private void checkGameStatus() {
        if (!player1.isAlive()) {
            System.out.println(player2.toString() + " wins!");
        }
        if (!player2.isAlive()) {
            System.out.println(player1.toString() + " wins!");
        }
        if(!player1.isAlive() && !player2.isAlive()) {
            System.out.println("Honored Match TIE");
        }
    }
    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
