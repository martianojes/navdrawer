package com.example.jessymartiano.navdrawer.backend;

import com.example.jessymartiano.navdrawer.entities.Activity;

import java.util.ArrayList;




/**
 * filters the Activity by the search input
 */
public class ActivityFilter extends Filter<Activity> {

    public ActivityFilter(String input, ArrayList<Activity> data) {
        super(input, data);
    }

    @Override
    protected ArrayList<Activity> SumFilter(String i, ArrayList<Activity> exceptList) throws Exception {
        ArrayList<Activity> sum = new ArrayList<>();
        //clone list
        ArrayList<Activity> toRunOn = new ArrayList<>();
        toRunOn.addAll(exceptList);
        //clone
        sum.addAll(FilterAttributes(i,toRunOn));
        sum.addAll(TryParseRange(i,toRunOn));
        return sum;
    }

    @Override
    protected ArrayList<Activity> FilterAttributes(String i, ArrayList<Activity> toRunOn) throws Exception {
        ArrayList<Activity> toReturn = new ArrayList<>();
        String[] cols = Activity.getColumns();
        for (Activity item:toRunOn)
            for (String val:cols)
                if(item.getValue(val).contains(i))
                    toReturn.add(item);
        return toReturn;
    }

    /**
     * Try to parse the String i to a range argument
     * @param i the input to parse
     * @param toRunOn this is the output array , if succeeded the answer will be added
     * @return returns if the parse has succeeded
     */
    protected ArrayList<Activity> TryParseRange(String i, ArrayList<Activity> toRunOn) throws Exception {
        ArrayList<Activity> toReturn = new ArrayList<>();
        try {
            String[] range = i.split("-");
            if(range.length > 2)
                throw new Exception("Error parsing");
            final int low = Integer.parseInt(range[0]);
            final int high = Integer.parseInt(range[1]);
            for (Activity item:toRunOn) {
                float price = item.getPrice();
                if(price>=low && price<=high)
                    toReturn.add(item);
            }
        }
        catch (Exception ex){
            return toReturn;
        }
        return toReturn;
    }
}
