package fr.carage.pitchout;

import org.bukkit.scheduler.BukkitRunnable;

public class BoardStart extends BukkitRunnable {
    public BoardScore bs;
    public BoardStart(BoardScore b) {
        bs = b;
    }

    @Override
    public void run() {
        bs.start();
    }
}
