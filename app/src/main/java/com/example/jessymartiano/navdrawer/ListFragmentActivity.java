package com.example.jessymartiano.navdrawer;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.CursorTreeAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jessymartiano.navdrawer.R;
import com.example.jessymartiano.navdrawer.MainActivity;
import com.example.jessymartiano.navdrawer.backend.AcademyContract;
import com.example.jessymartiano.navdrawer.backend.ActivityFilter;
import com.example.jessymartiano.navdrawer.backend.DBManagerFactory;
import com.example.jessymartiano.navdrawer.backend.DB_manager;
import com.example.jessymartiano.navdrawer.entities.Activity;

import org.w3c.dom.Text;

import java.util.ArrayList;

import com.example.jessymartiano.navdrawer.dummy.DummyContent.DummyItem;


public class ListFragmentActivity extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    ArrayList<Activity> activity = new ArrayList<>();
    ArrayList<Activity> beforeFilterList = new ArrayList<>();
    private OnListFragmentInteractionListener mListener;
    BaseExpandableListAdapter adap;
    ExpandableListView listView;
    ProgressBar pBar;


    // EditText filterEditText;
    SearchView filterSearchView;
    //  CursorAdapter adapter;

    CursorAdapter adapter;
    SimpleCursorAdapter adapter1 ;

    public ListFragmentActivity() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expandable_list_activity_list, container, false);
        pBar = (ProgressBar) view.findViewById(R.id.pBarAttractionFragment);
        listView = (ExpandableListView) view.findViewById(R.id.Attlist);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Activity curr = activity.get(groupPosition);
                switch (childPosition){
                    case 6: // maps
                        ListFragmentBusiness.MapsIntent(getActivity(),curr.getCountry(),"");
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        adap = new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return activity.size();
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return 8;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return activity;
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                Activity count =  activity.get(groupPosition);
                switch (childPosition)
                {
                    case 0:
                        return count.getId();
                    case 1:
                        return count.getType().toString();
                    case 2:
                        return count.getBusinessid();
                    case 3:
                        return count.getPrice()+" $";
                    case 4:
                        return count.getBeginning();
                    case 5:
                        return count.getEnd();
                    case 6:
                        return count.getCountry();
                    case 7:
                        return count.getExplanation();
                    default:
                        return count.getPrice()+" $";
                }
            }

            @Override
            public long getGroupId(int groupPosition) {
                return 0;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            private String getTitle(int groupPosition, int childPosition) {
                switch (childPosition)
                {
                    case 0:
                        return "ID: ";//att name
                    case 1:
                        return "Deal: ";//type
                    case 2:
                        return "Owner: "; //Business name
                    case 3:
                        return "Price ";
                    case 4:
                        return "Starting Date ";
                    case 5:
                        return "Ending Date ";
                    case 6:
                        return "Country ";
                    case 7:
                        return "Description: ";
                    default:
                        return "Price: ";
                }
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                if(convertView == null){
                    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.parent_layout_att, parent,false);
                }
                Activity current = activity.get(groupPosition);

                TextView country = (TextView) convertView.findViewById(R.id.Tvcountry);
                TextView enddate = (TextView) convertView.findViewById(R.id.TvEndDate);

                country.setText(current.getCountry());
                enddate.setText(current.getEnd().toString());

                TextView parent_textview = (TextView) convertView.findViewById(R.id.parentTv);
                parent_textview.setTypeface(null, Typeface.BOLD);
                parent_textview.setText(current.getId());
                ImageView img = (ImageView) convertView.findViewById(R.id.imageViewAtt);
                TextView desc = (TextView)convertView.findViewById(R.id.TVdesc);
                desc.setText(current.getExplanation());
                switch (current.getType()){
                    case AIRLINE:
                        img.setImageResource(R.mipmap.airline_icon);
                        break;
                    case ENTERTAINMENT:
                        img.setImageResource(R.mipmap.enterintemnt_icon);
                        break;
                    case TRAVEL_AGENCY:
                        img.setImageResource(R.mipmap.travel_icon);
                        break;
                    case VACATION_PACKAGE_HOTEL:
                        img.setImageResource(R.mipmap.hotel_icon);
                        break;
                    default:
                        break;
                }
                return convertView;
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                if(convertView == null)
                {
                    LayoutInflater inflator = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflator.inflate(R.layout.expandable_list_activity, parent,false);
                }
                TextView child_textview = (TextView) convertView.findViewById(R.id.content);
                TextView title = (TextView) convertView.findViewById(R.id.id);
                child_textview.setText((String) getChild(groupPosition,childPosition));
                title.setText(getTitle(groupPosition,childPosition));
                return convertView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };
        //listView.setIndicatorBoundsRelative(listView.getWidth()-50, listView.getWidth());
        listView.setAdapter(adap);
        getAttractionListAsyncTask();
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
/*        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    //endregion

    //region other functions

    /**
     * get attractions by asynctask from contentprovider
     */
    private void getAttractionListAsyncTask() {
        class myTask extends AsyncTask<Void,Void,Void> {
            ArrayList<Activity> newList;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                if(listView != null)
                    listView.setVisibility(View.GONE);
                if(pBar != null)
                    pBar.setVisibility(View.VISIBLE);

            }

            @Override
            protected Void doInBackground(Void... params) {
                DB_manager db = DBManagerFactory.getManager();
                newList = new ArrayList<>();
                newList = db.getActivities();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if(adap != null)
                    ListFragmentBusiness.refreshAdapter(adap,activity,newList);
                if(pBar != null)
                    pBar.setVisibility(View.GONE);
                if(listView != null)
                    listView.setVisibility(View.VISIBLE);
            }
        }
        myTask task = new myTask();
        task.execute();
    }

    /**
     * refresh the database
     */
    public void updateView() {
        getAttractionListAsyncTask();
    }

    /**
     * filter the results by the input in the search section
     * @param s
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void Filter(String s) {
        ArrayList list = new ArrayList();
        //saving current list
        beforeFilterList.clear();
        beforeFilterList.addAll(activity);

        list.addAll(activity);
        ActivityFilter filter = new ActivityFilter(s,list);
        ArrayList<Activity> newList;
        try {
            newList = filter.Filter();
            ListFragmentBusiness.refreshAdapter(adap,activity,newList);
        } catch (Exception e) {
            Toast.makeText(getContext(),"Error Parsing Query", Toast.LENGTH_SHORT);
        }
    }

    public void clearFilter(){
        if(beforeFilterList.size() == 0)
            if(activity.size() != 0)
                return;
        ListFragmentBusiness.refreshAdapter(adap,activity,beforeFilterList);
    }
    //endregion

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}