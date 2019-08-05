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

public class FragmentRoboListAmarcs extends Fragment {
    String[] web = {
            "CIPHERTECH",
            "TECH QUIZ",
            "CRYPTIA",
            "GOOGLER",
            "LAN Gaming",
            "CODASM",
            "Bits and Divs",
            "IET Dialogue"

    } ;

    String[] details = {
            "Encoded Questions will be given to participants who have to decipher the questions in the specified time. Time allotted is 1 hour.\n" +
                    "\n" +
                    "TEAM OF 2\n" +
                    "Free\n" +
                    "Prize Money- 600/-\n",

            "Quiz Related to Computer Science and General Technology. A 4 round contest with each round of increasing difficulty.\n" +
                    "\n" +
                    "TEAM OF 2\n" +
                    "Registration Amount- 25/- per team\n" +
                    "Prize Money- 800/-\n",

            "A Series of events will be shown. Every detail on the image will be a hint. With the help of those images, you have to reach the answer. It will be a online event to be conducted on PARAKRAM website.\n" +
                    "\n" +
                    "TEAM OF 2\n" +
                    "Registration Amount : Free\n" +
                    "Prize : goodies\n",

            "Images will be shown to you. You have to search approximately near picture or exactly the same picture on GOOGLE.\n" +
                    "\n" +
                    "TEAM OF 2\n" +
                    "Registration Amount- 20/- per team\n" +
                    "Prize Money- 500/- + goodies",

            "Counter Strike 1.6\n" +
                    "Entry fee – 500/- per team\n" +
                    "Prize money – 4000/-\n" +
                    "\n" +
                    "FIFA 15\n" +
                    "Entry fee – 100/- per person\n" +
                    "Prize money – 500/-\n" +
                    "\n" +
                    "NFS Most Wanted\n" +
                    "Entry fee – 100/- per person\n" +
                    "Prize money- 500/-\n",

            "Students compete on online coding portal to solve real life problems.\n" +
                    "\n" +
                    "INDIVIDUAL EVENT\n" +
                    "Registration Amount- Free\n" +
                    "Prize Money- 1500/- + T-Shirts & goodies\n",



            "An online event for learning web development in an easy and interesting way. The event is divided in 3 steps. It will be conducted on PARAKRAM website.\n" +
                    "\n" +
                    "INDIVIDUAL EVENT\n" +
                    "Registration Amount- Free\n" +
                    "Prize Money- 600/- ",

            "Seminar and Influential talks by senior faculty, Alumni and Final Year Students\n"

    } ;

    int[] imageId = {
            R.drawable.cipertechimg,
            R.drawable.techquizimg,
            R.drawable.eventcompbackimg,
            R.drawable.googlerimg,
            R.drawable.langamingimg,
            R.drawable.bitsimg,
            R.drawable.bitsimage,
            R.drawable.comworkshopimg

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
