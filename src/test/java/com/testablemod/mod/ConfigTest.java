package com.testablemod.mod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import net.minecraft.SharedConstants;
import net.minecraft.server.Bootstrap;

public class ConfigTest {

    @BeforeAll
    public static void setup() {
        SharedConstants.tryDetectVersion();

        // Initialize an empty LoadingModList to prevent NPE during FeatureFlagLoader which is needed by Bootstrap.
        try {
            java.lang.reflect.Method ofMethod = net.neoforged.fml.loading.LoadingModList.class.getDeclaredMethod("of", java.util.List.class, java.util.List.class, java.util.List.class, java.util.List.class, java.util.Map.class);
            ofMethod.invoke(null, java.util.List.of(), java.util.List.of(), java.util.List.of(), java.util.List.of(), java.util.Map.of());
        } catch (Throwable e) {
            // ignore
        }

        try {
            Bootstrap.bootStrap();
        } catch (Throwable e) {
            // ignore
        }
    }

    @Test
    public void testValidateItemNameInvalidType() {
        assertFalse(Config.validateItemName(123), "Should return false for non-String types (Integer)");
        assertFalse(Config.validateItemName(new Object()), "Should return false for non-String types (Object)");
        assertFalse(Config.validateItemName(null), "Should return false for null");
    }

    @Test
    public void testValidateItemNameInvalidFormat() {
        assertThrows(net.minecraft.ResourceLocationException.class, () -> {
            Config.validateItemName("invalid format");
        }, "Should throw ResourceLocationException for invalid ResourceLocation format");
    }

    @Test
    public void testValidateItemNameValidFormat() {
        assertTrue(Config.validateItemName("minecraft:iron_ingot"), "Should return true for valid item");
        assertFalse(Config.validateItemName("minecraft:non_existent_item"), "Should return false for non-existent item");
    }
}
