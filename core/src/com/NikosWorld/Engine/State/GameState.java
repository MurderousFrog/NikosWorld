package com.NikosWorld.Engine.State;

import com.NikosWorld.Engine.Managers.CameraManager;

/**
 * Created by Niko on 07.12.2015.
 */
public class GameState implements IGameState {

    private CameraManager cameraManager;

    public GameState(){
        this.create();
    }

    @Override
    public void create() {
        cameraManager = new CameraManager();
    }

    @Override
    public void render() {

    }

    @Override
    public void update() {

    }

    @Override
    public void resize() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}


