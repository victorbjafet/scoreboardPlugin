package io.github.vbjfr;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class CommandSB implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("Incorrect arguments");
        }
        else {
            Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
            if (board.getObjective(args[0]) != null) {
                board.getObjective(args[0]).setDisplaySlot(DisplaySlot.SIDEBAR);
                sender.sendMessage("Leaderboard set to " + args[0]);
            }
            else {
                sender.sendMessage("Leaderboard " + args[0] + " does not exist");
            }
        }

        return true;
    }
}
