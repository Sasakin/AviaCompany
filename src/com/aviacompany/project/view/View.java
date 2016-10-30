package com.aviacompany.project.view;

import java.util.Map;
import java.util.Set;

public abstract class View {

  /*  public void showAircraftInConsole(Aircraft aircraft) {
        System.out.println(aviacompany.getAircrafts());
    }
*/
    public void showString(String str) {
        System.out.println(str);
    }

    public void showMapList(Map<Integer,String> map) {
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        for (Map.Entry<Integer,String> setHelpIter : set) {
            System.out.println(setHelpIter.getKey() + ". " + setHelpIter.getValue());
        }
    }

    public void printLine(){
        for (int i = 0; i < 100; i++) {
            System.out.print("-");
            if(i == 99)
            {
                System.out.print("\n");
            }
        }
    }

    public void showInterfaceScreen(String headScreen,Map<Integer,String> mapList){
        printLine();
        showString(headScreen);
        printLine();
        showMapList(mapList);
        printLine();
    }
}
