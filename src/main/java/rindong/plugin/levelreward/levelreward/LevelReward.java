package rindong.plugin.levelreward.levelreward;

import org.bukkit.plugin.java.JavaPlugin;
import rindong.plugin.levelreward.levelreward.command.mainCommand;

public final class LevelReward extends JavaPlugin {

    public static final String pluginName="[等级奖励]";

    @Override
    public void onEnable() {

        saveDefaultConfig();
        saveResource("data.yml",false);

        System.out.println(pluginName + "已加载");

        setting.loadSetting();

        getCommand("levelreward").setExecutor(new mainCommand());
    }

    @Override
    public void onDisable() {

        System.out.println(pluginName + "已卸载");

    }
}
