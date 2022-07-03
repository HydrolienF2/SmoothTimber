package net.sourcewriters.smoothtimber.spigot.world;

import org.bukkit.block.Block;

import net.sourcewriters.smoothtimber.api.platform.world.IPlatformBlock;
import net.sourcewriters.smoothtimber.api.resource.key.ResourceKey;
import net.sourcewriters.smoothtimber.api.util.math.Vector3i;
import net.sourcewriters.smoothtimber.spigot.SpigotConversionRegistry;

public final class SpigotBlock implements IPlatformBlock {

    private final Block block;

    public SpigotBlock(final Block block) {
        this.block = block;
    }
    
    @Override
    public Block getHandle() {
        return block;
    }

    @Override
    public ResourceKey getType() {
        return SpigotConversionRegistry.fromBukkit(block.getType().getKey());
    }

    @Override
    public Vector3i getPosition() {
        return new Vector3i(block.getX(), block.getY(), block.getZ());
    }

}
