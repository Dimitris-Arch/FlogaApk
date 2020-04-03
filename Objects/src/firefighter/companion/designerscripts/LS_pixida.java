package firefighter.companion.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_pixida{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("pnlrose").vw.setLeft((int)((3d / 100 * width)));
views.get("pnlrose").vw.setWidth((int)((94d / 100 * width)));
views.get("pnlrose").vw.setTop((int)((33d / 100 * height)));
views.get("pnlrose").vw.setLeft((int)((50d / 100 * width) - (views.get("pnlrose").vw.getWidth() / 2)));
views.get("pnlrose").vw.setHeight((int)((views.get("pnlrose").vw.getWidth())));
views.get("pnlneedle").vw.setHeight((int)((views.get("pnlrose").vw.getHeight())));
views.get("pnlneedle").vw.setWidth((int)((views.get("pnlneedle").vw.getHeight())/9.6d));
views.get("pnlneedle").vw.setLeft((int)((views.get("pnlrose").vw.getWidth())/2d - (views.get("pnlneedle").vw.getWidth() / 2)));
views.get("pnlneedle").vw.setTop((int)((views.get("pnlrose").vw.getHeight())/2d - (views.get("pnlneedle").vw.getHeight() / 2)));
views.get("label1").vw.setTop((int)((83d / 100 * height)));
views.get("label1").vw.setLeft((int)((3d / 100 * width)));
views.get("label1").vw.setWidth((int)((30d / 100 * width)));
views.get("label1").vw.setHeight((int)((10d / 100 * height)));
views.get("label2").vw.setTop((int)((35d / 100 * height)));
views.get("label2").vw.setLeft((int)((85d / 100 * width)));
views.get("label2").vw.setWidth((int)((7d / 100 * width)));
views.get("label2").vw.setHeight((int)((15d / 100 * height)));
views.get("label3").vw.setTop((int)((83d / 100 * height)));
views.get("label3").vw.setLeft((int)((85d / 100 * width)));
views.get("label3").vw.setWidth((int)((7d / 100 * width)));
views.get("label3").vw.setHeight((int)((15d / 100 * height)));

}
}