package year2017.Day9;

import year2017.Day9.entities.Entity;
import year2017.Day9.entities.Group;

public class EntityPrinter {

    private Entity entity;

    public EntityPrinter(Entity entity){
        this.entity = entity;
    }

    public void print(){
        print(entity, 0);
    }

    public void print(Entity mainEntity, int depth){
        printDeep(mainEntity.getAsString(), depth);
        if(mainEntity instanceof Group) {
            for (Entity entity : ((Group)mainEntity).getChildren()) {
                print(entity, depth + 1);
            }
        }
    }

    public void printDeep(String string, int depth){
        StringBuilder deepLine = new StringBuilder();
        for(int i = 0; i < depth; i++){
            deepLine.append("--");
        }
        deepLine.append(string);
        System.out.println(deepLine.toString());
    }
}
