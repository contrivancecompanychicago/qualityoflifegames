package civ.core.map.civilization;

import java.awt.Color;

public class America extends Landscape {
  public America() {
    super("America", "American", new Color(34, 103, 214),
        new String[] {"Washington", "New York", "Boston", "Philadelphia", "Atlanta", "Chicago",
            "Seattle", "San Francisco", "Los Angeles", "Houston"});
  }
}
