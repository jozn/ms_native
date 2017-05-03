package com.mardomsara.social.json.social.rows;

/**
 * Created by Hamid on 9/1/2016.
 */
@Deprecated
public class ActivityRowJson {
	public long Id;
	public int ActorUserId;
	public int ActionTypeId;
	public int TargetId;
	public int RefId;
	public int CreatedAt;
	public Load Load;

	public static class Load {
		public UserInfoJson Actor;
		public PostRowJson Post;
		public CommentRowJson Comment;
	}

}

/*Id: 3125,
ActorUserId: 17,
ActionTypeId: 220,
TargetId: 189297,
RefId: 189297220,
CreatedAt: 1481136613,*/

