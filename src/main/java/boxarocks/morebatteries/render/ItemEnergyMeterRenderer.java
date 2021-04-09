package boxarocks.morebatteries.render;

/*import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import boxarocks.morebatteries.lib.Reference;

public class ItemEnergyMeterRenderer {

	public static enum energyMeter
	{
		
		ENERGY_METER_ANIMATED(new ResourceLocation(Reference.MOD_ID + ":textures/items/item.energyMeterAnimated.png"), 32, 32, 7);
		
		ResourceLocation texture;
		int width;
		int height;
		int count;
		
		private energyMeter(ResourceLocation texture, int width, int height, int count)
		{
			this.texture = texture;
			this.width = width;
			this.height = height;
			this.count = count;
			this.
					
		}
	}
	
	public static void renderEnergymeter(energyMeter energymeter, double x, double y, double z, double progress)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(energyMeter.texture);
		
		int frameNum = ((int) Math.round((energymeter.count - 1) * progress));
		double singleFrame = 1D / (double)energymeter.count;
		double frameOffset = singleFrame * frameNum;
		
		Tessellator tesselator = Tessellator.instance;
		tesselator.startDrawingQuads();
		tesselator.addVertexWithUV(x, y + energymeter.height, z, 0, frameOffset + singleFrame);
		tesselator.addVertexWithUV(x + energymeter.width, y, z, 1, frameOffset + singleFrame);
		tesselator.addVertexWithUV(x + energymeter.width, y, z, 1, frameOffset);
		tesselator.addVertexWithUV(x, y, z, 0, frameOffset);
		tesselator.draw();
	}
}*/
