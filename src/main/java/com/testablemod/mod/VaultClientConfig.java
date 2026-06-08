package com.testablemod.mod;

import net.neoforged.neoforge.common.ModConfigSpec;

public class VaultClientConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.ConfigValue<String> TERMINAL_TITLE;
    public static final ModConfigSpec.BooleanValue SHOW_MISSING_ITEMS;
    public static final ModConfigSpec.BooleanValue SHOW_UNSAFE_ITEMS;
    public static final ModConfigSpec.BooleanValue SHOW_SOURCE_PACK;
    public static final ModConfigSpec.BooleanValue SHOW_ITEM_HASH;

    static {
        BUILDER.push("ui");

        TERMINAL_TITLE = BUILDER
                .comment("Title of the Continuity Vault terminal")
                .define("terminal_title", "Continuity Vault");

        SHOW_MISSING_ITEMS = BUILDER
                .comment("Whether to show missing items")
                .define("show_missing_items", true);

        SHOW_UNSAFE_ITEMS = BUILDER
                .comment("Whether to show unsafe items")
                .define("show_unsafe_items", true);

        SHOW_SOURCE_PACK = BUILDER
                .comment("Whether to show the source pack of items")
                .define("show_source_pack", true);

        SHOW_ITEM_HASH = BUILDER
                .comment("Whether to show the item hash")
                .define("show_item_hash", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
