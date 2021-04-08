package boxarocks.morebatteries.blocks;

import java.util.List;

import boxarocks.morebatteries.lib.Energy;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockStandardMetadata extends ItemBlock
{
	public ItemBlockStandardMetadata(Block block)
	{
		super(block);
		setHasSubtypes(true);
	}
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return getUnlocalizedName() + "." + itemstack.getItemDamage();
	}
	
	public int getMetadata(int meta) 
	{
		return meta;
	}
	
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean advanced)
	{
		if(itemstack.getItem() == Item.getItemFromBlock(boxarocks.morebatteries.RegistryBlocks.CABLE))
		{
			int meta = itemstack.getItemDamage();
			if(meta == 0)
			{
				list.add("Energy loss: 0%" + Energy.MoreBatteries.getSymbol() + "/m");
			}
		}
	}
}
