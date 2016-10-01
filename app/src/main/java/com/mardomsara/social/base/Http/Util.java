package com.mardomsara.social.base.Http;

import com.mardomsara.social.helpers.AppUtil;

import org.apache.commons.lang3.StringUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Util {

    public static Headers headersToOkHttpHeaders(Map<String, String> headers){
        Headers.Builder hs = new Headers.Builder();
        for(String k: headers.keySet() ){
            hs.add(k,headers.get(k));
        }
        return hs.build();
    }

    public static RequestBody formsToOkHttpFormParams(Map<String, String> form){
        FormBody.Builder fb =new FormBody.Builder() ;
        for(String k: form.keySet() ){
            fb.add(k,form.get(k));
        }
        return fb.add("asd","eeeeee")
                .add("asdsa","werwe")
                .build();
    }

    public static RequestBody buildOthersFormParamsForUpload(MultipartBody.Builder b, Map<String, String> form){
//            FormBody.Builder fb =new FormBody.Builder() ;
        for(String k: form.keySet() ){
            b.addFormDataPart(k,form.get(k));
        }
        return b.addFormDataPart("asd","eeeeee")
                .addFormDataPart("asdsa","werwe")
                .build();
    }

    public static String getUrlParamsToStringUrls(Map<String, String> urlQueryParams){
        List<String> ls = new ArrayList<>();
        for (String k : urlQueryParams.keySet()){
            ls.add(""+k+"="+ urlQueryParams.get(k));
        }

        Map<String, String> defs = Http._getDefualturlParams();
        for (String k : defs.keySet()){
            ls.add(""+k+"="+defs.get(k));
        }
        //todo: kind of urlencode ?
        return StringUtils.join(ls.toArray(), "&");
    }

    public static URL buildFinalUrlFromPath(String absUrl,Map<String, String> urlQueryParams){
        String urlLast = StringUtils.indexOf(absUrl, "?")<0 ? absUrl +"?"+ getUrlParamsToStringUrls(urlQueryParams) : absUrl +"&"+ getUrlParamsToStringUrls(urlQueryParams);
        return AppUtil.toUrl(urlLast);
    }

}
