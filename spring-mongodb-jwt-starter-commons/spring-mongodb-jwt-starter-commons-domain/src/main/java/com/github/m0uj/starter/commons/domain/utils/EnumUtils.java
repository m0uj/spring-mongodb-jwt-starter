package com.github.m0uj.starter.commons.domain.utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by m0uj on 4/19/17.
 */
public class EnumUtils {
    public static <T extends Enum<T>> T valueOf(Class<T> var0, String var1) {
        List<T> var2 = Arrays.asList(var0.getEnumConstants());
        /**
         * return a default value of enums (first enums constant) instead of throwing a NullPointerException
         */
        //if (var1 == null)
        //    throw new NullPointerException("Value is null");
        if (var2.size() == 0)
            throw new IndexOutOfBoundsException("No enums constant " + var0.getCanonicalName() + "." + var1 + ", Enum may not be null or empty !");
        return var2.stream().filter(m -> m.toString().equals(var1)).findAny().orElse(var2.get(0));
    }
}
