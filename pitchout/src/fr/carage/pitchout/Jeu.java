package fr.carage.pitchout;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import java.util.Timer;

public class Jeu implements CommandExecutor {
    private BoardScore bs;
    public Plugin plugin;
    public static boolean started = false;
    public Jeu(BoardScore board, Plugin plug) {
        this.plugin = plug;
        bs = board;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!started) {
            started = true;
            Bukkit.broadcastMessage("Game is starting");
            TimerStart start = new TimerStart(5, bs);
            start.runTaskTimer(plugin, 0, 20);
            return true;
        } else {
            sender.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "PitchOut" + ChatColor.DARK_GRAY+ "] " + ChatColor.RED + " La partie est déjà commencée");
            return true;
        }
    }
}
