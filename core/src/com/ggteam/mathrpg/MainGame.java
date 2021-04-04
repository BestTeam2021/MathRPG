package com.ggteam.mathrpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class MainGame extends Game {
	private Screen gameScreen;

	public MainGame() {
		
	}

	public void create() {
		this.setScreen(new MenuScreen(this));
	}
}
