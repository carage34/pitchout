package fr.carage.pitchout;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Objective;

public class CountDown implements Runnable {
    private Objective objective;
    private int seconde=0;
    private int minutes=8;
    private String tmp="";
    public CountDown(Objective obj) {
        this.objective = obj;
    }
    public void run() {
        if(minutes==0) {
            Bukkit.getServer().getScheduler().cancelAllTasks();
        }
        if(seconde==0) {
            seconde = 60;
            minutes--;
        }
        seconde--;
        tmp = seconde+"";
        if(seconde<10) {
            tmp = "0"+seconde;
        }
        this.objective.setDisplayName(ChatColor.YELLOW + "PitchOut " + ChatColor.GREEN + minutes + ":"+tmp);
    }
}
