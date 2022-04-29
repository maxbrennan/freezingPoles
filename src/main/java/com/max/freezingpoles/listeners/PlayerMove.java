package com.max.freezingpoles.listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    public static final int right = 6140;
    public static final int left = -6140;
    public static final int top = -3070;
    public static final int bottom = 3070;

    Location location;
    World world;
    Location teleport;

    double x;
    double y;
    double z;
    double fromZ;
    float yaw;
    float pitch;

    private float oppositeRotation(float rotation) {

        if (rotation >= 0) { return -180 + rotation; }
        else { return 180 + rotation; }

    }

    private Location crossPole(double x) {

        double newX;
        yaw = oppositeRotation(yaw);

        if (x >= 0) { newX = x - 6174; }
        else { newX = x + 6174; }

        return new Location(world, newX, y, fromZ, yaw, pitch);

    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {

        location = e.getTo();
        assert location != null;
        world = location.getWorld();
        assert world != null;

        x = location.getX();
        y = location.getY();
        z = location.getZ();
        fromZ = e.getFrom().getZ();
        yaw = location.getYaw();
        pitch = location.getPitch();

        if (!world.getName().equals("world")) { return; }
        
        if (z <= top || z >= bottom) { teleport = crossPole(x); }
        else if (x >= right) { teleport = new Location(world, left, y, z, yaw, pitch); }
        else if (x <= left) { teleport = new Location(world, right, y, z, yaw, pitch); }
        else { return; }

        e.getPlayer().teleport(teleport);

    }
}
