package fr.carage.pitchout;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;

public class BoardScore {
    private Pitchout plugin;
    private Score score;
    private Scoreboard sb;
    private ArrayList name;
    public BoardScore(Pitchout plg) {
        this.plugin = plg;
    }

    public void start() {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard sb = manager.getNewScoreboard();
        Objective objective = sb.registerNewObjective(ChatColor.GREEN + "Survivants :", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.YELLOW + "PitchOut" + ChatColor.GREEN + " 8:00");
        this.score = objective.getScore("Survivants :");
        this.score.setScore(JoinListener.playerCount);
        for(Player p : Bukkit.getOnlinePlayers()) {
            p.setScoreboard(sb);
            p.setHealth(10);
        }

        Bukkit.getScheduler().runTaskTimer(this.plugin, new fr.carage.pitchout.CountDown(objective), 0, 20);
    }

    public void setPlayerCount(int pc) {
        this.score.setScore(pc);
        for(Player p : Bukkit.getOnlinePlayers()) {
            p.setScoreboard(sb);
        }
    }

    public void setScoreBoard(Player p) {
        p.setScoreboard(sb);
    }
}
