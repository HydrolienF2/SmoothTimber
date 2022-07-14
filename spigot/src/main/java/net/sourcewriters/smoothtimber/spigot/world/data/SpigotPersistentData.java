package net.sourcewriters.smoothtimber.spigot.world.data;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import net.sourcewriters.smoothtimber.api.platform.world.data.IPlatformData;
import net.sourcewriters.smoothtimber.api.resource.key.ResourceKey;
import net.sourcewriters.smoothtimber.spigot.version.VersionHelper;

public final class SpigotPersistentData implements IPlatformData {

    private final PersistentDataContainer container;
    private final VersionHelper helper = VersionHelper.get();

    public SpigotPersistentData(final PersistentDataContainer container) {
        this.container = container;
    }

    @Override
    public boolean isPersistent() {
        return true;
    }

    @Override
    public IPlatformData newData() {
        return new SpigotPersistentData(container.getAdapterContext().newPersistentDataContainer());
    }

    @Override
    public void set(ResourceKey key, byte value) {
        container.set(helper.convert(key), PersistentDataType.BYTE, value);
    }

    @Override
    public void set(ResourceKey key, short value) {
        container.set(helper.convert(key), PersistentDataType.SHORT, value);
    }

    @Override
    public void set(ResourceKey key, int value) {
        container.set(helper.convert(key), PersistentDataType.INTEGER, value);
    }

    @Override
    public void set(ResourceKey key, long value) {
        container.set(helper.convert(key), PersistentDataType.LONG, value);
    }

    @Override
    public void set(ResourceKey key, float value) {
        container.set(helper.convert(key), PersistentDataType.FLOAT, value);
    }

    @Override
    public void set(ResourceKey key, double value) {
        container.set(helper.convert(key), PersistentDataType.DOUBLE, value);
    }

    @Override
    public void set(ResourceKey key, String value) {
        container.set(helper.convert(key), PersistentDataType.STRING, value);
    }

    @Override
    public void set(ResourceKey key, byte[] array) {
        container.set(helper.convert(key), PersistentDataType.BYTE_ARRAY, array);
    }

    @Override
    public void set(ResourceKey key, int[] array) {
        container.set(helper.convert(key), PersistentDataType.INTEGER_ARRAY, array);
    }

    @Override
    public void set(ResourceKey key, long[] array) {
        container.set(helper.convert(key), PersistentDataType.LONG_ARRAY, array);
    }

    @Override
    public void set(ResourceKey key, IPlatformData data) {
        if (!(data instanceof SpigotPersistentData)) {
            return;
        }
        container.set(helper.convert(key), PersistentDataType.TAG_CONTAINER, ((SpigotPersistentData) data).container);
    }

    @Override
    public byte getOrDefault(ResourceKey key, byte value) {
        return container.getOrDefault(helper.convert(key), PersistentDataType.BYTE, value);
    }

    @Override
    public short getOrDefault(ResourceKey key, short value) {
        return container.getOrDefault(helper.convert(key), PersistentDataType.SHORT, value);
    }

    @Override
    public int getOrDefault(ResourceKey key, int value) {
        return container.getOrDefault(helper.convert(key), PersistentDataType.INTEGER, value);
    }

    @Override
    public long getOrDefault(ResourceKey key, long value) {
        return container.getOrDefault(helper.convert(key), PersistentDataType.LONG, value);
    }

    @Override
    public float getOrDefault(ResourceKey key, float value) {
        return container.getOrDefault(helper.convert(key), PersistentDataType.FLOAT, value);
    }

    @Override
    public double getOrDefault(ResourceKey key, double value) {
        return container.getOrDefault(helper.convert(key), PersistentDataType.DOUBLE, value);
    }

    @Override
    public String getOrDefault(ResourceKey key, String value) {
        return container.getOrDefault(helper.convert(key), PersistentDataType.STRING, value);
    }

    @Override
    public byte[] getOrDefault(ResourceKey key, byte[] value) {
        return container.getOrDefault(helper.convert(key), PersistentDataType.BYTE_ARRAY, value);
    }

    @Override
    public int[] getOrDefault(ResourceKey key, int[] value) {
        return container.getOrDefault(helper.convert(key), PersistentDataType.INTEGER_ARRAY, value);
    }

    @Override
    public long[] getOrDefault(ResourceKey key, long[] value) {
        return container.getOrDefault(helper.convert(key), PersistentDataType.LONG_ARRAY, value);
    }

    @Override
    public boolean hasByte(ResourceKey key) {
        return container.has(helper.convert(key), PersistentDataType.BYTE);
    }

    @Override
    public boolean hasShort(ResourceKey key) {
        return container.has(helper.convert(key), PersistentDataType.SHORT);
    }

    @Override
    public boolean hasInt(ResourceKey key) {
        return container.has(helper.convert(key), PersistentDataType.INTEGER);
    }

    @Override
    public boolean hasLong(ResourceKey key) {
        return container.has(helper.convert(key), PersistentDataType.LONG);
    }

    @Override
    public boolean hasFloat(ResourceKey key) {
        return container.has(helper.convert(key), PersistentDataType.FLOAT);
    }

    @Override
    public boolean hasDouble(ResourceKey key) {
        return container.has(helper.convert(key), PersistentDataType.DOUBLE);
    }

    @Override
    public boolean hasString(ResourceKey key) {
        return container.has(helper.convert(key), PersistentDataType.STRING);
    }

    @Override
    public boolean hasByteArray(ResourceKey key) {
        return container.has(helper.convert(key), PersistentDataType.BYTE_ARRAY);
    }

    @Override
    public boolean hasIntArray(ResourceKey key) {
        return container.has(helper.convert(key), PersistentDataType.INTEGER_ARRAY);
    }

    @Override
    public boolean hasLongArray(ResourceKey key) {
        return container.has(helper.convert(key), PersistentDataType.LONG_ARRAY);
    }

    @Override
    public boolean hasData(ResourceKey key) {
        return container.has(helper.convert(key), PersistentDataType.TAG_CONTAINER);
    }

    @Override
    public byte getByte(ResourceKey key) {
        return container.get(helper.convert(key), PersistentDataType.BYTE);
    }

    @Override
    public short getShort(ResourceKey key) {
        return container.get(helper.convert(key), PersistentDataType.SHORT);
    }

    @Override
    public int getInt(ResourceKey key) {
        return container.get(helper.convert(key), PersistentDataType.INTEGER);
    }

    @Override
    public long getLong(ResourceKey key) {
        return container.get(helper.convert(key), PersistentDataType.LONG);
    }

    @Override
    public float getFloat(ResourceKey key) {
        return container.get(helper.convert(key), PersistentDataType.FLOAT);
    }

    @Override
    public double getDouble(ResourceKey key) {
        return container.get(helper.convert(key), PersistentDataType.DOUBLE);
    }

    @Override
    public String getString(ResourceKey key) {
        return container.get(helper.convert(key), PersistentDataType.STRING);
    }

    @Override
    public byte[] getByteArray(ResourceKey key) {
        return container.get(helper.convert(key), PersistentDataType.BYTE_ARRAY);
    }

    @Override
    public int[] getIntArray(ResourceKey key) {
        return container.get(helper.convert(key), PersistentDataType.INTEGER_ARRAY);
    }

    @Override
    public long[] getLongArray(ResourceKey key) {
        return container.get(helper.convert(key), PersistentDataType.LONG_ARRAY);
    }

    @Override
    public IPlatformData getData(ResourceKey key) {
        return new SpigotPersistentData(container.get(helper.convert(key), PersistentDataType.TAG_CONTAINER));
    }

    @Override
    public IPlatformData getDataOrNew(ResourceKey key) {
        NamespacedKey bukkitKey = helper.convert(key);
        if (container.has(bukkitKey, PersistentDataType.TAG_CONTAINER)) {
            return new SpigotPersistentData(container.get(bukkitKey, PersistentDataType.TAG_CONTAINER));
        }
        PersistentDataContainer newContainer = container.getAdapterContext().newPersistentDataContainer();
        container.set(bukkitKey, PersistentDataType.TAG_CONTAINER, newContainer);
        return new SpigotPersistentData(newContainer);
    }

}
