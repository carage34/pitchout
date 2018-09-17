package fr.carage.pitchout;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Pitchout extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("Plugin charge");
        BoardScore bs = new BoardScore(this);
        Listener l = new JoinListener(bs);
        this.getCommand("start").setExecutor(new Jeu(bs, this));
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(l, this);
    }
}
