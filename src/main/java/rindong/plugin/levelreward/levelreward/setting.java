package rindong.plugin.levelreward.levelreward;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class setting {

    public static List<String> L1 = new ArrayList<>();
    public static List<String> L2 = new ArrayList<>();
    public static List<String> L3 = new ArrayList<>();
    public static List<String> L4 = new ArrayList<>();
    public static List<String> L5 = new ArrayList<>();
    public static List<String> L6 = new ArrayList<>();
    public static List<String> L7 = new ArrayList<>();

    public static void loadSetting()
    {
        System.out.println(LevelReward.pluginName + "载入设置");

        Plugin plugin=LevelReward.getProvidingPlugin(LevelReward.class);

        plugin.reloadConfig();

        FileConfiguration config=plugin.getConfig();

        L1.clear();
        L2.clear();
        L3.clear();
        L4.clear();
        L5.clear();
        L6.clear();
        L7.clear();

        L1 = config.getStringList("L1");
        L2 = config.getStringList("L2");
        L3 = config.getStringList("L3");
        L4 = config.getStringList("L4");
        L5 = config.getStringList("L5");
        L6 = config.getStringList("L6");
        L7 = config.getStringList("L7");
    }

    public static void getPrice(String playerName)
    {
        File file=new File(LevelReward.getPlugin(LevelReward.class).getDataFolder(),"data.yml");
        FileConfiguration config= YamlConfiguration.loadConfiguration(file);

        Player p= Bukkit.getPlayer(playerName);
        if (config.getInt(playerName,-1) == -1)
        {
            int level=p.getLevel();
            if (level <= 100)
            {
                givePlayerPrice(playerName,L1);
            }
            else if (level <= 350)
            {
                givePlayerPrice(playerName,L2);
            }
            else if (level <= 700)
            {
                givePlayerPrice(playerName,L3);
            }
            else if (level <= 1000)
            {
                givePlayerPrice(playerName,L4);
            }
            else if (level <= 2999)
            {
                givePlayerPrice(playerName,L5);
            }
            else if (level <= 5999)
            {
                givePlayerPrice(playerName,L6);
            }
            else if (level<= 20000)
            {
                givePlayerPrice(playerName,L7);
            }
            else
            {
                p.sendMessage(ChatColor.RED + "奥谢特，我们没有为你准备礼物，因为你太他妈高级了");
            }
            config.set(playerName,1);
            try {
                config.save(file);
            }
            catch (IOException ex)
            {
                System.out.println(LevelReward.pluginName + "保存文件错误。");
            }
        }
        else
        {
            p.sendMessage(ChatColor.RED + "你已经领取过此奖励了。");
        }
    }

    public static void givePlayerPrice(String playerName,List<String> reward)
    {
        for (String x : reward)
        {
            String i = x.replace("%player_name%",playerName);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),i);
        }
    }
}
