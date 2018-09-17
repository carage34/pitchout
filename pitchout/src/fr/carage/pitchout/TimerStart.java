package fr.carage.pitchout;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerStart extends BukkitRunnable {
    private int i;
    private BoardScore bs;
    public TimerStart(int i, BoardScore bss) {
        this.i = i;
        bs = bss;
    }

    @Override
    public void run() {
        System.out.println("aaa");
        if(i>0) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle("", ChatColor.GOLD + "La partie commence dans " + ChatColor.YELLOW + this.i + " secondes", 10, 20, 20);
            }
            i--;
        } else {
            bs.start();
            this.cancel();
        }
    }
}
