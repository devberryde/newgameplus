package com.testablemod.mod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VaultConfigTest {

    @Test
    void testClientConfigDefaults() {
        assertEquals("Continuity Vault", VaultClientConfig.TERMINAL_TITLE.getDefault());
        assertEquals(true, VaultClientConfig.SHOW_MISSING_ITEMS.getDefault());
        assertEquals(true, VaultClientConfig.SHOW_UNSAFE_ITEMS.getDefault());
        assertEquals(true, VaultClientConfig.SHOW_SOURCE_PACK.getDefault());
        assertEquals(false, VaultClientConfig.SHOW_ITEM_HASH.getDefault());
    }

    @Test
    void testCommonConfigDefaults() {
        assertEquals("https", VaultCommonConfig.NETWORK_SCHEME.getDefault());
        assertEquals("ngp-vault.cozycatcrew.de", VaultCommonConfig.NETWORK_HOST.getDefault());
        assertEquals(443, VaultCommonConfig.NETWORK_PORT.getDefault());
        assertEquals("/api/ngp/v1", VaultCommonConfig.NETWORK_BASE_PATH.getDefault());
        assertEquals(49173, VaultCommonConfig.NETWORK_DIRECT_DEV_PORT.getDefault());

        assertEquals("token", VaultCommonConfig.AUTH_MODE.getDefault());

        assertEquals("warn", VaultCommonConfig.VAULT_WITHDRAW_POLICY.getDefault());
        assertEquals("allow", VaultCommonConfig.VAULT_DEPOSIT_POLICY.getDefault());

        assertEquals(true, VaultCommonConfig.CACHE_ENABLED.getDefault());
        assertEquals("ngp-vault-cache.sqlite", VaultCommonConfig.CACHE_DB_FILE.getDefault());

        assertEquals(true, VaultCommonConfig.SAFETY_BAN_CREATIVE_ITEMS.getDefault());
        assertEquals(true, VaultCommonConfig.SAFETY_SCAN_NESTED_CONTAINERS.getDefault());
        assertEquals(8, VaultCommonConfig.SAFETY_MAX_NESTED_DEPTH.getDefault());
    }
}
