package com.max.freezingpoles.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class PlayerPortal implements Listener {

    final int right = PlayerMove.right;
    final int left = PlayerMove.left;
    final int top = PlayerMove.top;
    final int bottom = PlayerMove.bottom;
    double x;
    double y;
    double z;

    Location to;
    Block topBlock;
    Location nether;

    Block getTop(World world, int x, int z) {

        for (int i = 255; i >= -64; i--) {

            topBlock = new Location(world, x, i, z).getBlock();

            if (!(topBlock.getType() == Material.AIR)) {

                topBlock.getLocation().setY(i + 1);
                return topBlock;

            }
        }

        throw new NullPointerException();

    }

    void createPortal(Block bottomEast) {

        World world = bottomEast.getWorld();
        int x = bottomEast.getX();
        int y = bottomEast.getY();
        int z = bottomEast.getZ();

        bottomEast.setType(Material.OBSIDIAN);
        nether = new Location(world, x - 1, y, z);

        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setX(x - 2);
        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setX(x - 3);
        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setY(y + 1);
        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setY(y + 2);
        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setY(y + 3);
        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setY(y + 4);
        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setX(x - 2);
        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setX(x - 1);
        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setX(x);
        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setY(y + 3);
        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setY(y + 2);
        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setY(y + 1);
        nether.getBlock().setType(Material.OBSIDIAN);
        nether.setX(x - 1);
        nether.getBlock().setType(Material.FIRE);

    }

    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent e) {

        to = e.getTo();
        x = to.getX();
        y = to.getY();
        z = to.getZ();

        if (e.getCanCreatePortal()) {
            if (right > x) {
            }
        }
    }
}
