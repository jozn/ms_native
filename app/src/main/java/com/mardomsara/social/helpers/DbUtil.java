package com.mardomsara.social.helpers;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by Hamid on 4/28/2016.
 */
public class DbUtil {
    public static String ToSqlIn(List ids){
        return StringUtils.join(ids.iterator(),",");
    }
}
