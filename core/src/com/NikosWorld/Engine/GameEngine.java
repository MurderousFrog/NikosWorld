package com.NikosWorld.Engine;

import com.NikosWorld.Engine.Managers.StateManager;
import com.NikosWorld.Engine.State.State;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;

/**
 * Created by Niko on 07.12.2015.
 */
public class GameEngine extends ApplicationAdapter{

    private StateManager stateManager;
    private AssetManager assetManager;

    @Override
    public void create(){
        stateManager = new StateManager();
        assetManager = new AssetManager();
        stateManager.setCurrentState(State.SplashScreen);
        stateManager.create();
    }
    @Override
    public void render(){
        stateManager.update();
        stateManager.render();
    }
    @Override
    public void dispose(){
        stateManager.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }
}
