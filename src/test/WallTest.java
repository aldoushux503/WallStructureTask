package test;

import main.*;
import main.impl.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class WallTest {

    private Wall wall;
    private List<Block> blocks;

    @BeforeEach
    void setUp() {
        // Create test blocks
        Block block1 = new BlockImpl("Red", "Wood");
        Block block2 = new BlockImpl("Blue", "Stone");
        Block block3 = new BlockImpl("Green", "Wood");
        Block block4 = new BlockImpl("Red", "Brick");
        Block block5 = new BlockImpl("Black", "Brick");

        // Create composite block with nested blocks
        CompositeBlock compositeBlock = new CompositeBlockImpl("Composite", "Steel",
                Arrays.asList(block1, block2, block3));

        CompositeBlock compositeBlock2 = new CompositeBlockImpl("Composite", "Steel",
                Arrays.asList(compositeBlock, block5));

        // Create the wall with blocks
        blocks = Arrays.asList(compositeBlock2, block4);
        wall = new Wall(blocks);
    }

    @Test
    void testFindBlockByColor() {
        // Test finding an existing block by color
        Optional<Block> redBlock = wall.findBlockByColor("Red");
        Assertions.assertTrue(redBlock.isPresent());
        Assertions.assertEquals("Red", redBlock.get().getColor());

        // Test finding a non-existing block by color
        Optional<Block> yellowBlock = wall.findBlockByColor("Yellow");
        Assertions.assertFalse(yellowBlock.isPresent());
    }

    @Test
    void testFindBlocksByMaterial() {
        // Test finding blocks by an existing material
        List<Block> woodBlocks = wall.findBlocksByMaterial("Wood");
        Assertions.assertEquals(2, woodBlocks.size());

        // Test finding blocks by a non-existing material
        List<Block> metalBlocks = wall.findBlocksByMaterial("Metal");
        Assertions.assertEquals(0, metalBlocks.size());
    }

    @Test
    void testCount() {
        // Test counting the number of blocks
        int blockCount = wall.count();
        Assertions.assertEquals(7, blockCount);
    }

}

