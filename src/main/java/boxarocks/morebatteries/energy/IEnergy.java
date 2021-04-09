package boxarocks.morebatteries.energy;

import boxarocks.morebatteries.blocks.BlockType;
import net.minecraftforge.common.util.ForgeDirection;

public interface IEnergy {

	public boolean canAddEnergyOnSide(ForgeDirection direction);
	public boolean canConnect(ForgeDirection direction);
	
	public EnergyBar getEnergyBar();
	public void SetLastRecivedDirection(ForgeDirection direction);
	
	public int getEnergyTransferRate();
	public BlockType getType();
	
}
