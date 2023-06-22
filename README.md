# GitHubUserSearch
This is an exercise repository for Android application development using Kotlin. 


## About GitHubUserSearch
GitHubUserSearch is an android application to search GitHub users. There will be SearchView, RecyclerView to list users, dark theme and light theme setting, and Favorite. This project is using MVVM design pattern, and fetching data from GitHub RestAPI.


## UI 
<div style="display: flex; justify-content: center;">
  <img src="https://github.com/drewjd27/GitHubUser_AndroidApp/assets/26517220/4a843fb3-5ec7-470a-9e25-d55909e9092a" alt="Home" width="200" margin=""/>
  <img src="https://github.com/drewjd27/GitHubUser_AndroidApp/assets/26517220/5c0d8c72-d397-49a5-912f-a1adc54b96d0" alt="User Detail" width="200" />
  <img src="https://github.com/drewjd27/GitHubUser_AndroidApp/assets/26517220/389f7ac2-149d-4ab1-80a0-48018bc5e931" alt="Favorite Screen" width="200" />
  <img src="https://github.com/drewjd27/GitHubUser_AndroidApp/assets/26517220/9180916d-af02-4743-9bed-afbb69948d88" alt="Theme Setting" width="200" />
</div>


## Feature
- Search user
- Dark theme and light theme setting
- Favorite


## Tech Stack
- Kotlin programming language
- [Retrofit2](https://github.com/square/retrofit)
- [Glide](https://github.com/bumptech/glide)
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore)
- [ViewPager2](https://developer.android.com/jetpack/androidx/releases/viewpager2)
- [Room](https://developer.android.com/jetpack/androidx/releases/room)
- [RecyclerView](https://developer.android.com/develop/ui/views/layout/recyclerview)
- [Fragment](https://developer.android.com/guide/fragments)


## RestAPI
[GitHub RestAPI](https://docs.github.com/en/rest?apiVersion=2022-11-28)


## Project Insalation
1. Clone the repository


    ```bash
    git clone https://github.com/drewjd27/GitHubUser_AndroidApp.git
    cd GitHubUser
    ```

2. Add your API_TOKEN in build.gradle(Module:app)

   ```bash
    buildConfigField("String", "API_TOKEN", '"INPUT_YOUR_TOKEN_VALUE_HERE"')
    ```

   
3. Run the app in Android Studio from emulator or physical device.
