# Examples of using

This document contains examples of code usage 


### Processes

- [Create individual blocks](#create-individual-blocks)
- [Create a composite block](#create-a-composite-block)
- [Create a wall structure](#create-a-wall-structure)
- [Find a block by color](#find-a-block-by-color)
- [Find blocks by material](#find-blocks-by-material)
- [Count the total number of blocks in the wall](#count-the-total-number-of-blocks-in-the-wall)

### Create individual blocks
```java
Block block1 = new BlockImpl("red", "wood");
Block block2 = new BlockImpl("blue", "stone");
```

### Create a composite block
```java
List<Block> compositeBlocks = new ArrayList<>();
compositeBlocks.add(block1);
compositeBlocks.add(block2);
Block compositeBlock = new CompositeBlockImpl("green", "metal", compositeBlocks);
```

### Create a wall structure
```java
List<Block> wallBlocks = new ArrayList<>();
wallBlocks.add(block1);
wallBlocks.add(compositeBlock);
Structure wall = new Wall(wallBlocks);
```

### Find a block by color
```java
Optional<Block> foundBlock = wall.findBlockByColor("blue");
if (foundBlock.isPresent()) {
    Block block = foundBlock.get();
    System.out.println("Found block: " + block.getColor() + ", " + block.getMaterial());
} else {
    System.out.println("No block found with the specified color.");
}
```

### Find blocks by material
```java
List<Block> foundBlocks = wall.findBlocksByMaterial("wood");
System.out.println("Found " + foundBlocks.size() + " blocks with the specified material.");
```

### Count the total number of blocks in the wall
```java
int totalCount = wall.count();
System.out.println("Total number of blocks in the wall: " + totalCount);
```
