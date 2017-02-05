package ch.chost.attendanceapp.models;

/**
 * Created by mtoeltl on 04.02.17.
 */

public class DrawerItem {
    private String ItemName;
    private int ImgResId;

    public DrawerItem (String name, int icon) {
        this.ItemName = name;
        this.ImgResId = icon;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public Integer getImgResId() {
        return ImgResId;
    }

    public void setImgResId(Integer imgResId) {
        ImgResId = imgResId;
    }
}
