package de.fhtrier.gdig.demos.jumpnrun.common.gamelogic.player.states;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import de.fhtrier.gdig.demos.jumpnrun.common.gamelogic.player.Player;
import de.fhtrier.gdig.demos.jumpnrun.common.gamelogic.player.states.identifiers.PlayerActions;
import de.fhtrier.gdig.demos.jumpnrun.identifiers.Assets;
import de.fhtrier.gdig.engine.graphics.entities.AssetEntity;
import de.fhtrier.gdig.engine.management.Factory;
import de.fhtrier.gdig.engine.sound.SoundManager;

public class AbstractShootState extends AbstractAssetState {

	private Animation anim;
	private Animation weaponAnim;
	
	public AbstractShootState(Player player, int playerAnimAssetId,
			String playerAnimAssetPath, int weaponAnimAssetId, String weaponAnimAssetPath, int entityOrder, Factory factory)
			throws SlickException {
		super(player, playerAnimAssetId, playerAnimAssetPath, weaponAnimAssetId, weaponAnimAssetPath, entityOrder, factory);
		AssetEntity e = getGfxEntity();

		anim = e.Assets().getAnimation(e.getAssetId());
		anim.setLooping(false);
		anim.setAutoUpdate(true);
		
		e = getWeaponGfxEntity();

		weaponAnim = e.Assets().getAnimation(e.getAssetId());
		weaponAnim.setLooping(false);
		weaponAnim.setAutoUpdate(true);
	}

	@Override
	public void enter() {
		if (anim.isStopped()) {
			anim.restart();
			weaponAnim.restart();
		}

		// SoundManager.playSound(Assets.PlayerRunSoundId, 1f, 0.2f);
		SoundManager.playSound(Assets.Sounds.BulletSoundId, 1f, 0.2f);

	}

	@Override
	public void update() {

		if (anim.isStopped()) {
			getPlayer().applyAction(PlayerActions.StopShooting);
		}
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
}
