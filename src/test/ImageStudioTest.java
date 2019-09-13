package test;

import org.junit.Test;
import visual.imagestudio.Canvas;
import visual.imagestudio.ImageStudio;
import visual.imagestudio.VirtualImage;

import static org.junit.Assert.assertEquals;

public class ImageStudioTest {
    @Test
    public void evaluateImageCreation() {
        VirtualImage vi = VirtualImage.createSample();
        ImageStudio studio = new ImageStudio(vi);
        Canvas canvas = new Canvas();
        canvas.loadStudio(studio);
        assertEquals(256, canvas.getStudio().getImage().getData().size());
    }
}
