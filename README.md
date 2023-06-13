# WallStructureTask
This repository contains a block structure library that provides classes and interfaces for creating and manipulating structures made up of blocks. The library allows you to define individual blocks, composite blocks (blocks made up of other blocks), and structures composed of blocks.

## Classes
### BlockImpl

This class represents an individual block. It implements the *Block* interface and provides the following methods:

* *getColor()*: Returns the color of the block.
* *getMaterial()*: Returns the material of the block.

### CompositeBlockImpl

This class represents a composite block, which is a block made up of other blocks. It implements the *CompositeBlock* interface and provides the following methods:

* *getColor()*: Returns the color of the composite block.
* *getMaterial()*: Returns the material of the composite block.
* *getBlocks()*: Returns a list of blocks that make up the composite block

### Wall 
This class represents a wall, which is a specific type of structure composed of blocks. It implements the *Structure* interface and provides the following methods:

* *findBlockByColor(String color)*: Returns an optional block with the specified color. If no block is found, an empty optional is returned.
* *findBlocksByMaterial(String material)*: Returns a list of blocks with the specified material.
* *count()*: Returns the total number of blocks in the wall.

## Interfaces
### Structure

This interface represents a structure composed of blocks. It defines the following methods:

* *findBlockByColor(String color)*: Returns an optional block with the specified color. If no block is found, an empty optional is returned.
* *findBlocksByMaterial(String material)*: Returns a list of blocks with the specified material.
* *count()*: Returns the total number of blocks in the structure.

## Usage

To use this block structure library, you can create instances of BlockImpl, CompositeBlockImpl, and Wall classes to represent individual blocks, composite blocks, and structures, respectively. The Wall class provides methods for finding blocks by color or material and counting the total number of blocks in the wall.

You can find examples of usage in the [usage examples](docs/USAGE.md) in the `docs` folder.
