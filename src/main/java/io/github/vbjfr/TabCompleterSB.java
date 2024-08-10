package io.github.vbjfr;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.List;

public class TabCompleterSB implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length != 1) {
            return null;
        }
        else if (command.getName().equals("sb")) {
            Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
            ArrayList<String> completions = new ArrayList<String>();
            for (Objective objective : board.getObjectives()) {
                completions.add(objective.getName());
            }
            ArrayList<String> filteredCompletions = new ArrayList<String>();
            for (String completion : completions) {
                if (completion.toLowerCase().contains(args[args.length - 1].toLowerCase())) {
                    filteredCompletions.add(completion);
                }
            }
            return filteredCompletions;
        }
        return null;
    }
}
