package com.jackmeng.halcyon.malimbica.maker;

import com.jackmeng.halcyon.malimbica.global.Pair;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A class used to generate proper serialized
 * data that will be hosted on the web.
 *
 * @author Jack Meng
 * @since 3.1
 */
public class Maker implements Runnable {
    private Map<String, Map<Object, Object>> content;
    private String locale;

    public Maker(Pair<String[], Map<Object, Object>> stuffs, String locale) {
        content = new HashMap<>();
        this.locale = locale;
        for(String str: stuffs.first()) {
            content.put(str, stuffs.second());
        }
    }

    public Maker(Map<String, Map<Object, Object>> maps, String locale) {
        this.content = maps;
        this.locale = locale;
    }

    public Map<String, Map<Object, Object>> getContentMap() {
        return content;
    }

    @Override
    public void run() {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(locale);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Objects.requireNonNull(content));
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
