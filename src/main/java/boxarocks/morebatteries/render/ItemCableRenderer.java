package boxarocks.morebatteries.render;

import org.lwjgl.opengl.GL11;

import boxarocks.morebatteries.lib.Reference;
import boxarocks.morebatteries.model.ModelCable;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemCableRenderer implements IItemRenderer
{
	public static final ItemCableRenderer instance = new ItemCableRenderer();
	ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/model/cable.png");
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		return true;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		int meta = item.getItemDamage();
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180, 0, 0, 1);
		if(meta == 0)
		{
			Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
			ModelCable.instance.renderMiddle();
			ModelCable.instance.renderDown(false);
			ModelCable.instance.renderUp(false);
			ModelCable.instance.renderNorth(false);
			ModelCable.instance.renderSouth(false);
			ModelCable.instance.renderWest(false);
			ModelCable.instance.renderEast(false);
		}
		GL11.glPopMatrix();
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return true;
	}
	
}
