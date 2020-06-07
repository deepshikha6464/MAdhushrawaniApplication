package com.maithil.madhushravani.ui;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.MenuRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
import com.maithil.madhushravani.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class Day1Fragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "Day1Fragment";
    MaterialCardView day1,day2,day3,day4,day5,day6,day7,day8,day9,day10,day11,day12,day13;
String poojaVidhi ="";
TextView poojavidhi;
ImageView play,pause,read;
    MediaPlayer mp;
    LinearLayout nonframe;

    public Day1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_day1, container, false);
        Toolbar tb = view.findViewById(R.id.toolbar);
        findViewByid(view);
        createMenus(tb,R.menu.toolbar_contextual);
        return view;
    }
    private void createMenus(Toolbar actionBarToolBar, @MenuRes int menu){
        ((MainActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(actionBarToolBar);
        actionBarToolBar.setTitle("");
        actionBarToolBar.inflateMenu(menu);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {
            case R.id.card1:
              poojaVidhi = "भगवती,ब्राह्मण,कुलदेवता क गीत गायाल जायत\n" +
                      "नव कनिया नहा धो सासुर सं आयल कपड़ा छुरी पहिर श्रृंगार कय भगवती आ कुल देवता क प्रणाम क पूजा स्थान पर आइ बैसथीन\n" +
                      "पाटिल पुरहर आ कलश बाला जगह पर बालु ध क जल सं सींच ,वही पर किछु धान राखी टीनू के यथास्थान राखि,कलश के जल सं भरि ऊपर सं आम क पल्लव रखवाक छै ,टकरा बाद पाटिल में दीप लेश देवक छै\n" +
                      "सब दिन पूजै बाला गौरी उत्तर फूल पर ,सासुर सं आयल गौरी बीच में आ नहीअर बला गौरी दक्षिण फूल पर राखि कनिया गौरी पूजा करथिन";
                cardClicked(poojaVidhi);
              break;
 case R.id.card2:
              poojaVidhi = "अक्षत लय -“नमः शांति कलश इहागच्छ यह तिष्ट “\n" +
                      "जल लय – “इतनी पाद्यादिनी नमः शान्तिकालशया नमः “\n" +
                      "उजरा चन्दन लय – इदमनुलेपनम् श्वेत चन्दनं नमः शांति कलशया नमः “\n" +
                      "ललका चन्दन “इदं रक्तानुलेपनम् शांति कलशाय नमः “\n" +
                      "अक्षत लाया -“इदमक्षतम् शान्तिकलशाय नमः “\n" +
                      "धुप नैवेद्य लय – एतानि गंध,पुष्प ,धुप दीप ताम्बूल यथा भाग नानाविध नैवेद्यानि शान्तिकलशाय नमः “\n" +
                      "जल लय – “इदमाचमनीयम् नमः शान्तिकालशयाय नमः “\n" +
                      "“नमः शान्तिकुम्भ महाभाग सर्व काम फल प्रदः”\n" +
                      "फूल लय -” पुष्पम ग्रहण सुबह यच्छ पुज्याधार नमोस्तुते ” ऐश पुष्पांजलिः नमः शांतिकलशयाय नमः “";
                cardClicked(poojaVidhi);
              break;
 case R.id.card3:
              poojaVidhi ="अक्षत लय -“नमः सूर्य इहागच्छ यह तिष्ट “\n" +
                      "जल लय – “इतनी पाद्यादिनी नमः सूर्याय नमः “\n" +
                      "उजरा चन्दन लय – इदमनुलेपनम् श्वेत चन्दनं नमः सूर्याय नमः “\n" +
                      "ललका चन्दन “इदं रक्तानुलेपनम् सूर्याय नमः “\n" +
                      "अक्षत लाया -“इदमक्षतम सूर्याय नमः “\n" +
                      "धुप नैवेद्य लय – एतानि गंध,पुष्प ,धुप दीप ताम्बूल यथा भाग नानाविध नैवेद्यानि सूर्याय नमः “\n" +
                      "जल लय – “इदमाचमनीयम् नमः सूर्याय नमः “\n" +
                      "“नमः सूर्याय महाभाग सर्व काम फल प्रदः”\n" +
                      "फूल लय -” पुष्पम ग्रहण सुबह यच्छ पुज्याधार नमोस्तुते ” ऐश पुष्पांजलिः नमः सूर्याय नमः “";
                      cardClicked(poojaVidhi);
              break;
 case R.id.card4:
              poojaVidhi = "अक्षत लय -“नमः चन्द्र इहागच्छ यह तिष्ट”\n" +
                      "जल लय – “इतनी पाद्यादिनी नमः चन्द्राय नमः “\n" +
                      "उजरा चन्दन लय – इदमनुलेपनम् श्वेत चन्दनं नमःचन्द्राय नमः “\n" +
                      "ललका चन्दन “इदं रक्तानुलेपनम् चन्द्राय नमः “\n" +
                      "अक्षत लाया -“इदमक्षतम चन्द्राय नमः “\n" +
                      "धुप नैवेद्य लय – एतानि गंध,पुष्प ,धुप दीप ताम्बूल यथा भाग नानाविध नैवेद्यानि चन्द्राय नमः “\n" +
                      "जल लय – “इदमाचमनीयम् नमः चद्राय नमः “\n" +
                      "“नमः चन्द्राय महाभाग सर्व काम फल प्रदः”\n" +
                      "फूल लय -” पुष्पम ग्रहण सुबह यच्छ पुज्याधार नमोस्तुते ” ऐश पुष्पांजलिः नमः चन्द्राय नमः “";
                cardClicked(poojaVidhi);
              break;
 case R.id.card5:
              poojaVidhi = "अक्षत लय -“नमः नवग्रहा:इहागच्छ यह तिष्ट “\n" +
                      "जल लय – “इतनी पाद्यादिनी नमः नवग्रहेभ्यो नमः “\n" +
                      "उजरा चन्दन लय – इदमनुलेपनम् श्वेत चन्दनं नवग्रहेभ्यो नमः “\n" +
                      "ललका चन्दन “इदं रक्तानुलेपनम् नवग्रहेभ्यो नमः “\n" +
                      "अक्षत लाया -“इदमक्षतम नवग्रहेभ्यो नमः “\n" +
                      "धुप नैवेद्य लय – एतानि गंध,पुष्प ,धुप दीप ताम्बूल यथा भाग नानाविध नैवेद्यानि नवग्रहेभ्यो नमः “\n" +
                      "जल लय – “इदमाचमनीयम् नमः नवग्रहेभ्यो नमः “\n" +
                      "“नमः नवग्रहेभ्यो महाभाग सर्व काम फल प्रदः”\n" +
                      "फूल लय -” पुष्पम ग्रहण सुबह यच्छ पुज्याधार नमोस्तुते ” ऐश पुष्पांजलिः नमः नवग्रहेभ्यो नमः “";
                cardClicked(poojaVidhi);
              break;
 case R.id.card6:
              poojaVidhi ="अक्षत लय -“नमःनाग-दांपत्य इहागच्छ यह तिष्ट “\n" +
                      "जल लय – “इतनी पाद्यादिनी नमः नागदंपतिभ्याम् नमः “\n" +
                      "उजरा चन्दन लय – इदमनुलेपनम् श्वेत चन्दनं नागदंपतिभ्याम् नमः “\n" +
                      "ललका चन्दन “इदं रक्तानुलेपनम् नागदंपतिभ्याम् नमः “\n" +
                      "अक्षत लाया -“इदमक्षतम नागदंपतिभ्याम् नमः “\n" +
                      "धुप नैवेद्य लय – एतानि गंध,पुष्प ,धुप दीप ताम्बूल यथा भाग नानाविध नैवेद्यानि नागदंपतिभ्याम् नमः “\n" +
                      "जल लय – “इदमाचमनीयम् नमः नागदंपतिभ्याम् नमः “\n" +
                      "“नमः नागदंपतिभ्याम् महाभाग सर्व काम फल प्रदः”\n" +
                      "फूल लय -” पुष्पम ग्रहण सुबह यच्छ पुज्याधार नमोस्तुते ” ऐश पुष्पांजलिः नमः नागदंपतिभ्याम् नमः “";
                      cardClicked(poojaVidhi);
              break;
 case R.id.card7:
              poojaVidhi ="अक्षत लय -“नमःकुसुमावती इहागच्छ इह तिष्ठ “\n" +
                      "जल लय – “इतनी पाद्यादिनी नमः कुसुमावती नमः “\n" +
                      "उजरा चन्दन लय – इदमनुलेपनम् श्वेत चन्दनं कुसुमावती नमः “\n" +
                      "ललका चन्दन “इदं रक्तानुलेपनम् कुसुमावती नमः “\n" +
                      "अक्षत लाया -“इदमक्षतम कुसुमावती नमः “\n" +
                      "धुप नैवेद्य लय – एतानि गंध,पुष्प ,धुप दीप ताम्बूल यथा भाग नानाविध नैवेद्यानि कुसुमावती नमः “\n" +
                      "जल लय – “इदमाचमनीयम् नमः कुसुमावती नमः “\n" +
                      "“नमः कुसुमावती महाभाग सर्व काम फल प्रदः”\n" +
                      "फूल लय -” पुष्पम ग्रहण सुबह यच्छ पुज्याधार नमोस्तुते ” ऐश पुष्पांजलिः नमः कुसुमावती नमः “";
                      cardClicked(poojaVidhi);
              break;
 case R.id.card8:
              poojaVidhi ="अक्षत लय -“नमःचनाइ नाग इहागच्छ इह तिष्ठ “\n" +
                      "जल लय – “इतनी पाद्यादिनी नमः चनाइ नागाय नमः “\n" +
                      "उजरा चन्दन लय – इदमनुलेपनम् श्वेत चन्दनं च नाइ नागाय नमः “\n" +
                      "ललका चन्दन “इदं रक्तानुलेपनम् चनाइ नागाय नमः “\n" +
                      "अक्षत लाया -“इदमक्षतम चनाइ नागाय नमः “\n" +
                      "धुप नैवेद्य लय – एतानि गंध,पुष्प ,धुप दीप ताम्बूल यथा भाग नानाविध नैवेद्यानि चनाइ नागाय नमः “\n" +
                      "जल लय – “इदमाचमनीयम् नमः चनाइ नागाय नमः “\n" +
                      "“नमः चनाइ नागाय महाभाग सर्व काम फल प्रदः”\n" +
                      "फूल लय -” पुष्पम ग्रहण सुबह यच्छ पुज्याधार नमोस्तुते ” ऐश पुष्पांजलिः नमः चनाइ नागाय नमः “";
                      cardClicked(poojaVidhi);
              break;
 case R.id.card9:
              poojaVidhi = "अक्षत लय -“नमः लीली नागे इहागच्छ इह तिष्ठ “\n" +
                      "जल लय – “एतानी पाद्यादिनी नमः लीली नागाये  नमः “\n" +
                      "उजरा चन्दन लय – इदमनुलेपनम् श्वेत चन्दनं लीली नागाये नमः “\n" +
                      "ललका चन्दन “इदं रक्तानुलेपनम् लीली नागाये नमः “\n" +
                      "अक्षत लाया -“इदमक्षतम लीली नागाये नमः “\n" +
                      "धुप नैवेद्य लय – एतानि गंध,पुष्प ,धुप दीप ताम्बूल यथा भाग नानाविध नैवेद्यानि लीली नागाये नमः “\n" +
                      "जल लय – “इदमाचमनीयम् नमः लीली नागाये नमः “\n" +
                      "“नमः लीली नागाये महाभाग सर्व काम फल प्रदः”\n" +
                      "फूल लय -” पुष्पम ग्रहण सुबह यच्छ पुज्याधार नमोस्तुते ” ऐश पुष्पांजलिः नमः लीली नागाये नमः “";
                cardClicked(poojaVidhi);
              break;
 case R.id.card10:
              poojaVidhi ="अक्षत लय -“नमः पिंगले इहागच्छ इह तिष्ठ “\n" +
                      "जल लय – “एतानी पाद्यादिनी नमः पिंगले नमः “\n" +
                      "उजरा चन्दन लय – इदमनुलेपनम् श्वेत चन्दनं पिंगले नमः “\n" +
                      "ललका चन्दन “इदं रक्तानुलेपनम् पिंगले नमः “\n" +
                      "अक्षत लाया -“इदमक्षतम पिंगले नमः “\n" +
                      "धुप नैवेद्य लय – एतानि गंध,पुष्प ,धुप दीप ताम्बूल यथा भाग नानाविध नैवेद्यानि पिंगले नमः “\n" +
                      "जल लय – “इदमाचमनीयम् नमः पिंगले नमः “\n" +
                      "“नमः पिंगले महाभाग सर्व काम फल प्रदः”\n" +
                      "फूल लय -” पुष्पम ग्रहण सुबह यच्छ पुज्याधार नमोस्तुते ” ऐश पुष्पांजलिः नमः पिंगले नमः “";
                cardClicked(poojaVidhi);
              break;
 case R.id.card11:
              poojaVidhi = "अक्षत लय -“नमःशतानुजसाहित बैरस्ये नमः “\n" +
                      "जल लय – “इतनी पाद्यादिनी नमः शतनुजसाहित बैरस्ये नमः “\n" +
                      "उजरा चन्दन लय – इदमनुलेपनम् श्वेत चन्दनं शतानुजसाहित बैर स्ये नमः “\n" +
                      "ललका चन्दन “इदं रक्तानुलेपनम् शतानुजसाहिर बैर स्ये नमः “\n" +
                      "अक्षत लाया -“इदमक्षतम शतानुजसाहित बैर स्ये नमः “\n" +
                      "धुप नैवेद्य लय – एतानि गंध,पुष्प ,धुप दीप ताम्बूल यथा भाग नानाविध नैवेद्यानि शतानुजसाहित बैर स्ये नमः “\n" +
                      "जल लय – “इदमाचमनीयम् नमः शतानुजसाहित बैर स्ये नमः “\n" +
                      "“नमः शतानुजसाहित बैर स्ये महाभाग सर्व काम फल प्रदः”\n" +
                      "फूल लय -” पुष्पम ग्रहण सुबह यच्छ पुज्याधार नमोस्तुते ” ऐश पुष्पांजलिः नमः शतानुजसाहित बैर स्ये नमः “";
                cardClicked(poojaVidhi);
              break;
 case R.id.card12:
              poojaVidhi ="अक्षत लय -“नमः षष्ठी देवी  इहागच्छ इह तिष्ठ “\n" +
                      "जल लय – “एतानी पाद्यादिनी नमः षष्टदेव्यै  नमः “\n" +
                      "उजरा चन्दन लय – इदमनुलेपनम् श्वेत चन्दनं षष्टदेव्यै नमः “\n" +
                      "ललका चन्दन “इदं रक्तानुलेपनम् षष्टदेव्यै नमः “\n" +
                      "अक्षत लाया -“इदमक्षतम षष्टदेव्यै नमः “\n" +
                      "धुप नैवेद्य लय – एतानि गंध,पुष्प ,धुप दीप ताम्बूल यथा भाग नानाविध नैवेद्यानि षष्टदेव्यै नमः “\n" +
                      "जल लय – “इदमाचमनीयम् नमः षष्टदेव्यै नमः “\n" +
                      "“नमः षष्टदेव्यै महाभाग सर्व काम फल प्रदः”\n" +
                      "फूल लय -” पुष्पम ग्रहण सुबह यच्छ पुज्याधार नमोस्तुते ” ऐश पुष्पांजलिः नमः षष्टदेव्यै नमः “";
                cardClicked(poojaVidhi);
              break;
            case R.id.audioCard:
                mp= MediaPlayer.create(getActivity().getApplicationContext(),R.raw.tum_kehti_ho);
                mp.start();
                play.setVisibility(View.GONE);
                pause.setVisibility(View.VISIBLE);
                break;

            case R.id.audioCardPause:
                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.GONE);
                mp.stop();
                break;

            case R.id.pictureCard:
                nonframe.setVisibility(View.GONE);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragContainer, new PictureRead())
                        .commit();


        }

    }




    private void findViewByid(View view){
        day1 = view.findViewById(R.id.card1); day1.setOnClickListener(this);
        day2 = view.findViewById(R.id.card2); day2.setOnClickListener(this);
        day3 = view.findViewById(R.id.card3); day3.setOnClickListener(this);
        day4 = view.findViewById(R.id.card4); day4.setOnClickListener(this);
        day5 = view.findViewById(R.id.card5); day5.setOnClickListener(this);
        day6 = view.findViewById(R.id.card6); day6.setOnClickListener(this);
        day7 = view.findViewById(R.id.card7); day7.setOnClickListener(this);
        day8 = view.findViewById(R.id.card8); day8.setOnClickListener(this);
        day9 = view.findViewById(R.id.card9); day9.setOnClickListener(this);
        day10 = view.findViewById(R.id.card10); day10.setOnClickListener(this);
        day11 = view.findViewById(R.id.card11); day11.setOnClickListener(this);
        day12 = view.findViewById(R.id.card12); day12.setOnClickListener(this);


        play = view.findViewById(R.id.audioCard); play.setOnClickListener(this);
        pause = view.findViewById(R.id.audioCardPause); pause.setOnClickListener(this);
        read = view.findViewById(R.id.pictureCard); read.setOnClickListener(this);
        nonframe = view.findViewById(R.id.nonframe);

    }
    private void cardClicked(String pp){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());

        View view1 = getLayoutInflater().inflate(R.layout.mini_pooja, null);

        bottomSheetDialog.setContentView(view1);
        poojavidhi = view1.findViewById(R.id.poojaText);
        poojavidhi.setText(pp);

        bottomSheetDialog.show();
    }

}
