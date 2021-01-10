package br.com.vtspp.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import br.com.vtspp.block.Block;
import br.com.vtspp.dictionary.Blocks;
import br.com.vtspp.enums.Element;

public class World {

    public int[][][] map = new int[80][45][2];

    public void regenerate() {
        new Blocks().initializeRegister();
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                if (y < 10) {
                    map[x][y][1] = Element.OBSIDIAN.ordinal();
                }
                else if (y < 20) {
                    map[x][y][1] = Element.COBBLESTONE.ordinal();
                }
                else if (y < 22) {
                    map[x][y][1] = Element.DIRTY.ordinal();
                }
            }
        }
    }

    public void render(Batch batch) {
        Texture texture = null;

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                texture = Blocks.getBlockById(map[x][y][1]).texture;

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
