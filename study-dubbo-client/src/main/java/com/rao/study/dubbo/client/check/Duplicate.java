package com.rao.study.dubbo.client.check;

import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public final class Duplicate {
    private Duplicate() {}

    public static void checkDuplicate(Class cls) {
        checkDuplicate(cls.getName().replace('.', '/') + ".class");
    }

    public static void checkDuplicate(String path) {
        try {
            // 在ClassPath搜文件
            Enumeration urls = Thread.currentThread().getContextClassLoader().getResources(path);
            Set files = new HashSet();
            while (urls.hasMoreElements()) {
                URL url = (URL) urls.nextElement();
                if (url != null) {
                    String file = url.getFile();
                    if (file != null && file.length() > 0) {
                        files.add(file);
                    }
                }
            }
            // 如果有多个，就表示重复
            if (files.size() > 1) {
                System.out.println("Duplicate class " + path + " in " + files.size() + " jar " + files);
            }
        } catch (Throwable e) { // 防御性容错
            System.out.println(e.getMessage());
        }
    }
}
