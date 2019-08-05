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

public class FragmentRoboListAmarchem extends Fragment {
    String[] web = {
            "SPOTLIGHT QUIZ",
            "FOOD ADULTERATION",
            "PATENT PRESENTATION",
            "FRUGAL",
            "INDUSTRIAL DESIGN PROBLEM"
    } ;

    String[] details = {
            "Quiz regarding Chemical science and aptitude. It will be a 2 round contest.\n" +
                    "\n" +
                    "TEAM OF 2\n" +
                    "Registration Amount- 20/- per team\n" +
                    "Prize Money- 600/-\n",

            "Presentation on Food Adulteration. Time allotted will be 1:30 hour.\n" +
                    "\n" +
                    "TEAM OF 5(Max..)\n" +
                    "Registration Amount- 10/- per person\n" +
                    "Prize Money- 500/-\n",

            "You have to give a presentation on Patenting. Time will be 1:30 hours.\n" +
                    "\n" +
                    "TEAM OF 5\n" +
                    "Registration Amount- Free\n" +
                    "Prize Money- goodies\n",

            "Frugal regarding new ideas, inventions or anything prepared from waste material. Time allotted is 1:30 hours.\n" +
                    "\n" +
                    "TEAM OF 5(Max..)\n" +
                    "Registration Amount- 10/- per person\n" +
                    "Prize Money- 1200/-",

            "Presentation or chart relating to any industrial design. Time allotted is 1:30 hour.\n" +
                    "\n" +
                    "TEAM OF 5(Max..)\n" +
                    "Registration Amount- 10/- per person\n" +
                    "Prize Money- 1200/-\n"
    } ;

    int[] imageId = {
            R.drawable.chem11img,
            R.drawable.foodchemimg,
            R.drawable.patentchem,
            R.drawable.frugalchemimg,
            R.drawable.chem5img

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
