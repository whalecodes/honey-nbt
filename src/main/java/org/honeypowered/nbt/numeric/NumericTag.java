package org.honeypowered.nbt.numeric;

import org.honeypowered.nbt.NamedTag;
import org.jetbrains.annotations.NotNull;

/**
 * NumericTag represents a NamedTag which stores a single numeric value.
 *
 * @param <T> the type of number stored in this tag.
 */
public sealed interface NumericTag<T extends Number> extends NamedTag permits NamedByteTag, NamedDoubleTag {

    /**
     * @return the value stored in this tag.
     */
    @NotNull T getValue();

    /**
     * Change the numeric value stored in this tag.
     *
     * @param value the new value to be stored in this tag.
     */
    void setValue(@NotNull T value);

    /**
     * @return whether the value stored in this tag is a floating point number.
     *
     * true means that this can either store a {@link Float} or a {@link Double}.
     * false means that this can either store a {@link Byte}, {@link Short}, {@link Integer} or {@link Long}.
     */
    boolean isFloatingPoint();

    /**
     * @return whether the value stored in this tag is an integer; essentially an inverse of {@link #isFloatingPoint()}.
     *
     * true means that this can either store a {@link Byte}, {@link Short}, {@link Integer} or {@link Long}.
     * false means that this can either store a {@link Float} or a {@link Double}.
     */
    boolean isInteger();

    /**
     * @return the numeric value stored by this tag cast to a byte if necessary.
     */
    default byte getByte() {
        return getValue().byteValue();
    }

    /**
     * @return the numeric value stored by this tag cast to a short if necessary.
     */
    default short getShort() {
        return getValue().shortValue();
    }

    /**
     * @return the numeric value stored by this tag cast to an integer if necessary.
     */
    default int getInteger() {
        return getValue().intValue();
    }

    /**
     * @return the numeric value stored by this tag cast to a long if necessary.
     */
    default long getLong() {
        return getValue().longValue();
    }

    /**
     * @return the numeric value stored by this tag cast to a float if necessary.
     */
    default float getFloat() {
        return getValue().floatValue();
    }

    /**
     * @return the numeric value stored by this tag cast to a double if necessary.
     */
    default double getDouble() {
        return getValue().doubleValue();
    }

}
