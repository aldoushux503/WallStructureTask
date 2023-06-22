package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.*;

public class Wall implements Structure, Iterable<Block> {
    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : this) {
            if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> matchingBlocks = new ArrayList<>();
        for (Block block : this) {
            if (block.getMaterial().equals(material)) {
                matchingBlocks.add(block);
            }
        }
        return matchingBlocks;
    }

    @Override
    public int count() {
        int count = 0;
        for (Block ignored : this) {
            count++;
        }
        return count;
    }

    @Override
    public Iterator<Block> iterator() {
        return new WallIterator();
    }

    private class WallIterator implements Iterator<Block> {
        private final Stack<Iterator<Block>> iteratorStack;

        public WallIterator() {
            this.iteratorStack = new Stack<>();
            iteratorStack.push(blocks.iterator());
        }

        @Override
        public boolean hasNext() {
            if (iteratorStack.isEmpty()) {
                return false;
            }
            Iterator<Block> currentIterator = iteratorStack.peek();
            if (!currentIterator.hasNext()) {
                iteratorStack.pop();
                return hasNext();
            }
            return true;
        }

        @Override
        public Block next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator<Block> currentIterator = iteratorStack.peek();
            Block block = currentIterator.next();
            if (block instanceof CompositeBlock) {
                iteratorStack.push(((CompositeBlock) block).getBlocks().iterator());
            }
            return block;
        }
    }
}

