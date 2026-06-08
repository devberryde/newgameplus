package com.testablemod.mod.vault;

import java.util.List;

public record ItemResolutionV1(
        String itemRecordId,
        String status,
        Checks checks,
        List<String> warnings,
        Actions actions
) {
    public record Checks(
            boolean itemIdExists,
            boolean sourceModPresent,
            boolean stackPayloadDecodable,
            boolean componentsKnown,
            boolean nestedItemsResolvable,
            boolean policyAllowsWithdraw
    ) {}

    public record Actions(
            boolean canWithdraw,
            boolean canForceWithdraw,
            boolean canSanitizeWithdraw,
            boolean canTradeOnly
    ) {}
}
