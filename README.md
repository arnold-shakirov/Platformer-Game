# Platformer game

## Overview
This project is a Java-based 2D game where the player can interact with the environment using keyboard and mouse inputs. The game includes multiple features such as player movement, level management, and interaction with game entities, along with additional utilities for loading and saving game states.

## Features
- **Player Control**: The player can move around using keyboard inputs.
- **Mouse Interaction**: The player can interact with objects or perform specific actions using mouse inputs.
- **Level Management**: The game includes a `LevelManager` class that manages different levels of the game.
- **Entity System**: The game uses an `Entity` class to represent game objects, making it easy to extend with new entities.
- **Load and Save**: The game allows saving and loading game states using `LoadSave.java`.
- **Helper Methods**: Utility functions that simplify game logic are found in `HelpMethods.java`.
- **Constants**: Global constants for the game are defined in `Constants.java`.
- **Customizable Window**: The game provides a resizable window for a flexible gaming experience.

## Class Overview

### Core Classes
- **`player.java`**: Handles player movement and interaction.
- **`entity.java`**: Represents a game object or entity in the game.
- **`keyboardinputs.java`**: Manages keyboard inputs for player movement.
- **`mouseinputs.java`**: Manages mouse inputs for interactions.
- **`levelmanager.java`**: Manages and loads game levels.
- **`level.java`**: Represents an individual level in the game.
- **`game.java`**: The main game loop that updates and renders the game.
- **`gamepanel.java`**: Manages the drawing of the game and handles game states.
- **`gamewindow.java`**: Initializes and manages the game window.
- **`Main.java`**: The entry point of the game, where the game starts.

### Utility Classes (Located in the `utils/` folder)
- **`loadsave.java`**: Handles loading and saving of game states.
- **`helpmethods.java`**: Contains utility functions used throughout the game.
- **`constants.java`**: Defines game-wide constants such as screen dimensions and settings.

## Requirements
- **Java 8** or higher.

## Contact

For any questions or suggestions, feel free to reach out to me at [ashakirov@stetson.edu].
