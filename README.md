 # 🧪 AlchemyMix

  **A Java-based desktop game client with modern UI and account management**

  [![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://open
  jdk.org/)
  [![Gradle](https://img.shields.io/badge/Gradle-Kotlin_DSL-02303A?style=for-the-badge&logo=gradle&logoColor=white)](http
  s://gradle.org/)
  [![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)

  ---

  [Features](#-features) • [Installation](#-installation) • [Usage](#-usage) • [Architecture](#-architecture) •
  [Contributing](#-contributing)

  </div>

  ---

  ## 📖 Overview

  AlchemyMix is a desktop game client built with Java Swing, featuring a clean modular architecture with panel-based
  navigation, persistent account management, and customizable display settings. The application provides a solid
  foundation for game development with its component-based UI system.

  ---

  ## ✨ Features

  - **Account System** - Create and manage player accounts with JSON-based persistence
  - **Panel Navigation** - Seamless transitions between different application screens
  - **Display Settings** - Fullscreen toggle and multiple resolution options (720p, 900p, 1080p)
  - **Modern UI** - Nimbus Look & Feel with gradient backgrounds and custom styling
  - **Modular Architecture** - Clean separation of concerns with dedicated packages for models, services, and UI

  ---

  ## 🚀 Installation

  ### Prerequisites

  - **Java Development Kit (JDK)** 17 or higher
  - **Git** (optional, for cloning)

  ### Clone the Repository

  ```bash
  git clone https://github.com/Somadevv/AlchemyMix.git
  cd AlchemyMix

  Build the Project

  Linux/macOS:
  ./gradlew build

  Windows:
  gradlew.bat build

  ---
  🎮 Usage

  Running the Application

  Linux/macOS:
  ./gradlew run

  Windows:
  gradlew.bat run

  First Launch

  1. Launch the application - the main menu will appear
  2. Create an Account - Click "Create Account" and enter your credentials
  3. Adjust Settings - Visit "Options" to configure display preferences
  4. Play - Your account data is automatically saved to the accounts/ directory

  ---
  🏗 Architecture

  src/main/java/com/alchemymix/
  ├── Main.java                    # Application entry point
  ├── account/
  │   └── AccountCreationResult.java   # Account operation result wrapper
  ├── client/
  │   └── ClientLoader.java            # Application bootstrap & LAF setup
  ├── models/
  │   └── Account.java                 # Player account data model
  ├── service/
  │   └── AccountManager.java          # Account CRUD operations with JSON persistence
  └── ui/
      ├── core/
      │   └── PanelManager.java        # Screen navigation controller
      ├── panels/
      │   ├── MainMenuPanel.java       # Primary navigation screen
      │   ├── CreateAccountPanel.java  # Account registration form
      │   ├── OptionsPanel.java        # Application settings
      │   ├── GamePanel.java           # Main game display
      │   └── LoginPanel.java          # User authentication screen
      ├── buttons/                     # Custom button components
      ├── widgets/
      │   └── MainMenuButton.java      # Styled menu button widget
      └── util/
          └── UIInitializer.java       # UI component registration

  Key Components

  | Component      | Description                                                                          |
  |----------------|--------------------------------------------------------------------------------------|
  | PanelManager   | Central controller managing screen transitions via a panel registry                  |
  | AccountManager | Handles account creation with validation, duplicate checking, and JSON serialization |
  | UIInitializer  | Bootstraps the application window (1280×720) and registers all panels                |
  | Account        | Immutable data model containing username, password, level, health, and gold          |

  ---
  ⚙️ Configuration

  Display Options

  | Resolution | Aspect Ratio |
  |------------|--------------|
  | 1280×720   | 16:9 (HD)    |
  | 1600×900   | 16:9         |
  | 1920×1080  | 16:9 (FHD)   |

  Settings are configured through the Options panel and stored in src/main/resources/config/options.properties.

  ---
  🛠 Technologies

  - Java 17+ - Core programming language
  - Swing - GUI framework with Nimbus Look & Feel
  - Gradle (Kotlin DSL) - Build automation
  - Gson 2.10.1 - JSON serialization for account data
  - JUnit 5 - Testing framework

  ---
  📂 Data Storage

  Account data is stored locally in JSON format:

  accounts/
  └── Username.json

  Example account file structure:
  {
    "username": "Player",
    "password": "********",
    "level": 1,
    "health": 0,
    "gold": 0
  }

  ---
  🤝 Contributing

  Contributions are welcome! Please follow these steps:

  1. Fork the repository
  2. Create a feature branch (git checkout -b feature/amazing-feature)
  3. Commit your changes (git commit -m 'Add amazing feature')
  4. Push to the branch (git push origin feature/amazing-feature)
  5. Open a Pull Request

  ---
  📋 Roadmap

  - Login functionality with existing accounts
  - Audio settings implementation
  - Controls customization
  - Game mechanics and content
  - Settings persistence across sessions

  ---
  📄 License

  This project is licensed under the MIT License - see the LICENSE file for details.

  ---
  Built with ☕ Java by https://github.com/Somadevv

  ---
  Summary

  AlchemyMix is a Java Swing desktop game client with:

  - Modular panel-based UI architecture for easy screen navigation
  - Account management system with JSON persistence using Gson
  - Display settings (fullscreen, resolution selection)
  - Modern styling via Nimbus Look & Feel with gradient backgrounds
  - Clean project structure following standard Java conventions
