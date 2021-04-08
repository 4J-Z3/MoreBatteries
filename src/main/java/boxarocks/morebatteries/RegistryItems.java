package boxarocks.morebatteries;

import boxarocks.morebatteries.items.ItemEnergyMeter;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class RegistryItems 
{
	
	public static Item DEBUGGER_TOOL;
	
	public static void InitItems()
	{
		DEBUGGER_TOOL = new ItemEnergyMeter();
		GameRegistry.registerItem(DEBUGGER_TOOL, DEBUGGER_TOOL.getUnlocalizedName());
		
	}
	
}
