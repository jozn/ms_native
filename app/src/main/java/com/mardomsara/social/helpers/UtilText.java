package com.mardomsara.social.helpers;

import com.mardomsara.emojicon.EmojiMaper;

/**
 * Created by Hamid on 9/26/2017.
 */

public class UtilText {

	public static boolean isJustEmoji(String text){
		return EmojiMaper.isJustEmoji(text);
	}
}
