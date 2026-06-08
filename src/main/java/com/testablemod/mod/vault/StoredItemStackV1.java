package com.testablemod.mod.vault;

import java.util.List;
import java.util.Map;

public record StoredItemStackV1(
        int schemaVersion,
        String itemRecordId,
        String ownerId,
        String vaultId,
        String itemId,
        int count,
        Source source,
        Display display,
        Stack stack,
        Analysis analysis,
        Status status,
        Timestamps timestamps
) {
    public record Source(
            String minecraftVersion,
            String loader,
            String loaderVersion,
            List<String> modIds,
            Map<String, String> modVersions,
            String packFingerprint,
            String worldId,
            String serverId
    ) {}

    public record Display(
            String displayName,
            String sourceModId,
            String iconItemId,
            List<String> tooltipCache
    ) {}

    public record Stack(
            String format,
            String encoding,
            String compression,
            String payload,
            String sha256,
            int byteLength
    ) {}

    public record Analysis(
            String normalizedHash,
            String exactStackHash,
            boolean containsNestedItems,
            boolean containsBlockEntityData,
            boolean containsEntityData,
            boolean containsFluid,
            boolean containsEnergy,
            boolean containsOwnerBinding,
            boolean containsUnknownComponents,
            List<String> unsafeFlags
    ) {}

    public record Status(
            String lifecycle,
            String lockedBy,
            String lockExpiresAt,
            int revision
    ) {}

    public record Timestamps(
            String depositedAt,
            String updatedAt,
            String lastResolvedAt
    ) {}
}
