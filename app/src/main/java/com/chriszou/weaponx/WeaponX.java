package com.chriszou.weaponx;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by xiaochuang on 05/12/2016.
 */

public class WeaponX {
    public static <T> void each(Collection<T> collection, Action1<T> action) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            action.call(t);
        }
    }

}
