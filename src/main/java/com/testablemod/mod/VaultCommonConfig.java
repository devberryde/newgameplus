package com.testablemod.mod;

import net.neoforged.neoforge.common.ModConfigSpec;

public class VaultCommonConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    // network
    public static final ModConfigSpec.BooleanValue NETWORK_ENABLED;
    public static final ModConfigSpec.ConfigValue<String> NETWORK_SCHEME;
    public static final ModConfigSpec.ConfigValue<String> NETWORK_HOST;
    public static final ModConfigSpec.IntValue NETWORK_PORT;
    public static final ModConfigSpec.ConfigValue<String> NETWORK_BASE_PATH;
    public static final ModConfigSpec.IntValue NETWORK_DIRECT_DEV_PORT;
    public static final ModConfigSpec.IntValue NETWORK_TIMEOUT_MS;
    public static final ModConfigSpec.IntValue NETWORK_RETRY_MAX;
    public static final ModConfigSpec.IntValue NETWORK_RETRY_BACKOFF_MS;
    public static final ModConfigSpec.BooleanValue NETWORK_PREFER_HTTP3;
    public static final ModConfigSpec.BooleanValue NETWORK_ALLOW_HTTP2_FALLBACK;

    // auth
    public static final ModConfigSpec.ConfigValue<String> AUTH_MODE;
    public static final ModConfigSpec.ConfigValue<String> AUTH_TOKEN_FILE;
    public static final ModConfigSpec.BooleanValue AUTH_ALLOW_OFFLINE_QUEUE;

    // vault
    public static final ModConfigSpec.ConfigValue<String> VAULT_ID;
    public static final ModConfigSpec.ConfigValue<String> VAULT_PROFILE_MODE;
    public static final ModConfigSpec.ConfigValue<String> VAULT_WITHDRAW_POLICY;
    public static final ModConfigSpec.ConfigValue<String> VAULT_DEPOSIT_POLICY;
    public static final ModConfigSpec.BooleanValue VAULT_ALLOW_CROSS_PACK_WITHDRAW;
    public static final ModConfigSpec.BooleanValue VAULT_ALLOW_MISSING_COMPONENT_WITHDRAW;
    public static final ModConfigSpec.BooleanValue VAULT_ALLOW_FORCE_WITHDRAW;
    public static final ModConfigSpec.IntValue VAULT_MAX_STACK_BLOB_BYTES;
    public static final ModConfigSpec.IntValue VAULT_MAX_BATCH_ITEMS;

    // local_cache
    public static final ModConfigSpec.BooleanValue CACHE_ENABLED;
    public static final ModConfigSpec.ConfigValue<String> CACHE_DB_FILE;
    public static final ModConfigSpec.ConfigValue<String> CACHE_JOURNAL_MODE;
    public static final ModConfigSpec.BooleanValue CACHE_SYNC_ON_LOGIN;
    public static final ModConfigSpec.IntValue CACHE_SYNC_INTERVAL_SECONDS;
    public static final ModConfigSpec.BooleanValue CACHE_FLUSH_ON_WORLD_SAVE;

    // safety
    public static final ModConfigSpec.BooleanValue SAFETY_BAN_CREATIVE_ITEMS;
    public static final ModConfigSpec.BooleanValue SAFETY_BAN_COMMAND_BLOCKS;
    public static final ModConfigSpec.BooleanValue SAFETY_BAN_DEBUG_ITEMS;
    public static final ModConfigSpec.BooleanValue SAFETY_BAN_PLAYER_BOUND_ITEMS;
    public static final ModConfigSpec.BooleanValue SAFETY_BAN_UNKNOWN_BLOCK_ENTITY_DATA;
    public static final ModConfigSpec.BooleanValue SAFETY_SCAN_NESTED_CONTAINERS;
    public static final ModConfigSpec.IntValue SAFETY_MAX_NESTED_DEPTH;

    static {
        BUILDER.push("network");
        NETWORK_ENABLED = BUILDER.define("enabled", true);
        NETWORK_SCHEME = BUILDER.define("scheme", "https");
        NETWORK_HOST = BUILDER.define("host", "ngp-vault.cozycatcrew.de");
        NETWORK_PORT = BUILDER.defineInRange("port", 443, 1, 65535);
        NETWORK_BASE_PATH = BUILDER.define("base_path", "/api/ngp/v1");
        NETWORK_DIRECT_DEV_PORT = BUILDER.defineInRange("direct_dev_port", 49173, 1, 65535);
        NETWORK_TIMEOUT_MS = BUILDER.defineInRange("timeout_ms", 8000, 1, Integer.MAX_VALUE);
        NETWORK_RETRY_MAX = BUILDER.defineInRange("retry_max", 5, 0, Integer.MAX_VALUE);
        NETWORK_RETRY_BACKOFF_MS = BUILDER.defineInRange("retry_backoff_ms", 750, 0, Integer.MAX_VALUE);
        NETWORK_PREFER_HTTP3 = BUILDER.define("prefer_http3", true);
        NETWORK_ALLOW_HTTP2_FALLBACK = BUILDER.define("allow_http2_fallback", true);
        BUILDER.pop();

        BUILDER.push("auth");
        AUTH_MODE = BUILDER.define("mode", "token");
        AUTH_TOKEN_FILE = BUILDER.define("token_file", "config/ngp-vault.token");
        AUTH_ALLOW_OFFLINE_QUEUE = BUILDER.define("allow_offline_queue", true);
        BUILDER.pop();

        BUILDER.push("vault");
        VAULT_ID = BUILDER.define("vault_id", "default");
        VAULT_PROFILE_MODE = BUILDER.define("profile_mode", "loose");
        VAULT_WITHDRAW_POLICY = BUILDER.define("withdraw_policy", "warn");
        VAULT_DEPOSIT_POLICY = BUILDER.define("deposit_policy", "allow");
        VAULT_ALLOW_CROSS_PACK_WITHDRAW = BUILDER.define("allow_cross_pack_withdraw", true);
        VAULT_ALLOW_MISSING_COMPONENT_WITHDRAW = BUILDER.define("allow_missing_component_withdraw", false);
        VAULT_ALLOW_FORCE_WITHDRAW = BUILDER.define("allow_force_withdraw", true);
        VAULT_MAX_STACK_BLOB_BYTES = BUILDER.defineInRange("max_stack_blob_bytes", 1048576, 1, Integer.MAX_VALUE);
        VAULT_MAX_BATCH_ITEMS = BUILDER.defineInRange("max_batch_items", 128, 1, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("local_cache");
        CACHE_ENABLED = BUILDER.define("enabled", true);
        CACHE_DB_FILE = BUILDER.define("db_file", "ngp-vault-cache.sqlite");
        CACHE_JOURNAL_MODE = BUILDER.define("journal_mode", "wal");
        CACHE_SYNC_ON_LOGIN = BUILDER.define("sync_on_login", true);
        CACHE_SYNC_INTERVAL_SECONDS = BUILDER.defineInRange("sync_interval_seconds", 60, 1, Integer.MAX_VALUE);
        CACHE_FLUSH_ON_WORLD_SAVE = BUILDER.define("flush_on_world_save", true);
        BUILDER.pop();

        BUILDER.push("safety");
        SAFETY_BAN_CREATIVE_ITEMS = BUILDER.define("ban_creative_items", true);
        SAFETY_BAN_COMMAND_BLOCKS = BUILDER.define("ban_command_blocks", true);
        SAFETY_BAN_DEBUG_ITEMS = BUILDER.define("ban_debug_items", true);
        SAFETY_BAN_PLAYER_BOUND_ITEMS = BUILDER.define("ban_player_bound_items", false);
        SAFETY_BAN_UNKNOWN_BLOCK_ENTITY_DATA = BUILDER.define("ban_unknown_block_entity_data", false);
        SAFETY_SCAN_NESTED_CONTAINERS = BUILDER.define("scan_nested_containers", true);
        SAFETY_MAX_NESTED_DEPTH = BUILDER.defineInRange("max_nested_depth", 8, 1, Integer.MAX_VALUE);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
