package boxarocks.morebatteries.energy;

import net.minecraft.nbt.NBTTagCompound;

public class EnergyBar {
	
	private int maxEnergyLevel = 0;
	private int defaultMaxEnergyLevel;
	private int energyLevel = 0;
	
	public EnergyBar(int maxEnergyLevel, boolean baseEnergyLevel) 
	{
		this.maxEnergyLevel = defaultMaxEnergyLevel = maxEnergyLevel;
		if(baseEnergyLevel) this.energyLevel = maxEnergyLevel;
	}
	
	public EnergyBar(int maxEnergyLevel) 
	{
		this(maxEnergyLevel, false);
	}
	
	public void addEnergy(int amount) 
	{
		energyLevel += amount;
	}
	
	public void removeEnergy(int amount) 
	{
		energyLevel -= amount;
	}
	
	public boolean canAddEnergy(int amount) 
	{
		return(energyLevel + amount) <= maxEnergyLevel;
	}
	
	public boolean canRemoveEnergy(int amount) 
	{
		return(energyLevel - amount) >= 0;
	}
	
	public void setMaxEnergyLevel(int amount) 
	{
		this.maxEnergyLevel = amount;
	}
	
	public int getMaxEnergyLevel() 
	{
		return maxEnergyLevel;
	}
	
	public void setEnergyLevel(int amount) 
	{
		this.energyLevel = amount;
	}
	
	public int getEnergyLevel() 
	{
		return energyLevel;
	}
	
	public void writeToNBT(NBTTagCompound tag) 
	{
		tag.setInteger("energyLevel", energyLevel);
	}
	
	public void readFromNBT(NBTTagCompound tag) 
	{
		this.energyLevel = tag.getInteger("energyLevel");
	}
	
	public int getEnergyLevel(int scale) 
	{
		return energyLevel * scale / maxEnergyLevel;
	}
	
	public int addEnergyRemaining(int amount) 
	{
		energyLevel += amount;
		if(energyLevel > maxEnergyLevel) 
		{
			int powerRemaining = energyLevel - maxEnergyLevel;
			energyLevel -= powerRemaining;
			return powerRemaining;
		}
		return 0;
	}
	
	public void resetMaxEnergy() 
	{
		maxEnergyLevel = defaultMaxEnergyLevel;
	}
}
