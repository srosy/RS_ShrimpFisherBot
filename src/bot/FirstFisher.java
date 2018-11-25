package bot;

import java.awt.Graphics2D;

import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "srosy", info = "First Fishing Script", name = "FirstFisher", version = 0, logo = "")
public class FirstFisher extends Script {

	@Override
	public void onStart() {
		log("Starting fishing script..!");
	}

	@Override
	public int onLoop() throws InterruptedException {
		
		//RS2Object fishingSpot = getObjects().closest("Fishing Spot");
		NPC fishingSpot = getNpcs().closest("Fishing Spot");
		
		if (getInventory().contains("Raw Shrimps")) {
		  getInventory().drop("Raw Shrimps");
		} else if (fishingSpot != null && !myPlayer().isAnimating()) {
		  fishingSpot.interact("Steal-from"); // figure out command to fish.
		}
		return random(200, 300); // time delay before next event
	}

	@Override
	public void onExit() {
		log("Closing fishing script...");
	}

	@Override
	public void onPaint(Graphics2D g) {	}
}
