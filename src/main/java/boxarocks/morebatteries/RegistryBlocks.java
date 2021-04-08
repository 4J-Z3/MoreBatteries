package boxarocks.morebatteries;

import boxarocks.morebatteries.blocks.BlockCable;
import boxarocks.morebatteries.blocks.ItemBlockStandardMetadata;
import boxarocks.morebatteries.lib.Names;
import boxarocks.morebatteries.tileentity.TileEntityCable;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RegistryBlocks {

	public static Block CABLE;
	
	public static void BlockInit()
	{
		CABLE = new BlockCable(Material.iron);
		GameRegistry.registerBlock(CABLE, ItemBlockStandardMetadata.class, CABLE.getUnlocalizedName());
		
		GameRegistry.registerTileEntity(TileEntityCable.class, "Calbe");
	}
}
