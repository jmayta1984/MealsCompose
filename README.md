<h1 align="center">MealsCompose</h1></br>
<p align="center">  
A demo app using compose based on modern Android tech-stacks and MVVM architecture. Fetching data from network and integrating persisted data in the database via repository pattern, using compose.
</p>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
    <a href="http://developer.android.com/index.html"><img alt="Platform" src="https://img.shields.io/badge/platform-Android-green.svg"/></a>

  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  </p>

## Screenshots
<p align="center">
<img src="https://user-images.githubusercontent.com/38768001/137116322-8dc85b9f-62c9-4bc4-9d4f-c3d3b95d56dd.png" width=32%"/>
<img src="https://user-images.githubusercontent.com/38768001/137116318-d5f78df0-35af-4226-8f35-a5df88a5a157.png" width=32%"/>
<img src="https://user-images.githubusercontent.com/38768001/137116309-b4c44ef2-d2b9-40ad-b7dc-50b594a68c3a.png" width=32%"/>
</p>

## Tech stack & Open-source libraries
- Minimum SDK level 21
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- JetPack
  - Compose - A modern toolkit for building native Android UI.
  - LiveData - notify domain layer data to views.
  - Lifecycle - dispose observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - Room Persistence - construct database.
- Architecture
  - MVVM Architecture (Declarative View - ViewModel - Model)
  - Repository pattern
- Material Design
- [Accompanist](https://github.com/google/accompanist) - A collection of extension libraries for Jetpack Compose.
- [Retrofit2](https://github.com/square/retrofit) - construct the REST APIs and paging network data.

## MAD Score
![summary](https://user-images.githubusercontent.com/38768001/137116711-3761a96c-75d4-4a17-a9d6-19b1d9831f9c.png)
![jetpack](https://user-images.githubusercontent.com/38768001/137116709-83a26fc9-0125-4875-8077-c66a4bf5c44a.png)

## Architecture
HeroCompose is based on MVVM architecture and repository pattern.
![architecture](https://user-images.githubusercontent.com/38768001/134121196-9a278e99-fc4c-426a-a136-d564ebc2915d.png)

# License
```xml
Designed and developed by 2021 jmayta1984 (Jorge Mayta)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
