# Android App with SQLite Database and Splash Screen 📱

## 🌟 Overview
This Android app project utilizes an SQLite database for CRUD operations using the DAO pattern. It features a user-friendly interface with functionalities such as adding notes and a confirmation dialog for deletion. Additionally, the app includes a splash screen to enhance user experience.

## 🛠️ Project Structure
The project is structured to efficiently manage user notes and authentication:

### Key Components
- **MainActivity**:
  - Controls app navigation and initialization.
  - Displays the list of existing notes.
  - Implements CRUD operations using the DAO pattern to manage notes in the SQLite database.

- **AddNoteActivity**:
  - Allows users to add new notes.
  - Utilizes the DAO pattern to create and store new notes in the SQLite database.

- **NoteDAO (Data Access Object)**:
  - Implements CRUD operations to manage notes in SQLite.
  - Provides methods such as `createNote`, `readNotes`, `updateNote`, `deleteNote`.

- **SplashScreen**:
  - Displays the app branding and initializes necessary resources.
  - Configured directly in the manifest for a smooth app startup.

- **Adaptive Icons**:
  - Ensures consistent visual identity across different device interfaces.

## 📷 Screenshots
<div style="display: flex; flex-wrap: wrap;">
  <img src="https://github.com/user-attachments/assets/8f3d3b66-30c1-4b76-b2c8-dd708b0a38e4" width="150" style="margin: 10px;"/>
  <img src="https://github.com/user-attachments/assets/397091f8-5ec0-4d15-a49d-f1b233a88919" width="150" style="margin: 10px;"/>
  <img src="https://github.com/user-attachments/assets/a6ae8424-f378-4383-8107-95e5e7c5ac3e" width="150" style="margin: 10px;"/>
  <img src="https://github.com/user-attachments/assets/c7038d9e-a0ed-4b20-b77a-f34a55e750ad" width="150" style="margin: 10px;"/>
   <img src="https://github.com/user-attachments/assets/2469ea2c-60f9-41a7-8698-760f1cf263fa" width="150" style="margin: 10px;"/>
</div>

## 🚀 Implemented Features
- CRUD operations for managing user notes.
- Integration of the DAO pattern for efficient database interactions.
- Splash screen for a smooth app startup.
- Adaptive icons ensuring consistent branding on all Android devices.

## 🛠️ Dependencies
- `androidx.room:room-runtime:2.5.0`: SQLite database management.
- Additional AndroidX libraries for RecyclerView, Alert Dialogs, etc.

## 📌 License
This project is open-source under the [MIT License](LICENSE).
