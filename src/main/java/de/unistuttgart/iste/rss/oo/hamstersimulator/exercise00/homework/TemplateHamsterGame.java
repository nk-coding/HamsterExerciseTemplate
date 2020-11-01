package de.unistuttgart.iste.rss.oo.hamstersimulator.exercise00.homework;

import de.unistuttgart.iste.rss.oo.hamstersimulator.exceptions.FrontBlockedException;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.SimpleHamsterGame;
import de.unistuttgart.iste.rss.oo.hamstersimulator.server.http.client.HamsterClient;
import de.unistuttgart.iste.rss.oo.hamstersimulator.ui.javafx.JavaFXInputInterface;
import de.unistuttgart.iste.rss.oo.hamstersimulator.ui.javafx.JavaFXUI;


/**
 * A template SimpleHamsterGame
 */
public class TemplateHamsterGame extends SimpleHamsterGame {
    
    /**
     * Put the hamster code into this method.
     * Solve the task in this method NOT in the constructor
     */
    @Override
    protected void run() {
        this.loadTerritoryFromResourceFile("/territories/territoryExample00.ter");
        //this.displayInNewGameWindow();
        JavaFXUI.displayInNewGameWindow(game.getModelViewAdapter());
        HamsterClient.startAndConnectToServer(game.getModelViewAdapter());
        game.startGame();

        //paule.move();
        //game.getModelViewAdapter().getGameController().abortOrStopGame();
        for (int i = 0; i < 10; i++) {
            while (paule.frontIsClear()) {
                paule.move();
            }
            paule.turnLeft();
        }
    }
}
