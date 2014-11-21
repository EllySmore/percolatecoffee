Eileen Yau
Percolate App Challenge

Instructions:
Compiled on *Andriod Studio* 

Lib Used: 
* 'com.squareup.picasso:picasso:2.4.0' 
* 'com.jakewharton:butterknife:6.0.0' 
* "com.android.support:appcompat-v7:21.0.+" 
* 'com.octo.android.robospice:robospice-okhttp:1.4.14' 
* 'de.greenrobot:eventbus:2.4.0' 
* 'com.google.code.gson:gson:2.3'

Other Sources:
http://romannurik.github.io/AndroidAssetStudio/ to generate custom action bar.

Summary:
I tried to separate the data from UI and strictly follow MVC and Single Responsiblity Principal.
You can see how things are organized in certain directories and classes are strictly for UI
only.
I used Robospice OkHttpclient. I'm not really familiar with it but
I made the request also a resultlistener and sent the result on the default eventbus.
One place to make request and listen for response.
I did not use Jackson, didn't have enough time to dwell into it. 

Let me know if you have any questions.
Cheers.