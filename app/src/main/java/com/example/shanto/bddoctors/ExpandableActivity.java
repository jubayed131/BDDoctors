package com.example.shanto.bddoctors;

import android.app.Activity;

import android.os.Bundle;

import android.view.Menu;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shanto on 10/17/2015.
 */
public class ExpandableActivity extends Activity{
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_activity);
        expListView=(ExpandableListView)findViewById(R.id.lvExp);

        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

    }
    private void prepareListData(){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Daily Exercise");
        listDataHeader.add("Healthy Diet");
        listDataHeader.add("Weight loss");
        listDataHeader.add("Regular physical exams");
        listDataHeader.add("Less stress");
        listDataHeader.add("Heart");
        listDataHeader.add("Prevent Cancer");
        listDataHeader.add("Yoga");
        listDataHeader.add("Be a Giver");
        listDataHeader.add("First Aid");

        // Adding child data
        List<String> DailyExercise = new ArrayList<String>();
        DailyExercise.add("You brush your teeth every day; exercise is equally important for your daily routine. Turn off the TV or computer, and get at least 30 minutes of exercise every day.\n" +
                "\n" +
                "To work your heart, it's got to be aerobic exercise. You've got lots of options: walking, jogging, biking, rowing machine, elliptical machine, swimming. But don't feel like you have to be an athlete. Walking is great exercise. Get 10 minutes here and there during the day. It all counts.\n" +
                "\n" +
                "Start with something simple, like parking in the far corner of the parking lot -- so you get those extra steps to the door. Take the stairs one or two flights instead of the elevator. If you take public transportation, get off one stop early and walk the rest. Get out at lunch to walk. Or walk with your significant other or your spouse after work. You'll get a bonus -- relaxation and stress reduction.");

        List<String> HealthyDiet = new ArrayList<String>();
        HealthyDiet.add("Quit eating junk food and high-fat fast food. Your heart, brain, and overall health are harmed by foods high in saturated fats, salt, and cholesterol. There's no getting around it. You've got to replace them with healthy foods: lots of fruits, vegetables, fish, nuts, olive oil -- what we call the Mediterranean diet. Eat like an Italian, a Spaniard, a Greek! Enjoy!");

        List<String> WeightLoss = new ArrayList<String>();
        WeightLoss.add("Too much body weight puts your health at great risk. When you take in more calories than you burn, you get fat -- it's that simple. You've got to eat less. You've got to exercise more. You've got to push yourself to make these lifestyle changes -- but you've got to do it to help avoid serious health problems like heart disease, diabetes, or stroke.");

        List<String> RegularPhysicalExams = new ArrayList<String>();
        RegularPhysicalExams.add("Tell your doctor your family medical history. Learn your personal risk factors, and the screening tests you need. Women may have mammograms to screen for breast cancer and Pap tests for cervical cancer. Men may have prostate cancer PSA tests. Routine screening for colorectal cancer should start at age 50, perhaps earlier if colon cancer runs in your family. You also need regular diabetes, blood pressure, and cholesterol tests. Make sure your immunizations are up to date. You may need flu and pneumonia shots, depending on your age.");

        List<String> LessStress = new ArrayList<String>();
        LessStress.add("When a person says they're too busy to exercise, it tells me other things are crowding out what's important in life: They don't spend time with family and friends; don't exercise enough; don't eat right; don't sleep properly. All these things reduce stress in your life, and that is critical to your health and longevity.\n" +
                "\n"+
                "\"To be healthy, we need to set boundaries -- and set limits on work hours. We should not be working so hard that we're neglecting the things that keep us healthy. This is important advice, too, for people who take care of elderly parents or young children. Make sure you're getting proper exercise and sleep -- and that you're not trying to do too much.");


        List<String> Heart = new ArrayList<String>();
        Heart.add("What is heart failure?\n" +
                "\n" +
                "When you have heart failure, your heart has weakened. It is not pumping blood around your body as efficiently as it should. A weakened heart has to pump extra hard to supply your body with the oxygen and nutrients it needs. This extra work can enlarge and damage it even further.\n" +
                "\n" +
                "The most common symptoms of heart failure:\n" +
                "\n" +
                " * Shortness of breath\n" +
                " * Weakness, fatigue\n" +
                " * Swollen feet, ankles, abdomen, or veins in the neck\n" +


                " * Other symptoms may include:\n" +
                "\n" +
                " * Rapid weight gain\n" +
                " * Difficulty moving\n" +
                " * Heart palpitations\n" +
                " * Nausea/vomiting\n" +
                " * Coughing" +
                "\n" +


                "Keep Your Heart Healthy: \n" +
                "\n" +
                "Take steps today to lower your risk of heart disease and heart attack. Heart disease is the leading cause of death for both men and women in the United States.\n" +
                "\n" +


                "To help prevent heart disease, you can:\n" +
                "\n" +
                " * Eat healthy and get active.\n" +
                " * Watch your weight.\n" +
                " * Quit smoking and stay away from secondhand smoke.\n" +
                " * Control your cholesterol (“koh-LEHS-tuh-rahl”) and blood pressure.\n" +
                " * If you drink alcohol, drink only in moderation.\n" +
                " * Take steps to prevent type 2 diabetes.\n" +
                " * Manage stress.");


        List<String> PreventCancer = new ArrayList<String>();
        PreventCancer.add("First, the good news: You probably won't get cancer.\n" +
                "\n" +
                "That is, if you have a healthy lifestyle. \"As many as 70% of known causes of cancers are avoidable and related to lifestyle,\" says Thomas A. Sellers, PhD, associate director for cancer prevention and control at Moffitt Cancer Center in Tampa. Diet, exercise, and avoidance of tobacco products are, of course, your first line of defense, but recent research has uncovered many small, surprising ways you can weave even more disease prevention into your everyday life.\n" +
                "\n" +

                "Try these novel strategies and your risk of cancer could dwindle even more.\n" +
                "\n" +
                "1. Filter your tap water\n" +
                "You'll reduce your exposure to known or suspected carcinogens and hormone-disrupting chemicals. A report from the President's Cancer Panel on how to reduce exposure to carcinogens suggests that home-filtered tap water is a safer bet than bottled water, whose quality often is not higher—and in some cases is worse—than that of municipal sources, according to a study by the Environmental Working Group. (Consumer Reports' top picks for faucet-mounted filters: Culligan, Pur Vertical, and the Brita OPFF-100.) Store water in stainless steel or glass to avoid chemical contaminants such as BPA that can leach from plastic bottles.\n" +
                "\n" +
                "2. Stop topping your tank\n" +
                "So say the EPA and the President's Cancer Panel: Pumping one last squirt of gas into your car after the nozzle clicks off can spill fuel and foil the pump's vapor recovery system, designed to keep toxic chemicals such as cancer-causing benzene out of the air, where they can come in contact with your skin or get into your lungs.\n" +
                "\n" +

                "\n" +
                "3. Marinate meat first\n" +
                "Processed, charred, and well-done meats can contain cancer-causing heterocyclic amines, which form when meat is seared at high temperatures, and polycyclic aromatic hydrocarbons, which get into food when it's charcoal broiled. \"The recommendation to cut down on grilled meat has really solid scientific evidence behind it,\" says Cheryl Lyn Walker, PhD, a professor of carcinogenesis at the University of Texas M.D. Anderson Cancer Center. If you do grill, add rosemary and thyme to your favorite marinade and soak meat for at least an hour before cooking. The antioxidant-rich spices can cut HCAs by as much as 87%, according to research at Kansas State University.\n" +
                "\n" +
                "4. Caffeinate every day\n" +
                "Java lovers who drank 5 or more cups of caffeinated coffee a day had a 40% decreased risk of brain cancer, compared with people who drank the least, in a 2010 British study. A 5-cup-a-day coffee habit reduces risks of oral and throat cancer almost as much. Researchers credit the caffeine: Decaf had no comparable effect. But coffee was a more potent protector against these cancers than tea, which the British researchers said also offered protection against brain cancer.\n" +
                "\n" +

                "\n" +
                "5. Water down your risk\n" +
                "Drinking plenty of water and other liquids may reduce the risk of bladder cancer by diluting the concentration of cancer-causing agents in urine and helping to flush them through the bladder faster. Drink at least 8 cups of liquid a day, suggests the American Cancer Society.\n" +
                "\n" +
                "6. Load up on green greens\n" +
                "Next time you're choosing salad fixings, reach for the darkest varieties. The chlorophyll that gives them their color is loaded with magnesium, which some large studies have found lowers the risk of colon cancer in women. \"Magnesium affects signaling in cells, and without the right amount, cells may do things like divide and replicate when they shouldn't,\" says Walker. Just 1/2 cup of cooked spinach provides 75 mg of magnesium, 20% of the daily value.\n" +
                "\n" +
                "7. Snack on Brazil nuts\n" +
                "They're a stellar source of selenium, an antioxidant that lowers the risk of bladder cancer in women, according to research from Dartmouth Medical School. Other studies have found that people with high blood levels of selenium have lower rates of dying of lung cancer and colorectal cancer. Researchers think selenium not only protects cells from free radical damage but also may enhance immune function and suppress formation of blood vessels that nourish tumors.\n" +
                "\n" +
                "8. Burn off your risk\n" +
                "Moderate exercise such as brisk walking 2 hours a week cuts risk of breast cancer 18%. Regular workouts may lower your risks by helping you burn fat, which otherwise produces its own estrogen, a known contributor to breast cancer. (Try these 14 Walking Workouts That Blast Fat.)\n" +
                "\n" +
                "9. Skip the dry cleaner\n" +
                "A solvent known as perc (short for perchloroethylene) that's used in traditional dry cleaning may cause liver and kidney cancers and leukemia, according to an EPA finding backed in early 2010 by the National Academies of Science. The main dangers are to workers who handle chemicals or treated clothes using older machines, although experts have not concluded that consumers are also at increased cancer risk. Less toxic alternatives: Hand-wash clothes with mild soap and air-dry them, spot cleaning if necessary with white vinegar.\n" +
                "\n" +
                "10. Ask about breast density\n" +
                "Women whose mammograms have revealed breast density readings of 75% or more have a breast cancer risk 4 to 5 times higher than that of women with low density scores, according to recent research. One theory is that denser breasts result from higher levels of estrogen—making exercise particularly important (see #8). \"Shrinking your body fat also changes growth factors, signaling proteins such as adipokines and hormones like insulin in ways that tend to turn off cancer-promoting processes in cells,\" Walker says.\n" +
                "\n" +
                "11. Head off cell phone risks\n" +
                "Use your cell phone only for short calls or texts, or use a hands-free device that keeps the phone—and the radio frequency energy it emits—away from your head. The point is more to preempt any risk than to protect against a proven danger: Evidence that cell phones increase brain cancer risk is \"neither consistent nor conclusive,\" says the President's Cancer Panel report. But a number of review studies suggest there's a link.\n" +
                "\n" +
                "12. Block cancer with color\n" +
                "Choosing your outdoor outfit wisely may help protect against skin cancer, say Spanish scientists. In their research, blue and red fabrics offered significantly better protection against the sun's UV rays than white and yellow ones did. Don't forget to put on a hat: Though melanoma can appear anywhere on the body, it's more common in areas the sun hits, and researchers at the University of North Carolina at Chapel Hill have found that people with melanomas on the scalp or neck die at almost twice the rate of people with the cancer on other areas of the body.\n" +
                "\n" +
                "13. Pick a doc with a past\n" +
                "Experience—lots of it—is critical when it comes to accurately reading mammograms. A study from the University of California, San Francisco, found that doctors with at least 25 years' experience were more accurate at interpreting images and less likely to give false positives. Ask about your radiologist's track record. If she is freshly minted or doesn't check a high volume of mammograms, get a second read from someone with more mileage.\n" +
                "\n" +
                "14. Eat clean foods\n" +
                "The President's Cancer Panel recommends buying meat free of antibiotics and added hormones, which are suspected of causing endocrine problems, including cancer. The report also advises that you purchase produce grown without pesticides and wash conventionally grown food thoroughly to remove residues. (The foods with the most pesticides: celery, peaches, strawberries, apples, and blueberries. See the full list of dirtiest fruits and vegetables here.) \"At least 40 known carcinogens are found in pesticides and we should absolutely try to reduce exposure,\" Sellers says.\n" +
                "\n" +

                "\n" +
                "15. Do a folic acid check\n" +
                "The B vitamin, essential for women who may become or are pregnant to prevent birth defects, is a double-edged sword when it comes to cancer risk. Consuming too much of the synthetic form (not folate, found in leafy green veggies, orange juice, and other foods) has been linked to increased colon cancer risk, as well as higher lung cancer and prostate cancer risks. Rethink your multivitamin, especially if you eat a lot of cereal and fortified foods. A CDC study discovered that half of supplement users who took supplements with more than 400 mcg of folic acid exceeded 1,000 mcg per day of folic acid. Most supplements pack 400 mcg. Individual supplements (of vitamin D and calcium, for instance) may be a smarter choice for most women who aren't thinking of having kids.\n" +
                "\n" +
                "16. Up your calcium intake\n" +
                "Milk's main claim to fame may also help protect you from colon cancer. Those who took calcium faithfully for 4 years had a 36% reduction in the development of new precancerous colon polyps 5 years after the study had ended, revealed Dartmouth Medical School researchers. (They tracked 822 people who took either 1,200 mg of calcium every day or a placebo.) Though the study was not on milk itself, you can get the same amount of calcium in three 8-ounce glasses of fat-free milk, along with an 8-ounce serving of yogurt or a 2- to 3-ounce serving of low-fat cheese daily.\n" +
                "\n" +

                "\n" +
                "17. Commit to whole grains\n" +
                "You know whole wheat is better for you than white bread. Here's more proof why you should switch once and for all: If you eat a lot of things with a high glycemic load—a measurement of how quickly food raises your blood sugar—you may run a higher risk of colorectal cancer than women who eat low-glycemic-load foods, found a Harvard Medical School study involving 38,000 women. The problem eats are mostly white: white bread, pasta, potatoes, and sugary pastries. The low-glycemic-load stuff comes with fiber.\n" +
                "\n" +
                "18. Pay attention to pain\n" +
                "If you're experiencing a bloated belly, pelvic pain, and an urgent need to urinate, see your doctor. These symptoms may signal ovarian cancer, particularly if they're severe and frequent. Women and physicians often ignore these symptoms, and that's the very reason that this disease can be deadly. When caught early, before cancer has spread outside the ovary, the relative 5-year survival rate for ovarian cancer is a jaw-dropping 90 to 95%.\n" +
                "\n" +
                "19. Avoid unnecessary scans\n" +
                "CT scans are a great diagnostic tool, but they deliver much more radiation than x-rays and may be overused, says Barton Kamen, MD, PhD, chief medical officer for the Leukemia & Lymphoma Society. In fact, researchers suggest that one-third of CT scans could be unnecessary. High doses of radiation can trigger leukemia, so make sure scans are not repeated if you see multiple doctors, and ask if another test, such as an ultrasound or MRI, could substitute.\n" +
                "\n" +
                "20. Drop 10 pounds\n" +
                "Being overweight or obese accounts for 20% of all cancer deaths among women and 14% among men, notes the American Cancer Society. (You're overweight if your body mass index is between 25 and 29.9; you're obese if it's 30 or more.) Plus, losing excess pounds reduces the body's production of female hormones, which may protect against breast cancer, endometrial cancer, and ovarian cancer. Even if you're not technically overweight, gaining just 10 pounds after the age of 30 increases your risk of developing breast, pancreatic, and cervical, among other cancers.");


        List<String> Yoga = new ArrayList<String>();
        Yoga.add("From the ancient time to present Yoga has a great impact on human mind and health"+
                "\n"+
                "Yoga helps to be fit mentaly and physically\n" +

                "1. Yoga for Flexibility:\n" +
                "Yoga poses work by stretching your muscles. They can help you move better and feel less stiff or tired.\n" +
                "\n" +
                "At any level of yoga, you'll probably start to notice benefits soon. In one study, people improved their flexibility by up to 35% after only 8 weeks of yoga.\n" +
                "\n" +

                "2. Strike a Pose for Strength:\n" +
                "Some styles of yoga, such as ashtanga and power yoga, are very physical. Practicing one of these styles will help you improve muscle tone.\n" +
                "\n" +
                "But even less vigorous styles of yoga, such as Iyengar or hatha, can provide strength and endurance benefits.\n" +
                "\n" +
                "Many of the poses, such as downward dog, upward dog, and the plank pose, build upper-body strength. The standing poses, especially if you hold them for several long breaths, build strength in your hamstrings, quadriceps, and abs. Poses that strengthen the lower back include upward dog and the chair pose.\n" +
                "\n" +
                "When done right, nearly all poses build core strength in the deep abdominal muscles.\n" +
                "\n" +

                "3. Better Posture From Yoga:\n" +
                "When you're stronger and more flexible, your posture improves.\n" +
                "\n" +
                "Most standing and sitting poses develop core strength, since you need your core muscles to support and maintain each pose.\n" +
                "\n" +
                "With a stronger core, you're more likely to sit and stand \"tall.\"\n" +
                "\n" +
                "Yoga also helps your body awareness. That helps you notice more quickly if you're slouching or slumping, so you can adjust your posture.\n" +
                "\n" +

                "4. Breathing Benefits: \n" +
                "Yoga usually involves paying attention to your breath, which can help you relax. It may also call for specific breathing techniques.\n" +
                "\n" +
                "But yoga typically isn't aerobic, like running or cycling, unless it's an intense type of yoga or you're doing it in a heated room.\n" +
                "\n" +

                "5. Less Stress, More Calm: \n" +
                "You may feel less stressed and more relaxed after doing some yoga.\n" +
                "\n" +
                "Some yoga styles use meditation techniques that help calm the mind. Focusing on your breathing during yoga can do that, too.\n" +
                "\n" +

                "6. Good for Your Heart:\n" +
                "Yoga has long been known to lower blood pressure and slow the heart rate. A slower heart rate can benefit people with high blood pressure or heart disease, and people who've had a stroke.\n" +
                "\n" +
                "Yoga has also been linked to lower cholesterol and triglyceride levels, and better immune system function.");

        List<String> BeaGiver = new ArrayList<String>();
        BeaGiver.add("1. Giving makes us feel happy. A 2008 study by Harvard Business School professor Michael Norton and colleagues found that giving money to someone else lifted participants’ happiness more that spending it on themselves (despite participants’ prediction that spending on themselves would make them happier). Happiness expert Sonja Lyubomirsky, a professor of psychology at the University of California, Riverside, saw similar results when she asked people to perform five acts of kindness each week for six weeks.\n" +
                "These good feelings are reflected in our biology. In a 2006 study, Jorge Moll and colleagues at the National Institutes of Health found that when people give to charities, it activates regions of the brain associated with pleasure, social connection, and trust, creating a “warm glow” effect. Scientists also believe that altruistic behavior releases endorphins in the brain, producing the positive feeling known as the “helper’s high.”\n" +
                "\n"+

                "2. Giving is good for our health. A wide range of research has linked different forms of generosity to better health, even among the sick and elderly. In his book Why Good Things Happen to Good People, Stephen Post, a professor of preventative medicine at Stony Brook University, reports that giving to others has been shown to increase health benefits in people with chronic illness, including HIV and multiple sclerosis.\n" +
                "A 1999 study led by Doug Oman of the University of California, Berkeley, found that elderly people who volunteered for two or more organizations were 44 percent less likely to die over a five-year period than were non-volunteers, even after controlling for their age, exercise habits, general health, and negative health habits like smoking. Stephanie Brown of the University of Michigan saw similar results in a 2003 study on elderly couples. She and her colleagues found that those individuals who provided practical help to friends, relatives, or neighbors, or gave emotional support to their spouses, had a lower risk of dying over a five-year period than those who didn’t. Interestingly, receiving help wasn’t linked to a reduced death risk.\n" +
                "Researchers suggest that one reason giving may improve physical health and longevity is that it helps decrease stress, which is associated with a variety of health problems. In a 2006 study by Rachel Piferi of Johns Hopkins University and Kathleen Lawler of the University of Tennessee, people who provided social support to others had lower blood pressure than participants who didn’t, suggesting a direct physiological benefit to those who give of themselves.\n" +
                "\n"+

                "3. Giving promotes cooperation and social connection. When you give, you’re more likely to get back: Several studies, including work by sociologists Brent Simpson and Robb Willer, have suggested that when you give to others, your generosity is likely to be rewarded by others down the line—sometimes by the person you gave to, sometimes by someone else.\n" +
                "These exchanges promote a sense of trust and cooperation that strengthens our ties to others—and research has shown that having positive social interactions is central to good mental and physical health. As researcher John Cacioppo writes in his book Loneliness: Human Nature and the Need for Social Connection, “The more extensive the reciprocal altruism born of social connection . . . the greater the advance toward health, wealth, and happiness.”\n" +
                "What’s more, when we give to others, we don’t only make them feel closer to us; we also feel closer to them. “Being kind and generous leads you to perceive others more positively and more charitably,” writes Lyubomirsky in her book The How of Happiness, and this “fosters a heightened sense of interdependence and cooperation in your social community.”\n" +
                "\n" +


                "4. Giving evokes gratitude. Whether you’re on the giving or receiving end of a gift, that gift can elicit feelings of gratitude—it can be a way of expressing gratitude or instilling gratitude in the recipient. And research has found that gratitude is integral to happiness, health, and social bonds.\n" +
                "Robert Emmons and Michael McCullough, co-directors of the Research Project on Gratitude and Thankfulness, found that teaching college students to “count their blessings” and cultivate gratitude caused them to exercise more, be more optimistic, and feel better about their lives overall. A recent study led by Nathaniel Lambert at Florida State University found that expressing gratitude to a close friend or romantic partner strengthens our sense of connection to that person.\n" +
                "Barbara Fredrickson, a pioneering happiness researcher, suggests that cultivating gratitude in everyday life is one of the keys to increasing personal happiness. “When you express your gratitude in words or actions, you not only boost your own positivity but [other people’s] as well,” she writes in her book Positivity. “And in the process you reinforce their kindness and strengthen your bond to one another.”\n" +
                "\n" +
                "\n" +
                "5. Giving is contagious. When we give, we don’t only help the immediate recipient of our gift. We also spur a ripple effect of generosity through our community.\n" +
                "A study by James Fowler of the University of California, San Diego, and Nicholas Christakis of Harvard, published in the Proceedings of the National Academy of Science, shows that when one person behaves generously, it inspires observers to behave generously later, toward different people. In fact, the researchers found that altruism could spread by three degrees—from person to person to person to person. “As a result,” they write, “each person in a network can influence dozens or even hundreds of people, some of whom he or she does not know and has not met.”\n" +
                "Giving has also been linked to the release of oxytocin, a hormone (also released during sex and breast feeding) that induces feelings of warmth, euphoria, and connection to others. In laboratory studies, Paul Zak, the director of the Center for Neuroeconomics Studies at Claremont Graduate University, has found that a dose of oxytocin will cause people to give more generously and to feel more empathy towards others, with “symptoms” lasting up to two hours. And those people on an “oxytocin high” can potentially jumpstart a “virtuous circle, where one person’s generous behavior triggers another’s,” says Zak.\n" +
                "So whether you buy gifts, volunteer your time, or donate money to charity this holiday season, your giving is much more than just a year-end chore. It may help you build stronger social connections and even jumpstart a cascade of generosity through your community. And don’t be surprised if you find yourself benefiting from a big dose of happiness in the process.");

        List<String> FirstAid = new ArrayList<String>();
        FirstAid.add("First aid for someone who’s unconscious and not breathing\n" +
                "How to help\n" +
                "\n" +
                "Key skill:The delivery of chest compressions\n" +
                "\n" +
                "    Check breathing by tilting their head backwards and looking and feeling for breaths.\n" +
                "    Call 999 as soon as possible, or get someone else to do it.\n" +
                "    Push firmly downwards in the middle of the chest and then release.\n" +
                "    Push at a regular rate until help arrives.\n" +
                "\n");
        FirstAid.add("First aid for choking\n" +
                "\n" +
                "Key skill:The delivery of back blows\n" +
                "\n" +
                "    * Hit them firmly on their back between the shoulder blades to dislodge the object.\n" +
                "    * If necessary, call 999 or get someone else to do it.\n" +
                "\n");
        FirstAid.add("First aid for someone who’s bleeding heavily\n" +
                "\n" +
                "Key skill:Put pressure on the wound\n" +
                "\n" +
                "    * Put pressure on the wound with whatever is available to stop or slow down the flow of blood.\n" +
                "    * As soon as possible, call 999 or get someone else to do it.\n" +
                "    * Keep pressure on the wound until help arrives.\n" +
                "\n");
        FirstAid.add("First aid for burns\n" +
                "\n" +
                "Key skill: Cool the affected area\n" +
                "\n" +
                "    * Cool the burn under cold running water for at least ten minutes.\n" +
                "    * Loosely cover the burn with cling film or a clean plastic bag.\n" +
                "    * If necessary, call 999 or get someone else to do it.\n" +
                "\n");
        FirstAid.add("First aid for a broken bone\n" +
                "\n" +
                "Key skill: Immobilise the affected part\n" +
                "\n" +
                "    * Encourage the person to support the injury with their hand, or use a cushion or items of clothing to prevent unnecessary movement.\n" +
                "    * As soon as possible, call 999 or get someone else to do it.\n" +
                "    * Continue supporting the injury until help arrives.\n" +
                "\n");
        FirstAid.add("First aid for a heart attack\n" +
                "\n" +
                "Key skill:Ensure they are sitting and call 999 immediately\n" +
                "\n" +
                "    * The person may have persistent, vice-like chest pain, which may spread to their arms, neck, jaw, back or stomach.\n" +
                "    * Call 999 immediately or get someone else to do it.\n" +
                "    * Make sure they are in a position that is comfortable for them (e.g. sit them on the floor, leaning against a wall or chair).\n" +
                "    * Give them constant reassurance while waiting for the ambulance.\n" +
                "\n");
        FirstAid.add("First aid for a stroke\n" +
                "How to help\n" +
                "\n" +
                "Key skill:Carry out the FAST test\n" +
                "\n" +
                "    * Think FAST. Face: is there weakness on one side of the face? Arms: can they raise both arms? Speech: is their speech easily understood? Time: to call 999.\n" +
                "    * Immediately call 999 or get someone else to do it.\n" +
                "\n");
        FirstAid.add("First aid for seizures (epilepsy)\n" +
                "\n" +
                "Key skill: Make them safe and prevent injury\n" +
                "\n" +
                "    * Do not restrain them but use a blanket or clothing to protect their head from injury.\n" +
                "    * After the seizure, help the person rest on their side with their head tilted back.\n" +
                "\n");
        FirstAid.add("First aid for a diabetic emergency\n" +
                "\n" +
                "Key skill: Give them something sweet to drink or eat\n" +
                "\n" +
                "    * Give them something sweet to eat or a non-diet drink.\n" +
                "    * Reassure the person. If there is no improvement, call 999 or get someone else to do it.\n" +
                "\n");
        FirstAid.add("First aid for an asthma attack\n" +
                "\n" +
                "Key skill: Help them take their medication\n" +
                "\n" +
                "    * Help the person sit in a comfortable position and take their medication.\n" +
                "    * Reassure the person. If the attack becomes severe, call 999 or get someone else to do it.\n" +
                "\n");
        FirstAid.add("First aid for poisoning and harmful substances\n" +
                "\n" +
                "Key skill: Establish what? When? And how much?\n" +
                "\n" +
                "    * Establish what they have taken. When? And how much?\n" +
                "    * As soon as possible, call 999 or get someone else to do it.\n" +
                "    * Do not make the person sick.\n" +
                "\n");
        FirstAid.add("First aid for a head injury\n" +
                "\n" +
                "Key skill: Apply something cold\n" +
                "\n" +
                "    * Ask them to rest and apply a cold compress to the injury (e.g. frozen vegetables wrapped in a tea towel).\n" +
                "    * If they become drowsy or vomit, call 999 or get someone else to d");
        FirstAid.add("First aid for someone who’s distressed\n" +
                "\n" +
                "Key skill: Ask if you can help\n" +
                "\n" +
                "    * Show you are listening and calmly ask them how you can help.\n" +
                "    * Be considerate of what is going on around them and what they need.\n" +
                "\n");


        listDataChild.put(listDataHeader.get(0), DailyExercise);
        listDataChild.put(listDataHeader.get(1), HealthyDiet);
        listDataChild.put(listDataHeader.get(2), WeightLoss);
        listDataChild.put(listDataHeader.get(3), RegularPhysicalExams);// Header, Child data
        listDataChild.put(listDataHeader.get(4), LessStress);
        listDataChild.put(listDataHeader.get(5), Heart);
        listDataChild.put(listDataHeader.get(6), PreventCancer);
        listDataChild.put(listDataHeader.get(7), Yoga);
        listDataChild.put(listDataHeader.get(8), BeaGiver);// Header, Child data
        listDataChild.put(listDataHeader.get(9), FirstAid);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
