package com.testablemod.mod;

import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.gametest.framework.GameTestAssertException;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

@GameTestHolder(TestableMod.MODID)
public class TestableModTests {

    @GameTest(templateNamespace = TestableMod.MODID, template = "testcontinuityterminalblockentity")
    @PrefixGameTestTemplate(false)
    public static void testContinuityTerminalBlockEntity(GameTestHelper helper) {
        BlockPos pos = new BlockPos(1, 1, 1);
        helper.setBlock(pos, TestableMod.CONTINUITY_TERMINAL_BLOCK.get());

        BlockEntity blockEntity = helper.getBlockEntity(pos);
        if (!(blockEntity instanceof ContinuityTerminalBlockEntity terminalEntity)) {
            throw new GameTestAssertException("Expected ContinuityTerminalBlockEntity at position " + pos);
        }

        terminalEntity.setTerminalId("test_terminal_123");
        terminalEntity.setOwnerMode("team");
        terminalEntity.setLinkedVaultId("custom_vault");

        CompoundTag tag = terminalEntity.saveWithFullMetadata(helper.getLevel().registryAccess());

        if (!tag.getString("terminalId").equals("test_terminal_123")) {
            throw new GameTestAssertException("terminalId mismatch");
        }
        if (!tag.getString("ownerMode").equals("team")) {
            throw new GameTestAssertException("ownerMode mismatch");
        }
        if (!tag.getString("linkedVaultId").equals("custom_vault")) {
            throw new GameTestAssertException("linkedVaultId mismatch");
        }

        helper.succeed();
    }
}
