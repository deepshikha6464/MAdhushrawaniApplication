package com.maithil.madhushravani.view.explore;


import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.maithil.madhushravani.R;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */
public class Day2_14 extends Fragment  implements View.OnClickListener {

    private static final String TAG = "Day2_14";
    TextView mainKatha,nextTitle,nextKatha,note,noteHeading,temi,temiHeading,startPoojaDay,read214,listen214;
    LinearLayout toolbar, fragToolbar,mainToolBar,katha214;
    TextView tooltext , mediacard;

    ImageView back;
    SeekBar seekBar;
    static MediaPlayer mp;
    ImageView playmini, pause;
    LinearLayout mediaLayout,nonframe;
    Handler mHandler;
    NestedScrollView naviday1;
    LottieAnimationView play, read, audioCardKatha1,vacho;
    String kathaName;


    public Day2_14() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_day2_14, container, false);

        setToolbarDAYS(view);
        findViewByid(view);
        setDayfromSelectedCard();
//        media initialization
        mp = new MediaPlayer();
        mHandler = new Handler();
        return view;
    }

    @Override
    public void onClick(View view) {
        String data ="2";
        Bundle b = getArguments();
        if(b!= null) {
             data = b.getString("UNIQUE_KEY");
        }
        int id = view.getId();
                    switch (id){

                        case R.id.readBiniDays:
                            nonframe.setVisibility(View.GONE);
                            getActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.biniFragCont2, new PictureRead())
                                    .commit();
                            break;

                        case R.id.biniDays:
                            play.playAnimation();
                            if (mp.isPlaying()) {
                                mp.stop();
                                mp.reset();
                            }
                            mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.bini);
                            playMedia("Bini");
                            break;

                        case R.id.audioCardVachoBinidays:
                            vacho.playAnimation();
                            if (mp.isPlaying()) {
                                mp.stop();
                                mp.reset();
                            }
                            mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.vacho_bini);
                            playMedia("Vacho Bini");
                            break;

                        case R.id.pause:
                            mp.pause();
                            playmini.setVisibility(View.VISIBLE);
                            pause.setVisibility(View.GONE);
                            break;

                        case R.id.play:
                            mp.start();
                            playmini.setVisibility(View.GONE);
                            pause.setVisibility(View.VISIBLE);
                            break;

                        case R.id.listen214:
                            read214.setTextColor(Color.parseColor("#D81B60"));
                            listen214.setTextColor(Color.parseColor("#000000"));

                            audioCardKatha1.playAnimation();
                            if (mp.isPlaying()) {
                                mp.stop();
                                mp.reset();
                            }

                            switch(data){
                                case "2":
                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    try {
                                        mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/madhushrawani.appspot.com/o/songs%2Fkatha2.mp3?alt=media&token=466f1539-e35f-4bf3-b935-c589b57c2441");
                                        mp.prepare();
                                        playMedia("Katha of Day 2");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case "3":
                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    try {
                                        mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/madhushrawani.appspot.com/o/songs%2Fkatha_three.mp3?alt=media&token=af607c05-135c-4f70-8546-ff489a8699f9");
                                        mp.prepare();
                                        playMedia("Katha of Day 3");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case "4":
                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    try {
                                        mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/madhushrawani.appspot.com/o/songs%2Fkatha_four.mp3?alt=media&token=19d09886-9e2b-41d5-9bcf-62610b177604");
                                        mp.prepare();
                                        playMedia("Katha of Day 4");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case "5":
                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    try {
                                        mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/madhushrawani.appspot.com/o/songs%2Fkatha_five.mp3?alt=media&token=6632006a-d36f-41c2-8d62-3447c4aac97a");
                                        mp.prepare();
                                        playMedia("Katha of Day 5");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    break;
                                case "6":
                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    try {
                                        mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/madhushrawani.appspot.com/o/songs%2Fkatha_six.mp3?alt=media&token=a5ed56b1-32cb-4e62-8376-8aca3f1fd3cf");
                                        mp.prepare();
                                        playMedia("Katha of Day 6");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    break;
                                case "7":
                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    try {
                                        mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/madhushrawani.appspot.com/o/songs%2Fkatha7.mp3?alt=media&token=656bc8b1-2d5d-477f-bd82-035222af044f");
                                        mp.prepare();
                                        playMedia("Katha of Day 7");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    break;
                                case "8":
                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    try {
                                        mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/madhushrawani.appspot.com/o/songs%2Fkatha8.mp3?alt=media&token=2ba230a7-0ee3-4ae1-a81e-f8ba50f22b99");
                                        mp.prepare();
                                        playMedia("Katha of Day 8");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case "9":
                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    try {
                                        mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/madhushrawani.appspot.com/o/songs%2Fkatha9.mp3?alt=media&token=474a74ad-198a-49a5-98ec-eb05d1954bfe");
                                        mp.prepare();
                                        playMedia("Katha of Day 9");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case "10":
                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    try {
                                        mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/madhushrawani.appspot.com/o/songs%2Fkatha10.mp3?alt=media&token=2eb43629-6347-452e-8033-2771d9d4c1b4");
                                        mp.prepare();
                                        playMedia("Katha of Day 10");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    break;
                                case "11":
                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    try {
                                        mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/madhushrawani.appspot.com/o/songs%2Fkatha11.mp3?alt=media&token=48aac7e7-17f3-4a45-b16b-39b0212e9507");
                                        mp.prepare();
                                        playMedia("Katha of Day 11");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    break;
                                case "12":
                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    try {
                                        mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/madhushrawani.appspot.com/o/songs%2Fkatha12.mp3?alt=media&token=c67ebf22-c49e-4c4d-9514-65d6df0727c5");
                                        mp.prepare();
                                        playMedia("Katha of Day 12");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case "13":
                                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    try {
                                        mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/madhushrawani.appspot.com/o/songs%2Fkatha13.mp3?alt=media&token=b7a09cc4-511e-44b6-ac8c-e86222158591");
                                        mp.prepare();
                                        playMedia("Katha of Day 13");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;

                            }
                            break;

                        case R.id.back:
                            Log.d(TAG, "onClick: ");
                            getActivity().onBackPressed();
                            break;

                        case R.id.read214:
                            katha214.setVisibility(View.VISIBLE);
                            read214.setTextColor(Color.parseColor("#D81B60"));
                            listen214.setTextColor(Color.parseColor("#000000"));
                            break;


                    }
    }

    public void setToolbarDAYS(View view){
        //toolbar
        toolbar = view.findViewById(R.id.toolbar);
        fragToolbar = view.findViewById(R.id.fragToolbar);
        mainToolBar = view.findViewById(R.id.mainToolBar);
        tooltext = view.findViewById(R.id.toolText);
        back = view.findViewById(R.id.back); back.setOnClickListener(this);
        fragToolbar.setVisibility(View.VISIBLE);
        mainToolBar.setVisibility(View.GONE);
    }

    public void findViewByid(View view){

        mainKatha = view.findViewById(R.id.mainKatha);
        nextTitle = view.findViewById(R.id.nextTitle);
        nextKatha = view.findViewById(R.id.nextKatha);
        note = view.findViewById(R.id.note);
        noteHeading = view.findViewById(R.id.noteheading);
        temi = view.findViewById(R.id.temi);
        temiHeading = view.findViewById(R.id.temiheading);
        startPoojaDay = view.findViewById(R.id.starPooojaDay);
        nonframe = view.findViewById(R.id.nonframedays);

        back = view.findViewById(R.id.back); back.setOnClickListener(this);
        read214 = view.findViewById(R.id.read214); read214.setOnClickListener(this);
        listen214 = view.findViewById(R.id.listen214); listen214.setOnClickListener(this);
        katha214 = view.findViewById(R.id.kathaLayout214); katha214.setOnClickListener(this);

//        media
        mediaLayout = view.findViewById(R.id.media_layout);

        playmini = view.findViewById(R.id.play);
        playmini.setOnClickListener(this);
        pause = view.findViewById(R.id.pause);
        pause.setOnClickListener(this);
        seekBar = view.findViewById(R.id.SeekBar);
        mediacard = view.findViewById(R.id.mediaCard);    //song name  to be displayed

//on screen
        play = view.findViewById(R.id.biniDays);
        play.setOnClickListener(this);
        read = view.findViewById(R.id.readBiniDays);
        read.setOnClickListener(this);
        audioCardKatha1 = view.findViewById(R.id.audioCardKathaDays);
        audioCardKatha1.setOnClickListener(this);

        vacho = view.findViewById(R.id.audioCardVachoBinidays);
        vacho.setOnClickListener(this);

        naviday1 = view.findViewById(R.id.navidays);


    }
 public void setDayfromSelectedCard(){

     Bundle b = getArguments();
     if(b!= null)
     {
         String data = b.getString("UNIQUE_KEY");
         //doing something with this data
         Log.d(TAG, "onCreateView: "+data);
         switch (data){
             case ("2"):
                 tooltext.setText("Day 2");
                 mediacard.setText("Katha of Day 2");
                 startPoojaDay.setText("Start Pooja for Day Two");
                 mainKatha.setText("बिहुला आ मनसा क कथा \n" +
                         "\n" +
                         "मनसा शिव के मानस पुत्री रहथिन .जन्म होईते  वो युवती भई गेली I लाज क  रक्षा हेतु हुनका शरीर पर नाग लेपटा गेलनि I गौरी हुनका पसंद नय केलखिन त महादेव क कृपा सं ओ धरती पर निवास लेल चलि एलिह I ओहि समय  चंद्रधर (चंदू) नामक पैघ सौदागर  धरती पर रहैत छल I जे पैघ लोक करैत अछि तकरे अनुसरण सब लोक करैत अछि  I तें मनसा चंदू क कहलखिन जे अहाँ हमार पूजा करू I चंदू महादेव क परम भक्त I ओ कहलैथ -दहिना हाथ त हम महादेव क द देने छिएन आ अहाँ बामा हाथे पूजा ग्रहण करब त हम कए सकैत छी I ताहि पर मनसा क्रोधित भय गेली आ हुनकर छबो जवान बेटा के डँसि के मारि देलखिन I चंदू के बुढारि में फेर एकटा बेटा भेल I जखन बालक क टिप्पनि देखल गेल त हुनको आयु अल्पछल आ ई छल जे हुनको विवाह क दिन कोहबर में साँप डँसि लेत I ओहि बेटा क नाम लक्ष्मीधर (लखंदर )परल I लक्ष्मीधर जखन छबे मास क भेला त चंदू  अपना कनिया क आग्रह पर पुत्र क विवाह एहन कनिया सं करेवा लेल प्रस्स्तुत भय  गेला जकरा टिप्पनि में चिर-सोहागिन क योग छलैक I ओ पहाङ  पर एकटा एहन कोठा बनबौलेथ जाहि में कतओ सं साँप नहीं प्रवेश कय सकें I ओहि कोठा में लखंदर क विवाह बारह वर्ष क कन्या बिहुला सं भेल I जखन ओ अपना कनिया संगे कोहवर में छलैथ तखन कोना ने कोना कतउ सं साँप आवि हुनका डँसि लेलकनि आ ओ तुरंत मरि गेला I हुनकर दाह संस्कार हेतु हुनका गंगा कात आनल गेल संगहि परम सती बिहुला सेहो एलि I मुदा ओ अपना पति के गाङय नय देलखिन त लोक सब हुनका दुनू के श्मशान में छोङि घुरि अयलाह I बिहुला केरा क थम्हक एक टा नाव बना ओहि पर मुर्दा संगे अपनहूँ बैस गंगा धार में बह लागलि I बिना अन्न-जल अहिना कय दिन तक बहैत रहलि ,शव गलि-गलि खस लागल,केरा क थम्ह टुट लागल आ भसिआइत-भसिआईत  ओ बेढ-प्रयाग पहुँचली त ओतय त्रिवेणी घाट पर एकटा धोबिन क कपङा खिचैत देखलखिन I ओकरा संगे एकटा छोट बच्चा छलैक जे बर तंग करैत छल I धोबिन ओकरा जान सं मारि क कपङा तर में झाँपि के राखि  देलकैक आ जखन कपङा सब धोआ गेलइ तँ बच्चा क जिया क कोङा में ल विदा भ गेल I बिहुला ओहि धोबिन के शरण में गेलखिन आ अपना पति के जियेवाक लेल आग्रह करय लगलि I धोबिन बिहुला के सुंदरता ,धैर्य आ साहस देखि द्रवित भई गेलि I धोबिन बिहुला क लय इन्द्र क दरवार में गेलैथ जतय सब भगवान सेहो छलैथ I बिहुला अपन सब टा  वृतांत सुनेलखिन त सब देवता द्रवित भय मनसा क बजा चंदू के क्षमा करवाक  लेल आग्रह केलखिन I बिहुला सेहो बिसहारा क पैर पकङि विनती केलनि आ कबूला केलैथ जे यदि पति सहित हुनकर छबो भैंसुर जीवि उठताह तँ ओ अपना ससुर क मना क पूर्ण समारोह संग बिसहारा क पूजा करतीह तथा मृत्यु-भुवन में हुनक प्रचार करतीह I बिसहारा  प्रसन्न भय लक्ष्मीधर आ हुनकर छबो भाई के जीवित कय देलखिन I बिहुला क संगे सातो भाई नव शरीर लय यमलोक सं धरती पर आबि गेला I\n" +
                         "\n" +
                         "जखन मरणाशन्न चंदू अपना सातो बेटा आ पुतोहु क देखलखिन त आनंदविभोर भय गेलाह I सब गोटा धूमधाम सं बिसहारा क पूजा कएलानि आ एहि प्रकारे मनसा के पूजा धरती पर प्रारंभ भेल II");
                 nextTitle.setText("मंगला गौरी क कथा");
                 nextKatha.setText("श्रुतिकर नामक एकटा राजा छलैथ ,जिनका संतान नहि छेलैन I निरन्तर भगवती क आराधना सं भगवती हुनका पर प्रसन्न भई हुनका वरदान माँगए कहलखिन I राजा भगवती सं अपना लेल जखन पुत्र मगलखिन त भगवति कहलखिन-हे राजा तोरा सं हम अत्यंत प्रसन्न छी,परन्तु तोरा भाग्य में पुत्र नहि लिखल छह ! तथापि हम तोरा बेटा देबह I यदि सर्वगुणी चाहि त ओ मात्र सोलह वर्ष जीउतह आ यदि चिरंजीव बेटा लेबह त ओ महामूर्ख होयतह I राजा रानी सं विचार करि सर्वगुणी बेटा माँगलखिन I भगवती हुनका एकटा आम देलखिन जकरा सेवन सं रानी के गर्भ रहलें आ नियत समय पर हुनकर कोखि सं एकटा सुन्दर बालक क जन्म भेल जाकर नाम चिरायु राखल गेल I भगवती कह्लानुसार चिरायु विलक्षण छलैथ I देखैत देखैत सोलहम वर्ष नजदीक आबि गेल I राजा रानी चिंता में पङि गेला कि अपना आगु में बेटा क मृत्यु केना  देखता ते श्रुतिकर अपना पुत्र क अपना सार के सुपुर्द कय कहखिन जे – जावैत चिरायु जिता,हिनकर सुख-सुविधा क ध्यान राखब आ मरणोपरांत राजकुमार योग्य सम्मान सहित मणिकर्णिका पर दाह-संस्कार करि अहाँ घुरि आयब I\n" +
                         "\n" +
                         "दुनू मामा-भगिना काशी दिस बिदा भय गेला I रस्ता में एकटा नगर आनंदनगर आयल जतय क राजा बीरसेन क सुलक्षिणी बेटी मंगलागौरी क आई विवाह छल I जाहि फुलबारी में मामा भागीन  विश्राम करैत छलैथ ताहि  में राजकुमारी सखि सब संगे फुल तोरबाक लेल ऐली I गप्पे गप्पे में एक  सखि तमसा क मंगला गौरी के ‘राँङी’ कहि देलखिन ताहि पर सब सखि बाज लागलि कि एहि शुभ दिन पर एहन अशुभ बात केना I ताहि प्रतिउत्तर में मंगला गौरी कहलखिन –दूर,एकरा राँङी  कहने कि हम विधवा भए सकत छी ? हमरा कुल में आई धरि  कियो विधवा नहीं भेल अछि I हमरा ओहिठाम सबकेओ गौरी के तेना क गोहरौने रहेत अछि जे विधवा होएबे असंभव I हमरा हाथ क अक्षत जाहि वर पर पङत ओ यदि अल्पायुओ रहत त चिरायु भय जायत I\n" +
                         "\n" +
                         "\n" +
                         "मामा मंगला गौरी क बात सुनैत छलाह ,ओ सोचलैथ कि कहुना ने कहुना मंगलागौरी सं अपना भगिना क विवाह करैल जा I संयोगवश मंगला क विवाह बाह्वीक देश क राजा दृढवर्मा क बेटा सुकेतुवर्मा सं छल जे परम कुरूप आ मुर्ख छल I बर क बाप-काका सब विचारलेथ कि ज्यो येहन कुरूप बर मङवा पर जाएत त कन्या पक्ष बर के घूरा देत I तें सुन्दर बर के लय क मङवा पर जयबाक चाहि आ विवाह क बाद ओकरा भगा क कोहवर में सुकेतुवर्मा क बैसा देबनि I ताबत बरियाती क  नजर चिरायु पर परल I ओ सब हुनकर मामा लग अपन प्रस्ताव राखलखिन I मामा त मने मन प्रसन्न भेला आ प्रस्ताव मानि बरियअति संगे विदा भेला I शुभ लग्न में  मंगला गौरी के विवाह मङनी क बर सं भय गेल आ दुनू बर-कनियाँ कोहबर में सूतलाह I आईए  राति चिरायु क सोलह वर्ष पूरा भेलैन I निशा राति में काल गहुमनसाँप क रूप में कोहवर में पैसल I राजकुमारी जगले छेलिह,भयंकर साँप क देखि साहस कय साँप क आगु भरि बाटी दूध राखि देलखिन का कल जोङी प्रार्थना करय लागलि जे –हे नाग राज !हमरा पति के प्राण जुनी लिअ ,वरन् हुनका चिरंजीवी बना दिअ त हम आजीवन नाग राज पूजा करब आ व्रत राखब I नागराज मानि गेलखिन आ दूध पीवि ओतहि राखल पुरहर में पैस गेलैथ I ताबत चिरायु क नींद टूटलनि आ ओ किछु खेबाक लेल मंगलैथ I मंगला हुनका खीर आ लड्डू खेबाक लेल देलखिन I बर क हाथ धोबाक काल हुनकर हाथ सं पञ्चरत्नक अंगूठी खसि पङलनि जे कनियाँ अपना आंगुर में पहिर लेलि I बर पान सुपारी खा सूति रहला I बाद में जखन कनियाँ साँप बला पुरहर के फेकय  गेलि त साँप क स्थान पर रत्नहार देखलखिन जकरा ओ अपना गरदनि में पहिर लेलि I भोर भेला पर चिरायु अपना मामा संगे गाम छोङि बिदा भय गेला आ सुकेतु कोहबर में प्रवेश कर लगला I परन्तु मंगला हुनका मुंहे पर रोकि लेलखिन I बरियाती सब हुज्जत कर लागल त मंगला बर सुकेतु सं रात्रि में कोहबर बला खिस्सा पुछलखिन ,जकर कुनु जबाब सुकेतु लग नहि छेलनि आ पञ्चरत्न अँगूठी सेहो सुकेतु के आंगुर में नहि अंटल तखन बरियाती सब सुकेतु क लय घुरि गेला I\n" +
                         "\n" +
                         "चिरायु अपना मामा संगे काशी,प्रयाग आदि होईत एक साल बाद वोहि बाटें घुरला ,त अपना छत सं मंगला हुनका देखते चिन्ह गेलखिन I हुनका सादर बजायल गेल आ पुछला पर सबटा सही सही जबाब देलखिन I राजा तखन धूम धाम सं विवाह उत्सव मना ,गाजा बाजा संगे दुनू के बिदा केलखिन I\n" +
                         "\n" +
                         "जखन चिरायु अपना पत्नी संगे अपना राजधानी पहुँचला ,त हुनकर जीवित रहवाक समाचार सुनि राजा रानी के आनंद क कुनु सीमा नहि  रहल आ ओ अपना पुतहु के भरि-भरि आशीर्वाद देलखिन II");
                 break;

             case("3"):
                 tooltext.setText("Day 3");
                 mediacard.setText("Katha of Day 3");

                 startPoojaDay.setText("Start Pooja for Day Three");
                 mainKatha.setText("पृथ्वी क जन्म\n" +
                         "\n" +
                         "\n" +
                         "ब्रह्मा सब देवता लोकनि के सभा बजा क कहलखिन जे संसार में पाप बड पासरि गेल अछि तें पृथ्वी भागि के रसातल में चलि गेलिह ,हुनका कोनों तरह अनबाक अछि I  सब गोटा मिल तखन पृथ्वी के आग्रह केलखिन ऊपर अयबाक लेल I पृथ्वी कहलखिन कि – हम कोना आयब लोक हमर अपमान करैत अछि I लोक हमरा ऊपर रहैतो  अछि आ मल-मूत्र सेहो त्याग करैत ऐछ I ताहि पर देवता सब कहलखिन कि – अहाँ एकर चिंता नहि करू ,जे अहाँ क ऊपर मल-मूत्र करत आ ओकरा देखि लेत ओकरा पाप हेतई I तखन अहाँ क असहज नहि लागत I ज्यों कियो बिना अहाँ सं क्षमा मागने अहाँ पर पैर रखत तकरो पाप हेतई I तखन पृथ्वी रसातल सं ऊपर एलखिन I विष्णु कछुआ क रूप धरि हुनका अपना पीठ पर धेलखिन,पृथ्वी डगमगैईत रहलि ,तँ माइट ताकल गेल I अगस्त्य मुनि तपस्या करैत छलैथ I हुनका जाँघ तर सं माटि आनल गेल I विष्णु मतस्य रूप धरि भाति अनलैथ त पृथ्वी साटल गेल ,तखनो डोलैत रहलि I तखन विष्णु वराह रूप धरि उत्तर दिश सं पृथ्वी क दबलेथ त पृथ्वी स्थिर भेलखिन तदानोपरांत ब्रह्मा ओहि पर संसार क सृजन कैयलेथ  II");
                 nextTitle.setText("समुद्र मंथन  ");
                 nextKatha.setText(
                         "देवता सब अमर होएबाक इक्षा सं समुद्र मंथन क हेतु जाहि में दानव सभक सेहो मदद लेल जाय से विचार-विमर्श लेल सुमेरु पर्वत पर जमा भेला I वासुकी नाग क बजायल गेल ,ओ मंदराचल पर्वत के अपना विशाल शरीर सं लपेटि उखाङि देलखिन आ देवता सब हुनका उठा समुद्र क कात अनलैथ I मंदराचल मथनी आ वासुकी मथैबाला रस्सी ,आब आधार चाही छल जाहि पर मंदराचल घुमता ,ताहि लेल देवता आ दानव क अनुरोध पर कूर्म(कछ्छ्प )राज तैयार भेला I समुद्र मंथन आरम्भ भेल नाग क शीश दिस दानव आ पूंछ दिस देवता गण I मंथन सं समुद्र जीव-जंतु पिसाए लागल आ मंदार क गाछ सब टकरा क खस लागल ,पर्वत पर अग्नि प्रज्वलित भय गेल जाहि में सोना-चांदी मूंगा – मोती सब भस्म होबए लागल I सब के व्याकुल देखि इन्द्र वर्षा कर लगला जाहि सं सब भस्म सब धोखरि के समुद्र में जाय लागल I समुद्र क नूनगर  जल दूध भई गेल ,जे फेर मथला पर घी भय गेल I धीरे धीरे समुद्र सं लक्ष्मी,सुरा,उच्चैःश्रवा घोङा निकलल जकरा चन्द्रमा हथिया लेलैथ I तत्पश्च्यात धनवंतरी अमृत लेने प्रगट भेलैथ I तखन विष निकलल जकर थाह सं सब गोटा मूर्छित भए गेला I तखन शिव सबटा विष पीबि  गेलैथ आ बेहोश भए गेलैथ I गौरा क निहोरा केला पर सब बिसहारा ,साँप बिरहनी चुट्टी सब मिलि  क महादेव क शरीर सं विष निकाललक ,मुदा शिव क अनुरोध पर कनेक  विष कंठ में छोङि देलक जाहि सं हुनकर कंठ कारी छनि,आ तहिये सं ओ नीलकंठ कहेला I\n" +
                                 "\n" +
                                 "अमृत लेल देवता और दानव में झगङा होमय लागल I दानव अमृत में अपन हिस्सा मांग लगला आ देवता सब के इ डर छल ,जे बिना अमृत के दानव सब बहुत बलिष्ठ ऐछ आ कैक बेर देवता सब के परास्त क स्वर्ग सं भगा देने छल त अमृत पी लेला बाद पता ने कि करत  इ सोचि विष्णु मोहनि नारी रूप धरि दानव सभक समक्ष प्रगट भेलि I मोहनि सं  मोहित भय हुनका हाथ में अमृत दय असुर देवता सब सं युद्ध करवा लेल चलि गेला I एही बीच मोहनी अमृत सब देवता सब में बाँटी देलखिन I ओहि देवता सब में एक टा असुर राहू ,देवता क रूप धरि  अमृत ग्रहण कर लागल त सूर्य आ चंद्रमा हुनका चिन्ह गेलखिन आ विष्णु के कहि देलखिन I यावत् ओकरा कंठ में अमृत जाइ तावत् विष्णु ओकर गरदनि काटि देलखिन I अमृत क स्पर्श सं ओ मरि नहि सकल ,किन्तु दु भाग में विभक्त भ गेल ,मुंड राहु आ धङ केतु I तहिये सं ओ सूर्य आ चंद्रमा क शत्रु भय गेल I तेँ अखन्हु धरि कहियो कहियो  अमावस्या में सूर्य के आ पूर्णिमा में चंद्रमा के निगली जाइत छैथ  जाहि सं सूर्यग्रहण आ चंद्रग्रहण होइत अछि I जें ओकर धङ कटल छैक तें सूर्य आ चन्द्रमा फेर बाहर निकलि जैत छैथ I\n" +
                                 "\n" +
                                 "देवगण केँ अमृत पिऔला क बाद विष्णु अश्त्र-शश्त्र लए दानव सब के युद्ध में परास्त करि पताल भगा देलखिन आ बचल अमृत  इन्द्र क जिम्मा राखि विश्वकर्मा के ओकर रखवार बना देलखिन I वासुकी नाग जिनका समुद्र मंथन में अपार कष्ट भेलैन हुनका वरदान देलखिन जे हुनका माय के श्राप नहि  लगतनि ,ओ सपरिवार जनमेजय महाराज क सर्प यज्ञ में नहीं जरताह ,हुनकर भगिन आस्तिक मुनि हुनकर रक्षा करथिन   II");
                 break;
             case("4"):
                 tooltext.setText("Day 4");
                 mediacard.setText("Katha of Day 4");

                 startPoojaDay.setText("Start Pooja for Day Four");
                 mainKatha.setText("सती क कथा\n" +
                         "\n" +
                         "\n" +
                         "सृष्टि रचना में पहिने विष्णु तखन महादेव आ फेर ब्रह्मा क जन्म भेलनि I ब्रह्मा अपना शरीर सं देवता आ ऋषि-मुनि ,मुँह सं शतरूपा नामक स्त्री आ मनु ,दहिना आँखी सं अत्रि,कान्ह सं मरीचि आ दाहिना पांजर सं दक्ष प्रजापति क जन्म देलखिन I ब्रह्मा क संतान सब सेहो सृजन करय लगला , मरीचिक बेटा कश्यप आ अत्रिक क पुत्र चंद्रमा I मनु के दु बेटा  प्रियव्रत आ उत्तानपाद और तीन बेटी आकूति,देवहुति आ प्रसूति भेलखिन I प्रसूति क विवाह दक्ष प्रजापति सं भेल जिनका सं साठि टा कन्या क जन्म भेल I ओहि में आठ क विवाह धर्म सं ,ग्यारह क विवाह रूद्र सं ,तेरह कश्यप ,सताईस चंद्रमा आ एक गोट सती क विवाह महादेव सं भेलनि I\n" +
                         "\n" +
                         "चंद्रमा अपना पत्नी सब में रोहिण के सब सं बेसी मानैत छलैथ जाहि सं बाकि छबिसो हुनका सं क्रोधित भय प्रजापति लग शिकायत केलखिन I प्रजापति चंद्रमा के बुझेलखिन मुदा ओ काँन बात नहि देलखिन त क्रोधित भय दक्ष हुनका श्राप देलखिन – ‘अहाँ के क्षय रोग भय जायत आ अहाँ क सम्पूर्ण शरीर गलि जायत I“ चंद्रमा क शरीर दिन दिन गल लागल I ओ सब लग गोहारी लगेलैथ मुदा कियो मदद नय केलक तँ ओ महादेव क शरण में गेलैथ त ओ हुनका अपना माथ पर राखि लेलखिन जाहि सं हुनकर गलनाइ बंद भय गेल I दक्ष क जखन पता चलल त ओ महादेव क हुनका माथ सं उतारअ कहलखिन जकरा महादेव अस्वीकार क देलखिन I ओहि पर क्रोधित भय दक्ष महादेव सं संबंध तोरी लेलैथ I\n" +
                         "\n" +
                         "दक्ष एक टा पैघ यज्ञ क आयोजन केलैथ जाहि में महादेव क छोङि  सब गोटा के बजेलखिन I मुदा सती बिना नोंते बाप क घर जेवाक जिद कर लागलि त हारि  के महदेव हुनका अपन सेवक वीरभद्र संगे विदा क देलखिन I सती जखन नैहर पहूँचलि त कियो हुनका नय त बैसय लेल कहलकैन ना कियो गप्प केलकैन I सती अपना अवहेलना सं रुष्ट भय धधकैत यज्ञ कुंड में कुदि गेलि जाहि पर क्रोधित भय वीरभद्र यज्ञ क तहस नहस क दक्ष क गर्दनि काटि देलखिन I इ सब सुनि महादेव अएलाह हुनका आगु सब कल जोरि कहलखिन जे ज्यो यज्ञ पूर्ण नहि होयत तँ संसार क अनिस्ठ होयत आ बिना यजमान क यज्ञ पूर्ण नहि होयत तेँ दक्ष के जियाओल जाय I महादेव ओहि ठाम बांधल बकरी क मुरी काटि  क दक्ष क लगा देलखिन आ ओ बो –बो करैत जीवित भ गेला I हुनकर बो-बो सुनि महादेव प्रस्सन  भेलखि ते महादेव के पूजा क अंत में बो-बो-बू अर्थात बम्-बम्-बू करैत अछि  I\n" +
                         "\n" +
                         "सती क दुर्दशा देखि महादेव बताह भय गेला I सती के शव के कान्हा पर राखि बौआबअ लगला I तखन विष्णु अपना चक्र सं सती के शरीर क काटि काटि खसब लगला I जतय जतय सती क शरीर खसल सिद्धपीठ भय गेल I आ विष्णु महादेव क कहलखिन कि सती के फेर सं प्राप्त करवा हेतु ओ तपस्या करैथ I तपस्या हेतु महादेव कैलाश छोङि हिमालय चलि गेला  II");
                 nextTitle.setText("");
                 nextKatha.setText("");
                 break;
             case("5"):
                 tooltext.setText("Day 5");
                 mediacard.setText("Katha of Day 5");

                 startPoojaDay.setText("Start Pooja for Day Five");
                 mainKatha.setText("महादेव क परिवार\n" +
                         "\n" +
                         "\n" +
                         "दक्ष, सती के प्राण त्याग्लाक बाद हिमालय के रूप में अवतार लेलैथ I हुनका क्रमशः पाँच टा कन्या भेलनि उमा,पार्वती ,गंगा,गौरी आ संध्या I एही पाँचो क विवाह बेरि बेरि महादेव सं भेलनिI\n" +
                         "\n" +
                         "उमा\n" +
                         "\n" +
                         "हिमालय क मनाइन नामक स्त्री सं एकटा बेटी भेलखिन I जखन ओ पाँच वर्ष क भेलि त महादेव क वर रूप में प्राप्त करवाक कामना सं तपस्या करवा हेतु विदा भेलि I मनाईन मना करैत रहि  गेलखिन मुदा ओ नहि मानलि तें हुनकर नाम उमा पङलैन I आठ वर्ष क भेला पर महादेव हुनका तपस्या सं प्रसन्न भई हुनका सं विवाह क लेलैथ I आ मनाईन अपन माथ पिटैत रहि गेली कि हुनकर सुकुमारी क विवाह बूढ बर सं भ गेल I\n" +
                         "\n" +
                         "पार्वती\n" +
                         "\n" +
                         "हिमालय क दोसर बेटी पार्वती भेलखिन I पार्वती एक दिन फूल तोरबाक लेल कनक शिखर पर  गेलखिन I ओतए एकटा बूढबा क बसहा पर चढल आ डमरू बजबैत देखलखिन I पार्वती चिन्ह गेलखिन जे इ त साक्षात् महादेव छैथ I सखि सब के मना केला क बादो ओ ओकरा सब के घर विदा क बसहा  पर बैसी  महदेव संगे चलि गेली I मानाइन फेर कानैत बाजैत रहि गेली I\n" +
                         "\n" +
                         "गंगा\n" +
                         "\n" +
                         "हिमालय क तेसर बेटी भेलखिन गंगा I ओ जखन पैघ भेलि त एक दिन महादेव भिखारी रूप ध आबि क गंगा क अपना चोटी में नुकाए भागि गेलखिन I तहिया सं गंगा महादेव के जटा में विराजमान रहैत छैथ I");
                 nextTitle.setText("");
                 nextKatha.setText("");
                 break;
             case("6"):
                 tooltext.setText("Day 6");
                 mediacard.setText("Katha of Day 6");

                 startPoojaDay.setText("Start Pooja for Day Six");
                 mainKatha.setText("गंगा क कथा\n" +
                         "\n" +
                         "\n" +
                         "राजा सगर क दु टा स्त्री वेदर्भी आ शैव्या I शैव्या क पुता असमंजस मुदा वेदर्भी  कुनु संतान नहि छेलनि I ओ संतान हेतु सौ वर्ष तक महादेव क तपस्या केलैथ त हुनका संतान क नाम पर एकटा लोथ क जन्म भेलनि त ओ महादेव क कानि क स्मरण केलैथ I महादेव ब्राह्मण क रूप धरि अयलाह आ ओहि लोथ के साठि हजार खंड क सब के तौला में तेल में ध राखि देलखिन I थोङे दिन बाद ओहि सं साठि हजार सुन्दर बालक भ गेल I\n" +
                         "\n" +
                         "राजा समर ९९ टा अश्वमेघ यज्ञ क बाद सौ वां क तैयारी में लागल छलैथ मुदा इन्द्र नहि चाहैत छलैथ कि इ यज्ञ पूरा होय कियक त सौवा पूरा भेला पर ओ शतक्रतु इन्द्र भ जेता ,तेँ ओ विघ्न पैदा करैत रहैत छलैथ I\n" +
                         "\n" +
                         "अश्वमेध क घोङा छोरल गेल जकर रखवाङ हुन कर साठि हजार पुत्र छलैथ I इन्द्र घोङा छल सं चोरा क भागलैथ , हुनका पाछू पाछू साठियो हजार पुत्र पृथिवी कोङैत आगु बढ़लाह त घोङा क कपिलमुनि क आश्रम में बांधल देखलखिन I सगर पुत्र मुनि क चोर बुछि हुनका दिस ज्यो दौङलखिन त मुनि क ध्यान टूटि गेलनि आ  हुनकर क्रुद्ध दृष्टी सं सब सगर पुत्र भस्म भ गेला I राजा क यज्ञ अपूर्ण रही गेल ,आ ओ शोकाकुल मरि गेला I अपमृत्यु क प्राप्त राजकुमार सब के सदगति क जखन उपाय पुँछल गेल त सब कहलखिन जे से तखने संभव जँ गंगा हुनकर सभक अस्थि क स्पर्श करति I गंगा क धरती पर अनवा लेल असमंजस तपस्या करैत करैत मरि गेला I ओकर बाद हुनकर बेटा दिलीप आ फेर दिलीप क बेटा अंशुमान सेहो तपस्या करैत मरि गेला I तखन हुनकर बेटा भागीरथ क तपस्या सं प्रसन्न भय विष्णु गंगा के बैकुंठ सं धरती पर अनबाक अनुमति देलखिन I चुकि गंगा यकायक धरती पर उतरति त धरती रसातल में चलि जायत ते पहिले शिव अपना माथ पर उतारि जटा में समेटलखिन I तकर बाद गंगा हिमालय क दह्बैत बिदा भेलि I जह्नु ऋषि क आश्रम दहा लगलैन त ओ उठा गंगा क पीवि  गेलखिन  I भगीरथ ऋषि के सेवा कर लगला जाहि सं प्रसन्न भय एही शर्त पर गंगा के छोङलखिन कि गंगा हुनकर बेटी कहोती तेँ गंगा जाह्नवी कहेली I आगु आगु भागीरथ आ पाछु पाछु गंगा ,गंगा द्वार सं होइत हरिद्वार फेर हुनकर पितर क्र भस्म सब के धोइत पखारैत अंत में ओहि विशाल खाधि में खसलीह जकरा सगर पुत्र खुन्ने छलैथ आ ओ सागर कहाएल .एही प्रकारे गंगा धरती पर एली I\n" +
                         "\n");
                 nextTitle.setText("श्री गौरी क जन्म");
                 nextKatha.setText("सती क मृत्यु क बाद महादेव संसार सं विरक्त भय निर्जन स्थान में जा तपस्या में लीन भय गेला I एही बीच राक्षस सब हक उपद्रव बहुत बढि गेल I ओहि राक्षस  सब में तारकासुर नामक राक्षस अपना तपस्या सं प्रस्सन कय ब्रह्मा सं वरदान मंगलक कि हम अमर भय जाई ,जाहि पर ब्रह्मा राजी नई भेलखिन त ओ दोसर वरदान मंगलक कि ओकर मृत्यु मात्र महादेव के औरस पुत्र क हाथे हूअए I ब्रह्मा तखन मानि  गेलखिन आ ओकरा तथास्तु  कहि देलखिन I इ वरदान मंगवा में तारकासुर के इ उद्देश्य छल कि महादेव क स्त्री त निस्संतान मरि गेल छैथ आ महादेव संसार सं विरक्त भय गेल छैथ तें हुनकर दोसर विवाह असंभव I अर्थात ओ अमर रही जायत I मृत्यु भयहिन तारकासुर सब देवता सब के स्वर्ग सं भगा अपने राजा बनि गेल I जप तप बंद करवा देलक ,मुनि सब के सतबए लागल,स्त्री सब के अपहरण करय लागल I ओकर त्राहि त्राहि सं तंग आवि  क  सब लोक ब्रह्मा लग गेलैथ त ब्रह्मा कहलखिन जे आँहा  सब महाशक्ति दुर्गा क आराधाना करू त ओ गौरी रूप में जन्म लेति आ जखन हुनकर और महादेव क विवाह सं पुत्र ह्र्तैन त ओहि बालक हाथे तारकासुर क वध हैत I तखन सब गोटा माँ  दुर्गा क आराधना करय लगला जाहि सं प्रस्सन  भय दुर्गा क जन्म हिमालय क बेटी क रूप में भेलनि II\n" +
                         "\n" +
                         "काम-दहन \n" +
                         "\n" +
                         "\n" +
                         "एक दिन नारद मुनि हिमालय क ओहिठाम अयलाह आ हिमालय क कहलखिन जे अहाँ क पुत्री गौरी क हाथ में  महादेव संग विवाह लिखल छैन , आ अखन  महादेव अहिं क शिखर पर तपस्या क रहल छैथ तेँ अहाँ गौरी के महादेव क सेवा में लगा दिऔन जाहि सं ओ प्रस्सन भय अहाँ क बेटी सं विवाह क लेता I हिमालय नित्य गौरी क दु गोट सखि संगे महादेव क सेवा में पठबए लगलखिन I देवतागण महादेव क तपस्या भंग कय  हुनकर ध्यान गौरी दिस आकृष्ट करवा हेतु कामदेव क कहलखिन I कामदेव अपन मित्र वसंत आ पत्नी रति संगे ओतय पँहूचि   गेलैथ I सम्पूर्ण हिमालय वसंत क महिमा सं सुंगंधित आ आकर्षक भई गेल I परम सुंदरी गौरी जखन महादेव क पूजा क हेतु पुष्प श्रृंगार कय महदेव क आगु ठाढ़ भेलखिन तखने कामदेव महादेव क ऊपर अपन वाण चला देलखिन I महादेव क तन्द्रा टुटि गेलैन आ ओ अपना समक्ष गौरी क देख हुनका पर आसक्त भैय कामातुर भय गेला I परन्तु तत् क्षण महादेव संभालि गेला आ अपन क्षण में उपजल यही भावना क कारण ताक लगला त झाङी में नुकायल कामदेव क देखलखिन Iमहादेव क क्रोध सं हुनकर तेसर नेत्र खुलि  गेल  आ ज्यो ओ कामदेव दिस तकलखिन ,कामदेव भस्म भ गेला I रति अपना स्वामी क दशा देख विलाप करय लागलि त सब देवता सब महादेव क कहलखि जे-एहि में कामदेव क कुनु गलति नहि  छल अपितु संसार क तारकासुर सं बचेवा हेतु अहाँ क तपस्या सं उठेनए जरूरी छल I तखन महादेव कहलखिन जे कामदेव मरला नइ हुनकर शरीर जरलनि I रति अखन  समुद्र क राक्षस शम्बर संगे  जा क रहति आ जखन द्वापर में कृष्ण क बेटा प्रदुम्म क उठा क शम्बर राक्षस अपना नगर ल जायत त रति क ओतहि प्रदुम्म क शरीर में कामदेव भेटतनि  I आ जखन प्रदुम्म पैघ भ जेता त शम्बर क मारि रति क द्वारिका ल जा  हुनका सं विवाह करता I तखन रति कामदेव सं मिलन क आशा में शम्बर राक्षस क ओहिठाम लेल विदा भेलि II\n" +
                         "\n");
                 break;
             case("7"):
                 tooltext.setText("Day 7");
                 mediacard.setText("Katha of Day 7");

                 startPoojaDay.setText("Start Pooja for Day Seven");
                 mainKatha.setText("गौरी क तपस्या\n" +
                         "\n" +
                         "\n" +
                         "\n" +
                         "\n" +
                         "काम-दहन आ महादेव त रूद्र रूप देखि गौरी डेरा गेली आ नादर सं महादेव क पएबाक उपाय पुछ्हखिन त नारद कहलखिन बिना तपस्या महादेव क पेनाइ कठीन I तखन गौरी अपना माता-पिता सं आज्ञा ल अपना सखि सब संगे वन दिश बिदा भेलि I ओ अपना पटोर आ गहना खोलि कृष्णाजिन आ बल्कल  पहिर गौरी शिखर पर कठोर तपस्या कर लागलि I गौरी क तपस्या सं प्रभावित भय ऋषि सब आ नारद महादेव लग जा  कहलखिन –हे महादेव ,गौरी तेहन तपस्या क रहल छैथ जेहन आन ककरो लेल असंभव तेँ अहाँ हुनका पर प्रसन्न भय एही जग क कल्याण करू I\n" +
                         "\n" +
                         "महादेव एकटा बुढवा क रूप धय गौरी क आश्रम में गेला I गौरी हुनकर खूब स्वागत सत्कार केलखिन तखन प्रस्सन भय बुढा गौरी सं पुछलखिन –कि हे गौरी अहाँ कुन कामना सं एहन कठीन तप क रहल छी I त सखि सब गौरी क कामना बतेलखिन ताहि सुनि ओ बुढा उठ क विदा भ गेलखिन I\n" +
                         "\n" +
                         "गौरी कहलखिन जे – हमरा सं कुन अपराध भेल जे अहाँ एना जाइत छी I\n" +
                         "\n" +
                         "बुढा कहलखिन – हमरा अहाँ पर पहिने श्रद्धा भेल छल मुदा अहाँ क अभीष्ट बुझि अपार दुःख भ रहल अछि I अहाँ अशर्फी बेचि माटि किन निकललौ हं I हाथी  सवारी छोङि ,बङद  पर चढ चाहैत छी ,सूर्य क रोशनी छोर भगजोगनी आ कोठा सोफा छोरि मरघट में रहब I अहाँ अतेक सुन्दर आ ओ शरीर में साँप लपटोने कारि खट-खट बुढवा I अहाँ मंगल कारी ओ अमंगल I बर में जे जे गुण चाहि ओहिमें यको टा हुनका में नहीं छनि I ओ अहाँ क योग्य कदापि नहि  छैथ I\n" +
                         "\n" +
                         "गौरी ताहि प्रत्युत्तर में कहलखिन – महादेव निर्गुण ब्रह्म थीका I ओहए ब्रह्मा बनि संसार क सृष्टि करैत छैथ ,सबहक आदिपुरुष सेहो ओहए छैथ I हुनकर लीला अपरम्पार I सुंदरता आ कुरूपता हुनके रूप छनि I अहाँ अपने पापी थिकौं ,अहाँ इ रहस्य नहि बुझवई I इ कहि गौरी तमसा विदा भय गेलि I बुढा तुरत महादेव क रूप धरि हुनका आगु रस्ता रोकि ठाढ़ भय गेला,आ कहलखिन जे गौरी हम अहाँ क तपस्या सं प्रस्सन छी चलु कैलाश ओतय हम अहाँ सं विवाह करब I गौरी लजा गेली आ अपना सखि सं कहलवेलखिन – हे आदिनाथ यदि अहाँ हमरा पर प्रस्सन छी त विवाह के प्रचलित नियमानुसार अहाँ कुनु गोटा दिया हमरा पिता ओहिठाम अपनान विवाह क प्रस्ताव पठाऊ जाहि सं हमरा पिता क गृहस्थाश्रम सफल होईन आ यश पसरनि I महादेव मानि गेला आ गौरी अपना पिता घर वापस आबि गेली  II");
                 nextTitle.setText("");
                 nextKatha.setText("");
                 break; case("8"):
                 tooltext.setText("Day 8");
                 mediacard.setText("Katha of Day 8");

                 startPoojaDay.setText("Start Pooja for Day Eight");
                 mainKatha.setText("गौरी क विवाह आ बरियाती\n" +
                         "\n" +
                         "\n" +
                         "महादेव सप्तॠषी ,वशिष्ठ मुनि आ हुनकर पत्नी अरुंधती क हिमालय ओहिठाम पठा ,हिमालय आ हुनक पत्नी मैना सं गौरी क महादेव संग विवाह क प्रस्ताव रखलखिन I हिमालय आ मैना आह्लादित भय गेला I विवाह क दिन फागुन वदि चतुर्दशी ताकल गेल I ऋषि सब घुरि महादेव क समाचार देलखिनI महादेव देवता आ ऋषि लोकनि  के हकार देवाक जिम्मेदारी नारद क देलखिन I महादेव क गण सब बरियाती क तैयारी  कर लागल I बर स सजाएल गेल ,माथ पर चंद्रमा ,शरीर में साँप ,माथ बांधल जटा,बघम्बर ओढलल,आदि पुरुष महादेव I बरियाती बर क लय चलल आ चारिम दिन हिमालय ओतय पहुँचल I सब बरियाती क स्वागत में लागि  गेल I मैना क बढ मन कि वोहि बर के देखि जकरा लेल हुनकर बेटी महल छोङि जंगल में जा अतेक कठीन तपस्या केलि I ओ नारद मुनि संगे दुआरि पर गेली बर देखवा लेल I पहिने ओ सुन्दर गन्धर्वराज क देख क बर बुझि प्रस्सन भेलि मुदा नारद कहलखिन कि इ देवता क गवैया थीका I फेर ओ धर्मराज क देखलखिन आ आनंदित भेलि मुदा ओहो बर नहीं,एहिना क्रमशः देवता लोक अवैत गेला आ मैना ओकरा बर बुझैत रहलि आ नारद हुनकर बात क  खंडित करैत रहला I महादेव सब देखैत छलैथ ओ मैना क परेशान करवाक प्रयोजन सोच लगला I नारद मैना क कहलखिन कि देखियो ओ रहल बर I मैना हुलसि क देखए लागलि I पहिने महादेव क गण,सेवक,भूत,पिचाश  ,मैना का हृदय धक् धक् I तावत महादेव हुनका देखाए देलैथ ,बासहा चढल,पाँच मुँह ,तीन आँख,दस हाथ ,शरीर पर भस्म ,कौरी माला गर्दन में,माथ पर चंद्रमा,एक हाथ खप्पर,दोसर हाथ भिक्षा पात्र ,तेसर पिनाक,चारिम तीर,पाँचम त्रिशूल,छठम अभय ,हाथी क चाम पहिरने,बघम्म्बर ओढने ,सौसे शरीर पर साँप ,मैना बर के देखैत इ चिचिएत मूर्क्षित भय गेलि –कि एहन बर संगे हमर सुकुमारी गौरी कोना रहती .जिद्दी छौङी ,इ कि कयले II");
                 nextTitle.setText("");
                 nextKatha.setText("");
                 break;

             case("9"):
                 tooltext.setText("Day 9");
                 mediacard.setText("Katha of Day 9");

                 startPoojaDay.setText("Start Pooja for Day Nine");
                 mainKatha.setText("मैना क मोह भंग\n" +
                         "\n" +
                         "\n" +
                         "\n" +
                         "\n" +
                         " \n" +
                         "\n" +
                         "मैना के कोनों तरहे होश में आनल गेल आ जखन ओ होश में एयलि त नारद क फजिहत कर लागलि – नारद अहाँ त हमरा सब के कतहु मुँह देखेवर जोगर नहि रह देलउं I अहाँ त महा ठग छी I अहाँ कहलऊ महादेव एना छैथ ओना छैथ हुनका पएवाक् लेल गौरी तपस्या करथु I हमरा बेटी के अपमान भेल सं अलग आ एहन बर I कतए  छैथ ओ सप्तॠषि आ कतए वशिष्ठ ,हुनका सब के कि हेतैन , मनोरथ त हमर मनहि रहि गेल इ I हे गौरी तोरा कि भेलौ जे एहन सुन्दर- सुन्दर देवता सब छोङि एहन कुरूप वर लेल तुं तपस्या केलअ I इ कहैत मैना एकांत में जा कानए लागलि I ब्रह्मा कहलखिन-कि महादेव सब देवता में पैघ छैथ मुदा मैना टस-स मस नहि भेलखिन I  दसो दिक्पाल (सूर्य,अग्नि,यम,नैॠति ,वरुण,ईशान,ब्रह्मा तथा शेषनाग आदि)मिली क मैना क बुझेलखिन ,मैना  कहलखिन कि हम गौरी क जहर द देव मुदा एहन कुरूप वर सं गौरी क विवाह नहि करब I\n" +
                         "\n" +
                         "हिमालय एलखिन आ मैना क कहलखिन –कि किया एना बताहि जेकाँ  कैरत छी ,त्रिलोकिनाथ स्वंग द्वार पर आयल छैथ आ अहाँ जिद केने बैसल छी , मुदा मैना कहलखिन – गौर क पाथरि में बानहि  पोखैर में डूबा देवई मुदा ओकर विवाह महादेव सं नहि करब I विष्णु सेहो मनेलखिन  मुदा मैना अपना बात धेने बैसल रहलि I तखन नारद महदेव क कहलखिन जे –हे भोले नाथ आब अपन भाभट समटू आ अपन स्वरुप सुन्दर कय गौरी के देल वरदान के पूरा करु I\n" +
                         "\n" +
                         "भोलेनाथ अपन रूप बदलि देल ,तखन नारद मैना क कहलखिन कि आब कोप भवन सं निकलू आ महादेव क देखू ओ केहन  छैथ I आ जखन मैना महादेव दिस घूरी क देखलखिन त देखते रही गेलि I सूर्य सं चमकैत सुन्दर आँखि ,मोतीक माणिक गहना ,सूर्य हुनका छत्र ओढौने,चंद्रमा चामदार डोलबैत ,गंगा यमुना पाछू चामर धएने .ब्रह्मा ,विष्णु इन्द्र आ ॠषि हुनकर जय जयकार करैत ,गंधर्व अप्सरा गीत आ नृत्य  करैत ,मैना चकित रहि गेलि आ मोने मोन प्रस्सन भेलि आ अपना भाभट पर पछतै लागलिह II\n" +
                         "\n");
                 nextTitle.setText("गौरी क विवाह");
                 nextKatha.setText("महादेव बर-बरियाती संगे हिमालय क द्वार पर पहुँचला ,मैना हुनकर सभ हक परिछन केलखिन स्त्रिगण सब गीत गबैत मैना क संग देलखिन I सब लोग वर क रूप देखि काठपुतली जेकाँ ठाङ भ गेल I बर के मङवा पर आनल गेल I हिमालय हुनका अहॅणा केलखिन I ओंठगर कुटल गेल I महादेव कोहवर घर सं गौरी क हाथ पकङि अनलखिन I वर के रेशमी धोती ,फूल तथा सोना क माला पाहिरायल गेल I वर कनियाँ के आम पल्लव केर कंगन पाहिरायल गेल I ॠषि सब गोत्रध्याय पढाओल I हिमालय कन्यादान केलखिन ,शिव गौरी वेदी पर गेलाह I अग्नि क आव्वाहन कय हवन कएल गेल ,आ विवाह  बिधि-विधान सं संम्पन्न कएल गेल I सब लोक दुनू गोटा के आशीर्वाद देलखिन I गौरी-शंकर कुलदेवता क प्रणाम करि भोजन सं निवृत भय विश्राम करए गेला I तखन बरियाती सब के भोजन आ सत्कार कएल गेल I मैना अपन अज्ञातवाश लेल सब सं क्षमा मंगलैथ I त सब बरियाती सब कहलखिन कि – इ त त्रिलोकीनाथ क लीला छेलनि I अहाँ सब के सौभाग्य बढय I आब हमरालोकनिक जयवाक आज्ञा दिय I आगाँ –आँगा शिव-गौरी बसहां पर बरियाती सब संगे आ पाछू-पाछू  हिमालय अपना परिवार संगे अरियातई लेल चलला ,किछु दूर बाद हिमालय लोकनि भारी मान सं बेटी क विदा क अपना घर घुरी आयलाह II");
                 break;

             case("10"):
                 tooltext.setText("Day 10");
                 mediacard.setText("Katha of Day 10");

                 startPoojaDay.setText("Start Pooja for Day Ten");
                 mainKatha.setText("कार्तिक क जन्म\n" +
                         "\n" +
                         "\n" +
                         "एक बेर महादेव गौरी संग सम्भोग क इक्षा सं निर्जन वन में जा सुगन्धित झाङी में सम्भोग रत भ गेला I  कातेक दिन बीत गेल I सब देवता लोकनि के चिंता होमय लागल ,सब ब्रह्मा लग गेला  ब्रह्मा कहलैथ –चिंता जुनि करू सब कल्याण होयत मुदा एतबा ध्यान राखल जाएल  जे यदि गौरी पेट सं इ संतान होयत त ओ समस्त संसार क नाश कय देत I ते अहाँ सब महादेव क सम्भोग सं निवृत करबाक प्रयास करू I देवता सब वन में जा हल्ला कर लगला जाहि सं महादेव त सम्भोग सं निवृत भय गेला मुदा हुनकर अंश पृथ्वी पर खासि पङल I गौरी एही सं क्रोधित भय गेली आ सब के श्राप देलखिन जे देवता सब के कहियो सम्भोग सं संतान नहि हेतनि I\n" +
                         "\n" +
                         "महादेव क अंश क पृथ्वी नहि सहन क सकल त ओ ओकरा अग्नि में फेक देलक ,असमर्थ अग्नि ओकरा सरपत वन में I ओतय जा  ओ अंश छह मुँह बाला बच्चा भय गेल I ओहि वाटे कृतिका सब जैत छल I ओ सब ओहि कानैत बच्चा क उठा क पोसलक ,ताहि सं बच्चा क नाम कार्तिकेय पङल I गणेश क जन्म क बाद जखन गौरी क कर्तिकेय क बारे में पता चलल त ओ हुनका अपना लग बजा लेलखिन I देवता लोक हुनकर अभिषेक क हुनका देवता क सेनापति बनेलखिन I कार्तिकेय तारकासुर के मारि इन्द्र क हुनकर राज्य वापस केलखिन I कार्तिकेय क विवाह साठी सं  भेलनि II");
                 nextTitle.setText("गणेश क जन्म");
                 nextKatha.setText("देवता लोकनि के विघ्न वाधा सं प्रथम सम्भोग असफल भेला सं गौरी खिन्न आ रुष्ट रह लागलि तँ महादेव हुनका सं हुनकर खिन्नता क कारण पुछलखिन I ताहि पर गौरी कहलखिन –अहाँ\n" +
                         "\n" +
                         "अंतर्यामी छी फेर हमर बात कियाक नई बुछैत छी I स्त्रीगण लेल सब सं पैघ सुख नीक पुरुष संग सम्भोग करब थीक .ओहि में कुनु विघ्न-वाधा होइत छैक त यहि सं बढि क कोनों दुःख नहि I एही दुःख सं स्त्री दिनानुदिन खिन्न आ झक्की स्वभाव क भय जाइत छै I एकटा क सम्भोग में विघ्न दोसर अहाँ क अंश धरती पर खासि पङल I जकर स्वामी त्रिलोकीनाथ ओकरा  संतान  नहि Iआब यहि सं बढि क आर कों दुःख I हम कों उपाय करू से कहू I\n" +
                         "\n" +
                         "महादेव कहलखिन –हे प्रिये !अहाँ निराश नइ होउ I माघ सुदि त्रयोदशी सुपुष्प नामक विष्णु व्रत करू अहाँ क मनोकामना पूर्ण होयत I गौरी प्रसन्न भय अगिला माघ सुपुष्प व्रत नियम पूर्वक कयलानि I व्रत समाप्त क गौरी महादेव संग कैलाश क एक निर्जन स्थान पर सुख विलाश करय लागलि I जखन महादेव क अंश खासबाक समय आयल त विष्णु एक टा बुढ तपस्वी ब्राह्मण क रूप लय हुनका द्वार पर ठाढ भय हाक पाङ लगला –हे परम पिता महादेव आ जग माता गौरी ! हमरा किछु भोजन दय हमर प्राण क रक्षा करू I हाक सुनि दुनू गोटए धरफडाय  उठि दौङला जाहि सं महादेव क अंश पंलग पर खसि पङल I गौरी महादेव ब्राह्मण क सेवा में लागि गेला I तत्क्षण ब्राह्मण अंतर्ध्यान भय गेला आ आकाशवाणी भेल-गौरी अहाँ क व्रत क फल अहाँ क संतान  पंलग खेला रहल ऐछ ,जाऊ ह्रदय जुराऊ आ जीवन सफल करू I गौरी घर जा देखलखिन त पलग पर एक टा सुन्दर बालक अपन अगूंठा चुसैत खेलाइत छल I दुनू गोटा आनंदिंत भय गेला I कैलाश पर महोत्सव भेल जाहि में सब देवता,ऋषि आ हिमालय परिवार सहित सम्मलित भेलैथI बच्चा क नाम गणेश राखल गेल I एही उत्सव में शनि सेहो आयल छेलैथ गौरी क आग्रह पर ओ बच्चा के ओछेपे देखलखिन त गणेश क गरदनि काटि गेल I विष्णु एकटा हाथी  क बच्चा क गरदनि जोङि अमृत छिटि हुनका जिआउल I ओहि दिन सं गणेश क मुख हाथी  क छैन I गणेश क विवाह दक्षप्रजापति क बेटी पुष्टि सं भेलनि  II  \n" +
                         "\n" +
                         " \n" +
                         "\n" +
                         "गौरी क ननदि\n" +
                         "\n" +
                         "\n" +
                         "गौरी एक दिन महादेव सं कहलखिन जे – हे महादेव देखैत छिअइ सब हक ननदि अबैत छैथ हमरो सेहेंता होइत अछि जे हमरो ननदि अबितैथ I महादेव कहलखिन गौरी सेहेंता नई करू अहाँ ननदि केर भार नहि सकी सकब I परन्तु गौरी जिद ठानी लेलखिन कि ननदि कि बजायल जाय I तखन महादेव अपना बहिन आशाबरी देवी क बजेलखिन I आशाबरी एलखिन I हुनका पैर में बेमाय फाटल छेलैन I  हँसी –हँसी में एक दिन ओ गौरी क अपना बेमाय में नुका रखलखिन I  महादेव जखन घर अएलाह त गौरी क हाँक पारलखिन ,गौरी त ननदि क बेमाय में कानैत बैसल छेली I ज्यो आशाबरी पटकलथिन ,गौरी भट्ट सं खसलखिन I दुनू भई बहिन भभाह क हंस लगला I एकदिन महादेव बहुत रास माछ अनलैथ I गौरी बङ  प्रेम सं बनेलखिन आ स्नेह सं अपना ननदि क कहलखिन – अहाँ धि-सुहासिन छि ,पहिने अहाँ खा लिय तखन हम सब खायब I आशाबरी खाय लागलि आ खाईत खाइत सब टा खा गेलखिन I बेचारी गौरी आशाबरी क परिचर्या सं आब तंग भय गेली आ महादेव क कहलखिन जे –आंब  हिनका पठाऊ ,नई त कुनु दिन ई हमरो खा जेति I महादेव कहलखिन –तें हम अहाँ क कहने रहि कि सेहेंता नहि करू अहाँ अपना ननदि क भार नहि उठा सकब ,लेकिन अहाँ क जिद क देलउ आ आब अहाँ एतबे दिन में तंग भय गेलौ ,राखिओं किछ दिन आओर I गौरी नेहोरा करय लागलि त महादेव बहिन आशाबरी क बुझा –सुझा क विदा केलखिन II\n" +
                         "\n" +
                         "गौरी क भगिन\n" +
                         "\n" +
                         "\n" +
                         " \n" +
                         "\n" +
                         "महादेव क एकदिन गौरी कहलखि –हे महादेव ,सब हक भगिन अबैत  जाइत ऐछ ,मामी संग हंसी खेल करैत ऐछI  हमरा तकर बर सेहेंता होइत ऐछ I महादेव कहलखि – ननदि क त सेहेंता पुरि गेल आब भगिन क सेहन्ता सेहो पुरि जायत मुदा बाद में हमरा नहि उलाहना देव I गौरी गंगा जल भर गेलि ,खूब जोर सं पुरवा पछवा बह लागल ,एहन कि गौरी क सबटा वस्त्र उङ लागलैन I गौरी महादेव क कहलखिन –दे खू त इ बसात हमरा बेनग्न क देत I महादेव कहलखिन –इ बसात पुरवा-पछवा अहाँ के भागिन छि I दुनू गोटा अहाँ सं हंसी –मजाक आ धूर्तता  क रहल छैथ आ अहाँ क सेहेंता पूरा रहल छैथ I गौरी कहलखिन –जेहिना अहाँ सं कियो पार नहि पावि सकैत अछि तहिना अहाँ क सर-सम्बन्धी सब सं नहीं पाओत हटाऊ अपना भगिन सब के I महादेव इशारा केलखिन त बसात रुकि गेल II\n" +
                         "\n");
                 break;

             case("11"):
                 tooltext.setText("Day 11");
                 mediacard.setText("Katha of Day 11");

                 startPoojaDay.setText("Start Pooja for Day Eleven");
                 mainKatha.setText("संध्या क विवाह आ लीली क जन्म\n" +
                         "\n" +
                         "\n" +
                         "हिमालय क पाँचम बेटी संध्या जे गौरी क विवाह क समय महादेव सं हिल-मिल गेल छेलि I महादेव हुनका बङ मानैत छलखिन I जखन ओ विवाह लायक भेलि त महादेव गौरी सं चोरा  क हुनका सं विवाह लेल गेला आ जखन इ बात गौरी क पता लागल त ओ शोकातुर भय गेलि I ओ बैस क कानय लागलि ,कनैत-कनैत हुनका देह सं घाम चल लागल I घाम चुला सं देह सं मैल छूट लागलैन I सब मैल क जमा क ओ एकटा साँप क आकार बना बाट पर राखि देलखिन I जखन महादेव विवाह क घुरलाह देखैत छैथ जे गौरी दहो-बहों  कानि रहल छैथ आ बाट पर मैल क साँप राखल अछि I महादेव ओहि साँप में प्राण दए  देलैथ  आ गौरी क कहलखिन – अहाँ कनैत कियाक छि ? इ साँप अहाँ क बेटी थिक आ एकरहि संग खेलेवा लेल हम संध्या क अनलियनि हं I तखन गौरी हँसलि आ ओहि साँप क नाम लीली रखलखिन II\n" +
                         "\n");
                 nextTitle.setText("लीली क विवाह");
                 nextKatha.setText("नाहर नामक एक टा राजा छलैथ I हुनका अपना रानी ताँती  सं एक सौ बेटा रहनि ,जाहि में बैरसी जेठ आ हुनका सं छोट चनाइ छेलखिन I बैरसी जखन पैघ भेला त नौकरी लेल महादेव लग गेलैथ आ महादेव क अपना बेटी लीली लेल सेहो नौकर क खगता छेलनि तें ओ ओकरा लीली क चाकरी  लेल राखि लेलैथ I एक दिन महादेव बैरसी क कहलखिन – लीली क धर्मकुंड में स्नान कर देबनि आ सोहाग कुंड में अगूंठा दूबा देबनि I बैरसी धोखा में उल्टा बुझि गेलखिन I ओ लीली क धर्मकुंड में अगूंठा डूबबा देलखिन आ सोहाग कुंड में नहा देलखिन I तें लीली क सोहाग त पैघ भेलनि मुदा धर्म लेश मात्र भेलनि I विवाह योग्य भेला पर जखन महादेव लीली लेल वर ताक लगला त लीली कहलखिन जे – हमरा लेल वर नहि ताकू ,हम बैरसी सं विवाह करब I तखन लीली क विवाह बैरसी सं भेलनि II");
                 break;

             case("12"):
                 tooltext.setText("Day 12");
                 mediacard.setText("Katha of Day 12");

                 startPoojaDay.setText("Start Pooja for Day Tweleve");
                 mainKatha.setText("बाल-बसंत\n" +
                         "\n" +
                         "\n" +
                         "एक ब्राह्मण क सात पुत्र छेलनि I छोटकी पुतहु छोट घर सं छेलखिन I ओकरा पर हमेशा सासु तमसेल रहैत छलखिन ,कहियो ओकरा निक-निकुत खेबाक लेल नहि दइ छेलखिन I कनियाँ जखन गर्भवती भेलखिन त हुनका नीक-निकुत खेबाक इक्षा होइत छेलनि मुदा मन मरि क रहै पङैत छेलनि I ओ इ बात एक दिन अपना स्वामी क कहलखिन त ओ एकटा उपाय केलैथ I ओ अपना माँ क कहलखिन जे – हे माय आई हमरा खीर-पूरी खेबाक इक्षा भय रहल एछि I हम खेत पर जा रहल छि अहाँ हमरा कनियाँ संगे खिर-पूरी बाँध पर पठा  देब I माय त चंट ओ बेटा क भावना बुझि गेलखिन I कनियाँ क क जीह पर किछु लिख देलखिन आ हाथ में खीर-पूरी दय कहलखिन –जा धरि अहाँ बाँध पर सं घुरी के नहीं आयब ताबत धरि इ जीह पर लिखल रहवाक चाही I कनियाँ खीर-पूरी ल खेत पर गेलैथ आ स्वामी क देलखिन त ओ आधा खा ,आधा कनियाँ क खाई लेल देलखिन त कनियाँ कहलखिन –हम कोना खायब ,अहाँ क माय हमरा जीह पर किछु लिख देने छैथ I त ओ कहलैथ इ कतउ नुका क राखि लेब आ जखन माय जीह देख लेत त खा लेब I कनिया घुरी क खीर-पूरी पीपर गाछ क धोधैर में नुका क राखि देलखिन आ अपना सासू क जीह देखा देलखिन I आ बाद में जखन दोधैर में ताकय लेल गेलखिन त देखलखिन कि कियो सबटा खिर-पूरी खा गेल एछि I ओ दुखी भय गेली आ बजाय लागलि\n" +
                         "\n" +
                         "आशा भेल निराशा ,झांझर भेल पलास I\n" +
                         "\n" +
                         "जे मोरा खेलनि खिरया पुरिया ,तिनका पुरनि आस II\n" +
                         "\n" +
                         "ओहि धोधैर में में एकटा गर्भवती नागिन रहैत छल ओ खीर पूरी खा लेने रहा I ओकरा किछु दिन बाद दु टा बच्चा पोया भेलैन ,बाल आ बसंत I दुनू पोया ब्राह्मण क खेत में खेलाइत रहैत छेलैथ I एक दिन किछु बच्चा सब दुनू पोया क माङइ लेल खिहाङ लागलइ I कनियाँ क दया आबि गेल ओ दूनु पोआ क अपना लग पथिया में झापि लेलथि आ जखन बच्चा सब चलि गेल त ओकरा दुनू क छोङि देलखिन I इ बात बाल,बसंत अपना माय क कहलखिन,त माया कहलखिन जे  – जे तोरा पर अतेक उपकार केलकउ तकर तोहूँ उपकार करिहनि I दोसर दिन जखन कनियाँ खेत पर गेलि त बाल,बसंत हुनका लग गेलखिन आ कहलखिन –हम दुनू वासुकी नाग क बेटा छि काल्हि अहाँ हमर प्राण रक्षा केलहु ताहि सं हम अहाँ पर प्रस्सन छि ,हमरा सब वर मांगू I ताहि पर कनियाँ कहलखिन –हमरा नैहर क आसरा होएय,इहा वर दिय I दोसर दिन बाल बसंत मनुष्य रूप धरि कनिया क ओतय गेलखिन आ हुनका सासू सं कहलखिन – हम दुनू कनियाँ क भई छि ,हमर सभक जन्म दुइरागमन क बाद भेल ऐछ तें अहाँ हमरा नइ चिन्हैत छि I हम सब बहिन के नैहर लय जेवाक लेल एलियन हं I कनियाँ क इक्षा आ भई क जिद पर सासू कनियाँ क विदा क देलखिन I तीनू बिदा भय गेलैथ आ एकटा बीहाङ सं होइत महल में पहूचँलैथ I ओतय बसुकिनी मनुष्य रूप में हुनकर स्वागत केलखिन I कनियाँ ओहि महल में आराम सं रह लागलि I बसुकिनी कहलखिन – सुहासिन क काज होइत अछि घर में इजोत रखनइ तें अहाँ नित्य दिन साँझ में दीअठि पर दीप जराउ I कनियाँ नित्य संध्या दीप लेसि दीअठि पर राखि देथिन I जकरा ओ दीअठि बुझैत छेलखिन ओ वासुकीनाग क फन छल I दीप गरम भेला सं वासुकी क चैन पाक लगलैन आ फोंका भय गेलनि,त ओ तमसा क कनियाँ क डसवा लेल उद्दत भेला I बसुकिनी हुनका रोक लागलि – सुहासिन क सुख साधारण नहि  छैक I जखन ओकर जन्म होइत अछि तखने सं बाप क चानि तबए लागौत ऐछ ,कि केहन  एकर स्वभाव हेतई ,कहाँ घर-वर हेतई ,कोना अनचिन्हार संग संमय काटत ,सासुर में एकरा सुख होयत कि दुःख,यश होयत कि अपयश ,एही सब चिंता सं बाप सतत चिंतित रहैत ऐछ आ ओकर चानि गरम रहै ऐछ तें एकरा एतय दु र नहि कहिओक नइ त अपना अपयश होयत I काल्हि हम एकरा सासुर विदा क देवई तखन अहाँ क जे फुराय से करब I\n" +
                         "\n" +
                         "दोसर दिन बसुकिनी कनियाँ क नुआ ,गहना ,लहठी ,सार-सामान द दुनू भई संगे सासुर लेल विदा कर लागलि त जाइत काल कनियाँ सं कहलखिन कि राति में सुतए काल इ मंत्र पढि लेब तखन सुतब\n" +
                         "\n" +
                         "दीप- दिपहारा जागू हारा मोती मानिक करू धरा I\n" +
                         "\n" +
                         "नाग बढतु ,नागिन बढतु ,पाँचो बहिन बिसहरा बढ़थू I\n" +
                         "\n" +
                         "बाल-बसंत भय बढ़तु ,डाढि-खोढि मौसी बढ़थू  I\n" +
                         "\n" +
                         "आशावरी पीसी बढ़थू ,सोना-मोना मामा बढ़थू I\n" +
                         "\n" +
                         "राही शब्द लय सूती ,काँसा शब्द लय उठी I\n" +
                         "\n" +
                         "होइत प्रात सोना क कटोरा में दूध-भात खाइ I\n" +
                         "\n" +
                         "साँझ सूती ,प्रात उठी ,पटोर पहिरी ,कचोर ओढ़ी I\n" +
                         "\n" +
                         "ब्रह्मा क देल कोदारी ,विष्णु चाँछल बाट I\n" +
                         "\n" +
                         "भाग रे भाग कीङा –मकोङा ,ताहि बाते अओता I\n" +
                         "\n" +
                         "ईश्वर महादेव ,पङए गरुङ के ठाठ I\n" +
                         "\n" +
                         "आस्तिक आस्तिक आस्तिक II\n" +
                         "\n" +
                         "बासुकी किछु दिन बॉद कनियाँ क डसवा लेल ओकर सासुर एलैथ I कनिया प्रतिदिन बसुकिनी देल मंत्र पढैत छलैथ जाहि सुनि बासुकी क हुनका डसवाक साहस नहि होइत छलनि I तीन राति बासुकी कनियाँ क डसबाक प्रयास केलैथ मुदा मंत्र सुनि ठमकि जाइत छेलैथ चारिम दिन बासुकी तमसा क हुनकर सासू क डसि लेलखिन आ तीन बेर अपन पूंछ पटकि क वापस भय गेला .पूंछ पटकला सं घर में घर सोना –चांदी मानिक सब सं भरी गेल आ कनियाँ अपना बर संगे खुशी खुशी रह लागलि II\n" +
                         "\n");
                 nextTitle.setText("गोसाँउनि क कथा");
                 nextKatha.setText("मधस्थ एकटा राजा  छलैथ जिनका एक सौ एक बेटी छेलनि I सब सं पैघ बेटी क नाम गोसाँउनि छल जे बङ सुन्दर और सुलक्षणी छेली I जखन ओ विवाह क योग्य भेलैथ त राजा विचारलैथ जे अपना बेटी क विवाह ओहन वर सं करि जकरा सौ टा भाय होएन जाहि सं सब बेटी एके घर जाय I सयोग सं नाहर राजा ,जिनकर जेठ बेटा रहथिन बैरसी ,क एक सौ पुत्र छेलैन I  गोसाँउनी क विवाह बैरसी आ हुनकर सौ भाइ क विवाह सौ बहिन सं भेलनि I बैरसी क विवाह काल हुनका पाग सं एकटा साँप खसलानि जे बैरसी क पहिल पत्नी महादेव क बेटी लीली छलखिन I राजा मधस्थ क जखन पता चलल कि बैरसी विवाहित छैथ त ओ बैरसी आ लीली क डाबर में फेकवा देलैथ मुदा गोसाउनि क निहोरा पर कि ओ सौतिन संगे  रही जेति राजा मानलखिन त मुदा बैरसी क श्राप देलखिन जे यदि ओ डेग पिछू पान क बिङिया,खाईत रहताह ,आ कोस पिछू कोनों तिरिया सं गप्प  करैत रहताह त जीता नहि त मरि जयताह I\n" +
                         "\n" +
                         "गोसाउनि क जखन मुह बज्जी होइत रहेंन  त  बीच में लीली बैस क गप्प कर लगलि जाहि सं गोसाउनि क बङ तामस भेलानि-ओ लीली क कहलखिन –\n" +
                         "\n" +
                         "लीली गे !तों आङ क झिल्ली ,तार-मसूर सन तोहर केस\n" +
                         "\n" +
                         "भाग-भाग गे लीली !हट तों ,तोरा धर्मक छौ नहि लेस\n" +
                         "\n" +
                         "दोसर दिन भरि आँगन बालू बिछा जाहि सं लीली नाहि आबि सकै ,बैरसी सं गप्प करय बैसली मुदा फेर लीली बालू पर कंगना सब राखि घर में पैस गेलि आ बैरसी सं गप्प कर लागलि I ओ फेर लीली क दुत्कारलखिन –\n" +
                         "\n" +
                         "कारी गे !कचनारी ,कारी भाग पसारी\n" +
                         "\n" +
                         "कर्म दोष कि मेटतौ ,जानि कियो नहि पौतो\n" +
                         "\n" +
                         "द्विरागमन भेला पर गोसाउनि सासुर ऐली ,एतय हुनका सासू तन बड मानथिन मुदा बैरसी हमेशा लीली में लागल रहैत छलैथ .ओ सासू क इ बात कहलखिन त सासू कहलखिन जे –\n" +
                         "\n" +
                         "सासू सोहागिनि चिनवार चढि बैसथु\n" +
                         "\n" +
                         "साँए  सोहागिन नहिरा जा बैसथु\n" +
                         "\n" +
                         "चनाइ  ओ बैरसी\n" +
                         "\n" +
                         "गोसाउनि क बैरसी सं कखनो भेँट नहि  होइन जाहि सं ओ हमेशा दुखी रहैत छलैथ ,हुनका कुनु संतान सेहो नहीं भेलैन I ओ अपन दुःख अपना दिओर चनाइ क कहलखिन I चनाइ एक टा उपाय सोच लेथ I ओ बैरसी क कहलखिन कि जे –अहाँ हमेशा घर बैसल रहैत छि ,कखनो घूमबाक लेल बाहर चलू I ताहि पर बैरसी कहलखिन जे अहाँ त जनैत छि  जे हमरा ससुर क श्राप अछि जे ज्यो हमरा डेग पाछू बिरिया आ कोस पाछू तिरिया नहीं भेटत त हम मरि जायब I त चनाइ कहलखिन अहाँ चलू त हम सब ध्यान राखब I चनाइ यात्रा क तैयारी में लागी गेलैथ I ओ पाँच पाँच कोस पर खेमा खसेलैथ जतए आराम कयल जा सके ,आ गोसाउनि क सिखा देलखिन जे अहाँ प्रतिदिन भेष बदली खेमा में रहब आ संग में पासा राखब I ओतय भाई सं भेट हैत आ ओतहि निसानी रूप में  पासा जमीन में गाङी देब I\n" +
                         "\n" +
                         "बैरसी जखन यात्रा में बिदा भेला त चनाइ एक मोटा पान ल लेलनि आ डेग डेग पर बैरसी क  बिरिया पान देने जाथि I बैरसी कोस कोस पर जे तिरिया भेटनि टकरा टोकि दैत छेलखिन I जखन ओ पहिल कोस गेला ट हुनका भांग खेबाक मोन  भेलनि I ओ चारि सखि क पैन भरैत देखलखिन त हुनका सब के कहलखिन –\n" +
                         "\n" +
                         "बच्ची ! आं पिया गट-गट्ट I\n" +
                         "\n" +
                         "बच्ची ! आं पिया गट-गट्ट I\n" +
                         "\n" +
                         "सखि सब नहि बुझलखिन .पहिल सखि कहलखिन\n" +
                         "\n" +
                         "गँहीर कुआँ के निर्मल पानी ओ डोलंन के ठठ् I\n" +
                         "\n" +
                         "हम भरिहें तों पीहें बटोहिया .तब मचिहें गट गट्ट II\n" +
                         "\n" +
                         "बैरसी कहलखिन –\n" +
                         "\n" +
                         "नहि बच्ची ! आं पिया गट-गट्ट I\n" +
                         "\n" +
                         "दोसर सखि कहलखिन –\n" +
                         "\n" +
                         "तप्पत चूल्हा ,गरम कराही ,ओ धीबन के ठठ्ठ I\n" +
                         "\n" +
                         "हम छानब तू खयबे बटोहिया ! तब मचिहें गट गट्ट II\n" +
                         "\n" +
                         "बैरसी कहलखिन –\n" +
                         "\n" +
                         "बच्ची ! एही नहि गट गट्ट .बच्ची ! आन पिया गट गट I\n" +
                         "\n" +
                         "तेसर कहलखिन –\n" +
                         "\n" +
                         "लाल पलंग पर दरी बिछौना ,ओ तकिया के ठठ्ठ I\n" +
                         "\n" +
                         "हम सुतब तू सुतिहे बटोहिया ! तब मचिहें गट गट्ट I\n" +
                         "\n" +
                         "चारिम सखि बुझि गेलखिन आ कहलखिन –\n" +
                         "\n" +
                         "लाल लछ्छी केर हरियर पत्ती ओ मरीच  के ठठ्ठ I\n" +
                         "\n" +
                         "हम पीसी तुं पीबें बटोहिया ,तब मचिहे गट गट्ट II\n" +
                         "\n" +
                         "बैरसी कहलखिन –\n" +
                         "\n" +
                         "हँ  बच्ची  ! एही कही गट गट्ट II\n" +
                         "\n" +
                         "सब सखि मिली भाँग पीसी क बैरसी क देलखिन आ बैरसी ओ पीबी प्रस्सन भय आगु बढलैथ आ एक कोस बाद  देखलखिन जे खङहोरी में एकटा स्त्री सीकी चिरैत छल I बैरसी ओकरा टोकलखिन –\n" +
                         "\n" +
                         "सीकी चिरैत छथि,डाँ र लिबैत छनि ,डाँर खसैत छनि केश I\n" +
                         "\n" +
                         "एहन धनि ज्यो हमरो रहितथि ,सोने मढवितहूँ  भेष II\n" +
                         "\n" +
                         "स्त्री उत्तर देलखिन –\n" +
                         "\n" +
                         "चक चक गोर ,पान मुख शोभनि ,सिर ओंठिया केश I\n" +
                         "\n" +
                         "एहन पिया जो हमरहु रहितथि ,सोने मढबितौंहू भेष II\n" +
                         "\n" +
                         "बैरसी तेसर कोस में एकटा स्त्री के चिपङी पाथैत देखलखिन त कहलखिन –\n" +
                         "\n" +
                         "चिपङी थापय चटा पटी की , लट झिल्काएब केश I\n" +
                         "\n" +
                         "कनखी भाँजए छन छन गोरी ,तोर पिया की बेस II\n" +
                         "\n" +
                         "स्त्री उत्तर देलखिन –\n" +
                         "\n" +
                         "पान खाए मुख फेरए डंटा ,हाथी मारि बनए बलवंता I\n" +
                         "\n" +
                         "सिंह मारि करए शिकार ,ताहि पुरुष के हम बहु आरि II\n" +
                         "\n" +
                         "चारिम कोस पर एक टा दुबर पातर स्त्री क बैरसी टोकलखिन –\n" +
                         "\n" +
                         "सिकिया सन धनि पातरि ,फूल भरि अन्न ना खाय I\n" +
                         "\n" +
                         "जँ छुबनि एक अंग, त लोचन टूटि –फूटि जाए II\n" +
                         "\n" +
                         "स्त्री उत्तर देलखिन –\n" +
                         "\n" +
                         "अमुआ फङए लदा-लदी, डारि लीबि लीबि जाय I\n" +
                         "\n" +
                         "देखू पिया ! निः शंक, सं ऊपर दैब सहाय II\n" +
                         "\n" +
                         "पाँचम कोस में साँझ परी गेल त बैरसी आराम करय लगला I ओतय राउटी क भेष में गोसाउनि एलखिन आ राति भरि बैरसी संग सुख केलैथ आ चनाइ क कह्लानुसार एक टा पासा पलंग तरी गाङि देलखिन I दोसर दिन फेर बैरसी घूम निकलले त एक टा स्त्री क पोखरि में नाहित देखलखिन त हुनका कहलखिन –\n" +
                         "\n" +
                         "गोरी गे !दह गोरी ,दह पैसी कर सस्न्नान I\n" +
                         "\n" +
                         "योवन तोहर कादो लोटाइ छउ ,कर ब्राह्मण के दान II\n" +
                         "\n" +
                         "युवती कहलखिन –\n" +
                         "\n" +
                         "ब्राह्मण रें तों छूौकङा ,बढि के भेल सियान I\n" +
                         "\n" +
                         "लाख रुपैया जकरो उठल ,सेहो ने कयल लेवान II\n" +
                         "\n" +
                         "बैरसी उत्तर देलखिन –\n" +
                         "\n" +
                         "कोङल खेत ,महूआएल बीया ,पहिने खाएल सारिल सुगवा I\n" +
                         "\n" +
                         "जनमए ,फूटए ,पाकल धान ,तब गिरहस्त करए लिवान II\n" +
                         "\n" +
                         "बैरसी आगु बढला त जलखई लेल केरा किन कान्ह पर लटका लेलैथ I दोसर कोस पर एकटा युवती के खत्ता उप्छैत आ माछ मरैत देखलखिन त ओकटा कहलखिन  –\n" +
                         "\n" +
                         "खत्ता उप्छल ,खुत्ती उप्छल ,मारल रहू बूआर I\n" +
                         "\n" +
                         "योवन तोहर कादो लोटाइ छउ ,टिकुली क कों श्रृंगार II\n" +
                         "\n" +
                         "युवती कहलखिन –\n" +
                         "\n" +
                         "पगिया तोहर लटपट भरिया ,धोती तोहर छितनार I\n" +
                         "\n" +
                         "कान्ह पर केरा भार छउ ,डोपट कों श्रृंगार II\n" +
                         "\n" +
                         "बैरसी लजा क आगु बढ़ला त तेसर कोस जा केरा खा पानि पीबय लेल पोखरि पर बानर क पानि पिबैत देखलखिन त ओहो बानर जेक पानि पीब लगला से देख युवती कहलखिन  –\n" +
                         "\n" +
                         "एक देखू अलवत्त ,पुरुष देखू समर्थ I\n" +
                         "\n" +
                         "मुहँ ल क पानि पीबए ,तकर कि अर्थ II\n" +
                         "\n" +
                         "बैरसी उत्तर देलखिन –\n" +
                         "\n" +
                         "कानल खिजल हे सखि !काजर लागल हत्थ I\n" +
                         "\n" +
                         "मुहँ लय पानि पीबी ,तकर थिक इ अर्थ II\n" +
                         "\n" +
                         "चारिम कोस पर दु सखि गप्प करैत छेलि ,बैरसी क देखि पहिल सखि  सं पूछलखिन –\n" +
                         "\n" +
                         "खटियाँ पर सं पटिया देल ,सोलह फोंका तरबा  भेल I\n" +
                         "\n" +
                         "हम त पूछि हे सखि ,पंथ चलए से जीवए कोना II\n" +
                         "\n" +
                         "दोसर सखि पुछलखिन –\n" +
                         "\n" +
                         "गुल्ल्लरी सं एक निकलल पांखि ,से हम देखल अपने आँखि I\n" +
                         "\n" +
                         "ताहि बसाते खसल पचास,गुल्लारि खाए से जीवए कोना ?\n" +
                         "\n" +
                         "तेसर सखि पुछलक –\n" +
                         "\n" +
                         "अरोसिन- परोसिन कूटलनि धान,ताहि धमक सं बहीर भेल कान I\n" +
                         "\n" +
                         "हे स्वामी हम पूछे छि ,जे चुङा खाय से जीवए कोना II\n" +
                         "\n" +
                         "चारिम पुछलखिन –\n" +
                         "\n" +
                         "दही काट नहु ओर-ओर ,खैंक गरल तहुँ पोरे-पोरे I\n" +
                         "\n" +
                         "पंडित कहथून ह्रदय विचारी ,एही चारु में के सुकुमार II\n" +
                         "\n" +
                         "बैरसी क तुरंत में किछु नई बुझेलनी त ओ कहलैथ कि हम सोची क घूरती काल जबाब देब ताहि पर पाँचम सखि कहलखिन\n" +
                         "\n" +
                         "घर जेएबे घर डिंगर होएबे ,बहु सं अएबे सीखि I\n" +
                         "\n" +
                         "एतबा वचन जँ पहिने कहबे ,पएबे  हमर पिरीति II\n" +
                         "\n" +
                         "पाँचम कोस पर  बैरसी फेर गोसावानी संग राति में  आराम केला आ गोसावानी दोसर पासा पलग तर गाङी देलखिन\n" +
                         "\n" +
                         "तेसर दिन एक कोस पर बैरसी देखलखिन कदम्ब गाछ पर चढि फुल तोरि रहल छैथ त ओ ओकरा कहलखिन –\n" +
                         "\n" +
                         "कदम तोरए कदमावती ,कदमें लत्तर फत्त I\n" +
                         "\n" +
                         "मोर बियहुआ होइते कदमा ! उपर उठबितहूँ छत्त II\n" +
                         "\n" +
                         "युवती कहलखिन-\n" +
                         "\n" +
                         "भल सं भूल लें रे परदेसिया !जँ सरदेसिया होय I\n" +
                         "\n" +
                         "खोपा में जे फुल शोभय ,फुल चंपा होयए II\n" +
                         "\n" +
                         "दोसर कोस पर एकटा स्त्री के चम्पा तोरइत देखलखिन त कहलखिन –\n" +
                         "\n" +
                         "कुसुम तोराए कुसुमावती ,कुसुम लत्ते फत्त\n" +
                         "\n" +
                         "मोर बियहुआ होइते किसुमा,ऊपर उठबितउ छत्त\n" +
                         "\n" +
                         "युवती कहलखिन\n" +
                         "\n" +
                         "होए चंपा केर तीन गुण ,सुन्दर,सुभग सुवास\n" +
                         "\n" +
                         "एक अवगुण मोहे लागी रही,भभरा ने आबय पास\n" +
                         "\n" +
                         "तेसर कोस पर एकटा कवि गोरी  सं बैरसी क भेट भेलनि दुनू में वार्तालाप होमय लगलानि\n" +
                         "\n" +
                         "बैरसी –\n" +
                         "\n" +
                         " लाल झींगुर लाल सिंदूर लाल अरहुल फुल रे i\n" +
                         "\n" +
                         "तहू सं लाल देखल गोरी माथक सिन्दूर रे II\n" +
                         "\n" +
                         "युवती –\n" +
                         "\n" +
                         "लाल दोहा कहले भला,से त भेलहुं बदरंग रे I\n" +
                         "\n" +
                         "हरियर दोहा कहिते भला ,तब त लागितौ रंग रे II\n" +
                         "\n" +
                         "बैरसी –\n" +
                         "\n" +
                         "हरियर लत्ती ,हरियर फत्ती,हरियर भादव धान रे I\n" +
                         "\n" +
                         "ताहू सं हरियर देखल गोरी मुख के पान रे II\n" +
                         "\n" +
                         "युवती –\n" +
                         "\n" +
                         "हरियर दोहा कहले भला ,से त भेलहु बदरंग I\n" +
                         "\n" +
                         "कारी दोहा कहिते भला ,तब त लगितों रंग रे II\n" +
                         "\n" +
                         "बैरसी –\n" +
                         "\n" +
                         "कारी आँजन,कारी भांजन ,कारी भादव मास रे I\n" +
                         "\n" +
                         "ताहू स जे कारी देखल ,गोरी माथक केश रे II\n" +
                         "\n" +
                         "युवती –\n" +
                         "\n" +
                         "करि दोहा कहले भला ,ये त भेलहु बदरंग रे I\n" +
                         "\n" +
                         "पीयर दिहा कहिते भला ,तन त लागिताऊ रंग रे II\n" +
                         "\n" +
                         "बैरसी –\n" +
                         "\n" +
                         "पियर बेंग ,पियर ढाबुस ,पियर हार्दिक रंग रे I\n" +
                         "\n" +
                         "ताहू सं जे पीयर देखल गोरी नामक बेसरि रे  II\n" +
                         "\n" +
                         "युवती –\n" +
                         "\n" +
                         "उचें आरि ऊँचे धुर ,ऊँचे त खलिहान रे I\n" +
                         "\n" +
                         "नीच दोहा कहिते भला,तब त लगितऊ रंग रे II\n" +
                         "\n" +
                         "बैरसी –\n" +
                         "\n" +
                         "नीच आवर नीच डावर,नीच बीच पोखरी रे I\n" +
                         "\n" +
                         "ताहू सं जे नीच देखल ,गोरी आङ क पोखरी रे II\n" +
                         "\n" +
                         "युवती –\n" +
                         "\n" +
                         "नीच दोहा कहल्र भला,से त भेलहु बदरंग रे I\n" +
                         "\n" +
                         "तीत दोहा कहिते भला,तब त लागिताऊ रंग रे II\n" +
                         "\n" +
                         "बैरसी –\n" +
                         "\n" +
                         "तीत नीम,तीत करेला ,तीत हारदिक पात रे I\n" +
                         "\n" +
                         "ताहू सं जे तीत देखल ,गोरी सौतिन ठोर रे II\n" +
                         "\n" +
                         "युवती\n" +
                         "\n" +
                         "तीत दोहा कहल्रे  भला,से त भेलहु बदरंग रे I\n" +
                         "\n" +
                         "गोला  दोहा कहिते भला,तब त लागिताऊ रंग रे II\n" +
                         "\n" +
                         "बैरसी –\n" +
                         "\n" +
                         "गोल नेबो ,गोल अनार,गोल पुरैनिक पात रे I\n" +
                         "\n" +
                         "ताहू सं जे गोल देखल,गोरी क दुनू छाती रे II\n" +
                         "\n" +
                         "युवती –\n" +
                         "\n" +
                         "गोल  दोहा कहल्र भला,से त भेलहु बदरंग रे I\n" +
                         "\n" +
                         "उज्जर दोहा कहिते भला,तब त लागिताऊ रंग रे II\n" +
                         "\n" +
                         "बैरसी –\n" +
                         "\n" +
                         "उज्जर पोठी,उज्जर मारा,उज्जर चन्ना माछ रे I\n" +
                         "\n" +
                         "ताहू सं जे उज्जर देखल गोरी हाथ क सांख रे II\n" +
                         "\n" +
                         "युवती –\n" +
                         "\n" +
                         "दसम  दोहा दशम फुल,दशम गाछ क छाँह रे I\n" +
                         "\n" +
                         "ताः सं जे दशम देखल,गोरी केर विवाह रे II\n" +
                         "\n" +
                         "इ कहि गोरी भागि गेल आ बैरसी अपना खेमा में गोसावानी संगे राति बितेवा लेल आवी गेला .बैरसी पाँच दिन भ्रमण केला बाद चनाइ संगे अपन राजधानी घुरी एलैथ आ गोसावानी अपना पति संग बितेबा क साक्षी पाँच टा पासा चारि टा पलग क चारु पौया निचा आ एक टा पलग क बीच में गाङि प्रसन्ता पूर्वक घर घुरि अएलीह II\n" +
                         "\n" +
                         "गोसावनि देह फाटल\n" +
                         "\n" +
                         "किछु दिन बाद गोसावानी के पाँच टा बेटा भेलनि –ओधू ,कछु ,महाभाग ,श्रीनाग आ नाग श्री I लीली के कुनु संतान नहीं भेलनि I गोसावानी चनाइ क खूब आशीर्वाद देलखिन-\n" +
                         "\n" +
                         "जाहि वां जेता चन्ना चानन होयताह ,ताहि वन होयत पलास I\n" +
                         "\n" +
                         "चानन सैरभ सुरभित रहब ,ज्यो ज्यों बहत बसात II\n" +
                         "\n" +
                         "लीली के बङ  डाह होइत छेलनि ओ अपना सास सं कहलखिन –\n" +
                         "\n" +
                         "गे तांती रानी ! तोहर चनुआ कनुआ बेटा बङ दुःख दैत अछिI\n" +
                         "\n" +
                         "गोसावानी भरल –पुरल छेलि इ देख लीली के अपार कष्ट होइत छल I ओ बैरसी क कान  भर लागलि कि गोसावानी के जे बेटा सब छनि से चनाइ सं छैन आ बैरसी सेहो गोसावानी के पसंद नहि करैत छलैथ त लीली क बात मानि गोसावानी के पुछलखिन त ओ पति संग राति बितेला क सबूत पलग नीचा गारल पाँच टा पासा देखेलखिन I ओ लीली के मन रखवा लेल दुनू गोटा क धर्म परीक्षा करबा सोचलेथ I ओ लीली के अरवा चावल आ खेरही  क दालि देलखिन आ गोसावानी के लोहा क चाउर आ पाथर क दालि देलखिन आ दुनू क रंन्हबाक लेल कहलखिन I .लीली गौराबाहि बिना नियम निष्ठां के भोजन बनेलैथ ,भानस असिछ्छे रही गेलनि .आ गोसावानी धर्मात्मा रहथिन ,नियम निष्ठां सं भोजन बनैलैथ   हुनकर लोहा क चाउर आ पाथर क दालि सीछ गेलनि I सब लोग हुनकर प्रशंसा करय  लगलानि क ओ गौरबे  फाट लगलि  II  ");
                 note.setText("मधुश्ववानी सं एक दिन पहिने कथा समाप्त भेला क बाद कलश छोङि सब देवता क विसर्जन भय जेतइ .पहुलका फूल पात ,अरिपन सब हटा क घर क नीक जेकाँ  स्सफ क पवित्र कैल जायत .साँझ खान वर क परिछन होईतनि .साँझ खान सब टा ओरिआन पंचमी दिन जेक होयत .");
                 note.setVisibility(View.VISIBLE);
                 break;

             case("13"):
                 tooltext.setText("Day 13");
                 mediacard.setText("Katha of Day 13");

                 startPoojaDay.setText("Start Pooja for Day Thirteen");
                 note.setText("सबटा पूजा पंचमी दिन जेनका यथास्थान होयत .आई वर संगे पाछु बैसल रहथिन .\n" +
                         "आई लीली क तेरह टा मौनी जाहि में श्रींगार क समान रहत .जे कनियाँ अहियब सब क देत\n" +
                         "सात टा डाली पर फूलायल चना ,फल मिठाई रहत सेहो अहियब सब के कनियाँ देत\n" +
                         "टेमी लेल –सरवा -1 टेमी -5 ,आरतक पात -7 पान -7");
                 nextTitle.setText("श्री गणेश जी क सोहाग मथब आ बाँटब");
                 nextKatha.setText("मधुश्रावनी दिन गणेशजी माता गौरी क कहलखिन –आई हम सोहाग मथब आ जे मांगत टकरा देबइ I गणेश जी एही प्रयोजन लेल माय सं धान,धनि ,काठ क तामा ,नीम,बेल आ आम क काठी मगलखिन I गणेश जी सोहाग मथ लगला I सोगाग मंगवा लेल पहिने धोबिन आयल गणेश जी हुनका सोहाग देलखिन आ कहलखिन –अहाँ क धोबी भरी दिन नुआ वस्त्र धोयेताह ,भठ्ठी लगोताह आ भरी दिन परिश्रम केला क बाद अहाँ लग घर ऐय्ताह एही सं अहाँ क सोहाग बढ़त I फेर कैथिन एलखिन –गणेशजी हुनका कहलखिन-अहाँ क दीवानजी भरी दिन लिखा पढ़ी करताह आ साँझ खान घर ऐयताह I अहाँ सीकी क  मौनी ,चंगेरी बुनब आ खोपा विन्यास करब ताहि सं अहाँ क सोहाग बढ़त I तखन मलाहिन एलखिन ,हुनका  गणेशजी कहलखिन-अहाँ क मलाह माछ मारता ,जाल बुनता आ अहाँ क देह  मछाइन महकत ताहि सं अहाँ क सोहाग बढत I तखन मलिन एलखिन I गणेशजी हुनका सोहाग द कहलखिन-अहाँ क माली भरी दिन फूल तोरता  साँझ खन माला गुथि  ग्राहक लग पहुचेता ताहि सं अहाँ क सोहाग बढ़त तखन  गोआरि अऐलि गणेशजी हुनका सोहाग दैत कहलखिन-अहाँ क गुआर  गाय महीस चरायात ,भोर साँझ दूध दुहत अहाँ दूध औटब दही पउरब ,घी मथब अहाँ क सोहाग बढ़त I तखन बनिआइन क गणेशजी सोहाग दैत कहलखिन-अहाँ क बनिया भरि दिन सैदा बेचता अहाँ सौदा क फटकी धोई रखबनि अहाँ क सोहाग बढत I सब सं अंत में ब्रह्माणी ऐयेलखिन I ओकरा गणेशजी सोहाग दैत कहलखिन-ब्राह्मण पूजा पाठ करताह ,वेद –पुराण पढ़ताह आ पढ़ेताह I अहाँ जनउ  काटब ,पूजा क ओरिआन करब ,पवित्र सं भानस करब अहाँ क सोहाग बढ़त I एही प्रकार गणेशजी सब में सोहाग देलखिन आ सबके अपना कर्म क अनुसारे उपदेश देलखिन II");
                 note.setVisibility(View.VISIBLE);
                 mainKatha.setText("राजा श्रीकर क कथा\n" +
                         "\n" +
                         "\n" +
                         " श्रीकर नामक एक टा राजा रहैत जिनका परम सुन्दरि एकटा बेटी रहनि I जखन ज्योतिषी बेटी क हाथ देखलक त कहलकनि जे – राजा अहाँ क बेटी क बर दुःख लिखल छनि I हिनका में छनि “छाती लात ,झोंटा हाथ,आ सौतिन क पोखरी में आढाइ झांक माटी उघति “ राजा दुखी भय गेला आ जखन ओ विवाह लायक भेलि त राजा मारि गेला I राजा क बेटा चंद्रकर राज गद्दी पर बैसला I अपन माय क बार बार अनुरोध केला क बादो ओ अपना बहिन क विवाह करवा लेल तैयार नहीं भेला I ओ नहीं चाहैत छलेथ कि हुनका बहिन क क्यों देखनि आ विवाह क हुनका भविष्य में कष्ट दइन I ते ओ एकटा निर्जन स्थान में एक टा पैघ सोन्हि खूनबेलैथ आ ओहि में रहवा लेल एक टा घर बनबेलैथ I एकटा चेरिया संगे अपना बहिन के ओहि घर में राखि  ऊपर  सं सोन्हि क मुँह कनिक हवा जेवाक स्थान छोरि बंद क देलखिन I बहिन मन मारि ओहि में रह लगलि I बस मास दिन में खेबाक पिबाक समान अबैत रहल I\n" +
                         "\n" +
                         "एक दिन सुवर्ण नामक राजा ओहि जंगल में शिकार करवा लेल एलैथ आ हुनका प्यास लगलानि I ओ पानि ताक लगला त देखलखिन जे एक टा भूर सं चुट्टी सब जकर मुँह में भात आ साग छै निकलि रहल ऐछ I राजा सोचलेथ कि जरूर एताहि कुनु मनुष्य रहैत अछि I ओ ओहि सोन्ही में पैस गेलैथ आ हाक परलखिन जे – कियो छि हमरा प्यास लागल ऐछ ,पानि पिअऊ I राजकुमारी अपना चेरी द्वारा पानि पठेलखिन I राजा जखन  चेरी सं पुछलखिन त हुनका ज्ञात भेलनि कि यतए राजकुमारी  रहैत छथिन ,आ जखन ओ राजकुमारी क देखलैथ त ओकर सुंदरता पर मुग्ध भय ओकरा स विवाह कय लेलैथ I किछु दिन ओहि सोन्ही में अपना पत्नी संग बितेला क बाद ओ अपना राजधानी जेवाक इक्षा व्यक्त केलैथ त राजकुमारी  कहलखिन जे-अहाँ जाइ छि त जाऊ मुदा इ बात  मन राखब जे सावन तृतीया के मधुश्रावनी छै ओहि में नव कनियाँ सब पावनि करैत अछि I ओहि दिन कनियाँ सब सासुर क वस्त्र पहिरैत अछि आ सासुरे क अन्न खाईत ऐछ तें अहाँ ककरो दिय जरूर पठा  देव I राजा अपन राजधानी घुरी अयलाह आ जुलाहा क सुन्दर चुनरी बनेवाक आज्ञा देलखिन I राजा क जेठ रानी जिनका  पहिनहिये सं कनी शक रहेन  कि राजा अतेक दिन सं कतय बाहर गायब छलैथ,जरूर ककरो सं विवाह क ओकरे संग हेता आ जखन राजा चुनरी बनेवाक आज्ञा देलखिन त हुनका पूरा विश्वास भय गेलानि I ओ चुपेचाप  जुलाहा लग गेलखि आ कहलखिन – तोँ  ओहि चुनरी में ‘छाती लात आ झोंटा हाथ ‘ किख दहीन ,हम तोरा  डाला भरी सोना देबउ I जोलहा लोभ में आवी क ओहि चुनरी पर ओ बाट लिखी चुनरी क बधिया स मोरि जाहि सं राजा नहि बुझथिंन राजा क चुनरी द ऐल .राजा लग पोसुआ कउआ  छलेन ,ओ ओकरा  ठीक सं पाता बुझा चुनरी एकटा बांस क चोंगा में दय बिदा क देलखिन I कउया रस्ता में एक भोज क अइठ कुठ देखलकै त चोंगा कात में राखि खाय लागल आ फेर चोंगा ओतहि बिसरी गेल I जखन मधुश्रावनी दिन राजकुमारी अपना सासुर सं किछु नहीं आयल त ओ तामसे   उजरा  फूल आ उजरा  चानन  सं गौरी क पूजा क आ हाथ जोरि वर माँगल जे जहिया हमरा अपन वर सं भेंट हुये हम बउक भय जाई I\n" +
                         "\n" +
                         "राजकुमारी क भाय चंद्रकर के जखन पाता लागल कि हुनकर बहिन विवाह क लेलैथ त ओ तमसा क हुनका अन्न पानि पठेनै बंद क देलखिन जाहि सं राजकुमारी आ चेरिया कई दिन तक भूखल रहलि तकर बाद हारि क  दुनू गोटा बाहर निकललि I लग में एक टा पोखैर खुनैत छल ओहि में दुनू माटि उघबाक काज कर लागलि आ जे मजूरी भेटनि ओहि सं दुनू गोटा भोजन करैथ I बाद में हुनका पता चललनि कि पोखैर हुनकर सौतिन खुना रहल छैथ त ओ अपन लिखल मानि क बाजि उठालिह –\n" +
                         "\n" +
                         "सिरकर सिर हि चढ़ाओल ,चंद्रकर देल बनवास I\n" +
                         "\n" +
                         "राजा सुवर्ण बनहि बियाहल ,लिखला नहि परकार II\n" +
                         "\n" +
                         "ओहि दिन राजा सुवर्ण सेहो पोखैर पर आयल छलैथ आ जखन बेर बेर राजकुमारी ओ फकरा पढैत रहलि त हुनका अचानक मोन पङि गेलैन कि ओ केना एक टा राजकुमारी सं जंगल में विवाह केने रहैथ I राजा झट सं माटि उठवई बाली लग गेलथ आ ओकरा देखेत चिन्ह गेलखिन I ओ राजकुमारी क आदर सं अपना महल में आनि नहा सोना,पटोर पहिरा  ,श्रृगार करबेलिथ मुदा राजकुमारी किछु बाजबे नई करथिन त राजा  चेरी सं  कारण पुछलखिन I त चेरी कहलखिन जे –अहाँ जे मधुश्रावनी दिन किछु ने पठेलिअई ते रानी तमसा क भगवान  सं इ वर मग्लैथ  जे ज्यो अहाँ हुनका सामने अयबनि ओ बउक भ जाइथ I राजा तुरंत कउआ  क बजेलैथ ,कउआ क जखन  मोन  परल कि चुनरी कुम्हारा क ओतय छूटि  गेल त फेर कुम्हरा सं पुछल गेल I कुम्हार अपना घर में खोज करेलक त पता लागल कि ओकर पुतहु चुनरी क उठा क कोठी में राखि देने रहा I चुनरी आनि  क कुम्हारा राजा क देलक आ राजा जखन ओहि चुनरी में ‘छाती लात ,झोंटा हाथ ‘लिखल देखलखिन त तमसा क जुलाहा क बजौलैथ I जुलाहा जखन कहलक कि हुनकर जेठ रानी इ बाट लिख्बेने रहैत त राजा क्रोधित भय जेठ रानी त मरबा क गाङि देलखिन I रानी क आब बुझा गेल कि एही सब में राजा क कुनु दोष नहि छल I ओ अगला मधुश्रावनी दिन गौरी क पूजा ललका फूल आ ललका सिन्दूर सं केलैथ त हुनकर बोल सेहो फूटि गेल आ ओ राजा संगे आंनंद सं रह लागलि  II\n" +
                         "\n" +
                         "आम,बेल आ नीम क काठी के बामा हाथ सं पाकरि जाँघ तर राखल तामा जाहि में धान ,धनि ,आ पानि रहतें क मथैत गणेशजी क सोहाग मथबाक कथा सुनति");
                 temiHeading.setVisibility(View.VISIBLE);
                 temi.setText("कथा सुनलाक क बाद अहिअब सब के बामा हाथे कनि कनि सोहाग देथिन\n" +
                         "आब वर के हाथे कनियाँ के सिंदूरदान हेतई\n" +
                         "वर अपना दुनू हाथ में एक एक टा पान आ आरतक पात लेतीं जाहि सं कनिया क आँखि झांपथिन\n" +
                         "बिधकारि बीच में छेद कैल पान क पात ओहि पर छेद कैल आरतक पात कनिया क दुनू ठेहुन आ दुनू पैर आ बामा हाथ क लुलुहा पर राखि देथिन  जाहि ऊपर सं टेमी पङत\n" +
                         "कनिया पूजा पर सं उठी गोसावानी क गोर लगतीं फेर सब श्रेष्ठ सब क बर कनिया गोर लगतैथ\n" +
                         "साँझ खन साँझ,कोहवर क गीत हैट आ निर्मल सब क विसर्जन");
                 temi.setVisibility(View.VISIBLE);
                 break;

         }
     }
 }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mp.isPlaying()) {
            mp.stop();
            mp.reset();
        }
    }

    private void playMedia(String songName) {
        int time = mp.getDuration();
        seekBar.setMax(time / 1000);
        naviday1.setPadding(0, 0, 0, 200);
        mediaLayout.setVisibility(View.VISIBLE);
        mediacard.setText(songName);
        mp.start();
        pause.setVisibility(View.VISIBLE);

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                pause.setVisibility(View.GONE);
                playmini.setVisibility(View.VISIBLE);
            }

        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp.seekTo(progress);
                    seekBar.setProgress(progress);
                }
            }
        });

        //Make sure you update Seekbar on UI thread
        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if(mp != null){
                    int mCurrentPosition = mp.getCurrentPosition() / 1000;
                    seekBar.setProgress(mCurrentPosition);
                }
                mHandler.postDelayed(this, 1000);
            }
        });

    }
}
