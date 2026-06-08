package com.testablemod.mod.vault;

import java.util.List;
import java.util.Map;

public record ItemResolutionInputV1(
        StoredItemStackV1 item,
        CurrentEnvironment currentEnvironment,
        String policy
) {
    public record CurrentEnvironment(
            String minecraftVersion,
            String loader,
            List<String> modIds,
            Map<String, String> modVersions,
            List<String> registryItemIds,
            List<String> knownComponentIds
    ) {}
}
