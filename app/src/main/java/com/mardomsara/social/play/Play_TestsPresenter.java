package com.mardomsara.social.play;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.nav.Nav;
import com.mardomsara.social.play.presenters.Play_DiaolgPresenter;
import com.mardomsara.social.play.presenters.Play_FormsPresenter;
import com.mardomsara.social.play.presenters.Play_Http2TestPresenter;
import com.mardomsara.social.play.presenters.Play_Realm;
import com.mardomsara.social.play.presenters.Play_RecipiesPresenter;
import com.mardomsara.social.play.presenters.Play_WSCallPresenter;
import com.mardomsara.social.play.presenters.Play_XIconPresneter;
import com.mardomsara.social.play.presenters.Play_XTextColorsViews;
import com.mardomsara.social.play.presenters.Play_XTextViews;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.presenter.HelloPage;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Play_TestsPresenter extends FragmentPage {

	@Override
    public View getView(Bundle savedInstanceState) {
        Cells.Scroller cell =new Cells.Scroller();
        ViewGroup rootView =cell.rootView;
        ViewGroup layout =cell.layout;

        layout.addView(newTitle("همه حذف",()->{
			Nav.push(new HelloPage());
        }));

        layout.addView(newTitle("Http2 play test",()->{
            Nav.push(new Play_Http2TestPresenter());
        }));

		layout.addView(newTitle("Ws Call tsest",()->{
			Nav.push(new Play_WSCallPresenter());
		}));

		layout.addView(newTitle("Dialogs ",()->{
			Nav.push(new Play_DiaolgPresenter());
		}));

		layout.addView(newTitle("Edits ",()->{
			Nav.push(new Play_FormsPresenter());
		}));

		layout.addView(newTitle("Recipies ",()->{
			Nav.push(new Play_RecipiesPresenter());
		}));

		layout.addView(newTitle("XIcons ",()->{
			Nav.push(new Play_XIconPresneter());
		}));

		layout.addView(newTitle("XLinkerTextView ",()->{
			Nav.push(new Play_XTextViews());
		}));


		layout.addView(newTitle("Colores ",()->{
			Nav.push(new Play_XTextColorsViews());
		}));


		layout.addView(newTitle("Realm",()->{
			Nav.push(new Play_Realm());
		}));

/*
		layout.addView(newTitle("React ",()->{
			Nav.push(new ReactPresenter());
		}));

		layout.addView(newTitle("React Presenter",()->{
			Nav.push(new ReactPresenter());
		}));

		layout.addView(newTitle("React Presenter2",()->{
			Nav.push(new ReactPresenter());
		}));


		layout.addView(newTitle("React Presenter3",()->{
			Nav.push(new ReactPresenter());
		}));

		layout.addView(newTitle("React Activity +++++++",()->{
			Intent intent = new Intent(getContext(), MyReactActivity.class);
			getActivity().startActivity(intent);
		}));

		layout.addView(newTitle("React Activity2 ",()->{
			Intent intent = new Intent(getContext(), MSReactActivity2.class);
			getActivity().startActivity(intent);
		}));
*/

        return rootView;
    }

    View newTitle(String title, Runnable runnable){
        ViewGroup view = new Cells.Title_Info(null,title).rootView;
        view.setOnClickListener((v)->{
            runnable.run();
        });
        return view;
    }

    void play(){
//		Stream.of("d","d","g").filter((s)->  s.equals("ss")).toArray();
//		Stream.of("d","d","g").filter((s)->  s.equals("ss")).collect(Collectors.joining( ""));

		new X.PlayXicon().root.setOnClickListener(Play_TestsPresenter::cc);
	}

	static void cc(View v){}
}
