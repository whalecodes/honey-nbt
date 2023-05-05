package org.honeypowered.nbt2.numeric;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

public final class NamedByteTag implements NumericTag<Byte> {

    @Getter @Setter @NotNull String name;

    @Getter private byte value;

    public NamedByteTag(@NotNull String name, byte value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public int identify() {
        return 1;
    }

    @Override
    public @NotNull Byte value() {
        return value;
    }

    @Override
    public byte getByte() {
        return value;
    }

    @Override
    public void set(@NotNull Byte value) {
        this.value = value;
    }

    public void set(byte value) {
        this.value = value;
    }

    @Override
    public boolean isFloatingPoint() {
        return false;
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public @NotNull String toString() {
        return "ByteTag('" + getName() + "'): " + value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object instanceof NamedByteTag byteTag) {
            return byteTag.getName().equals(name) && byteTag.value == value;
        }
        return false;
    }

}
