package src;

import java.util.Hashtable;

public class Dungeon {
    private Hashtable<String, Room> map; //the map of this dungeon - Hashtable of room names mapped to Rooms
    

    public Dungeon() {
        // constructor
        int num_levels = 4;

        this.map = generateMap(num_levels);
    }

        
    private Hashtable<String, Room> generateMap(int num_levels) {
        this.map = new Hashtable<String, Room>();

        //int num_levels = 4;

        for (int l = 0; l < num_levels; ++l) {     
            if (l == 0) {
                // On level 0, there is only one room
                String room_name = new String("(0-1-1)");
                Room room = new Room(l, 1, 1);
                map.put(room_name, room);
            } else {
                // On all other levels, there are 3x3 rooms
                for (int r = 0; r < 2; ++r) { // row
                    for (int c = 0; c < 2; ++c) { // column
                        String room_name = new String("(" + l + "-" + r + "-" + c + ")");
                        Room room = new Room(l, r, c);       
                        map.put(room_name, room);        
                    }
                }
            }
        }
        return map;
    }


    public Hashtable<String, Room> getMap() {
        return map;
    }


    public Room getRoom(String room_name) {
        Room room = this.map.get(room_name);
        return room;
    }
}
