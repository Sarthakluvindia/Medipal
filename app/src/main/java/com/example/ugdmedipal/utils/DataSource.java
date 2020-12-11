package com.example.ugdmedipal.utils;

import com.example.ugdmedipal.R;
import com.example.ugdmedipal.model.HeaderTextItem;
import com.example.ugdmedipal.model.PostTextItem;
import com.example.ugdmedipal.model.PostVideoItem;
import com.example.ugdmedipal.model.TimelineItem;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<TimelineItem> getTimelineData(){

        List<TimelineItem> mData = new ArrayList<>();

        HeaderTextItem itemHeader = new HeaderTextItem("Vaccinations");
        TimelineItem headerTimelineItem = new TimelineItem(itemHeader);

        PostTextItem postTextItem = new PostTextItem("At birth primarily 3 vaccinations are given in India. \n 1. Bacillus Calmette–Guérin (BCG) vaccine is a vaccine primarily used against tuberculosis (TB). One dose is recommended in healthy babies as close to the time of birth as possible. \n 2. Oral polio vaccine (OPV 0) is a vaccine used to prevent poliomyelitis (polio). \n 3. Hepatitis B (Hep – B1) prevents against Hepatitis B, the first dose is recommended within 24 hours of birth.", R.drawable.vacc_birth, "At Birth");
        TimelineItem posttextTimelineItem = new TimelineItem(postTextItem);

        PostVideoItem postVideoItem = new PostVideoItem("G0-98gJsVR0",R.drawable.vacc_birth,"2:01");
        TimelineItem postvideoTimelineItem = new TimelineItem(postVideoItem);

        mData.add(headerTimelineItem);
        mData.add(posttextTimelineItem);
        mData.add(postvideoTimelineItem);

        PostTextItem postTextItem2 = new PostTextItem("After 6 weeks of birth 6 vaccinations are given in India. \n 1. Diptheria, Tetanus and Pertussis vaccine (DTwP 1) is a class of combination vaccines against three infectious diseases in humans: diphtheria, pertussis (whooping cough), and tetanus. \n 2. Inactivated polio vaccine (IPV 1). \n 3. Hepatitis B  (Hep – B2). \n4. Haemophilus influenzae type B (Hib 1) is a vaccine used to prevent Haemophilus influenzae type b (Hib) infection. Two or three doses should be given before six months of age. \n5. Rotavirus 1 is a vaccine used to protect against rotavirus infections, which are the leading cause of severe diarrhea among young children. \n6. Pneumococcal conjugate vaccine (PCV 1) is a pneumococcal vaccine and a conjugate vaccine used to protect infants, young children, and adults against disease caused by the bacterium Streptococcus pneumoniae (the pneumococcus).", R.drawable.vacc_6, "6 weeks");
        TimelineItem posttextTimelineItem2 = new TimelineItem(postTextItem2);

        mData.add(posttextTimelineItem2);

        PostTextItem postTextItem3 = new PostTextItem("After 10 weeks of birth 5 vaccinations are given in India, mainly they are the repeat of previous vaccinations. \n 1. Diptheria, Tetanus and Pertussis vaccine (DTwP 2). \n 2. Inactivated polio vaccine (IPV 2). \n3. Haemophilus influenzae type B (Hib 2) \n4. Rotavirus 2. \n5. Pneumococcal conjugate vaccine (PCV 2).", R.drawable.vacc_10, "10 weeks");
        TimelineItem posttextTimelineItem3 = new TimelineItem(postTextItem3);

        PostVideoItem postVideoItem3 = new PostVideoItem("Am8QPJ1BXPI",R.drawable.vacc_10,"2:01");
        TimelineItem postvideoTimelineItem3 = new TimelineItem(postVideoItem3);

        mData.add(posttextTimelineItem3);
        mData.add(postvideoTimelineItem3);

        return mData;

    }
}
