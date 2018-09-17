package fr.carage.pitchout;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.*;
import org.bukkit.util.Vector;

public class JoinListener implements Listener {
    private static final int MAX_PLAYER = 20;
    public static int playerCount = 0;
    private BoardScore bs;
    public JoinListener(BoardScore board) {
        bs = board;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        playerCount++;
        Player p = e.getPlayer();
        p.setHealth(10);
        if(!Jeu.started) {
            e.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "PitchOut" + ChatColor.DARK_GRAY + "] " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " a rejoint la partie " + ChatColor.YELLOW + "(" + this.playerCount + "/" + this.MAX_PLAYER + ")");
            bs.setPlayerCount(playerCount);
        } else {
            p.setGameMode(GameMode.SPECTATOR);
            e.setJoinMessage(null);
        }
        bs.setScoreBoard(p);
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        playerCount--;
        Player p = e.getPlayer();
        if(!Jeu.started) {
            e.setQuitMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "PitchOut" + ChatColor.DARK_GRAY + "] " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.GRAY + " a quitte la partie " + ChatColor.YELLOW + "(" + this.playerCount + "/" + this.MAX_PLAYER + ")");
        } else {
            e.setQuitMessage(null);
        }
        bs.setPlayerCount(playerCount);
    }

    @EventHandler
    public void onFish(PlayerFishEvent e) {
        if (e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)) {
            Entity hooked = e.getCaught();
            Player rodder = (Player)e.getPlayer();
            Vector vect = rodder.getLocation().getDirection().normalize().multiply(4);
            vect.setY(1);
            hooked.setVelocity(vect);
        }
    }

    public void onMove(PlayerMoveEvent e) {

    }

    public int getPlayerCount() {
        return playerCount;
    }
}
