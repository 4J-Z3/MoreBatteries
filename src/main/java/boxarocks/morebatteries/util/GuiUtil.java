package boxarocks.morebatteries.util;

import net.minecraft.client.renderer.Tessellator;

public class GuiUtil 
{
	public static void drawRectangle(double x, double y, double width, double height, int imageWidth, int imageHeight, double u, double v)
	{
		Tessellator tess = Tessellator.instance;
		tess.startDrawingQuads();
		tess.addVertexWithUV(x + 0, y + height, 0, u / imageWidth, height / imageHeight);
		tess.addVertexWithUV(x + width, y + height, 0, width / imageWidth, height / imageHeight);
		tess.addVertexWithUV(x + width, y + 0, 0, u / imageWidth, v / imageHeight);
		tess.addVertexWithUV(x + 0, y + 0, 0, u / imageWidth, v / imageHeight);
		tess.draw();
	}
}
