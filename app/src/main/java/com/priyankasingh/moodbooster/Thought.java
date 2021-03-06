package com.priyankasingh.moodbooster;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class is structure of thoughts.
 * Title, description and image all three are int because they store compiled int representation
 * of corresponding resource
 */

public class Thought implements Parcelable {
    private int title;
    private int description;
    private int image;

    public Thought(int num) {
        switch (num){
            case 1:
                title = R.string.title1;
                description = R.string.description1;
                image = R.drawable.exercise;
                break;
            case 2:
                title = R.string.title2;
                description = R.string.description2;
                image = R.drawable.grace;
                break;
            case 3:
                title = R.string.title3;
                description = R.string.description3;
                image = R.drawable.sleep;
                break;
            case 4:
                title = R.string.title4;
                description = R.string.description4;
                image = R.drawable.bloodsugar;

                break;
            case 5:
                title = R.string.title5;
                description = R.string.description5;
                image = R.drawable.brain;
                break;
            default:
                break;
        }
    }

    protected Thought(Parcel in) {
        title = in.readInt();
        description = in.readInt();
        image = in.readInt();
    }


    public static final Creator<Thought> CREATOR = new Creator<Thought>() {
        @Override
        public Thought createFromParcel(Parcel in) {
            return new Thought(in);
        }

        @Override
        public Thought[] newArray(int size) {
            return new Thought[size];
        }
    };

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(title);
        dest.writeInt(description);
        dest.writeInt(image);
    }
}
