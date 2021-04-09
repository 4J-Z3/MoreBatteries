package boxarocks.morebatteries;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import boxarocks.morebatteries.lib.Reference;
import boxarocks.morebatteries.proxies.CommonProxy;

@Mod(name = Reference.MOD_NAME,modid = Reference.MOD_ID,version = Reference.MOD_VERSION)
public class MoreBatteries {
	
	@Instance(Reference.MOD_NAME)
	public static MoreBatteries instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void PreInit(FMLPreInitializationEvent event) 
	{
		RegistryBlocks.BlockInit();
		RegistryItems.InitItems();
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event) 
	{
		proxy.registerRenders();
		proxy.registerTileEntitys();
	}
	
	@Mod.EventHandler
	public void PostInit(FMLPostInitializationEvent event) 
	{
		
	}
}
