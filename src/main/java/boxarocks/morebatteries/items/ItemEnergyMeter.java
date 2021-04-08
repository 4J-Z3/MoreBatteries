package boxarocks.morebatteries.items;

import boxarocks.morebatteries.energy.IEnergy;
import boxarocks.morebatteries.lib.Reference;
import boxarocks.morebatteries.render.ItemEnergyMeterRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemEnergyMeter extends Item 
{
	public ItemEnergyMeter() 
	{	
		this.setUnlocalizedName("energyMeter");
		this.setCreativeTab(CreativeTabs.tabRedstone);
		
	}
	
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) 
	{
		if(!world.isRemote)
		{
			TileEntity tileentity = world.getTileEntity(x, y, z);
			if(tileentity instanceof IEnergy)
			{
				player.addChatMessage(new ChatComponentText("[" + Reference.MOD_NAME + "] QF Level = " + (((IEnergy) tileentity).getEnergyBar().getEnergyLevel())));
			}
			return true;
		}
		return false;
	}
	
	public void registerIcons(IIconRegister iconReg) 
	{
		this.itemIcon = iconReg.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName());
	}
	
}
