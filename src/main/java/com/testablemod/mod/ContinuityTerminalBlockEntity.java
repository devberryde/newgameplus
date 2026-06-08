package com.testablemod.mod;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ContinuityTerminalBlockEntity extends BlockEntity {

    private String terminalId = "";
    private String ownerMode = "player"; // player, team, server
    private String linkedVaultId = "default";

    public ContinuityTerminalBlockEntity(BlockPos pos, BlockState state) {
        super(TestableMod.CONTINUITY_TERMINAL_BLOCK_ENTITY.get(), pos, state);
    }

    public ContinuityTerminalBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, net.minecraft.core.HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putString("terminalId", terminalId);
        tag.putString("ownerMode", ownerMode);
        tag.putString("linkedVaultId", linkedVaultId);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, net.minecraft.core.HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.terminalId = tag.getString("terminalId");
        this.ownerMode = tag.getString("ownerMode");
        this.linkedVaultId = tag.getString("linkedVaultId");
    }

    @Override
    public CompoundTag getUpdateTag(net.minecraft.core.HolderLookup.Provider registries) {
        CompoundTag tag = super.getUpdateTag(registries);
        saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
        setChanged();
    }

    public String getOwnerMode() {
        return ownerMode;
    }

    public void setOwnerMode(String ownerMode) {
        this.ownerMode = ownerMode;
        setChanged();
    }

    public String getLinkedVaultId() {
        return linkedVaultId;
    }

    public void setLinkedVaultId(String linkedVaultId) {
        this.linkedVaultId = linkedVaultId;
        setChanged();
    }
}
