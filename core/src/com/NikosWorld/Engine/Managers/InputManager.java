package com.NikosWorld.Engine.Managers;

import com.NikosWorld.Engine.Components.Input.InputComponent;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;

/**
 * Created by Niko on 07.12.2015.
 */
public class InputManager implements InputProcessor {
    ArrayList<InputComponent> listeners;

    public InputManager(){
        listeners = new ArrayList<InputComponent>();
    }

    public void register(InputComponent listener){
        listeners.add(listener);
    }

    public void unregister(InputComponent listener){
        listeners.remove(listener);
    }
    @Override
    public boolean keyDown(int keycode) {
        for (InputComponent listener:listeners) {
            listener.keyDown(keycode);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        for (InputComponent listener:listeners) {
            listener.keyUp(keycode);
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        for (InputComponent listener:listeners) {
            listener.keyTyped(character);
        }
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        for (InputComponent listener:listeners) {
            listener.touchDown(screenX,screenY,pointer,button);
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for (InputComponent listener:listeners) {
            listener.touchDown(screenX,screenY,pointer,button);
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        for (InputComponent listener:listeners) {
            listener.touchDragged(screenX,screenY,pointer);
        }
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        for (InputComponent listener:listeners) {
            listener.mouseMoved(screenX,screenY);
        }
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        for (InputComponent listener:listeners) {
            listener.scrolled(amount);
        }
        return true;
    }
}
