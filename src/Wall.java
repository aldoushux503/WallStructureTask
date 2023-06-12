import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private List<Block> blocks;

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
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
