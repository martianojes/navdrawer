package com.example.jessymartiano.navdrawer;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.jessymartiano.navdrawer.backend.AcademyContract;

import static com.example.jessymartiano.navdrawer.R.layout.list_row;


public class ListFragmentBusiness extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ActivityList activityList;
    private ListView itemListView;
    private TextView loadingTextView;
    private TextView typeActivity;
    private TextView country;


    // EditText filterEditText;
    SearchView filterSearchView;
    //  CursorAdapter adapter;

    CursorAdapter adapter;
    SimpleCursorAdapter adapter1 ;

    public ListFragmentBusiness() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listbusiness, container, false);



    }


    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        typeActivity= (TextView) getActivity().findViewById(R.id.typeActivity);
        country=(TextView) getActivity().findViewById(R.id.country);



        itemListView = (ListView) getActivity().findViewById(R.id.ItemListView);
        loadingTextView = (TextView) getActivity().findViewById(R.id.loadingTextView);


       /* filterEditText = (EditText) getActivity().findViewById(R.id.filterEditText);
        filterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }*//*
        });

        filterSearchView = (SearchView) getActivity().findViewById(R.id.filterSearchView);
        filterSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//        adapter.getFilter().filter(query);
//        adapter.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                adapter.notifyDataSetChanged();
                return false;
            }
        });*/
    }


    public void UpdateList(final Uri uri) {

        new AsyncTask<Void, Void, Cursor>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();



                itemListView.setVisibility(View.INVISIBLE);
                loadingTextView.setVisibility(View.VISIBLE);
            }

            @Override
            protected Cursor doInBackground(Void... params) {
                Cursor cursor = getActivity().getContentResolver().query(AcademyContract.Business.BUSINESS_URI, null, null, null, null);
                return cursor;
            }

            @Override
            protected void onPostExecute(final Cursor cursor) {
                super.onPostExecute(cursor);
                 adapter1 = new SimpleCursorAdapter
                        (
                                getActivity(),
                                list_row,
                                null,
                                new String[]{AcademyContract.Business.BUSINESS_ID, AcademyContract.Business.BUSINESS_WEBSITE,AcademyContract.Business.BUSINESS_PHONE},
                                new int[]{R.id.typeActivity, R.id.country,R.id.price}
                        );
                adapter1.changeCursor(cursor);

                adapter = new CursorAdapter(getActivity(), cursor) {
                    @Override
                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
                        TextView tv = new TextView(context);

                        return tv;
                    }

                    @Override
                    public void bindView(View view, Context context, Cursor cursor) {
                        TextView tv = (TextView) view;
                        tv.setText("[" + cursor.getString(0) + "]  " + cursor.getString(1));
                    }

                   /* @Override
                    public Filter getFilter() {
                        return new Filter() {
                            @Override
                            protected FilterResults performFiltering(CharSequence constraint) {
                                FilterResults results = new FilterResults();

                                // We implement here the filter logic
                                if (constraint == null || constraint.length() == 0) {

                                    // No filter implemented we return all the list
                                    results.values = cursor;
                                    results.count = cursor.getCount();
                                } else {
                                    // We perform filtering operation
                                    MatrixCursor returnCursor = new MatrixCursor(new String[]{"_id", "name"});

                                    cursor.moveToPosition(-1);
                                    while (cursor.moveToNext()) {
                                        String id = cursor.getString(0);
                                        String name = cursor.getString(1);

                                        if (name.toUpperCase().startsWith(constraint.toString().toUpperCase())) {
                                            returnCursor.addRow(new Object[]{id, name});
                                        }
                                    }

                                    results.values = returnCursor;
                                    results.count = returnCursor.getCount();
                                }
                                Toast.makeText(getActivity(), "performFiltering", Toast.LENGTH_LONG).show();
                                return results;

                            }

                            @Override
                            protected void publishResults(CharSequence constraint, FilterResults results) {
                                // Now we have to inform the adapter about the new list filtered
                                Toast.makeText(getActivity(), "publishResults", Toast.LENGTH_LONG).show();
                                if (results.count == 0)
                                    notifyDataSetInvalidated();
                                else {
                                    changeCursor((Cursor) results.values);
                                    notifyDataSetChanged();
                                    //    }

                                }
                            }


                        };
                    }*/

//                adapter = new CursorTreeAdapter(cursor,getActivity()) {
//                    @Override
//                    protected Cursor getChildrenCursor(Cursor groupCursor) {
//                        return null;
//                    }
//
//                    @Override
//                    protected View newGroupView(Context context, Cursor cursor, boolean isExpanded, ViewGroup parent) {
//                        return null;
//                    }
//
//                    @Override
//                    protected void bindGroupView(View view, Context context, Cursor cursor, boolean isExpanded) {
//
//                    }
//
//                    @Override
//                    protected View newChildView(Context context, Cursor cursor, boolean isLastChild, ViewGroup parent) {
//                        return null;
//                    }
//
//                    @Override
//                    protected void bindChildView(View view, Context context, Cursor cursor, boolean isLastChild) {
//
//                    }
//                };

                };
                itemListView.setVisibility(View.VISIBLE);
                loadingTextView.setVisibility(View.INVISIBLE);
                itemListView.setAdapter(adapter1);


            }

            ;
        }.execute();

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
