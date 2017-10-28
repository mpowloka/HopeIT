package org.hopeit.charapp.utils;

import android.net.Uri;

public class Content {
    private String textContent;
    private Uri imageContent;

    public Content(String textContent, Uri imageContent) {
        this.textContent = textContent;
        this.imageContent = imageContent;

    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Uri getImageContent() {
        return imageContent;
    }

    public void setImageContent(Uri imageContent) {
        this.imageContent = imageContent;
    }
}