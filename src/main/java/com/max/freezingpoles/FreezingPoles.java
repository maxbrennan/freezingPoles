package com.max.freezingpoles;

import com.max.freezingpoles.listeners.PlayerMove;
import com.max.freezingpoles.listeners.PlayerPortal;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class FreezingPoles extends JavaPlugin {

    public final String GREEN = "\033[32m";
    public final String RED = "\033[31m";
    public final String RESET = "\033[0m";

    @Override
    public void onEnable() {

        System.out.println(GREEN + "=================================================" + RESET);
        System.out.println(GREEN + "|                                               |" + RESET);
        System.out.println(GREEN + "|          Freezing poles has started!          |" + RESET);
        System.out.println(GREEN + "|                                               |" + RESET);
        System.out.println(GREEN + "=================================================" + RESET);

        Bukkit.getPluginManager().registerEvents(new PlayerMove(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerPortal(), this);

    }

    @Override
    public void onDisable() {

        System.out.println(RED + "=================================================" + RESET);
        System.out.println(RED + "|                                               |" + RESET);
        System.out.println(RED + "|           Freezing poles has ended!           |" + RESET);
        System.out.println(RED + "|                                               |" + RESET);
        System.out.println(RED + "=================================================" + RESET);

    }
}
