# An android social network
This a social network like Instagram with more advanced features: a chat section that is more like WhatsApp but it's cloud based, means texts, photo, video, files,... can be accessed across multi device.

This app is +70% complete.
This project is evolutionary, some technology adapted then dropped in favor of better technologies, Dropped: RESR, JSON, some SQLite tables to realm,  
At start this app was using REST with JSON , but then it rewrite with an custom RPC (like gRPC), with Protocol Buffer. 

---

## features:
Like Instagram.
A full chat section.
Home pictures feed can be changed from full screen (like Instagram) to a compact view like twitter.
sync with users phones contacts list.
very good notification system.

---

## Technology used:
Single Activity, MVP, Web socket ( duplex ), realm, SQLite, RPC, Protocol Buffer, advanced TextView, custom views, fonts.

---

## Some random in the app:
Gallery browser, photo and video.
File browser.
3 times bigger emoji in 'just emoji text chat'
custom emoji keyboard with "Emoji One"
single activity
Navigation of pages exactly like Instagram.

---

## folder structures 
+ main app entry codes: https://github.com/jozn/ms_native/tree/master/app/src/main/java/com/mardomsara/social
+ some other library codes changed to fit perfectly in the app: https://github.com/jozn/ms_native/tree/master/app/src/main/java/com/mardomsara
+ custom RPC codes generated via [pb_walker](https://github.com/jozn/pb_walker) in here: https://github.com/jozn/ms_native/tree/master/app/src/main/java/ir/ms/pb
