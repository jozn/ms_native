package com.mardomsara.social.play.presenters;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.AppLogger;
import com.mardomsara.social.app.DB;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.lib.NanoTimestamp;
import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.pipe.table.RpcOffline;
import com.mardomsara.social.ui.cells.Cells;

import ir.ms.pb.PB_ChatParam_GetChatList;
import ir.ms.pb.PB_ChatParam_GetFreshAllDirectMessagesList;
import ir.ms.pb.PB_OtherParam_Echo;
import ir.ms.pb.RPC;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Play_WSCallPresenter extends FragmentPage {

	Cells.Title_BigClickAble info = null;
    @Override
    public View getView(Bundle savedInstanceState) {
        Cells.Scroller cell =new Cells.Scroller();
        ViewGroup rootView =cell.rootView;
        ViewGroup layout =cell.layout;

		layout.addView(newTitle("Matisse ",()->{
			/*Matisse.from(getActivity())
				.choose(MimeType.ofAll())
				.countable(true)
				.maxSelectable(9)
				.gridExpectedSize(4)
				//.addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
				.gridExpectedSize(layout.getContext().getResources().getDimensionPixelSize(R.dimen.app_bar_height))
				.restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
				.thumbnailScale(0.85f)
				.imageEngine(new PicassoEngine())
				.forResult(26);*/
		}));

        layout.addView(newTitle("Call Echo ",()->{
            callEcho();
        }));

		layout.addView(newTitle("New Pipe PB Call Echo ",()->{
			callEcho();
		}));

		layout.addView(newTitle2("TEXT IN HERER",()->{

		} ));

		layout.addView(newTitle2("Offline call of rpc",()->{
			callEchoOffline();
		} ));


		layout.addView(newTitle2("RPC.RPC_Chat full chat and direct refresh",()->{
			RPC.RPC_Chat.GetFreshAllDirectMessagesList(PB_ChatParam_GetFreshAllDirectMessagesList.newBuilder().build(),null,null);
			RPC.RPC_Chat.GetChatList(PB_ChatParam_GetChatList.newBuilder().build(),null,null);
//			RPC.RPC_Msg.GetFreshChatList(PB_MsgParam_GetFreshChatList.newBuilder().build(),null,null);
		} ));

		layout.addView(newTitle2("GetFreshRoomMessagesList 2",()->{
//			RPC.RPC_Msg.GetFreshRoomMessagesList(PB_MsgParam_GetFreshRoomMessagesList.newBuilder().setRoomKey("d6_2").build(),null,null);
		} ));

		layout.addView(newTitle2("GetFreshAllDirectMessagesList",()->{
//			RPC.RPC_Msg.GetFreshAllDirectMessagesList(PB_MsgParam_GetFreshAllDirectMessagesList.getDefaultInstance().newBuilder().build(),null,null);
		} ));


		layout.addView(newTitle2("Android Logger to Sun play",()->{

			AppLogger.getInboxLogger().v("verbose to inbox");
			AppLogger.getInboxLogger().e("error to inbox");
			AppLogger.getInboxLogger().d("debug to inbox");

			AppLogger.getSettingLogger().v("verbose to setting ");
			AppLogger.getSettingLogger().e("error to setting");
			AppLogger.getSettingLogger().d("debug to setting");

		} ));

        return rootView;
    }

	private void callEcho() {
		PB_OtherParam_Echo paramEcho = PB_OtherParam_Echo.newBuilder().setText("hi therre i am hamid").build();
		RPC.RPC_Other.Echo(paramEcho,
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

	private void callEchoOffline() {
		/*PB_MsgParam_Echo paramEcho = PB_MsgParam_Echo.newBuilder().setText("hi therre i am hamid").build();
		RPC.RPC_Msg.Echo_Offline(null,paramEcho,
			(res)->{
				Helper.showDebugMessage("echo resu:" + res.getText() + res.toString());
				info.setText(res.getText());

//				throw new RuntimeException("YYYYYYYYYYYYYYYY");
			}, (err) -> {
				Helper.showDebugMessage("echo err:" + err);
			});
*/
		AndroidUtil.runInBackgroundNoPanic(()->{
			RpcOffline rpcOffline = new RpcOffline();
			rpcOffline.ClientCallId = NanoTimestamp.getNano();
			rpcOffline.CommandKey = LangUtil.getRandomString(15);
			rpcOffline.RpcMethod = "rpc_name.jjk(";
//		rpcOffline.Blob = ;

			DB.getRpcDB().insertIntoRpcOffline(rpcOffline);
		});
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
