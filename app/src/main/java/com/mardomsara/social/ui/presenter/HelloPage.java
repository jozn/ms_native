package com.mardomsara.social.ui.presenter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.nav.FragmentPage;

//import ;

/**
 * Created by Hamid on 5/2/2016.
 */
public class HelloPage extends FragmentPage {
    Integer count = 0;
    @Override
    public View getView(Bundle savedInstanceState) {
       ViewGroup v = (ViewGroup) AppUtil.inflate(R.layout.hello_world_row,null);
        View btn = v.findViewById(R.id.btn);
        View btn2 = v.findViewById(R.id.btn2);
        View btn3 = v.findViewById(R.id.btn3);
        TextView txt = (TextView)v.findViewById(R.id.txt);
        View anvil_view = v.findViewById(R.id.anvil);
        View anvil_view2 = v.findViewById(R.id.anvil2);
        txt.setText("Hello Wold + id:" + LangUtil.getRandomString(5));
        btn.setOnClickListener((vv)->{
            //Nav_DEP.push(Router_DEP.getHelloWolrdPage());
        });

        btn2.setOnClickListener((vv)->{
           // Nav_DEP.push(Router_DEP.getGalleryChooserPage());
        });

        btn3.setOnClickListener((vv)->{
//            Nav.push(new PlayPresenter());
        });
//        sendWsReqRes();

//        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
/*        FrameLayout container = new FrameLayout(getContext());
        container.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        container.addView(new MyView(getContext()));
        v.addView(container);*/


//        Anvi5 an = new Anvi5(){
////            @Override
//            void v(){
//            }
//        };
////        Anvil.Mount mount = Anvil.mount2(anvil_view2,new CounterView(getFragment().getActivity()));
//        Anvil.__realMount = mount;
//        Anvil.mount(anvil_view2, new CounterView(getFragment().getActivity()));
//        Anvil.mount(anvil_view, new TodoView(getFragment().getActivity()));

//        Anvil.currentView();
//        Anvil.mount(anvil_view, () -> {
//            linearLayout(() -> {
//                orientation(LinearLayout.VERTICAL);
//                // Show clicks count
//                textView(() -> {
//                    text("Count: " + count);
//                });
//                // Increase count on every click
//                button(() -> {
//
//                    text("Anvil");
//                    onClick((bb) -> {
//                        incer();
//                    });
//                });
//
//                textView(()->{
//                    textColor(R.color.colorAccent);
//                    text(LangUtil.getRandomString(10));
//                    padding(100,dip(14));
//                });
//
//            });
//        });
//
//        Anvil.mount(anvil_view2, new HelloView(getFragment().getActivity()));
        return v;
    }
    void incer(){
        count +=1;
    }

	/*void sendWsReqRes(){
		Command cmd = Command.getNewForResult("EchoRes");
		cmd.setData("dasdsad");
		WS_DEP.sendCommandForResponse(cmd,(data)->{
			AndroidUtil.runInUi(()->{
				UserInfoJson u = JsonUtil.fromJson(data,UserInfoJson.class);
				if(u!= null){
					Toast.makeText(App.context,u.FirstName,Toast.LENGTH_LONG).show();
				}
			});
		});
	}*/
    /*void sendWsReqRes(){
        Command cmd = Command.getNewForResult("EchoRes");
        cmd.setData("dasdsad");
        WS_DEP.sendCommandForResponse(cmd,(data)->{
            AndroidUtil.runInUi(()->{
				UserInfoJson u = JsonUtil.fromJson(data,UserInfoJson.class);
                if(u!= null){
                    Toast.makeText(App.context,u.FirstName,Toast.LENGTH_LONG).show();
                }
            });
        });
    }*/
}
