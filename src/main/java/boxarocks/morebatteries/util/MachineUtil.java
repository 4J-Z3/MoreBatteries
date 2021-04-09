package boxarocks.morebatteries.util;

import boxarocks.morebatteries.energy.EnergyBar;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class MachineUtil 
{
	public static void operate(ItemStack[] inventory, EnergyBar energyBar, ItemStack result, IInventory inventoryClass, int energyUsePerOperation, int StackSizeToDecrease)
	{
		if(result != null)
		{
			if(inventory[1] == null)
			{
				inventory[1] = result.copy();
			}
			else if(inventory[1].isItemEqual(result))
			{
				inventory[1].stackSize += result.stackSize;
			}
			
			inventory[1].stackSize -= StackSizeToDecrease;
			
			if(inventory[0].stackSize <= 0)
			{
				inventory[0] = null;
			}
			
			energyBar.removeEnergy(energyUsePerOperation);
		}
	}
	
	public static boolean canOperate(ItemStack[] inventory, EnergyBar energyBar, ItemStack result, IInventory inventoryClass, int energyUsePerOperation, int StackSizeToDecrease)
	{
		if(inventory[0] == null)
		{
			return false;
		}
		if(result == null) return false;
		if(!energyBar.canRemoveEnergy(energyUsePerOperation)) return false;
		if(inventory[1] == null) return true;
		if(!inventory[1].isItemEqual(result)) return false;
		if(inventory[1].stackSize + StackSizeToDecrease > inventory[1].getMaxStackSize()) return false;
		int resultStack = inventory[1].stackSize + result.stackSize;
		return(resultStack <= inventoryClass.getInventoryStackLimit() && (resultStack) <= result.getMaxStackSize());
	}
}