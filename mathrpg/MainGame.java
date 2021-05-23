package com.ggteam.mathrpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainGame extends Game {
	private Screen gameScreen;
	private static Viewport viewport;
	private static Viewport viewportInterfaceStage;
	public MainGame() {
		
	}

	public static Viewport getViewportInterfaceStage() {
		return viewportInterfaceStage;
	}

	public static void setViewportInterfaceStage(Viewport viewportInterfaceStage) {
		MainGame.viewportInterfaceStage = viewportInterfaceStage;
	}

	public void create() {
		viewportInterfaceStage = new ExtendViewport(Gdx.graphics.getWidth(),  Gdx.graphics.getHeight());
		InterfaceManager.game = this;
		this.setScreen(new MenuScreen(this));

	}
}
