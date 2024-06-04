My project is a pokemon battle simulator.
It takes real pokemon data from PokeAPI and inputs it into my game and then simulates a battle between two pokemon.
My project takes into consideration typing, stats, stab, nature, and many other pokemon mechanics.
Thank you for trying my game

Instructions to use my project: 

play the game by running PokemonBattleGUI.
then input two pokemon and press start battle.
The first pokemon you input is your pokemon and the second pokemon is the opponents pokemon.
press attack to utilize the moves that the pokemon has to attack the opponent and knock out the opponent before your pokemon faints


What each files does in my project:

PokemonBattleGUI uses swing to show the screen to select the pokemon and the start battle button

BattleSimulator: is called by pokemonBattleGUI once pokemon is selected and runs the actual simulation of the battle and the UI

Pokemon is the class for pokemon including stats, moves, typing, etc. also includes the damagecalc method to attack with

PokeApi is the wrapper that includes two methods that take pokemon data and move data from the API respectively

Type is a class used to set a pokemon's type and to see if a move is super effective or not.

DualType is an extension of Type for pokemon with multiple types

Moves contains all of the move stats like damage and accuracy

DamageClass is a class created so the physical/special type of each move is properly assigned to the move after being taken from the API

MoveType is the same as DamageClass but its for the Typing of the move

