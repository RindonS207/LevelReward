package rindong.plugin.levelreward.levelreward.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rindong.plugin.levelreward.levelreward.setting;

public class mainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            if (args.length == 0)
            {
                setting.getPrice(sender.getName());
            }
        }
        else
        {
            sender.sendMessage("等级奖励 1.0 by 凛冻");
        }
        if (args.length == 1)
        {
            if (args[0].equals("reload") && sender.hasPermission("levelreward.reload"))
            {
                sender.sendMessage("插件已重载。");
                setting.loadSetting();
            }
        }
        return false;
    }
}
