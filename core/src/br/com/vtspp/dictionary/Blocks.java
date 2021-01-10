package br.com.vtspp.dictionary;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.IntMap;

import br.com.vtspp.block.Block;
import br.com.vtspp.enums.Element;

public class Blocks {

    private Element elements;
    private static IntMap<Block> REGISTRY = new IntMap<>();

    private void register(int id, Block block){
        REGISTRY.put(id, block);
    }

    public void initializeRegister(){
        for(Element e : Element.values()){
            if(e.ordinal() == 0){
                register(e.ordinal(), new Block(null));
                continue;
            }
            register(e.ordinal(), new Block(new Texture("blocks/image_"+ e.ordinal() + ".png")));
        }
    }

    public static Block getBlockById(int id){
        return REGISTRY.get(id);
    }

    public static int getIdByBlock(Element block){
        return REGISTRY.findKey(block, true, Element.Air.ordinal());
    }
}
