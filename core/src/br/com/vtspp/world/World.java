package br.com.vtspp.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import br.com.vtspp.block.Block;
import br.com.vtspp.dictionary.Blocks;
import br.com.vtspp.enums.Element;

public class World {

    private int[][][] map = new int[80][45][2];

    public void regenerate() {
        new Blocks().initializeRegister();
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                for (int l = 0; l < getLayer(); l++) {
                    if (y < 10) {
                        map[x][y][l] = Element.OBSIDIAN.ordinal();
                    }
                    else if (y < 20) {
                        map[x][y][l] = Element.COBBLESTONE.ordinal();
                    }
                    else if (y < 22) {
                        map[x][y][l] = Element.DIRTY.ordinal();
                    }
                }
            }
        }
    }

    public void render(Batch batch) {
       renderBackground(batch);
       renderForeground(batch);
    }

    private void renderForeground(Batch batch) {
        Texture texture = null;

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                texture = getBlock(x, y, 1).texture;

                if (texture != null) {
                    batch.draw(texture, x * Block.TITLE_SIZE, y * Block.TITLE_SIZE);
                }
            }
        }
    }

    private void renderBackground(Batch batch) {
        Texture texture = null;

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                texture = getBlock(x, y, 0).texture;

                if (texture != null) {
                    batch.draw(texture, x * Block.TITLE_SIZE, y * Block.TITLE_SIZE);
                }
            }
        }
    }

    public Block getBlock(int x, int y, int layer) {
        return Blocks.getBlockById(map[x][y][layer]);
    }

    public int getWidth() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }

    public int getLayer() {
        return map[0][0].length;
    }
}
