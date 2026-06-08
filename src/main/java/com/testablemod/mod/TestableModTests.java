package com.testablemod.mod;

import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

@GameTestHolder(TestableMod.MODID)
public class TestableModTests {

    @GameTest
    @PrefixGameTestTemplate(false)
    public static void testExample(GameTestHelper helper) {
        helper.succeed();
    }
}
