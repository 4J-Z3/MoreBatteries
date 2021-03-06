package boxarocks.morebatteries.tileentity;

import boxarocks.morebatteries.blocks.BlockType;
import boxarocks.morebatteries.energy.EnergyBar;
import boxarocks.morebatteries.energy.EnergyNet;
import boxarocks.morebatteries.energy.IEnergy;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityCable extends TileEntity implements IEnergy
{
	private ForgeDirection lastDirection = ForgeDirection.UNKNOWN;
	private EnergyBar energyBar = new EnergyBar(480);
	
	@Override
	public void updateEntity() 
	{
		EnergyNet.distributeEnergyToSurrounding(worldObj, xCoord, yCoord, zCoord, lastDirection, energyBar);
	}
	
	@Override
	public boolean canAddEnergyOnSide(ForgeDirection direction) 
	{
		return true;
	}
	
	public boolean canConnect(ForgeDirection direction) 
	{
		return true;
	}
	                   
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared()  
	{
		return Double.MAX_VALUE;
	}
	
	public AxisAlignedBB getRenderBoundingBox()
	{
		return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 1, zCoord + 1);
	}
	
	public EnergyBar getEnergyBar()
	{
		return energyBar;
	}
	
	@Override
	public void SetLastRecivedDirection(ForgeDirection direction) 
	{
		this.lastDirection = direction;
	}
	
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
	}
	
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) 
	{
		readFromNBT(packet.func_148857_g());
	}
	
	public void writeToNBT(NBTTagCompound tag) 
	{
		super.writeToNBT(tag);
		energyBar.writeToNBT(tag);
		
	}
	
	public void readFromNBT(NBTTagCompound tag) 
	{
		super.readFromNBT(tag);
		energyBar.readFromNBT(tag);
	}
	
	@Override
	public int getEnergyTransferRate() 
	{
		return 80;
	}
	
	@Override
	public BlockType getType() {
		return BlockType.CABLE;
	}
	
	
	
}
