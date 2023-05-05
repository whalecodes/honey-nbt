package org.honeypowered.nbt;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * CompoundTag is the most complex and important structure in the NBT format.
 *
 * This tag stores a collection of other tags with arbitrary types, names, and stores.
 * TODO: implement {@link Iterable<NamedTag>}
 */
public sealed interface CompoundTag extends NamedTag permits CompoundTag.CompoundTagImpl {

    /**
     * Add the provided tag to this CompoundTag unless a tag with the given name already exists.
     *
     * @param tag the tag to add.
     * @return whether the tag was added.
     */
    boolean add(@NotNull NamedTag tag);



    /**
     * Add the provided tag to this CompoundTag regardless of whether a tag with the given name already exists.
     *
     * @param tag the tag to add.
     */
    void replace(@NotNull NamedTag tag);

    /**
     * @return whether this CompoundTag contains a tag with the given name.
     * @param name the name of the tag to check for.
     */
    boolean has(@NotNull String name);

    /**
     * @return the tag with the given name in this structure, or null if such tag does not exist.
     * @param name the name of the tag to get.
     */
    @Nullable NamedTag get(@NotNull String name);

    // TODO
    <T extends NamedTag> @Nullable T get(@NotNull String name, @NotNull Class<T> type);

    /**
     * Remove the tag with the given name from this CompoundTag.
     *
     * @param tag the name of the tag to remove.
     */
    void remove(@NotNull NamedTag tag);

    /**
     * Create a new CompoundTag with the given name.
     *
     * @param name the name of the new CompoundTag.
     * @return the new CompoundTag.
     */
    static @NotNull CompoundTag create(@NotNull String name) {
        return new CompoundTagImpl(name); // TODO
    }

    final class CompoundTagImpl implements CompoundTag {

        @Getter @Setter @NotNull String name;

        private CompoundTagImpl(@NotNull String name) {
            this.name = name;
        }

        @Override
        public int identify() {
            return 0;
        }

        @Override
        public boolean add(@NotNull NamedTag tag) {
            return false; // TODO
        }

        @Override
        public void replace(@NotNull NamedTag tag) {
            // TODO
        }

        @Override
        public boolean has(@NotNull String name) {
            return false; // TODO
        }

        @Override
        public @Nullable NamedTag get(@NotNull String name) {
            return null; // TODO
        }

        @Override
        public void remove(@NotNull NamedTag tag) {
            // TODO
        }

        @Override
        public boolean equals(Object object) {
            return this == object;
        }

    }

}
