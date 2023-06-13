package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return findBlockByColorRecursive(blocks, color);
    }

    private Optional<Block> findBlockByColorRecursive(List<Block> blocks, String color) {
        for (Block block : blocks) {
            if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
            if (block instanceof CompositeBlock) {
                Optional<Block> nestedBlock = findBlockByColorRecursive(((CompositeBlock) block).getBlocks(), color);
                if (nestedBlock.isPresent()) {
                    return nestedBlock;
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> matchingBlocks = new ArrayList<>();
        findBlocksByMaterialRecursive(blocks, material, matchingBlocks);
        return matchingBlocks;
    }

    private void findBlocksByMaterialRecursive(List<Block> blocks, String material, List<Block> matchingBlocks) {
        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                matchingBlocks.add(block);
            }
            if (block instanceof CompositeBlock) {
                findBlocksByMaterialRecursive(((CompositeBlock) block).getBlocks(), material, matchingBlocks);
            }
        }
    }

    @Override
    public int count() {
        return countBlocksRecursive(blocks);
    }

    private int countBlocksRecursive(List<Block> blocks) {
        int count = 0;
        for (Block block : blocks) {
            count++;
            if (block instanceof CompositeBlock) {
                count += countBlocksRecursive(((CompositeBlock) block).getBlocks());
            }
        }
        return count;
    }
}
