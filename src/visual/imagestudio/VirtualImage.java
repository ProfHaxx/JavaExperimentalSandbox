package visual.imagestudio;

import main.lists.ArrayList;

import java.awt.*;
import java.util.HashMap;

public class VirtualImage {

    private static String regex_1 = "([\\D]+)";
    private static String regex_2 = "([\\d]+)[/ ]+([\\d]+)";

    private String name;
    private ArrayList<VIDU> data = new ArrayList<>();
    private int x, y; //Resolution
    private String proportion;
    ArrayList<String> meta = new ArrayList<>();

    public VirtualImage() {

    }

    public VirtualImage(String name) {
        this.name = name;
    }

    public void setData(ArrayList<VIDU> data) {
        this.data = data;
    }
    public ArrayList<VIDU> getData() {
        return data;
    }
    public void setProportion(String proportion) {
        assert(proportion.matches(regex_2));
        this.proportion = proportion;
    }
    public String getProportion() {
        return proportion;
    }
    public void setResolution(int x, int y) {
        setProportion(x + "/" + y);
        this.x = x;
        this.y = y;
    }
    public void setResolution(int x){
        assert(getProportion() != null);
        int[] proportionNumbers = new int[] {
                Integer.parseInt(getProportion().split(regex_1)[0]),
                Integer.parseInt(getProportion().split(regex_1)[1])
        };
        this.x = x;
        this.y = (x / proportionNumbers[0]) * proportionNumbers[1];
    }
    public int[] getResolution() {
        return new int[]{x, y};
    }
    public int getHeight() {
        return y;
    }
    public int getWidth() {
        return x;
    }
    public void setPresetResolution(String resolution) {
        switch (resolution){
            case "HD":
                setProportion("16/9");
                setResolution(1280);
                break;
            case "HD+":
                setProportion("19/9");
                setResolution(1520);
                break;
            case "FHD":
            case "FullHD":
            case "Full HD":
                setProportion("16/9");
                setResolution(1920);
                break;
            case "FHD+":
                setProportion("16/9");
                setResolution(2280);
                break;
            default:
                System.out.println("Resolution not recognized! Please try again!");
                break;
        }
    }
    public void rename(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public static VirtualImage createSample() {
        VirtualImage vi = new VirtualImage("Smile");
        vi.setResolution(16, 16);
        HashMap<Integer, Integer> times = new HashMap<>();
        HashMap<Integer, Color> colors = new HashMap<>();
        for(int i = 0; i < 26; i+=2) {
            colors.put(i, Color.WHITE);
            colors.put(i+1, Color.BLACK);
        }
        colors.put(26, Color.WHITE);
        times.put(0, 34);
        times.put(1, 3);
        times.put(2, 6);
        times.put(3, 3);
        times.put(4, 20);
        times.put(5, 3);
        times.put(6, 6);
        times.put(7, 3);
        times.put(8, 4);
        times.put(9, 3);
        times.put(10, 6);
        times.put(11, 3);
        times.put(12, 4);
        times.put(13, 3);
        times.put(14, 6);
        times.put(15, 3);
        times.put(16, 68);
        times.put(17, 2);
        times.put(18, 8);
        times.put(19, 2);
        times.put(20, 6);
        times.put(21, 2);
        times.put(22, 4);
        times.put(23, 2);
        times.put(24, 10);
        times.put(25, 4);
        times.put(26, 38);
        for(int i = 0; i < 27; i++) {
            for(int j = 0; j < times.get(i); j++) {
                vi.data.add(new VIDU(colors.get(i)));
            }
        }
        System.out.println("Constructor Data Size: " + vi.data.size());
        return vi;
    }

    public void loadInStudio(ImageStudio studio) {
        studio.setImage(this);
    }
}
