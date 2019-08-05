package com.example.amazingami.parakram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentRoboListAmarelec extends Fragment {
    String[] web = {
            "SPARK",
            "ELECTRIATION",
            "STOP TO WIN",
            "INNOVATION AND YOU"
    } ;

    String[] details = {
            "It is an individual talent showcase in the field of electrical industry. Bring out the best research of yours in field of electrical applications.\n" +
                    "\n" +
                    "INDIVIDUAL EVENT\n" +
                    "Registration Amount- Free\n" +
                    "Prize Money- goodies\n",

            "A well defined presentation of electrical energy with sustainable development or by use of any other alternatives.\n" +
                    "\n" +
                    "TEAM OF 3\n" +
                    "Registration Amount- 30/- per team\n" +
                    "Prize Money- 600/-\n",

            "First round will be AV quiz related to electrical ,general knowledge and aptitude.\n" +
                    "In second round, you will be provided with some electrical circuits and you have to find the required output.\n" +
                    "\n" +
                    "TEAM OF 2\n" +
                    "Registration Amount- 30/- per team\n" +
                    "Prize Money- 600/-\n",

            "Frugal regarding new ideas, inventions or anything prepared from waste material. Time allotted is 1:30 hours.\n" +
                    "\n" +
                    "TEAM OF 4\n" +
                    "Registration Amount- 80/- per team\n" +
                    "Prize Money- 800/- "
  } ;

    int[] imageId = {
            R.drawable.sparkelecimg,
            R.drawable.electricalimg,
            R.drawable.stopelec,
            R.drawable.innelecimg


    };
ListView Lstamar;
    Fragment fragment;

    ArrayList<HashMap<String,String>>arrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View vi= inflater.inflate(R.layout.fragment_robo_list, parent, false);
arrayList=new ArrayList<HashMap<String, String>>();
        arrayList=getArraydata();

        Lstamar=(ListView)vi.findViewById(R.id.lst_robo);
        AdapterRoboListShiv adshiv=new AdapterRoboListShiv(getActivity(),arrayList,R.layout.row_robo_list,imageId);
        Lstamar.setAdapter(adshiv);

        Lstamar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

HashMap<String,String>map=arrayList.get(position);
             Helper.selectedtitle=   map.get("title");
                Helper.selecteddetails=map.get("details");
                Helper.selectedimage=imageId[position];

                Intent i=new Intent(getActivity(),ActivityRoboDetails.class);
                startActivity(i);
            }
        });
        return  vi;
    }



public ArrayList<HashMap<String,String>> getArraydata()
{
ArrayList<HashMap<String,String>>resultist=new ArrayList<HashMap<String, String>>();
    for(int i=0;i<web.length;i++)
    {
        HashMap<String,String>map=new HashMap<String,String>();
        map.put("title",web[i]);
        map.put("details",details[i]);
       resultist.add(map);
    }

return  resultist;
}

    private void changeFragment(Fragment targetFragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

        Fragment newCustomFragment = targetFragment;
        transaction.replace(R.id.main_fragment, newCustomFragment );
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
