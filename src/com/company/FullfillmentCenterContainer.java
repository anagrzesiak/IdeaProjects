package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class FullfillmentCenterContainer {
    public Map<String, FullfillmentCenter> Centers = new HashMap();

    public void addCenter(FullfillmentCenter f1) {
        Centers.put(f1.centerName, f1);
    }

    public void removeCenter(String name) {
        for(Map.Entry<String, FullfillmentCenter> entry : Centers.entrySet())
            if (entry.getKey() == name) {
                Centers.remove(entry.getKey());
            }
     }

    public List findEmpty() {
        List<FullfillmentCenter> emptyCenters = new ArrayList();
        for(Map.Entry<String, FullfillmentCenter> entry : Centers.entrySet())
            if (entry.getValue().totalQuantity == 0) {
                emptyCenters.add(new FullfillmentCenter(entry.getKey(), entry.getValue().maxWeight));
            }
        return emptyCenters;
    }

    public void summary(){
       for(Map.Entry<String, FullfillmentCenter> entry : Centers.entrySet()){
           System.out.print(entry.getKey()+" - FILLED: ");
           System.out.print((entry.getValue().totalWeight/entry.getValue().maxWeight)*100);
           System.out.println("%");
       }
    }
}
