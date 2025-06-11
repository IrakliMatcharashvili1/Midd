# Football Teams App

This app provides a list of football teams with photos, founding years, brief descriptions, and official websites. The data is fetched asynchronously from a JSON file hosted on GitHub using Retrofit.
![image](https://github.com/user-attachments/assets/c5ed3d3c-cef9-4c86-8de5-55e9cbc123e1)
![image](https://github.com/user-attachments/assets/663c383f-33de-412d-8237-2fa19e0d36ef)

## App Purpose

- Display a list of football teams with their images, names, and founding years.  
- Show detailed information about each team on a separate screen when selected.

## Technologies Used

- **Kotlin** — for app logic  
- **XML** — for UI layouts  
- **Retrofit** — to fetch JSON data from the API  
- **Glide** — for loading images from URLs  
- **RecyclerView** — to efficiently display the list of teams  
- **Coroutines** — for asynchronous network calls  

## API Endpoint

- The JSON file is hosted on GitHub at:  
`https://raw.githubusercontent.com/IrakliMatcharashvili1/Midd/refs/heads/main/Mid`

## Features

- Loads the list of teams asynchronously from the internet.  
- Displays each team’s image, name, and founding year in a RecyclerView.  
- Opens a detail screen with full description and website link on item click.  
- Simple and user-friendly UI design.

## Requirements to Run

1. Android Studio (with API level 26 or higher)  
2. Internet connection to fetch data from the API  
3. Gradle synced successfully in the project  
4. Run on either an emulator or a physical Android device  
