package com.hollingsworth.main.utils;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
/**
 * Created by Bailey Hollingsworth on 12/10/16.
 */
public class WebManager {
    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
