package org.honeypowered.nbt2;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;

/**
 * NamedListTag is a tag containing an unordered array of unnamed tags with a known type.
 *
 * @param <T> the type of plain tag stored in this tag.
 */
public sealed interface NamedListTag<T extends NamedListTag.PlainTag> extends NamedTag permits NamedListTag.NamedListTagImpl {

    /**
     * @return the number of elements stored in this tag.
     */
    int size();

    void add(@NotNull T tag);

    void remove(@NotNull T tag);

    @Nullable T get(int index);

    int search(@NotNull T tag);

    /**
     * @return the identifier of the tags stored within this list.
     */
    int identifyContent();

    public static NamedListTag<PlainStringTag> makeStringList(@NotNull String name) {
        return new NamedListTagImpl<>(name);
    }

    final class NamedListTagImpl<T extends PlainTag> implements NamedListTag<T> {

        @Getter @Setter @NotNull String name;
        @NotNull private final List<T> array;

        NamedListTagImpl(@NotNull String name) {
            this.name = name;
            this.array = new LinkedList<>();
        }

        @Override
        public int size() {
            return array.size();
        }

        @Override
        public void add(@NotNull T tag) {
            array.add(tag);
        }

        @Override
        public void remove(@NotNull T tag) {

        }

        @Override
        public @Nullable T get(int index) {
            return null;
        }

        @Override
        public int search(@NotNull T tag) {
            return 0;
        }

        @Override
        public int identifyContent() {
            return 0;
        }

        @Override
        public int identify() {
            return 0;
        }

        @Override
        public @NotNull String toString() {
            return ""; // TODO
        }

        @Override
        public boolean equals(Object object) {
            return this == object; // TODO
        }

    }

    interface PlainTag {

    }

    /**
     * NumericTag clone without a name.
     *
     * @param <T> the type of number stored in this tag.
     */
    class PlainNumericTag<T extends Number> implements PlainTag {

        @Getter @Setter private @NotNull T number;

        public PlainNumericTag(@NotNull T number) {
            this.number = number;
        }

        /**
         * @return whether the value stored in this tag is a floating point number.
         *
         * true means that this can either store a {@link Float} or a {@link Double}.
         * false means that this can either store a {@link Byte}, {@link Short}, {@link Integer} or {@link Long}.
         */
        public boolean isFloatingPoint() {
            return number instanceof Float || number instanceof Double;
        }

        /**
         * @return whether the value stored in this tag is an integer; essentially an inverse of {@link #isFloatingPoint()}.
         *
         * true means that this can either store a {@link Byte}, {@link Short}, {@link Integer} or {@link Long}.
         * false means that this can either store a {@link Float} or a {@link Double}.
         */
        public boolean isInteger() {
            return !isFloatingPoint();
        }

        /**
         * @return the numeric value stored by this tag cast to a byte if necessary.
         */
        public byte getByte() {
            return number.byteValue();
        }

        /**
         * @return the numeric value stored by this tag cast to a short if necessary.
         */
        public short getShort() {
            return number.shortValue();
        }

        /**
         * @return the numeric value stored by this tag cast to an integer if necessary.
         */
        public int getInteger() {
            return number.intValue();
        }

        /**
         * @return the numeric value stored by this tag cast to a long if necessary.
         */
        public long getLong() {
            return number.longValue();
        }

        /**
         * @return the numeric value stored by this tag cast to a float if necessary.
         */
        public float getFloat() {
            return number.floatValue();
        }

        /**
         * @return the numeric value stored by this tag cast to a double if necessary.
         */
        public double getDouble() {
            return number.doubleValue();
        }

    }

    class PlainStringTag implements PlainTag {

        @Getter @Setter private @NotNull String string;

        public PlainStringTag(@NotNull String string) {
            this.string = string;
        }

    }

    class PlainListTag implements PlainTag {
        // TODO
    }

    class PlainCompoundTag implements PlainTag {
        // TODO
    }

    class PlainNumericArrayTag {
        // TODO
    }

}
