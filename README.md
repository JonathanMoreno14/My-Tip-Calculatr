
# My Tip Calculator









![screenshot](https://user-images.githubusercontent.com/11635523/40263385-35bc1ce4-5ad7-11e8-8f02-e6140425db6f.png)

[![google-play-badge copy-v2](https://user-images.githubusercontent.com/11635523/40263384-35a219a2-5ad7-11e8-9492-698872b6e9d9.png)](https://play.google.com/store/apps/details?id=com.jm.jonathanmoreno.mytipcalculatr)


#### Android API 23

#### Android Manifest
```xml
    android:screenOrientation="portrait"
```

#### Dependencies
```gradle

   implementation 'com.android.support:cardview-v7:27.1.1'
   implementation 'com.android.support:design:27.1.1'
   implementation 'com.android.support:gridlayout-v7:27.1.1'
   implementation 'com.jakewharton:butterknife:8.8.1'
   annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'

```

#### Theme

```xml

<!--Custom Theme with no ActionBar-->
   <style name="AppThemefull" parent="Theme.AppCompat.Light.NoActionBar">
       <!--<item name="colorPrimaryDark">@color/colorPrimaryDark</item>-->
       <item name="colorPrimaryDark">@color/colorPrimary</item>
       <item name = "android:windowActionBar">false</item>
       <item name = "android:windowNoTitle">true</item>

       <!--Color for the EditText-->
       <item name="colorControlActivated">@color/colorAccent</item>
       <item name="colorControlHighlight">@color/colorAccent</item>

   </style>


```

#### How to Use

Clone the repository or download the app via Google Play Store
