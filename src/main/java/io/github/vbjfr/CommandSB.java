package io.github.vbjfr;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scoreboard.DisplaySlot;
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
                if (!args[0].equals("Health2")) { //hard coded so that the health in the tab menu doesnt go away lol
                    board.getObjective(args[0]).setDisplaySlot(DisplaySlot.SIDEBAR);
                    Bukkit.broadcastMessage(sender.getName() + " set the leaderboard to " + args[0]);
                }
                else {
                    sender.sendMessage("Don't change Health2, use Health instead");
                }

            }
            else {
                sender.sendMessage("Leaderboard " + args[0] + " does not exist");
            }
        }

        return true;
    }
}
