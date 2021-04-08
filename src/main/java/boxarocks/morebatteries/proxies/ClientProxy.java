package boxarocks.morebatteries.proxies;

import boxarocks.morebatteries.RegistryBlocks;
import boxarocks.morebatteries.lib.Reference;
import boxarocks.morebatteries.render.ItemCableRenderer;
import boxarocks.morebatteries.render.TileEntityCableRenderer;
import boxarocks.morebatteries.tileentity.TileEntityCable;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders() 
	{
		ClientRegistry.registerTileEntity(TileEntityCable.class, Reference.MOD_ID + ":" + "calbe", TileEntityCableRenderer.instance);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RegistryBlocks.CABLE), ItemCableRenderer.instance);
	}
	
}
