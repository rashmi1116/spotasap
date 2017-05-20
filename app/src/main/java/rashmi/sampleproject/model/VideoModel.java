package rashmi.sampleproject.model;

import android.graphics.drawable.Drawable;

/**
 * Created by rashmi.ramesh on 20-05-2017.
 */

public class VideoModel {
    private Drawable icon;
    private String title;
    private String subText;
    private String description;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
