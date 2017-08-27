package com.mardomsara.social.play.presenters;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.Cells;

import ir.ms.pb.PB_MsgParam_Echo;
import ir.ms.pb.RPC;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Play_WSCallPresenter extends BasePresenter {

	Cells.Title_BigClickAble info = null;
    @Override
    public View buildView() {
        Cells.Scroller cell =new Cells.Scroller();
        ViewGroup rootView =cell.rootView;
        ViewGroup layout =cell.layout;

        layout.addView(newTitle("Call Echo ",()->{
            callEcho();
        }));

		layout.addView(newTitle("New Pipe PB Call Echo ",()->{
			callEcho();
		}));

		layout.addView(newTitle2("TEXT IN HERER",()->{

		} ));

        return rootView;
    }

	private void callEcho() {
		PB_MsgParam_Echo paramEcho = PB_MsgParam_Echo.newBuilder().setText("hi therre i am hamid").build();
		RPC.RPC_Msg.Echo(paramEcho,
			(res)->{
			Helper.showDebugMessage("echo resu:" + res.getText() + res.toString());
				info.setText(res.getText());

				throw new RuntimeException("YYYYYYYYYYYYYYYY");
		}, (err) -> {
				Helper.showDebugMessage("echo err:" + err);
			});

		/*Pipe_OLD.sendCall("echo","Hi From go",
			()->{
				Helper.showDebugMessage("Echo Call Success");
			},
			()->{
				Helper.showDebugMessage("Echo Call Error");
			}
		);*/
	}

	View newTitle(String title, Runnable runnable){
		ViewGroup view = new Cells.Title_BigClickAble(null,title).rootView;
		view.setOnClickListener((v)->{
			runnable.run();
		});
		int p = AndroidUtil.dpToPx(10);
		view.setPadding(0,p,p,p);
		return view;
	}

	View newTitle2(String title, Runnable runnable){
		info = new Cells.Title_BigClickAble(null,title);
		ViewGroup view = info.rootView;
		view.setOnClickListener((v)->{
			runnable.run();
		});
		int p = AndroidUtil.dpToPx(10);
		view.setPadding(0,p,p,p);
		return view;
	}



}
