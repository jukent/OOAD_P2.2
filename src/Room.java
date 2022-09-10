package src;

import java.util.Hashtable;

public class Room {

    private int level, row, column; // the level, row, and column coordinates for this room - Integers
    private String name; // the name  of this room, i.e. "(2-0-0)" - String
    private Hashtable<String, String> exits; // valid exit directions from this room mapped to neighboring room names in a Hashtable
                                            // i.e. ["south": "(2-1-0)"", "east": "(2-0-1)"] 

    public Room(int aLevel, int aRow, int aColumn) {
        // constructor
        this.level = aLevel;
        this.row = aRow;
        this.column = aColumn;
        
        this.name = new String("(" + level + "-" + row + "-" + column + ")");

        Hashtable<String, String> exits = findExits();
        this.exits = exits;
    }


    private Hashtable<String, String> findExits() {
        Hashtable<String, String> exits = new Hashtable<String, String>();

        if (this.level == 0) {
            // If in starting room (0-1-1), only stairs down
            String neighboring_room = new String("(0-1-1)");
            exits.put("down", neighboring_room);
        } else {
            // If already in the dungeon . . .
            if (this.row != 0) {
                // If not in north-most row of level, door to north
                Integer new_row = this.row - 1;
                String neighboring_room = new String("(" + this.level + "-" + new_row + "-" + this.column + ")");
                exits.put("north", neighboring_room);
            }
            if (this.row != 2) {
                // If not in south-most row of level, door to south
                Integer new_row = this.row + 1;
                String neighboring_room = new String("(" + this.level + "-" + new_row + "-" + this.column + ")");
                exits.put("south", neighboring_room);
            }
            if (this.column != 0) {
                // If not in west-most row of level, door to west
                Integer new_column = this.column - 1;
                String neighboring_room = new String("(" + this.level + "-" + this.row + "-" + new_column + ")");
                exits.put("west", neighboring_room);
            }
            if (this.column != 2) {
                // If not in east-most row of level, door to east
                Integer new_column = this.column + 1;
                String neighboring_room = new String("(" + this.level + "-" + this.row + "-" + new_column + ")");
                exits.put("east", neighboring_room);
            }
            if (this.column == 1 && this.row == 1) {
                // If in center room of level, there is a staircase up and or down
                if (this.level != 1) {
                    // Cannot exit back to starting room from level 1
                    // If not on level 1, stairs up
                    Integer new_level= this.level - 1;
                    String neighboring_room = new String("(" + new_level + "-" + this.row + "-" + this.column + ")");
                    exits.put("up", neighboring_room);
                }
                if (this.level != 4) { 
                    // If not on bottom level, stairs down
                    // Currently bottom level is hard coded to be 4, hoping to change this
                    Integer new_level = this.level + 1;
                    String neighboring_room = new String("(" + new_level + "-" + this.row + "-" + this.column + ")");
                    exits.put("down", neighboring_room);
                }
            }
        }
        return exits;
    }


    public String getName() {
        return name;
    }


    public Hashtable<String, String> getExits() {
        return exits;
    }

}
