package io.MMJ;

/**
 * Created by matthewb on 5/24/16.
 */
public class ItemParser {

    public void checkForMissingField(Item item)throws FieldMissingException{
        if(item.getName() == null){
            throw new FieldMissingException();
        }
    }
}
