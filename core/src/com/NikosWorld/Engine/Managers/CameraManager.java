package com.NikosWorld.Engine.Managers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import javafx.scene.Camera;

/**
 * Created by Niko on 07.12.2015.
 */
public class CameraManager {
    private OrthographicCamera camera;

    public CameraManager(){

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 50, 50);
    }
}
