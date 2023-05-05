package org.honeypowered.nbt.test;

import org.honeypowered.nbt.CompoundTag;
import org.honeypowered.nbt.numeric.ByteTag;
import org.honeypowered.nbt.numeric.ShortTag;
import org.junit.Test;

public class TagParseTest {

    @Test
    public void createSampleNBT() {
        // create a CompoundTag that uses every other tag at least once
        CompoundTag tag = new CompoundTag("root");
        tag.addTag(new ByteTag("byte", (byte) 1));
        tag.addTag(new ShortTag("short", (short) 2));

    }

}
