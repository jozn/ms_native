/*
 * Copyright 2014 Hieu Rocker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mardomsara.emojicon;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.mardomsara.emojicon.emoji.Activities;
import com.mardomsara.emojicon.emoji.Diversity;
import com.mardomsara.emojicon.emoji.Emojicon;
import com.mardomsara.emojicon.emoji.Flags;
import com.mardomsara.emojicon.emoji.Foods;
import com.mardomsara.emojicon.emoji.Nature;
import com.mardomsara.emojicon.emoji.Objects;
import com.mardomsara.emojicon.emoji.People;
import com.mardomsara.emojicon.emoji.Places;
import com.mardomsara.emojicon.emoji.Symbols;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Hieu Rocker (rockerhieu@gmail.com).
 */
public class Emojicons implements ViewPager.OnPageChangeListener,
        EmojiconRecents,OnEmojiconClickedListener {
    private OnEmojiconBackspaceClickedListener mOnEmojiconBackspaceClickedListener;
    private OnEmojiconClickedListener mOnEmojiconClickedListener;
    private int mEmojiTabLastSelectedIndex = -1;
    private View[] mEmojiTabs;
    private PagerAdapter mEmojisAdapter;
    private EmojiconRecentsManager mRecentsManager;
    private boolean mUseSystemDefault = false;
    // colers
    int activeTabColor = Color.argb(55, 55, 55, 255);
    int unactiveTabcolor = Color.argb(255, 255, 255, 255);

    private static final String USE_SYSTEM_DEFAULT_KEY = "useSystemDefaults";

    FragmentManager fm;
    View view;

    Context context =AppUtil.getContext();
    public static Emojicons newInstance(boolean useSystemDefault,FragmentManager fragmentManager ) {
        Emojicons fragment = new Emojicons();
        Bundle bundle = new Bundle();
        bundle.putBoolean(USE_SYSTEM_DEFAULT_KEY, useSystemDefault);
        fragment.fm = fragmentManager;
//        fragment.setArguments(bundle);
        return fragment;
    }

    public View createView(ViewGroup container) {
        LayoutInflater inflater = LayoutInflater.from(AppUtil.getContext());
        view = inflater.inflate(R.layout.emojicons, null, false);
        final ViewPager emojisPager = (ViewPager) view.findViewById(R.id.emojis_pager);
        emojisPager.setOnPageChangeListener(this);
        // we handle recents
        EmojiconRecents recents = this;
        //ME: call: getChildFragmentManager

        mEmojisAdapter = new EmojisPagerAdapter(Arrays.asList(
                new EmojiconRecentsGridView(AppUtil.getContext(), null, null,this),//0
                EmojiconGridView.newInstance(People.DATA, this, recents, mUseSystemDefault),//1
                EmojiconGridView.newInstance(Nature.DATA, this, recents, mUseSystemDefault),//2
                EmojiconGridView.newInstance(Foods.DATA, this, recents, mUseSystemDefault),//3
                EmojiconGridView.newInstance(Activities.DATA, this, recents, mUseSystemDefault),//4
                EmojiconGridView.newInstance(Places.DATA, this, recents, mUseSystemDefault),//5
                EmojiconGridView.newInstance(Objects.DATA, this, recents, mUseSystemDefault),//6
                EmojiconGridView.newInstance(Symbols.DATA, this, recents, mUseSystemDefault),//7
                EmojiconGridView.newInstance(Flags.DATA, this, recents, mUseSystemDefault),//8
                EmojiconGridView.newInstance(Diversity.DATA, this, recents, mUseSystemDefault)//9
        ));
        emojisPager.setAdapter(mEmojisAdapter);
//        for (EmojiconGridFragment grid : mEmojisAdapter)

        mEmojiTabs = new View[10];
        mEmojiTabs[0] = view.findViewById(R.id.emojis_tab_0_recents);
        mEmojiTabs[1] = view.findViewById(R.id.emojis_tab_1_people);
        mEmojiTabs[2] = view.findViewById(R.id.emojis_tab_2_nature);
        mEmojiTabs[3] = view.findViewById(R.id.emojis_tab_3_food);
        mEmojiTabs[4] = view.findViewById(R.id.emojis_tab_4_activities);
        mEmojiTabs[5] = view.findViewById(R.id.emojis_tab_5_places);
        mEmojiTabs[6] = view.findViewById(R.id.emojis_tab_6_objects);
        mEmojiTabs[7] = view.findViewById(R.id.emojis_tab_7_symbols);
        mEmojiTabs[8] = view.findViewById(R.id.emojis_tab_8_flags);
        mEmojiTabs[9] = view.findViewById(R.id.emojis_tab_9_diversity);
        for (int i = 0; i < mEmojiTabs.length; i++) {
            final int position = i;
            ((ImageButton)mEmojiTabs[i]).setColorFilter(unactiveTabcolor);
            mEmojiTabs[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emojisPager.setCurrentItem(position);
//                    ((ImageButton)v).setColorFilter(Color.argb(255, 255, 55, 255));
//                    v.tin
                }
            });
        }
        view.findViewById(R.id.emojis_backspace).setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),"ssssssss",Toast.LENGTH_LONG).show();
                if (mOnEmojiconBackspaceClickedListener != null) {
                    mOnEmojiconBackspaceClickedListener.onEmojiconBackspaceClicked(v);
                }
            }
        });

        // get last selected page
        mRecentsManager = EmojiconRecentsManager.getInstance(view.getContext());
        int page = mRecentsManager.getRecentPage();
        // last page was recents, check if there are recents to use
        // if none was found, go to page 1
        if (page == 0 && mRecentsManager.size() == 0) {
            page = 1;
        }

        if (page == 0) {
            onPageSelected(page);
        } else {
            emojisPager.setCurrentItem(page, false);
        }
        return view;
    }

    public static void input(EditText editText, Emojicon emojicon) {
        if (editText == null || emojicon == null) {
            return;
        }

        int start = editText.getSelectionStart();
        int end = editText.getSelectionEnd();
        if (start < 0) {
            editText.append(emojicon.getEmoji());
        } else {
            editText.getText().replace(Math.min(start, end), Math.max(start, end), emojicon.getEmoji(), 0, emojicon.getEmoji().length());
        }
    }

    @Override
    public void addRecentEmoji(Context context, Emojicon emojicon) {
        final ViewPager emojisPager = (ViewPager) getView().findViewById(R.id.emojis_pager);
//        EmojiconRecentsGridView recentsGridView = (EmojiconRecentsGridView) mEmojisAdapter.instantiateItem(emojisPager, 0);
//        recentsGridView.addRecentEmoji(context, emojicon);
        EmojiconRecentsManager.getInstance(context).push(emojicon);
    }

    public static void backspace(EditText editText) {
        KeyEvent event = new KeyEvent(0, 0, 0, KeyEvent.KEYCODE_DEL, 0, 0, 0, 0, KeyEvent.KEYCODE_ENDCALL);
        editText.dispatchKeyEvent(event);
    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {
    }

    @Override
    public void onPageSelected(int i) {
        if (mEmojiTabLastSelectedIndex == i) {
            return;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                if (mEmojiTabLastSelectedIndex >= 0 && mEmojiTabLastSelectedIndex < mEmojiTabs.length) {
                    mEmojiTabs[mEmojiTabLastSelectedIndex].setSelected(false);
                    ((ImageButton)mEmojiTabs[mEmojiTabLastSelectedIndex]).setColorFilter(unactiveTabcolor);
                }
                mEmojiTabs[i].setSelected(true);
                ((ImageButton)mEmojiTabs[i]).setColorFilter(activeTabColor);
                mEmojiTabLastSelectedIndex = i;
                mRecentsManager.setRecentPage(i);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {
    }

    public void setmOnEmojiconClickedListener(OnEmojiconClickedListener mOnEmojiconClickedListener) {
        this.mOnEmojiconClickedListener = mOnEmojiconClickedListener;
    }

    @Override
    public void onEmojiconClicked(Emojicon emojicon) {
        if(mOnEmojiconClickedListener != null){
            mOnEmojiconClickedListener.onEmojiconClicked(emojicon);
        }
    }

    public View getView() {
        return view;
    }

    private static class EmojisPagerAdapter extends PagerAdapter {
        private List<EmojiconGridView> views;
        public EmojiconRecentsGridView getRecentFragment(){
            for (EmojiconGridView it : views) {
                if(it instanceof EmojiconRecentsGridView)
                    return (EmojiconRecentsGridView)it;
            }
            return null;
        }
        public EmojisPagerAdapter(List<EmojiconGridView> views) {
            super();
            this.views = views;
        }

        @Override
        public int getCount() {
            return views.size();
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = views.get(position).rootView;
            ((ViewPager)container).addView(v, 0);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object view) {
            ((ViewPager)container).removeView((View)view);
        }

        @Override
        public boolean isViewFromObject(View view, Object key) {
            return key == view;
        }
    }


/*    private static class EmojisPagerAdapter extends FragmentStatePagerAdapter {
        private List<EmojiconGridFragment> fragments;

        public EmojisPagerAdapter(FragmentManager fm, List<EmojiconGridFragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }*/

    /**
     * A class, that can be used as a TouchListener on any view (e.g. a Button).
     * It cyclically runs a clickListener, emulating keyboard-like behaviour. First
     * click is fired immediately, next before initialInterval, and subsequent before
     * normalInterval.
     * <p/>
     * <p>Interval is scheduled before the onClick completes, so it has to run fast.
     * If it runs slow, it does not generate skipped onClicks.
     */
    public static class RepeatListener implements View.OnTouchListener {

        private Handler handler = new Handler();

        private int initialInterval;
        private final int normalInterval;
        private final View.OnClickListener clickListener;

        private Runnable handlerRunnable = new Runnable() {
            @Override
            public void run() {
                if (downView == null) {
                    return;
                }
                handler.removeCallbacksAndMessages(downView);
                handler.postAtTime(this, downView, SystemClock.uptimeMillis() + normalInterval);
                clickListener.onClick(downView);
            }
        };

        private View downView;

        /**
         * @param initialInterval The interval before first click event
         * @param normalInterval  The interval before second and subsequent click
         *                        events
         * @param clickListener   The OnClickListener, that will be called
         *                        periodically
         */
        public RepeatListener(int initialInterval, int normalInterval, View.OnClickListener clickListener) {
            if (clickListener == null)
                throw new IllegalArgumentException("null runnable");
            if (initialInterval < 0 || normalInterval < 0)
                throw new IllegalArgumentException("negative interval");

            this.initialInterval = initialInterval;
            this.normalInterval = normalInterval;
            this.clickListener = clickListener;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    downView = view;
                    handler.removeCallbacks(handlerRunnable);
                    handler.postAtTime(handlerRunnable, downView, SystemClock.uptimeMillis() + initialInterval);
                    clickListener.onClick(view);
                    return true;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_OUTSIDE:
                    handler.removeCallbacksAndMessages(downView);
                    downView = null;
                    return true;
            }
            return false;
        }
    }

    /////////// BY ME //////////////

    public void setEmojiBackListener(OnEmojiconBackspaceClickedListener obj){
        mOnEmojiconBackspaceClickedListener = obj;
    }
}
