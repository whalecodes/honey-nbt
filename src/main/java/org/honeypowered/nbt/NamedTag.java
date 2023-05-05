package org.honeypowered.nbt2;

import org.jetbrains.annotations.NotNull;

/**
 * NamedTag is the most abstract entity in the NBT hierarchy. This class only represents a tag with a name.
 *
 * While you can not directly access stored values from this class, you can {@link #identify()} the tag and cast it to the matching type.
 */
public interface NamedTag {

    /**
     * @return the name of this tag.
     */
    @NotNull String getName();

    /**
     * Change the name of this tag to the given name.
     *
     * @param name the new name of this tag.
     */
    void setName(@NotNull String name);

    /**
     * @return the identifier assigned to this type of tag by NBT.
     */
    int identify();

    @Override
    @NotNull String toString();

}
