package de.fhtrier.gdig.demos.jumpnrun.common.gamelogic.player.states;

import org.newdawn.slick.SlickException;

import de.fhtrier.gdig.demos.jumpnrun.common.gamelogic.player.Player;
import de.fhtrier.gdig.demos.jumpnrun.common.gamelogic.player.states.identifiers.PlayerActions;
import de.fhtrier.gdig.demos.jumpnrun.identifiers.Assets;
import de.fhtrier.gdig.demos.jumpnrun.identifiers.Constants;
import de.fhtrier.gdig.demos.jumpnrun.identifiers.EntityOrder;
import de.fhtrier.gdig.engine.gamelogic.Entity;
import de.fhtrier.gdig.engine.management.Factory;

public class ShootStandingState extends AbstractShootState {


	public ShootStandingState(Player player, Factory factory)
			throws SlickException {
		super(player, Assets.Player.ShootStandingAnimId,
				Assets.Player.ShootStandingImagePath, Assets.Weapon.ShootStandingAnimId,
				Assets.Weapon.ShootStandingImagePath, EntityOrder.Player,
				factory);

	}
	
	@Override
	public void enter () {
		getPlayer().getWeaponParticleEntity().getData()[Entity.Y] = 155;
	}
	
	@Override
	public void leave () {
		getPlayer().getWeaponParticleEntity().getData()[Entity.Y] = 165;
	}

	@Override
	public void update() {
		super.update();
		
		// check if currentPos < prevPos --> start falling
		if (getPlayer().getVel()[Entity.Y] > Constants.GamePlayConstants.playerFallingTriggerSpeed) {
			getPlayer().applyAction(PlayerActions.Fall);
		}
	}
}
