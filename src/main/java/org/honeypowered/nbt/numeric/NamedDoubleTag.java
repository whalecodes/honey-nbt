package org.honeypowered.nbt2.numeric;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

public final class NamedDoubleTag implements NumericTag<Double> {

    @Getter @Setter @NotNull String name;
    private double value;

    public NamedDoubleTag(@NotNull String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public int identify() {
        return 6;
    }

    @Override
    public @NotNull Double value() {
        return value;
    }

    public double getDouble() {
        return value;
    }

    @Override
    public void set(@NotNull Double value) {
        this.value = value;
    }

    public void set(double value) {
        this.value = value;
    }

    @Override
    public boolean isFloatingPoint() {
        return true;
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public @NotNull String toString() {
        return "ByteTag('" + getName() + "'): " + value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object instanceof NamedDoubleTag doubleTag) {
            return doubleTag.getName().equals(name) && doubleTag.value == value;
        }
        return false;
    }

}
