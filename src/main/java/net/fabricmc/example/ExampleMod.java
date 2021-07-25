package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

public class ExampleMod implements ModInitializer {

	public static final Item TEST_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));

	public static final Block TEST_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		ColorProviderRegistry.ITEM.register(new ItemColorProvider() {
			@Override
			public int getColor(ItemStack stack, int tintIndex) {
				return 0x228B22;
			}
		}, TEST_ITEM);
		Registry.register(Registry.ITEM, new Identifier("test","test_item"), TEST_ITEM);
		ColorProviderRegistry.BLOCK.register(new BlockColorProvider() {
			@Override
			public int getColor(BlockState state, @Nullable BlockRenderView world, @Nullable BlockPos pos, int tintIndex) {
				return 0xFFED97;
			}
		}, TEST_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("test","test_block"), TEST_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("test","test_block"), new BlockItem(TEST_BLOCK, new Item.Settings().group(ItemGroup.MISC)));

	}
}
