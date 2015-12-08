package com.NikosWorld.Engine.Managers;

import com.NikosWorld.Engine.State.GameState;
import com.NikosWorld.Engine.State.State;
import com.NikosWorld.Game.States.Game;
import com.NikosWorld.Game.States.Menu;
import com.NikosWorld.Game.States.SplashScreen;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Niko on 07.12.2015.
 */
public class StateManager {
    private State currentState;
    private GameState currentGameState;
    private HashMap<State,GameState> gameStates;

    public StateManager(){
        gameStates = new HashMap<State, GameState>();
    }

    public void setCurrentState(State state) {
        if(!gameStates.containsKey(state)){
            switch (state) {
                case SplashScreen:
                    gameStates.put(state,new SplashScreen());
                    break;
                case Menu:
                    gameStates.put(state,new Menu());
                    break;
                case Game:
                    gameStates.put(state,new Game());
                    break;
            }
        }
        if(currentGameState != null){
            currentGameState.pause();
        }
        currentGameState = gameStates.get(state);
        currentGameState.resume();
        currentState = state;
    }

    public State getCurrentState(){
        return this.currentState;
    }

    public void create(){
        currentGameState.create();
    }
    public void render(){
        currentGameState.render();
    }
    public void update() {
        currentGameState.update();
    }
    public void dispose(){
        currentGameState.dispose();
    }
}
