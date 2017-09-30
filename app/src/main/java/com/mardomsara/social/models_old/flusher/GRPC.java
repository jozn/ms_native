package com.mardomsara.social.models_old.flusher;

/**
 * Created by Hamid on 6/20/2017.
 */

public class GRPC {

	/*public static RpcMsgsGrpc.RpcMsgsBlockingStub getNewBlockingMsgRpc() {
		ManagedChannel managedChannel = OkHttpChannelBuilder
			.forAddress(Config.WEBSOCKET_SERVER_ADDRESS, Config.WEBSOCKET_SERVER_PORT)
			.keepAliveTime(30, TimeUnit.MINUTES)
			.keepAliveTimeout(1, TimeUnit.MINUTES)
			.usePlaintext(true)
			.negotiationType(NegotiationType.PLAINTEXT)
			.transportExecutor(App.getDefultNetworkExecuter())
			.build();

		return RpcMsgsGrpc.newBlockingStub(managedChannel);
	}*/

	public static void play() {
//		getNewBlockingMsgRpc().uploadNewMsg();
		/*ManagedChannel managedChannel = OkHttpChannelBuilder.forAddress("").keepAliveWithoutCalls(false).usePlaintext().build();
		OkHttpChannelBuilder.forAddress("").usePlaintext().build();

		RpcMsgsGrpc.newBlockingStub(managedChannel).uploadNewMsg().;
		RpcMsgsGrpc.newStub(managedChannel).uploadNewMsg().*/
	}

}
