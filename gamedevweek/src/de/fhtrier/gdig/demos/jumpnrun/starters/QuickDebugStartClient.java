package de.fhtrier.gdig.demos.jumpnrun.starters;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import de.fhtrier.gdig.demos.jumpnrun.client.ClientGame;
import de.fhtrier.gdig.demos.jumpnrun.client.states.debug.DebugNoMenuStarterState;
import de.fhtrier.gdig.demos.jumpnrun.common.Lobby;
import de.fhtrier.gdig.demos.jumpnrun.identifiers.Settings;

public class QuickDebugStartClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final String host = "192.168.2.103";
		final int port = 49999;

		// client
		ClientGame clientGame = Lobby.createClient(true, host, port);

		if (args.length > 0) {
			DebugNoMenuStarterState.isMaster = true;
		}
		
		if (clientGame != null) {

			try {
				AppGameContainer gc = new AppGameContainer(clientGame);
				gc.setDisplayMode(Settings.SCREENWIDTH, Settings.SCREENHEIGHT,
						false);
				gc.setVSync(true);
				gc.setSmoothDeltas(true);
				gc.setAlwaysRender(true);
				gc.setUpdateOnlyWhenVisible(false);
				gc.setMaximumLogicUpdateInterval(30);
				gc.setTargetFrameRate(60);
				gc.start();
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}
}