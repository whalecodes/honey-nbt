package org.honeypowered.nbt2;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

/**
 * NamedStringTag is a NamedTag which stores a string.
 */
public sealed interface NamedStringTag extends NamedTag permits NamedStringTag.NamedStringTagImpl {

    /**
     * @return the String value stored in this tag.
     */
    @NotNull String getString();

    /**
     * Chance the String value stored in this tag.
     *
     * @param value the new value to be stored in this tag.
     */
    void setString(@NotNull String value);

    /**
     * @return the length of the String.
     */
    int length();

    static NamedStringTag from(@NotNull String name, @NotNull String string) {
        return new NamedStringTagImpl(name, string);
    }

    /**
     * NamedStringTagImpl implements {@link NamedStringTag}.
     */
    final class NamedStringTagImpl implements NamedStringTag {

        @Getter @Setter @NotNull private String name;
        @Getter @Setter @NotNull private String string;

        private NamedStringTagImpl(@NotNull String name, @NotNull String string) {
            // should there be a string length check?
            this.name = name;
            this.string = string;
        }

        @Override
        public int length() {
            return string.length();
        }

        @Override
        public int identify() {
            return 0;
        }

        @Override
        public @NotNull String toString() {
            return "StringTag('" + name + "'): '" + string + "'";
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object instanceof NamedStringTag stringTag) {
                return stringTag.getName().equals(name) && stringTag.getString().equals(string);
            }
            return false;
        }

    }

}