package kz.bee.bip.esedo;

import java.util.UUID;

/**
 * class
 * TODO
 */
public class GenerationGUID {

    private UUID guid;

    /**
     * .ctor
     * TODO
     */
    public GenerationGUID(){
        guid = UUID.randomUUID();
    }

    /**
     * .ctor
     * TODO
     * @return
     */
    public UUID generateGUID(){
        return guid;
    }

    /**
     * method
     * TODO
     * @return
     */
    @Override
    public String toString(){
        return guid.toString();
    }
}
