# An android social network
This a social network like Instagram with more advanced features: a chat section that is more like WhatsApp but it's cloud based, means texts, photo, video, files,... can be accessed across multi device.

![Main chat Page, like Whatsapp](https://i.imgur.com/KC4wQlq.png)

This app is +70% complete.
This project is evolutionary, some technology adapted then dropped in favor of better technologies, Dropped: RESR, JSON, some SQLite tables to realm,  
At start this app was using REST with JSON , but then it rewrite with an custom RPC (like gRPC), with Protocol Buffer. 

*note: there is just one developer in this project and this project was never meant to be shared so git's commit comments are not as thorough as it should be!*

## features:
Like Instagram.
A full chat section.
Home pictures feed can be changed from full screen (like Instagram) to a compact view like twitter.
sync with users phones contacts list.
very good notification system.

## Technology used:
+ Custom [RPC genrator](https://github.com/jozn/pb_walker) from `.proto` files. 
+ Fully remove of `.findViewById` with our custm [xml2java tool](https://github.com/jozn/xml2java). [X file](https://github.com/jozn/ms_native/blob/master/app/src/main/java/com/mardomsara/social/ui/X.java)
+ Single Activity, MVP, Web socket ( duplex ), realm, SQLite, RPC, Protocol Buffer, advanced TextView, custom views, fonts.
+ Fresco, Gson, Room (in new one), .... you can see more in gradle files.

## Some random features in the app:
Gallery browser, photo and video.
File browser.
3 times bigger emoji in 'just emoji text chat'
custom emoji keyboard with "Emoji One"
single activity
Navigation of pages exactly like Instagram.

## folder structures 
+ main app entry codes: https://github.com/jozn/ms_native/tree/master/app/src/main/java/com/mardomsara/social
+ some other library codes changed to fit perfectly in the app: https://github.com/jozn/ms_native/tree/master/app/src/main/java/com/mardomsara
+ custom RPC codes generated via [pb_walker](https://github.com/jozn/pb_walker) in here: https://github.com/jozn/ms_native/tree/master/app/src/main/java/ir/ms/pb
