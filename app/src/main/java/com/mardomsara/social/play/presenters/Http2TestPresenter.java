package com.mardomsara.social.play.presenters;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.API;
import com.mardomsara.social.base.Http2.Http2;
import com.mardomsara.social.base.Http2.Result;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.HttpJson;
import com.mardomsara.social.json.HttpJsonList;
import com.mardomsara.social.json.social.rows.TagRowJson;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.cells.TitleCellsGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Http2TestPresenter extends BasePresenter {
    @Override
    public View buildView() {
        PageCells.Scroller cell =new PageCells.Scroller();
        ViewGroup rootView =cell.rootView;
        ViewGroup layout =cell.layout;

        layout.addView(newTitle("Simple Http2.get()",()->{
            simpleGet();
        }));

        layout.addView(newTitle("Simple Http2.Post()",()->{
            simplePost();
        }));

        layout.addView(newTitle("Http2.get() + with json",()->{
            getJson();
        }));

        layout.addView(newTitle("Http2.get() + with json Moshi",()->{
            getJsonMoshi();
        }));

        return rootView;
    }

    View newTitle(String title, Runnable runnable){
        ViewGroup view = new TitleCellsGroup.BigClickAbleTitle(null,title).rootView;
        view.setOnClickListener((v)->{
            runnable.run();
        });
        int p = AndroidUtil.dpToPx(10);
        view.setPadding(0,p,p,p);
        return view;
    }

    void simpleGet(){
        Http2.get(API.SEARCH_TAGS)
                .setQueryParam("tag","م")
                .setQueryParam("nio",15)
                .doAsync((r)->{
                    Helper.showDebugMessage(r.data);
                });
    }

    void simplePost(){
        Http2.post(API.SEARCH_TAGS)
            .setQueryParam("tag","م")
            .setQueryParam("nio",15)
            .setFormParam("fo1","sdsdشسش")
                .setFormParam("fffff",""+256)
            .doAsync((r)->{
                Helper.showDebugMessage(r.data);
            });
    }

    void getJson(){
        Http2.get(API.SEARCH_TAGS)
                .setQueryParam("tag","م")
                .setQueryParam("nio",15)
                .setQueryParam("hamid","kar")
                .doAsync((result)->{
//                    TagsListJson r2 = Result.fromJson(result,TagsListJson.class);
//                    HttpJson<ArrayList> r2 = Result.fromJson2(result,ArrayList.class);
                    /*HttpJson<List<TagRowJson>> r2 = Result.fromJsonList(result,TagRowJson.class);
//                    TagsListJson r2 =result.fromJson2(TagsListJson.class);
                    if(result.isOk()){
                        String t = r2.Status;

                        Helper.showDebugMessage(""+t);
                        Helper.showDebugMessage(r2.Payload.get(0).toString());
                    }*/

//                    String t = result.<TagRowJson>fromJson(TagRowJson.class).Name;

                });

        /*.doAsyncJson(TagsListJson.class,
                new CallBack<TagsListJson>() {
                    @Override
                    public void callback(Result<TagsListJson> result) {
                        result.fromJson(TagsListJson.class);
//                                result.parsedJson
                    }
                });*/
//
//        .doAsyncJson(TagsListJson.class,(r)->{
//            r.parsedJson.
//                    Helper.showDebugMessage(r.data);
//        });
    }


    void getJsonMoshi() {
        Http2.get(API.SEARCH_TAGS)
                .setQueryParam("tag", "م")
                .setQueryParam("nio", 15)
                .setQueryParam("hamid", "kar")
                .doAsync((result) -> {
                    HttpJsonList<TagRowJson> r2 = Result.fromJsonList(result, TagRowJson.class);
//                    TagsListJson r2 =result.fromJson2(TagsListJson.class);
                    if (result.isOk()) {
                        String t = r2.Status;
                        try {
                            Helper.showDebugMessage("" + r2.Payload.getClass() );
                            Helper.showDebugMessage(r2.Payload.get(0).Name);
                        }catch (Exception e){
                            Helper.showDebugMessage("EXe: " + e.toString() );
                        }
                        Helper.showDebugMessage("" + t);
                        Helper.showDebugMessage(r2.Payload.toString());
                    }

//                    String t = result.<TagRowJson>fromJson(TagRowJson.class).Name;

                });
    }
    class TagsListsAll extends ArrayList<TagRowJson> {

    }

}
