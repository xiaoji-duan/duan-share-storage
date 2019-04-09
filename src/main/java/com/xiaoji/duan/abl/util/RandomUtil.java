package com.xiaoji.duan.abl.util;

import java.util.Random;

public class RandomUtil {
    public static int  randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }
}
